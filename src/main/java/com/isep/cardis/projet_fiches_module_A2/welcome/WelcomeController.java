package com.isep.cardis.projet_fiches_module_A2.welcome;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.isep.cardis.projet_fiches_module_A2.user.User;

@Controller
public class WelcomeController {
	
    @GetMapping(value={"tableau-de-bord"})
    public String welcome(HttpSession session, HttpServletRequest request) throws URISyntaxException {    		
    		final URI uri = new URI("http://localhost:" + request.getLocalPort() + "/api/users/" + request.getUserPrincipal().getName());

    		RestTemplate restTemplate = new RestTemplate();
    		User result = restTemplate.getForObject(uri, User.class);
    		
		if (request.isUserInRole("TEACHER") || request.isUserInRole("ADMIN")) {
			session.setAttribute("currentUsername", result.getUsername());
			return "welcomeTeacher";
		} else {
			return "welcomeStudent";
		}
    }

}
