package ch.hearc.holygram.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch.hearc.holygram.SearchResultDataWrapper;
import ch.hearc.holygram.models.Canton;
import ch.hearc.holygram.models.Demon;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.Service;
import ch.hearc.holygram.repositories.CantonRepository;
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

	@Autowired
	private CantonRepository cr;

	@RequestMapping(value = "/search", method = { RequestMethod.POST, RequestMethod.GET })
	public String search(Map<String, Object> model) {

		model.put("demons", dr.findAll());

		model.put("cantons", cr.findAll());

		return "search";
	}

	@RequestMapping(value = "/search/process", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public String process(Map<String, Object> model, @RequestParam("input_demon") Long demon_id,
			@RequestParam("input_advanced") Optional<String> a, @RequestParam("input_renown") Optional<Integer> renown,
			@RequestParam("input_canton") Optional<Long> canton_id,
			@RequestParam("input_price") Optional<Integer> price) {

		List<SearchResultDataWrapper> datas = new ArrayList<SearchResultDataWrapper>();

		// Data
		Demon demon = dr.findById(demon_id).get();
		Canton canton = null;
		boolean advanced = false;

		// Check if search is advanced
		if(a.isPresent())
		{
			System.out.println("FROMAGE");
			advanced = a.get().equalsIgnoreCase("on");
			canton = cr.findById(canton_id.get()).get();
		}

		for (Service s : sr.findAllServiceByDemon(demon)) {
			Exorcist e = s.getExorcist();

			if (advanced) {
				if (e.getCanton() != canton)
					continue;
				if (s.getPrice() > price.get())
					continue;
				if (e.getRenown() < renown.get())
					continue;
			}		

			// Exorcist is corresponding
			SearchResultDataWrapper w = new SearchResultDataWrapper(e, e.getUser(), s.getPrice());
			datas.add(w);

		}

		model.put("results", datas);

		// return list of exorcists
		return "results";
	}
}