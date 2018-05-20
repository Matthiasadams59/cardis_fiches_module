
package com.isep.cardis.projet_fiches_module_A2.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.isep.cardis.projet_fiches_module_A2.user.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired
    private UserService userService;
    
    @Autowired
    protected void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(username -> {
			        	Collection<GrantedAuthority> grantedAuthority = new ArrayList<>();
		            if (userService.getUser(username).getRole().equals("admin")){
		                grantedAuthority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		                grantedAuthority.add(new SimpleGrantedAuthority("ROLE_TEACHER"));
		            } else if (userService.getUser(username).getRole().equals("teacher")) {
		                grantedAuthority.add(new SimpleGrantedAuthority("ROLE_TEACHER"));
		            }
		            grantedAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
                    User user = new User(userService.getUser(username).getUsername(), passwordEncoder.encode(userService.getUser(username).getPassword()), grantedAuthority);
                    return user;
                }).passwordEncoder(passwordEncoder);
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
        		.antMatchers("/webjars/**").permitAll()
            .antMatchers("/api/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .csrf().disable()
        .formLogin()
            .loginPage("/")
            .defaultSuccessUrl("/tableau-de-bord", true)
            .permitAll()
            .and()
        .logout()
        		.logoutUrl("/logout")
        		.permitAll()
        		.logoutSuccessUrl("/?logout");
	}

}

