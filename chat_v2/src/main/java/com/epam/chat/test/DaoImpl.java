package com.epam.chat.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import com.epam.chat.dao.DAOFactory;
import com.epam.chat.dao.MessageDAO;
import com.epam.chat.dao.UserDAO;
import com.epam.chat.dao.jdbc.hibernate.HibernateUtil;
import com.epam.chat.elements.ChatMessage;
import com.epam.chat.elements.MessageAction;
import com.epam.chat.elements.User;
import com.epam.chat.elements.UserRole;
import com.epam.chat.elements.UserStatus;

public class DaoImpl {
	public void testMEthod(User bus) throws SQLException {
		
		DAOFactory dao = DAOFactory.getDAOFactory();
		MessageDAO messageDAO = dao.getMessageDAO();
		UserDAO userDAO = dao.getUserDAO();
		List<ChatMessage> messages = new ArrayList<ChatMessage>();
		
		
		//users =  userDAO.getAllLogged(); 
		//messages = messageDAO.getLast(0);
		//System.out.println messages.get(0).getUserLogin());
		java.util.Date date = new java.util.Date();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		
		System.out.println(timestamp);
		ChatMessage message = new ChatMessage();
		MessageAction action = new MessageAction();
		action.setNameAction("Login");
		action.setDesctiptionAction("Пользователь зарегитрировался");
		message.setUserLogin("LOgin");
		message.setTimeStamp( timestamp);
		message.setTextMessage("Hello guis3");
		message.setAction(action);
		messageDAO.sentMessage(message);
		
		
	}
	  
}
