package ch.hearc.holygram.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.hearc.holygram.accessors.CantonRepository;
import ch.hearc.holygram.accessors.ExorcistRepository;
import ch.hearc.holygram.accessors.UserRepository;
import ch.hearc.holygram.models.Canton;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.User;

@Controller
public class UserController {

	@Autowired
	private UserRepository uRepository;
	
	@Autowired
	private ExorcistRepository exorcistRepository;
	
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

	@PostMapping(value = "/users/registrationUser")
	public String registrationClient(Map<String, Object> model) {

		return "registration/user";
	}
	
	@PostMapping(value = "/users/registrationExorcist")
	public String registrationExorcist(Map<String, Object> model) {
		System.out.println("");
		System.out.println("pika");
		System.out.println("");
		Iterable<Canton> cantons = cRepository.findAll();
		System.out.println("");
		System.out.println("pika");
		System.out.println("");
		System.out.println("");
		System.out.println(cantons);
		System.out.println("");
		model.put("cantons", cantons);
		return "registration/exorcist";
	}
	
	@PostMapping(value = "/users/registerUser")
	public String registerUser(Map<String, Object> model) {

		return "index";
	}
	
	private boolean checkRegisterUser() {
		return true;
	}
	
	@GetMapping(value = "/users/registration")
	public String registrationUser(Map<String, Object> model) {

		return "registration/index";
	}

	@GetMapping(value = "/profile")
	public String profile(Map<String, Object> model, @RequestParam(required = false) String id) {
		if(id == null)
			return "redirect:/";
		
		Long lid = Long.valueOf(id);
		Optional<Exorcist> exorcist = exorcistRepository.findById(lid);
		
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
