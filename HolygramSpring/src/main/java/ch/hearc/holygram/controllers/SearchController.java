package ch.hearc.holygram.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ch.hearc.holygram.models.Demon;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.Service;
import ch.hearc.holygram.repositories.DemonRepository;
import ch.hearc.holygram.repositories.ServiceRepository;

@Controller
public class SearchController {

	// https://github.com/caveofprogramming/springboot/blob/master/spring-boot-tutorial-search/src/main/java/com/caveofprogramming/controllers/SearchController.java
	// https://github.com/caveofprogramming/springboot/blob/master/spring-boot-tutorial-search/src/main/java/com/caveofprogramming/model/dto/SearchResult.java
	// https://github.com/caveofprogramming/springboot/blob/master/spring-boot-tutorial-search/src/main/java/com/caveofprogramming/service/SearchService.java

	// https://spring.io/guides/tutorials/bookmarks/

	@Autowired
	private DemonRepository dr;

	@Autowired
	private ServiceRepository sr;

	@RequestMapping(value = "/search", method = { RequestMethod.POST, RequestMethod.GET })
	public String search(Map<String, Object> model) {

		// FIXME results = searchService.search(text, pageNumber);
		model.put("demons", dr.findAll());

		// TODO model
		return "search";
	}

	@RequestMapping(value = "/search/process", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public ResponseEntity<List<JsonNode>> process(@RequestParam("input_demon") Long demon_id,
			@RequestParam("input_renown") int renown) {

		class Wrapper {
			public String username;
			public String phone;
			public String email;
			public Exorcist exorcist;

			public Wrapper(Exorcist exorcist, String username, String phone, String email) {
				this.exorcist = exorcist;
				this.username = username;
				this.phone = phone;
				this.email = email;
			}
		}

		ObjectMapper mapper = new ObjectMapper();

		List<JsonNode> datas = new ArrayList<JsonNode>();

		Demon demon = dr.findById((long) 1).get();
		for (Service s : sr.findAllServiceByDemon(demon)) {
			Exorcist e = s.getExorcist();
			int e_renown = e.getRenown();

			// If this exorcist match minimal renown append it to the list
			if (e_renown >= renown) {
				JsonNode node = mapper.valueToTree(new Wrapper(e, e.getUser().getUsername(), e.getPhoneNumber(), e.getUser().getEmail()));
				datas.add(node);
			}

		}

		// return list of exorcists
		return new ResponseEntity<List<JsonNode>>(datas, HttpStatus.OK);
	}
}
