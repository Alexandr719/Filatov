package com.epam.chat.controllers;



import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;



import com.epam.chat.test.Greeting;
import com.epam.chat.test.HelloMessage;


@Controller
public class MessageController {
	


	 	@MessageMapping("/messages")
	    @SendTo("/topic/greetings")
	    public Greeting greeting(HelloMessage message) throws Exception {
	 		Thread.sleep(1000); 
	 		ObjectMapper mapper = new ObjectMapper();
	 		String jsonInString = mapper.writeValueAsString(message);
	        System.out.println(jsonInString);
	        return new Greeting(jsonInString);
	    }
	

	
}
