package com.isep.cardis.projet_fiches_module_A2.logout;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@GetMapping(value={"logout"})
    public String logout(HttpSession session) {
    		session.invalidate();
    		return "redirect:/";
    }

}
