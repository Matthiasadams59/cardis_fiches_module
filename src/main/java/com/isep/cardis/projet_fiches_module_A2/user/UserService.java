package com.isep.cardis.projet_fiches_module_A2.user;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		List<User> users = (List<User>) userRepository.findAll();
		//for (int i = 0 ; i < users.size() ; i++) {
		//	users.get(i).setPassword(passwordEncoder.encode(users.get(i).getPassword()));
		//}
		return users;
	}
	
	public User getUser(String username) {
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User user = userRepository.findByUsername(username);
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		return user;
	}
	
	public List<User> getAllUsersByRole(String role) {
		return userRepository.findByRole(role);
	}
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(String username) {
		userRepository.deleteByUsername(username);
	}
}
