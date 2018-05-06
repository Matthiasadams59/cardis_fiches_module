package com.isep.cardis.projet_fiches_module_A2.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping("/users/{userName}")
	public User getUser(@PathVariable String userName) {
		return userService.getUser(userName);
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PutMapping("/users/{userName}")
	public void updateUser(@RequestBody User user, @PathVariable String userName) {
		userService.updateUser(userName, user);
	}
	
	@DeleteMapping("/users/{userName}")
	public void deleteUser(@PathVariable String userName) {
		userService.deleteUser(userName);
	}

}
