package com.epam.chat.controllers;



import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.epam.chat.elements.ChatMessage;
import com.epam.chat.test.Greeting;



@Controller
public class MessageController {
	


	 	@MessageMapping("/messages")
	    @SendTo("/topic/greetings")
	    public Greeting greeting(ChatMessage message) throws Exception {
	 		Thread.sleep(1000); 
	 		ObjectMapper mapper = new ObjectMapper();
	 		java.util.Date date = new java.util.Date();
			message.setTimeStamp(date);
			String jsonInString = mapper.writeValueAsString(message);
	       
	        return new Greeting(jsonInString);
	    }
	

	
}
