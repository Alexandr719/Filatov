package com.epam.chat.controllers;



import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import com.epam.chat.dao.DAOFactory;
import com.epam.chat.dao.MessageDAO;
import com.epam.chat.elements.ChatMessage;
import com.epam.chat.elements.MessageAction;
import com.epam.chat.elements.User;
import com.epam.chat.test.Greeting;



@Controller
public class MessageController {
	
	 	@MessageMapping("/messages")
	    @SendTo("/topic/greetings")
	    public Greeting greeting(ChatMessage message,ModelMap model) throws Exception {
	 		ObjectMapper mapper = new ObjectMapper();
	 		java.util.Date date = new java.util.Date();
			message.setTimeStamp(date);
			
										
			String jsonInString = mapper.writeValueAsString(message);
			
			
			MessageAction messageAction = new MessageAction();
			messageAction.setNameAction("SEND");
			messageAction.setDesctiptionAction("Пользователь отправил сообщение");
			message.setAction(messageAction);
			User user = (User) model.get("sessinoUser");
			message.setUser(user);
			DAOFactory dao = DAOFactory.getDAOFactory();
			MessageDAO messageDAO =  dao.getMessageDAO();
  		    messageDAO.sentMessage(message);
			
			
			
	       
	        return new Greeting(jsonInString);
	    }
	

	
}
