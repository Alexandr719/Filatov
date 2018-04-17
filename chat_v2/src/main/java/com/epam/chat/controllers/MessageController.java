package com.epam.chat.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.epam.chat.dao.DAOFactory;
import com.epam.chat.dao.MessageDAO;
import com.epam.chat.dao.UserDAO;
import com.epam.chat.elements.ChatMessage;
import com.epam.chat.elements.MessageAction;
import com.epam.chat.elements.User;
import com.epam.chat.socket.Greeting;

@Controller
public class MessageController {
	
	

	@MessageMapping("/messages")
	@SendTo("/topic/greetings")
	public Greeting greeting(ChatMessage message, User user) throws Exception {
		DAOFactory dao = DAOFactory.getDAOFactory();
		UserDAO userDAO = dao.getUserDAO();
		java.util.Date date = new java.util.Date();
		
		ObjectMapper mapper = new ObjectMapper();
		user = userDAO.getUserByNick(message.getUser().getLogin());
		message.setTimeStamp(date);
		message.setUser(user);
		
		String jsonInString = mapper.writeValueAsString(message);
        
		MessageAction messageAction = new MessageAction();
		messageAction.setNameAction("SEND");
		messageAction.setDesctiptionAction("Пользователь отправил сообщение");
		message.setAction(messageAction);
		
		
		
		MessageDAO messageDAO = dao.getMessageDAO();
	    messageDAO.sentMessage(message);

		return new Greeting(jsonInString);
	}

}
