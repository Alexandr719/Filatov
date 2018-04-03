package com.epam.chat.controllers;



import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;



import com.epam.chat.test.Greeting;
import com.epam.chat.test.HelloMessage;

@Controller
public class GreetingController {
	


	 	@MessageMapping("/hello")
	    @SendTo("/topic/greetings")
	    public Greeting greeting(HelloMessage message) throws Exception {
	 		System.out.println("fsdfsdf");
	        Thread.sleep(3000); // simulated delay
	        return new Greeting("Hello, " + message.getName() + "!");
	    }
	

	
}
