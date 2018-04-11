package com.epam.chat.elements;


import java.util.Date;

public class ChatMessage {
	private int id;
    private String userLogin;
    private Date timeStamp;
    private MessageAction action;
	private String textMessage;
 
    
    
    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUserLogin() {
		return userLogin;
	}



	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}



	








	public Date getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}



	public MessageAction getAction() {
		return action;
	}



	public void setAction(MessageAction action) {
		this.action = action;
	}



	public String getTextMessage() {
		return textMessage;
	}



	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}



	public ChatMessage() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "ChatMessage [userLogin=" + userLogin + ", timeStamp=" + timeStamp + ", textMessage=" + textMessage
				+ "]";
	}
    
    
   
	
}
