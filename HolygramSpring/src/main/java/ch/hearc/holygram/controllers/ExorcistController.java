package ch.hearc.holygram.controllers;

import ch.hearc.holygram.models.*;
import ch.hearc.holygram.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

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

        Optional<User> ouser = userRepository.findById((long) id);

        if (!ouser.isPresent()) {
            System.out.println("invalid user");
            return "redirect:/";
        }

        User u = ouser.get();

        Exorcist e = u.getExorcist();
        if (e == null) {
            System.out.println("not an exorcist");
            return "redirect:/";
        }

        boolean isEditing = edit != null;

        model.put("edit", isEditing);
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
        // TODO : use the real profileId
        long profileId = 2l;
        try {
            Exorcist e = userRepository.findById(profileId).get().getExorcist();
            Canton c = cantonRepository.findById(Long.valueOf(formData.getFirst("canton"))).get();
            e.setCanton(c);
            e.setPhoneNumber(formData.getFirst("phonenumber"));
            e.setDescription(formData.getFirst("description"));
            exorcistRepository.save(e);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/exorcist/" + profileId);
        return new ResponseEntity<Exorcist>(headers, HttpStatus.FOUND);
    }
}