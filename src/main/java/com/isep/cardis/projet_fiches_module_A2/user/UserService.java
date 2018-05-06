package com.isep.cardis.projet_fiches_module_A2.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private List<User> users = new ArrayList<>(Arrays.asList(
				new User("dmutombo", "Dikembe", "Mutombo", "dikembe.mutombo@isep.fr", "ISEP2018", "admin"),
				new User("jmara", "Jean", "Mara", "jean.mara@isep.fr", "ISEP2018", "teacher"),
				new User("jdickinson", "Jack", "Dickison", "jack.dickison@isep.fr", "ISEP2018", "student")
				));
	
	public List<User> getAllUsers() {
		return users;
	}
	
	public User getUser(String username) {
		return users.stream().filter(u -> u.getUserName().equals(username)).findFirst().get();
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void updateUser(String username, User user) {
		for (int i = 0 ; i < users.size() ; i++) {
			User u = users.get(i);
			if (u.getUserName().equals(username)) {
				users.set(i, user);
				return;
			}
		}
	}
	
	public void deleteUser(String username) {
		users.removeIf(u -> u.getUserName().equals(username));
	}
}
