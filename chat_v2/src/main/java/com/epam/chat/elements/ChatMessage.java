package com.epam.chat.elements;



public class ChatMessage {
	private int id;
    private String userLogin;
    private Long timeStamp;
    private MessageAction action;
	private String textMessage;
 
    
    
    public ChatMessage() {
		// TODO Auto-generated constructor stub
	}
    
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return userLogin;
	}
	public void setUser(String userLogin) {
		this.userLogin = userLogin;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getTextMessage() {
		return textMessage;
	}
	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}


	public MessageAction getAction() {
		return action;
	}


	public void setAction(MessageAction action) {
		this.action = action;
	}
	
}
