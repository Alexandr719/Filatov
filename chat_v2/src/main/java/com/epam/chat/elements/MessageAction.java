package com.epam.chat.elements;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MessageAction {
	private String nameAction;
	private String desctiptionAction;

	public MessageAction() {
		// TODO Auto-generated constructor stub
	}

	public MessageAction(String nameAction, String desctiptionAction) {
		// TODO Auto-generated constructor stub
	}

	public String getNameAction() {
		return nameAction;
	}

	public void setNameAction(String nameAction) {
		this.nameAction = nameAction;
	}

	public String getDesctiptionAction() {
		return desctiptionAction;
	}

	public void setDesctiptionAction(String desctiptionAction) {
		this.desctiptionAction = desctiptionAction;
	}

	
	
	
}
