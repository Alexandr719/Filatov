package com.epam.chat.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.epam.chat.dao.DAOFactory;
import com.epam.chat.elements.User;

@Controller
public class MessageController {
	

	@RequestMapping(value = "/send_message", method = RequestMethod.GET)
	public ModelAndView main(HttpSession session) throws SQLException  {
		System.out.println("В контроллере сообщений");
		User user = new User();
		user.setLogin("LoginUser");
			
	
		
				

		
		
		return new ModelAndView("home", "user",user);
	}

}
