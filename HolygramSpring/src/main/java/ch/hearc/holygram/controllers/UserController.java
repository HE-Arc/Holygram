package ch.hearc.holygram.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.hearc.holygram.models.Canton;
import ch.hearc.holygram.repositories.CantonRepository;

@Controller
public class UserController {	
	@Autowired
	private CantonRepository cRepository;

	@GetMapping(value = "/signup/customer")
	public String signupCustomer(Map<String, Object> model) {

		return "signup/customer";
	}
	
	@GetMapping(value = "/signup/exorcist")
	public String signupExorcist(Map<String, Object> model) {

		Iterable<Canton> cantons = cRepository.findAll();
		model.put("cantons", cantons);
		
		return "signup/exorcist";
	}
	
	@GetMapping(value = "/signup/")
	public String signupUser(Map<String, Object> model) {

		return "signup/index";
	}
}
