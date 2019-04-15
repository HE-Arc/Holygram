package ch.hearc.holygram.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.hearc.holygram.models.Religion;
import ch.hearc.holygram.repositories.ReligionRepository;

@Controller
@RequestMapping("religion")
public class ReligionController {

	@Autowired
	ReligionRepository religionRepository;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = {
			MimeTypeUtils.APPLICATION_JSON_VALUE }, headers = "Accept=application/json")
	public ResponseEntity<Iterable<Religion>> findAll() {
		try {
			return new ResponseEntity<>(religionRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {
			MimeTypeUtils.APPLICATION_JSON_VALUE }, headers = "Accept=application/json")
	public ResponseEntity<Religion> findAll(@PathVariable long id) {
		try {
			return new ResponseEntity<>(religionRepository.findById(id).get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}