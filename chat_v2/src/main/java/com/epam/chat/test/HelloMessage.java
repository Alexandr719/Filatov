package com.epam.chat.test;


public class HelloMessage {
	 private String name;
	 private String textMessage;

	    public String getName() {
	        return name;
	    }
	    public HelloMessage() {
			// TODO Auto-generated constructor stub
		}
		public String getTextMessage() {
			return textMessage;
		}
		public void setTextMessage(String textMessage) {
			this.textMessage = textMessage;
		}
		@Override
		public String toString() {
			return "HelloMessage [name=" + name + ", textMessage=" + textMessage + "]";
		}

}
