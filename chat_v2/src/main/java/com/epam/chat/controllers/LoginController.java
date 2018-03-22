package com.epam.chat.controllers;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epam.chat.dao.FactoryDAO;
import com.epam.chat.dao.UserDAO;
import com.epam.chat.dao.jdbc.hibernate.HibernateFactoryDAO;
import com.epam.chat.elements.User;
import com.epam.chat.elements.UserRole;
import com.epam.chat.elements.UserStatus;
import com.epam.chat.json.JsonReader;
import com.epam.chat.test.DaoImpl;



@Controller
public class LoginController {
	
	//private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main(HttpSession session) throws SQLException  {
		System.out.println("Коннектимся к бд");
		
		LocalDateTime timePoint = LocalDateTime.now();
		 //user.setTimestamp(timePoint.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
			
		System.out.println(timePoint.toString());
		
	     DaoImpl daao = new DaoImpl();
		 UserStatus status = new UserStatus();
	     status.setNameStatus("ONLINE");
	     status.setDescriptionStatus("Пользоватлеь в сети");
		 UserRole role = new UserRole();
		 role.setNameRole("USER");
		 role.setDescriptionRole("Роль пользователя");
	     
	     
	     User user = new User();
	     user.setName("name");
	     user.setTelephone("12312312");
	     user.setLogin("LOgin2");
	     user.setPassword("123456");
	     user.setEmail("gdfg");
	     user.setPathToFoto("dasd");
	     user.setSurname("surname");
	     user.setUserStatus(status);
	     user.setUserRole(role);
		// daao.addBus(user);
		
		
		
//		TestUserImpl test = new TestUserImpl();
//		TestUser user = test.getTestUserById((long) 1);
//		System.out.println(user.getName());
		
		
		//WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
		return new ModelAndView("home", "user", new User());
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
