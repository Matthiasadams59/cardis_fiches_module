package com.isep.cardis.projet_fiches_module_A2.welcome;

import java.io.IOException; 
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.util.WebUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.auth.HttpAuthenticator;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.isep.cardis.projet_fiches_module_A2.user.User;

@Controller
public class WelcomeController {
	
    @GetMapping(value={"tableau-de-bord"})
    public String welcome(HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model, Authentication authentication) throws URISyntaxException {    		
    		
    		authentication.getCredentials()
    	
    		final URI uri = new URI("http://localhost:" + request.getLocalPort() + "/api/users/" + request.getUserPrincipal().getName());
    		
    		RestTemplate restTemplate = new RestTemplate();          
    		CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    		Cookie cookie = WebUtils.getCookie(request, "SESSION");
    		    		
    	    HttpHeaders csrfHeaders = new HttpHeaders();
    	    csrfHeaders.add(csrf.getHeaderName(), csrf.getToken());
    	    csrfHeaders.add("Cookie", "SESSION="+cookie.getValue());
    	    
        HttpEntity<String> requestEntity = new HttpEntity<>("headers",csrfHeaders);
        ResponseEntity<User> raiponce = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, User.class);
        User currentUser = raiponce.getBody();
        session.setAttribute("currentFirstname", currentUser.getFirstname());
        
        //ResponseEntity<String> raiponce = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
        //System.out.println(raiponce);
    		
		if (request.isUserInRole("TEACHER") || request.isUserInRole("ADMIN")) {
			return "welcomeTeacher";
		} else {
			return "welcomeStudent";
		}
    }

}
