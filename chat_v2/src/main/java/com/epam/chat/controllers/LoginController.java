package com.epam.chat.controllers;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.epam.chat.dao.*;
import com.epam.chat.dao.jdbc.hibernate.*;
import com.epam.chat.elements.ChatMessage;
import com.epam.chat.elements.MessageAction;
import com.epam.chat.elements.User;

import com.epam.chat.json.JsonReader;




@Controller
@SessionAttributes(types = User.class)
public class LoginController {
	
	//private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main(HttpSession session) throws SQLException  {
		
		DAOFactory dao = DAOFactory.getDAOFactory();
		
		UserDAO userDAO= dao.getUserDAO();
		System.out.println("Запуск");
		String name = new String();
		System.out.println(userDAO.getAllLogged());
//		System.out.println("Коннектимся к бд");
		

	
		
				

		
		//WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
		return new ModelAndView("testWeb", "dao", name);
	}
	
	@RequestMapping(value = "/login_user", method = RequestMethod.POST,produces="text/html")
	@ResponseBody
	public  String loginUser(@RequestParam("formData") String loginDate) {
		System.out.println("Внутри контроллера реистрации");
	    JsonReader reader = new JsonReader();
		reader.getPerson(loginDate);
		return "login";
	}
	
	
	@RequestMapping(value = "/registration_user", method = RequestMethod.POST,produces="text/html")
	@ResponseBody
	public  String registrationUser(@RequestParam("formData") String registrationDate, @ModelAttribute User user) {
		String registrationResult = "nosuccess";
		System.out.println("Внутри контроллера реистрации");
		JsonReader reader = new JsonReader();
		user = reader.getPerson(registrationDate);
		
		DAOFactory dao = DAOFactory.getDAOFactory();
		UserDAO userDAO = dao.getUserDAO();
		userDAO.login(user);
		
		
		
		if(1 > 0) {
			// TODO если регитрация прошла успешно
			registrationResult = "success";
		}
		
		
		
		//FactoryDAO dao = FactoryDAO.getDAOFactory();
        //HibernateFactoryDAO dao = new HibernateFactoryDAO();
        //UserDAO  userDAO = dao.getUserDAO();
		//UserDAO userDAO = dao.getUserDAO();
		
		
	
//		new FactoryDAO();
//		UserDAO userDAO = FactoryDAO.getInstance().getUserDAO();
		System.out.println(user);
		//userDAO.login(user);
		
	
		return registrationResult;
	
	

}
}
