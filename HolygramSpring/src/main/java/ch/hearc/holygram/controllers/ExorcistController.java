package ch.hearc.holygram.controllers;

import java.util.Map;
import java.util.Optional;

import ch.hearc.holygram.security.HolygramUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.hearc.holygram.models.Canton;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.CantonRepository;
import ch.hearc.holygram.repositories.DemonRepository;
import ch.hearc.holygram.repositories.ExorcistRepository;
import ch.hearc.holygram.repositories.ReligionRepository;
import ch.hearc.holygram.repositories.ServiceRepository;
import ch.hearc.holygram.repositories.UserRepository;

/**
 * Controller for the exorcists, display profile and modifications
 */
@Controller
@RequestMapping("exorcist")
public class ExorcistController {

	@Autowired
	ServiceRepository serviceRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ExorcistRepository exorcistRepository;

	@Autowired
	DemonRepository demonRepository;

	@Autowired
	CantonRepository cantonRepository;

	@Autowired
	ReligionRepository religionRepository;

	@GetMapping(value = "{id}", headers = "Accept=*/*")
	public String profile(Map<String, Object> model, @PathVariable int id,
			@RequestParam(required = false) String edit) {

		userRepository.findAll();
		Optional<User> ouser = userRepository.findById((long) id);

		if (!ouser.isPresent()) {
			return "redirect:/";
		}

		User u = ouser.get();

		Exorcist e = exorcistRepository.findByUser(u);
		if (e == null) {
			return "redirect:/";
		}

		boolean isOwnProfile = false;
		boolean isEditing = false;
		if(SecurityContextHolder.getContext().getAuthentication().getCredentials() == null)
        {
            HolygramUserDetails p = (HolygramUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Exorcist loggedExorcist = p.getUser().getExorcist();
            if(loggedExorcist != null && loggedExorcist.getUser().getId() == e.getUser().getId())
			{
				isOwnProfile = true;
				isEditing = edit != null;
			}
        }

		model.put("edit", isEditing);
		model.put("ownprofile", isOwnProfile);
		model.put("e", e);
		model.put("u", u);

		if (isEditing) {
			model.put("cantons", cantonRepository.findAll());
			model.put("religions", religionRepository.findAll());
		}
		return "exorcist/exorcist";
	}

	@PostMapping()
	public ResponseEntity<Exorcist> update(@RequestBody MultiValueMap<String, String> formData) {
		try {
			HolygramUserDetails p = (HolygramUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			long profileId = p.getUser().getId();

			userRepository.findAll();
			User u = userRepository.findById(profileId).get();
			Exorcist e = exorcistRepository.findByUser(u);
			Canton c = cantonRepository.findById(Long.valueOf(formData.getFirst("canton"))).get();
			e.setCanton(c);
			e.setPhoneNumber(formData.getFirst("phonenumber"));
			e.setDescription(formData.getFirst("description"));

			exorcistRepository.save(e);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Location", "/exorcist/" + profileId);
			return new ResponseEntity<>(headers, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}