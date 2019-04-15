package ch.hearc.holygram.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ch.hearc.holygram.models.Canton;
import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.CantonRepository;
import ch.hearc.holygram.repositories.DemonRepository;
import ch.hearc.holygram.repositories.ExorcistRepository;
import ch.hearc.holygram.repositories.ReligionRepository;
import ch.hearc.holygram.repositories.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ExorcistRepository exorcistRepository;

	@Autowired
	private CantonRepository cantonRepository;

	@Autowired
	private DemonRepository demonRepository;

	@Autowired
	private ReligionRepository religionRepository;

	@GetMapping(value = "/users")
	public String findAllUsers(Map<String, Object> model) {
		System.out.println("/users GET");
		model.put("users", userRepository.findAll());
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
		Iterable<Canton> cantons = cantonRepository.findAll();
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

	@PostMapping("/users")
	public String saveUsers(@Valid @ModelAttribute User user, BindingResult errors, Model model) {

		if (!errors.hasErrors()) {
			userRepository.save(user);
		}
		return ((errors.hasErrors()) ? "saisie_users" : "redirect:users");
	}
}
