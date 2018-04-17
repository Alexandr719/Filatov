package com.epam.chat.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.epam.chat.dao.*;
import com.epam.chat.elements.ChatMessage;
import com.epam.chat.elements.MessageAction;
import com.epam.chat.elements.User;

import com.epam.chat.json.JsonReader;
import com.epam.chat.socket.Greeting;

@Controller
@SessionAttributes("sessinoUser")
public class LoginController {
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main(ModelMap model) throws SQLException {

		DAOFactory dao = DAOFactory.getDAOFactory();

		return new ModelAndView("home", "dao", dao);
	}


	@RequestMapping(value = "/login_user", method = RequestMethod.POST, produces = "text/html")
	@ResponseBody
	public String loginUser(@RequestParam("formData") String loginDate, User user, ModelMap model, HttpSession session) {
		String loginResult = "error";
		JsonReader reader = new JsonReader();
		System.out.println(session.getAttributeNames());
		DAOFactory dao = DAOFactory.getDAOFactory();
		UserDAO userDAO = dao.getUserDAO();
		user = reader.getPerson(loginDate);
		if (userDAO.checkLogIN(user) != null) {
			user = userDAO.checkLogIN(user);
			loginResult = "success";
			//model.put("sessinoUser", user);
			model.addAttribute("sessinoUser", user);
			
		
		} else {
			loginResult = "badpassword";
		}
		System.out.println("Answeeeer");
System.out.println(user);
		return loginResult;
	}

	@RequestMapping(value = "/registration_user", method = RequestMethod.POST, produces = "text/html")
	@ResponseBody
	public String registrationUser(@RequestParam("formData") String registrationDate, @ModelAttribute User user,
			ModelMap model) {
		String registrationResult = "error";

		JsonReader reader = new JsonReader();
		user = reader.getPerson(registrationDate);

		DAOFactory dao = DAOFactory.getDAOFactory();
		UserDAO userDAO = dao.getUserDAO();
		if (userDAO.isLogged(user)) {
			registrationResult = "badlogin";

		} else {
			userDAO.login(user);
			registrationResult = "success";
			model.addAttribute("sessinoUser", user);

		}

		return registrationResult;

	}

	@RequestMapping(value = "/exit", method = RequestMethod.POST, produces = "text/html")
	@ResponseBody
	public void exitUser(SessionStatus sessionStatus, ModelMap model) {

		DAOFactory dao = DAOFactory.getDAOFactory();
		UserDAO userDAO = dao.getUserDAO();
		User logoutUser = (User) model.get("sessinoUser");
		userDAO.logout(logoutUser);
		sessionStatus.setComplete();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
