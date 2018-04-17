package com.epam.chat.elements;

public class UserRole {

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public String getDescriptionRole() {
		return descriptionRole;
	}

	public void setDescriptionRole(String descriptionRole) {
		this.descriptionRole = descriptionRole;
	}

	public String nameRole;
	public String descriptionRole;

	public UserRole(String nameRole, String descriptionRole) {
		super();
		this.nameRole = nameRole;
		this.descriptionRole = descriptionRole;
	}

	public UserRole() {
		// TODO Auto-generated constructor stub
	}

}
