package com.epam.chat.controllers;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.epam.chat.dao.*;
import com.epam.chat.dao.jdbc.hibernate.*;
import com.epam.chat.elements.ChatMessage;
import com.epam.chat.elements.MessageAction;
import com.epam.chat.elements.User;

import com.epam.chat.json.JsonReader;




@Controller
@SessionAttributes("sessinoUser")
public class LoginController {
	
	//private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main(ModelMap model) throws SQLException  {
		
		DAOFactory dao = DAOFactory.getDAOFactory();
		
		User user = new User();
		user.setLogin("Alexandr");
	
		//model.put("sessinoUser",user);
		java.util.Date date = new java.util.Date();
				
		MessageDAO messageDAO =  dao.getMessageDAO();
		ChatMessage message = new ChatMessage();
		MessageAction action = new MessageAction();
		action.setNameAction("LOGIN");
		action.setDesctiptionAction("Пользователь зарегитрировался");
		message.setUser(user);
		message.setTimeStamp(date);
		message.setTextMessage("Hello guys7777");
		message.setAction(action);
		//messageDAO.sentMessage(message);
		System.out.println("Hello");
		System.out.println(messageDAO.getLast(0).get(0).getTimeHMS());
		
			
		

		

	
		
				

		
		//WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
		return new ModelAndView("home", "dao", dao);
	}
	
	@RequestMapping(value = "/login_user", method = RequestMethod.POST,produces="text/html")
	@ResponseBody
	public  String loginUser(@RequestParam("formData") String loginDate,User user) {
		System.out.println("Внутри контроллера реистрации");
		String loginResult = "error";
		JsonReader reader = new JsonReader();
	    DAOFactory dao = DAOFactory.getDAOFactory();
		UserDAO userDAO = dao.getUserDAO();
		user = reader.getPerson(loginDate);
	    if(userDAO.checkLogIN(user) != null) {
	    	user = userDAO.checkLogIN(user);
	    	loginResult = "success";
	    }else {
	    	loginResult = "badpassword";
	    }
	    
	    
		
		return loginResult;
	}
	
	
	@RequestMapping(value = "/registration_user", method = RequestMethod.POST,produces="text/html")
	@ResponseBody
	public  String registrationUser(@RequestParam("formData") String registrationDate, @ModelAttribute User user,ModelMap model) {
		String registrationResult = "error";
	
		JsonReader reader = new JsonReader();
		user = reader.getPerson(registrationDate);
	
		DAOFactory dao = DAOFactory.getDAOFactory();
		UserDAO userDAO = dao.getUserDAO();
		if(userDAO.isLogged(user)){
			System.out.println("Пользователь с данным ником зарегистрирован");
			registrationResult = "badlogin";
			
		}else {
			userDAO.login(user);
			registrationResult = "success";
			model.put("sessinoUser",user);
			
	
		}
		
	    System.out.println(user);
	
	
		return registrationResult;

}
	
	@RequestMapping(value = "/exit", method = RequestMethod.POST,produces="text/html")
	@ResponseBody
	public  void exitUser(SessionStatus sessionStatus,ModelMap model) {
		
		
		DAOFactory dao = DAOFactory.getDAOFactory();
		UserDAO userDAO = dao.getUserDAO();
		User logoutUser = (User) model.get("sessinoUser");
		userDAO.logout(logoutUser);
		sessionStatus.setComplete(); 
	
	}
	
	
	
	
	
	
	
	
	
	
}
