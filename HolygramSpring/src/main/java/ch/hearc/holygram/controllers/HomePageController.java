package ch.hearc.holygram.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

public class HomePageController {
	@GetMapping(value = "/")
	public String homePage(Map<String, Object> model) {
		return "index";
	}
}
