package com.isep.cardis.projet_fiches_module_A2.index;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import javax.print.DocFlavor.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.isep.cardis.projet_fiches_module_A2.user.User;

@Controller
public class IndexController {

    @GetMapping(value={"", "/", "index"})
    public String index(Model model, HttpSession session) {
    		return "index";
    		/*String currentUserRole = (String) session.getAttribute("currentUserRole");
    		if (currentUserRole != null) {
    			return "redirect:/tableau-de-bord";
    		} else {
    	        
    		}*/
    }
    
    /*
    @PostMapping(value= {"","/", "index"})
    public String connexion(Model model, HttpServletRequest request, HttpSession session) {
    		
    		String inputUsername = request.getParameter("inputUsername");
    		String inputPassword = request.getParameter("inputPassword");    		
    		
		try {	    		
	    		final URI uri = new URI("http://localhost:" + request.getLocalPort() + "api/users/" + inputUsername);

	    		RestTemplate restTemplate = new RestTemplate();
	    		User result = restTemplate.getForObject(uri, User.class);
	    		
	    		if (result != null && result.getUsername().equals(inputUsername) && result.getPassword().equals(inputPassword))  {
    				//session.setAttribute("currentUser", result);
	    			
	    			session.setAttribute("currentUsername", result.getUsername());
    				session.setAttribute("currentUserRole", result.getRole());
    				session.setAttribute("currentFirstname", result.getFirstname());
    				
    				return "redirect:/tableau-de-bord";
	    		} else {
	    			String message = "";
	    			model.addAttribute("connectError", message);
	    			return "index";
	    		}

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
    			model.addAttribute("connectError", e.getMessage());
			return "index";
		}

    }
    */

}
