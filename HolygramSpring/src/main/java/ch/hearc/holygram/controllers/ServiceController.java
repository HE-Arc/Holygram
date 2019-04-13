package ch.hearc.holygram.controllers;

import ch.hearc.holygram.models.Demon;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.Religion;
import ch.hearc.holygram.models.Service;
import ch.hearc.holygram.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("service")
public class ServiceController {

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DemonRepository demonRepository;

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json"
    )
    public ResponseEntity<Iterable<Service>> findAll() {
        try {
            return new ResponseEntity<>(serviceRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json"
    )
    public ResponseEntity<Service> find(@PathVariable long id) {
        try {
            return new ResponseEntity<>(serviceRepository.findById(id).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(
            value = "delete/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Service> remove(@PathVariable long id) {
        /* Waiting for authentication to implement the correct gather of the profile id */
        long profileId = 2l;
        try {
            serviceRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/exorcist/" + profileId + "?edit");
        return new ResponseEntity<Service>(headers, HttpStatus.FOUND);
    }

    @RequestMapping(
            value = "add",
            method = RequestMethod.POST
    )
    public ResponseEntity<Service> add(@RequestBody MultiValueMap<String, String> formData) {
        /* Waiting for authentication to implement the correct gather of the profile id */
        long profileId = 2l;
        try {
            Service s = new Service();
            Exorcist e = userRepository.findById(profileId).get().getExorcist();
            Demon d = demonRepository.findById(Long.valueOf(formData.getFirst("demon"))).get();
            s.setExorcist(e);
            s.setPrice(Float.valueOf(formData.getFirst("price")));
            s.setDemon(d);
            serviceRepository.save(s);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/exorcist/" + profileId + "?edit");
        return new ResponseEntity<Service>(headers, HttpStatus.FOUND);
    }
}