package ch.hearc.holygram.controllers;

import java.util.Map;

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
