package ch.hearc.holygram.controllers;

import java.util.Map;

import ch.hearc.holygram.models.User;
import ch.hearc.holygram.security.HolygramUserDetails;
import ch.hearc.holygram.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String homePage(Map<String, Object> model) {
//        if(SecurityContextHolder.getContext().getAuthentication().getCredentials() == null)
//        {
//            HolygramUserDetails p = (HolygramUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            System.out.println(p.getUser().getCustomer());
//            System.out.println(p.getUser().getExorcist());
//        }
        return "index";
    }
}
