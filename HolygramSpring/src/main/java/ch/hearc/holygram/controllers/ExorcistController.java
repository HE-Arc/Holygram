package ch.hearc.holygram.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ch.hearc.holygram.repositories.CantonRepository;
import ch.hearc.holygram.repositories.ExorcistRepository;
import ch.hearc.holygram.models.Canton;
import ch.hearc.holygram.models.Exorcist;

@Controller
public class ExorcistController {

	@Autowired
	private ExorcistRepository ExorcistRepository;
	@Autowired
	private CantonRepository cantonRepository;
	
	@GetMapping("/exorcists")
	public String retrieveAllExorcists(Map<String, Object> model) {
		
		Iterable<Exorcist> exorcists = ExorcistRepository.findAll();
		Iterable<Canton> cantons = cantonRepository.findAll();
		
		model.put("exorcists", exorcists);
		model.put("cantons", cantons);
		
		return "exocist/list";
	}
	
	@GetMapping("/exorcists/signup")
	public String signUpExorcist(Map<String, Object> model) {

		Iterable<Canton> cantons = cantonRepository.findAll();
		model.put("cantons", cantons);
		
		return "exorcist/signup";
	}
	
	@GetMapping("/exorcists/{id}")
	public String retrieveExorcist(Map<String, Object> model, @PathVariable long id) {
		Optional<Exorcist> exorcist = ExorcistRepository.findById(id);

		model.put("exorcist", exorcist.get());
		
		return "exorcist/profile";
	}
	
	@PostMapping("/exorcists/create")
	public String createExorcist(Map<String, Object> model, @RequestBody Exorcist exorcist) {
		
		Exorcist saveExorcist = ExorcistRepository.save(exorcist);
		
		model.put("exorcist", saveExorcist);
		
		return "exorcist/profile";
	}

	@PostMapping("/exorcists/{id}/update")
	public String updateExorcist(Map<String, Object> model, @RequestBody Exorcist exorcist) {

		Exorcist updateExorcist = ExorcistRepository.save(exorcist);
		
		model.put("exorcist", updateExorcist);

		return "exorcist/profile";
	}
}
