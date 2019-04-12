package ch.hearc.holygram.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ch.hearc.holygram.models.User;
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
    private UserValidator userValidator;

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("userForm", new User());

        return "signup";
    }

    @PostMapping("/signup")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, HttpServletRequest request) {
    	userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "signup";
        }
        
        System.out.println(bindingResult);

        userService.save(userForm);

        String typeAccount = request.getParameter("type");
        
        if (typeAccount == "customer")
        
        
        //securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "signup";
        //return "redirect:/";
    }
}