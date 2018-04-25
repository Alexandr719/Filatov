package com.epam.chat.elements;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
@Data
public class ChatMessage {

  private int id;
  private User user;
  private Date timeStamp;
  private MessageAction action;
  private String textMessage;

  public ChatMessage() {
    // TODO Auto-generated constructor stub
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
