package com.epam.chat.elements;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MessageAction {
	private int idAction;
	private String nameAction;
	private String desctiptionAction;

	public MessageAction() {
		// TODO Auto-generated constructor stub
	}

	

	public MessageAction(int idAction, String nameAction, String desctiptionAction) {
		super();
		this.idAction = idAction;
		this.nameAction = nameAction;
		this.desctiptionAction = desctiptionAction;
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

	public int getIdAction() {
		return idAction;
	}

	public void setIdAction(int idAction) {
		this.idAction = idAction;
	}

	
	
	
}
