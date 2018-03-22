package com.epam.chat.elements;



public class ChatMessage {
	private Long id;
    private User user;
    private String timeStamp;
    private MessageAction action;
	private String textMessage;
 
    
    
    public ChatMessage() {
		// TODO Auto-generated constructor stub
	}
    
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getTextMessage() {
		return textMessage;
	}
	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}
	
}
