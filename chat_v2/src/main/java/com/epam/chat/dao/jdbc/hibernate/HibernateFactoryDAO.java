package com.epam.chat.dao.jdbc.hibernate;

import com.epam.chat.dao.FactoryDAO;
import com.epam.chat.dao.MessageDAO;
import com.epam.chat.dao.UserDAO;

public class HibernateFactoryDAO extends FactoryDAO {

	@Override
	public MessageDAO getMessageDAO() {
		
		return new HibernateMessageDAO();
	}

	@Override
	public UserDAO getUserDAO() {
	
		return new HibernateUserDAO();
	}

}
