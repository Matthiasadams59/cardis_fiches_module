package com.isep.cardis.projet_fiches_module_A2.user;

public class User {
	
	private String userName;
	private String firstName;
	private String lastName;
	private String mail;
	private String password;
	private String role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String user_name, String first_name, String last_name, String e_mail, String pass_word, String right) {
		this.userName = user_name;
		this.firstName = first_name;
		this.lastName = last_name;
		this.mail = e_mail;
		this.password = pass_word;
		this.role = right;
	}

}
