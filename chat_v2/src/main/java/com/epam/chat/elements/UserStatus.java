package com.epam.chat.elements;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class UserStatus {
	
	
	private int idStatus;
	private String nameStatus;
	private String descriptionStatus;
	

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

	public UserStatus(int idStatus, String nameStatus, String descriptionStatus) {
		super();
		this.nameStatus = nameStatus;
		this.descriptionStatus = descriptionStatus;
		this.idStatus = idStatus;
	}

	public void setDescriptionStatus(String descriptionStatus) {
		this.descriptionStatus = descriptionStatus;
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}
}
