package ch.hearc.holygram.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.hearc.holygram.accessors.DemonRepository;
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

	@RequestMapping(value="/search", method={RequestMethod.POST, RequestMethod.GET})
	public String search(Map<String, Object> model) {
		
		//FIXME results = searchService.search(text, pageNumber);
		model.put("demons", dr.findAll());
		
		//TODO model
		return "search";
	}
	
	@RequestMapping(value="/search/process", method={RequestMethod.POST, RequestMethod.GET})
	public String process(Map<String, Object> model) {
		
		//FIXME results = searchService.search(text, pageNumber);
		model.put("demons", dr.findAll());
		
		//TODO model
		return "search";
	}
}
