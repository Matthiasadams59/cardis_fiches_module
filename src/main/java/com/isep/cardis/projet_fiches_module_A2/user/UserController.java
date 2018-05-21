package com.isep.cardis.projet_fiches_module_A2.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("api/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping("api/users/{username}")
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User getUser(@PathVariable String username) {
		return userService.getUser(username);
	}
	
	@PostMapping("api/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PutMapping("api/users/{username}")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}
	
	@DeleteMapping("api/users/{username}")
	public void deleteUser(@PathVariable String username) {
		userService.deleteUser(username);
	}

}
