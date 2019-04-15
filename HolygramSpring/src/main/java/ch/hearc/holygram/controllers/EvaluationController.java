package ch.hearc.holygram.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.hearc.holygram.models.Customer;
import ch.hearc.holygram.models.Evaluation;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.CantonRepository;
import ch.hearc.holygram.repositories.CustomerRepository;
import ch.hearc.holygram.repositories.DemonRepository;
import ch.hearc.holygram.repositories.EvaluationRepository;
import ch.hearc.holygram.repositories.ExorcistRepository;
import ch.hearc.holygram.repositories.ReligionRepository;
import ch.hearc.holygram.repositories.ServiceRepository;
import ch.hearc.holygram.repositories.UserRepository;

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
    CustomerRepository customerRepository;

    @Autowired
    DemonRepository demonRepository;

    @Autowired
    CantonRepository cantonRepository;

    @Autowired
    ReligionRepository religionRepository;

    @Autowired
    EvaluationRepository evaluationRepository;

    @PostMapping(value = "add/{exorcistId}")
    public ResponseEntity<Evaluation> update(@PathVariable long exorcistId,
                                             @RequestBody MultiValueMap<String, String> formData) {
        // TODO : use the real customer id
        long customerId = 1l;
        try {
            User ue = userRepository.findById((long) exorcistId).get();
            Exorcist e = exorcistRepository.findByUser(ue);
            Evaluation eval = new Evaluation();
            eval.setExorcist(e);

            User uc = userRepository.findById((long) customerId).get();
            Customer c = customerRepository.findByUser(uc);
            eval.setCustomer(c);

            eval.setPositive(Integer.valueOf(formData.getFirst("evaluation")) > 0);
            eval.setText(formData.getFirst("comment"));

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