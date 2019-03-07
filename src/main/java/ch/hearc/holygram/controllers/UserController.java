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

import ch.hearc.holygram.accessors.UserRepository;
import ch.hearc.holygram.models.User;

@Controller
public class UserController {

	@Autowired
	private UserRepository uRepository;

	// private ProduitRepository prepo;

	@GetMapping(value = "/users")
	public String findAllProduits(Map<String, Object> model) {
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
	

	@GetMapping(value = "/profile")
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
