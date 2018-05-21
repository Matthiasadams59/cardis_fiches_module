package com.isep.cardis.projet_fiches_module_A2.welcome;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.WebUtils;

import com.isep.cardis.projet_fiches_module_A2.user.User;

@Controller
public class WelcomeController {
	
    @GetMapping(value={"tableau-de-bord"})
    public String welcome(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {    		
    		final URI uri = new URI("http://localhost:" + request.getLocalPort() + "/api/users/" + request.getUserPrincipal().getName());

    		RestTemplate restTemplate = new RestTemplate();
    		//User result = restTemplate.getForObject(uri, User.class);    		
    		String userInfo = restTemplate.getForObject(uri, String.class);
    		
    		/*CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName()); // Or "_csrf" (See CSRFFilter.doFilterInternal).
        String token = csrf.getToken();
        
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String> entity = new HttpEntity<>("_csrf=" + token,httpHeaders);
		String userInfo = restTemplate.getForObject(uri, entity, String.class);*/
        
    		System.out.println(userInfo);
    		
		if (request.isUserInRole("TEACHER") || request.isUserInRole("ADMIN")) {
			//session.setAttribute("currentFirstname", result.getFirstname());
			return "welcomeTeacher";
		} else {
			return "welcomeStudent";
		}
    }

}
