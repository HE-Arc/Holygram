package ch.hearc.holygram.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.hearc.holygram.models.Demon;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.Service;
import ch.hearc.holygram.repositories.DemonRepository;
import ch.hearc.holygram.repositories.ExorcistRepository;
import ch.hearc.holygram.repositories.ServiceRepository;
import ch.hearc.holygram.services.SearchService;

@Controller
public class SearchController {

	// https://github.com/caveofprogramming/springboot/blob/master/spring-boot-tutorial-search/src/main/java/com/caveofprogramming/controllers/SearchController.java
	// https://github.com/caveofprogramming/springboot/blob/master/spring-boot-tutorial-search/src/main/java/com/caveofprogramming/model/dto/SearchResult.java
	// https://github.com/caveofprogramming/springboot/blob/master/spring-boot-tutorial-search/src/main/java/com/caveofprogramming/service/SearchService.java

	// https://spring.io/guides/tutorials/bookmarks/

	@Autowired
	SearchService searchService;

	@Autowired
	private DemonRepository dr;

	@Autowired
	private ExorcistRepository er;

	@Autowired
	private ServiceRepository sr;

	@RequestMapping(value = "/search", method = { RequestMethod.POST, RequestMethod.GET })
	public String search(Map<String, Object> model) {

		// FIXME results = searchService.search(text, pageNumber);
		model.put("demons", dr.findAll());

		// TODO model
		return "search";
	}

	@RequestMapping(value = "/search/process", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody List<Exorcist> process(HttpServletRequest request) {

		Long demon_id = Long.parseLong(request.getParameter("input_demon"));
		Demon demon = dr.findById(demon_id).get();

		List<Exorcist> exorcists = new ArrayList<Exorcist>();
		List<Service> services = sr.findAllServiceByDemon(demon);
		for (Service s : services) {
			exorcists.add(s.getExorcist());
			System.out.println("[search] service's id: " + s.getId());
		}

		// return list of exorcists
		return exorcists;
	}
}