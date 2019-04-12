package ch.hearc.holygram.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ch.hearc.holygram.models.Customer;
import ch.hearc.holygram.repositories.CustomerRepository;



@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@PostMapping("/customers/create")
	@PostAuthorize("hasRole('CUSTOMER')")
	public String createCustomer(@Valid @ModelAttribute Customer customer, BindingResult errors, Model model) {

		if (!errors.hasErrors()) {
			customer = customerRepository.save(customer);
        }

        return ((errors.hasErrors()) ? "customer/signup" : "redirect:/customers/" + customer.getId());
	}

	@PostMapping("/customers/{id}/update")
	public String updateCustomer(Map<String, Object> model, @RequestBody Customer customer) {

		Customer updateCustomer = customerRepository.save(customer);
		
		model.put("customer", updateCustomer);

		return "customer/profile";
	}
}
