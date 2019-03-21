package ch.hearc.holygram.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.hearc.holygram.accessors.UserRepository;
import ch.hearc.holygram.accessors.CantonRepository;
import ch.hearc.holygram.models.User;
import ch.hearc.holygram.models.Canton;

@Controller
public class UserController {

	@Autowired
	private UserRepository uRepository;
	@Autowired
	private CantonRepository cRepository;

	// private ProduitRepository prepo;

	@GetMapping(value = "/users")
	public String findAllUsers(Map<String, Object> model) {
		System.out.println("/users GET");
		model.put("users", uRepository.findAll());
		model.put("user", new User());

		return "produits";
	}

	@GetMapping(value = "/saisie_users")
	public String saisieUsers(Map<String, Object> model) {

		model.put("user", new User());

		return "saisie_users";
	}
	
	@GetMapping(value = "/login")
	public String login(Map<String, Object> model) {
		return "login";
	}
	
	@GetMapping(value = "/register")
	public String register(Map<String, Object> model) {
		return "register/index";
	}
	
	@GetMapping(value = "/register/customer")
	public String registerCustomer(Map<String, Object> model) {
		return "register/customer";
	}
	
	@GetMapping(value = "/register/exorcist")
	public String registerExorcist(Map<String, Object> model) {

		Iterable<Canton> cantons = cRepository.findAll();

		model.put("cantons", cantons);
		return "register/exorcist";
	}

	@PostMapping(value = "/profile")
	public String profile(Map<String, Object> model) {
		return "profile";

	}

	@PostMapping("/users")
	public String saveUsers(@Valid @ModelAttribute User user, BindingResult errors, Model model) {

		if (!errors.hasErrors()) {
			uRepository.save(user);
		}
		return ((errors.hasErrors()) ? "saisie_users" : "redirect:users");
	}
}
