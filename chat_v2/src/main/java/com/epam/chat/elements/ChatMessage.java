package com.epam.chat.elements;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatMessage {

  private int id;
  private User user;
  private Date timeStamp;
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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getTimeHourMinSec() {
    SimpleDateFormat sm = new SimpleDateFormat("HH:mm:ss");
    String strDate = sm.format(this.timeStamp);

    return strDate;

  }

  @Override
  public String toString() {
    return "ChatMessage [userLogin=" + user + ", textMessage=" + textMessage + "]";
  }

}
