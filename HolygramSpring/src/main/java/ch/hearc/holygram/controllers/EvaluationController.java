package ch.hearc.holygram.controllers;

import ch.hearc.holygram.models.Canton;
import ch.hearc.holygram.models.Evaluation;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("evaluation")
public class EvaluationController {

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

    @Autowired
    EvaluationRepository evaluationRepository;

    @PostMapping(value="add/{exorcistId}")
    public ResponseEntity<Evaluation> update(@PathVariable long exorcistId, @RequestBody MultiValueMap<String, String> formData) {
        // TODO : use the real customer id
        long customerId = 1l;
        try {
            Exorcist e = userRepository.findById((long)exorcistId).get().getExorcist();
            Evaluation eval = new Evaluation();
            eval.setExorcist(e);
            eval.setCustomer(userRepository.findById(customerId).get().getCustomer());
            eval.setPositive(Integer.valueOf(formData.getFirst("evaluation")) > 0);
            eval.setText(formData.getFirst("comment"));
            System.out.println(eval);
            evaluationRepository.save(eval);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/exorcist/" + exorcistId);
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}