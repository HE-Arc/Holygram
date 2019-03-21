package ch.hearc.holygram.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.hearc.holygram.services.SearchService;

@Controller
public class SearchController {

	// https://github.com/caveofprogramming/springboot/blob/master/spring-boot-tutorial-search/src/main/java/com/caveofprogramming/controllers/SearchController.java
	// https://github.com/caveofprogramming/springboot/blob/master/spring-boot-tutorial-search/src/main/java/com/caveofprogramming/model/dto/SearchResult.java
	// https://github.com/caveofprogramming/springboot/blob/master/spring-boot-tutorial-search/src/main/java/com/caveofprogramming/service/SearchService.java
	
	// https://spring.io/guides/tutorials/bookmarks/
	
	@Autowired
	SearchService searchService;

	@RequestMapping(value="/search", method={RequestMethod.POST, RequestMethod.GET})
	
	// FIXME : Add @RequestParam
	public ModelAndView search(ModelAndView modelAndView) {
		
		//FIXME results = searchService.search(text, pageNumber);
		
		//TODO modelAndView
		//modelAndView.getModel().put("s", text);
		//modelAndView.getModel().put("page", results);
		modelAndView.setViewName("app.search");
		
		return modelAndView;
	}
}
