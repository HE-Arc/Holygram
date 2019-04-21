package ch.hearc.holygram.controllers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ch.hearc.holygram.models.Canton;
import ch.hearc.holygram.models.Customer;
import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.Role;
import ch.hearc.holygram.models.User;
import ch.hearc.holygram.repositories.CantonRepository;
import ch.hearc.holygram.repositories.CustomerRepository;
import ch.hearc.holygram.repositories.ExorcistRepository;
import ch.hearc.holygram.repositories.RoleRepository;
import ch.hearc.holygram.security.UserValidator;
import ch.hearc.holygram.services.SecurityServiceImpl;
import ch.hearc.holygram.services.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityServiceImpl securityService;

	@Autowired
	private ExorcistRepository exorcistRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CantonRepository cantonRepository;
	
	@Autowired
	private RoleRepository roleRepository;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/signup")
    public String signup(Model model) {
    	
    	Iterable<Canton> cantons = cantonRepository.findAll();
        model.addAttribute("cantons", cantons);

        model.addAttribute("user", new User());
        
        return "signup";
	}

    @PostMapping("/signup")
    public String registration(@ModelAttribute("user") User user, HttpServletRequest request, BindingResult bindingResult) {
		try {			
			//user = new User(request.getParameter("username"),request.getParameter("password"),request.getParameter("passwordConfirm"), request.getParameter("email"));
			userValidator.validate(user, bindingResult);

	        if (bindingResult.hasErrors()) {
	            return "signup";
	        }

	        String typeAccount = request.getParameter("type");
	        
	        if (typeAccount.equals("customer")) {
	        	Customer customer = new Customer(user);
	        	Role role = roleRepository.findByName("CUSTOMER");
	        	user.setRole(role);
	        	userService.save(user);
	        	customerRepository.save(customer);
	        } else {
	        	Canton canton = cantonRepository.findByAcronym(request.getParameter("canton"));
	        	Exorcist exorcist = new Exorcist(user, request.getParameter("description"), request.getParameter("phoneNumber"), canton);
	        	Role role = roleRepository.findByName("EXORCIST");
	        	user.setRole(role);
	        	userService.save(user);
	        	exorcistRepository.save(exorcist);
	        }
	        
	        
	        securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return "redirect:/";
    }
    
    @GetMapping("/formExorcist")
    public String formExorcist(Model model) {
		Iterable<Canton> cantons = cantonRepository.findAll();
        model.addAttribute("cantons", cantons);
        
        System.out.println("");
        System.out.println("pika");
        System.out.println("");
        return "fragments/signup :: exorcist";
    }
}