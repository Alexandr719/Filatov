package com.epam.chat.elements;


public class User {
	private String login;
	private String password;
	private String name;
	private String surname;
	private String telephone;
	private String email;
	private UserRole userRole;
	private UserStatus userStatus;
	private String pathToFoto;
	
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	
	
	
	

	public User(String login, String password, String name, String surname, String telephone, String email,
			UserRole userRole, UserStatus userStatus, String pathToFoto) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.telephone = telephone;
		this.email = email;
		this.userRole = userRole;
		this.userStatus = userStatus;
		this.pathToFoto = pathToFoto;
	}


	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public UserStatus getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	public String getPathToFoto() {
		return pathToFoto;
	}

	public void setPathToFoto(String pathToFoto) {
		this.pathToFoto = pathToFoto;
	}


	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", telephone=" + telephone + ", email=" + email + "]";
	}
	
	
}
