package ch.hearc.holygram.controllers;

import ch.hearc.holygram.security.HolygramUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.hearc.holygram.models.Demon;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.Service;
import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.DemonRepository;
import ch.hearc.holygram.repositories.ExorcistRepository;
import ch.hearc.holygram.repositories.ServiceRepository;
import ch.hearc.holygram.repositories.UserRepository;

@Controller
@RequestMapping("service")
public class ServiceController {

	@Autowired
	ServiceRepository serviceRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	DemonRepository demonRepository;

	@Autowired
	ExorcistRepository exorcistRepository;

	@GetMapping(value = "", produces = {
			MimeTypeUtils.APPLICATION_JSON_VALUE }, headers = "Accept=application/json")
	public ResponseEntity<Iterable<Service>> findAll() {
		try {
			return new ResponseEntity<>(serviceRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/{id}", produces = {
			MimeTypeUtils.APPLICATION_JSON_VALUE }, headers = "Accept=application/json")
	public ResponseEntity<Service> find(@PathVariable long id) {
		try {
			return new ResponseEntity<>(serviceRepository.findById(id).get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "delete/{id}")
	public ResponseEntity<Service> remove(@PathVariable long id) {
		try {
			HolygramUserDetails p = (HolygramUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			long profileId = p.getUser().getId();

			Service s = serviceRepository.findById(id).get();
			if(s.getExorcist().getUser().getId() != profileId)
				throw new Exception("the given service assigned for the currently logged in user");
			serviceRepository.deleteById(id);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Location", "/exorcist/" + profileId + "?edit");
			return new ResponseEntity<>(headers, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "add")
	public ResponseEntity<Service> add(@RequestBody MultiValueMap<String, String> formData) {
		/*
		 * Waiting for authentication to implement the correct gather of the exorcist id
		 */
		try {
			HolygramUserDetails p = (HolygramUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			long profileId = p.getUser().getId();

			Service s = new Service();
			userRepository.findAll();
			User u = userRepository.findById(profileId).get();
			Exorcist e = exorcistRepository.findByUser(u);
			Demon d = demonRepository.findById(Long.valueOf(formData.getFirst("demon"))).get();
			s.setExorcist(e);
			s.setPrice(Float.valueOf(formData.getFirst("price")));
			s.setDemon(d);
			serviceRepository.save(s);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Location", "/exorcist/" + profileId + "?edit");
			return new ResponseEntity<>(headers, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}