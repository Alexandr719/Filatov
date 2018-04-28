package com.epam.chat.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.chat.dao.DAOFactory;
import com.epam.chat.dao.MessageDAO;
import com.epam.chat.dao.UserDAO;
import com.epam.chat.elements.ChatMessage;
import com.epam.chat.elements.MessageAction;
import com.epam.chat.elements.User;

@Controller
public class MessageController {

  @MessageMapping("/messages")
  @SendTo("/topic/greetings")
  @ResponseBody
  public ChatMessage greeting(ChatMessage message, User user) throws Exception {
      
    
    
    MessageAction messageAction = null;
    DAOFactory dao = DAOFactory.getDAOFactory();
    UserDAO userDAO = dao.getUserDAO();
    java.util.Date date = new java.util.Date();
    user = userDAO.getUserByNick(message.getUser().getLogin());
    message.setTimeStamp(date);
    message.setUser(user);

    System.out.println(message.getAction().getIdAction());

    switch (message.getAction().getIdAction()) {
    case 1:
      messageAction = new MessageAction(1, "SEND", "Пользователь оставил сообщение");
      break;
      case 2:
      messageAction = new MessageAction(2, "LOGIN", "Пользватель зашел в сеть");
      message.setTextMessage(user.getLogin() + " connect to chat");
      break;

    }

    message.setAction(messageAction);
    MessageDAO messageDAO = dao.getMessageDAO();
    messageDAO.sentMessage(message);
    return message;
  }

}
