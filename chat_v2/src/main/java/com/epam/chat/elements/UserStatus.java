package com.epam.chat.elements;

public class UserStatus {
	public String nameStatus;
	public String descriptionStatus;

	public UserStatus() {
		// TODO Auto-generated constructor stub
	}

	public String getNameStatus() {
		return nameStatus;
	}

	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}

	public String getDescriptionStatus() {
		return descriptionStatus;
	}

	public UserStatus(String nameStatus, String descriptionStatus) {
		super();
		this.nameStatus = nameStatus;
		this.descriptionStatus = descriptionStatus;
	}

	public void setDescriptionStatus(String descriptionStatus) {
		this.descriptionStatus = descriptionStatus;
	}
}
