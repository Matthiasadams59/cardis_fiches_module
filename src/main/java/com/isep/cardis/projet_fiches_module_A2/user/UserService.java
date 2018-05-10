package com.isep.cardis.projet_fiches_module_A2.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	public User getUser(String username) {
		return userRepository.findByUsername(username);
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
