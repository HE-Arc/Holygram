package ch.hearc.holygram.controllers;


import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ch.hearc.holygram.models.Customer;
import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.CantonRepository;
import ch.hearc.holygram.repositories.CustomerRepository;
import ch.hearc.holygram.repositories.ExorcistRepository;
import ch.hearc.holygram.repositories.UserRepository;
import ch.hearc.holygram.security.UserValidator;
import ch.hearc.holygram.services.SecurityService;
import ch.hearc.holygram.services.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ExorcistRepository exorcistRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CantonRepository cantonRepository;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("userForm", new User());

        return "signup";
	}

    @PostMapping("/signup")
    public String registration(HttpServletRequest request, BindingResult bindingResult) {
    	User user;
		try {
			user = new User(request.getParameter("username"),request.getParameter("password"),request.getParameter("passwordConfirm"), request.getParameter("email"));
			userValidator.validate(user, bindingResult);

	        if (bindingResult.hasErrors()) {
	            return "signup";
	        }
	        
	        System.out.println(bindingResult);

	        

	        String typeAccount = request.getParameter("type");
	        
	        if (typeAccount == "customer") {
	        	Customer customer = new Customer(user);
	        	userService.save(user);
	        	customerRepository.save(customer);
	        }
	        
	        
	        //securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return "signup";
        //return "redirect:/";
    }
}