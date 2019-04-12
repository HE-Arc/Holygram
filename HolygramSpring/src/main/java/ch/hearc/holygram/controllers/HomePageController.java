package ch.hearc.holygram.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	@GetMapping("/")
	public String homePage(Map<String, Object> model) {
		return "index";
	}
	
	@GetMapping("/signup")
	public String signUp(Map<String, Object> model) {
		return "signup";
	}
}
