package ch.hearc.holygram.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ch.hearc.holygram.accessors.CantonRepository;
import ch.hearc.holygram.accessors.CustomerRepository;
import ch.hearc.holygram.models.Canton;
import ch.hearc.holygram.models.Customer;



@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CantonRepository cantonRepository;
	
	@GetMapping("/customers/signup")
	public String signUpCustomer(Map<String, Object> model) {

		Iterable<Canton> cantons = cantonRepository.findAll();
		model.put("cantons", cantons);
		
		return "customer/signup";
	}
	
	@GetMapping("/customers/{id}")
	public String retrieveCustomer(Map<String, Object> model, @PathVariable long id) {
		Optional<Customer> customer = customerRepository.findById(id);

		model.put("customer", customer.get());
		
		System.out.println("");
		System.out.println("toto");
		System.out.println("");
		
		return "customer/profile";
	}
	
	/*@PostMapping("/customers/create")
	public String createCustomer(@Valid @ModelAttribute Customer customer, BindingResult errors, Model model) {

		if (!errors.hasErrors()) {
			customer = customerRepository.save(customer);
        }

        return ((errors.hasErrors()) ? "customer/signup" : "redirect:/customers/" + customer.getId());
	}*/

	@PostMapping("/customers/{id}/update")
	public String updateCustomer(Map<String, Object> model, @RequestBody Customer customer) {

		Customer updateCustomer = customerRepository.save(customer);
		
		model.put("customer", updateCustomer);

		return "customer/profile";
	}
}
