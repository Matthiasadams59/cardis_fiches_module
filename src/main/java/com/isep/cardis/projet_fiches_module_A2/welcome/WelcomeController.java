package com.isep.cardis.projet_fiches_module_A2.welcome;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
    @GetMapping(value={"tableau-de-bord"})
    public String welcome(HttpSession session) {
    		String currentUserRole = (String) session.getAttribute("currentUserRole");
    		if (currentUserRole != null) {
    			if (currentUserRole.equals("admin") || currentUserRole.equals("teacher")) {
    				return "welcomeTeacher";
    			} else {
    				return "welcomeStudent";
    			}
    		} else {
			return "redirect:/";
    		}
    }

}
