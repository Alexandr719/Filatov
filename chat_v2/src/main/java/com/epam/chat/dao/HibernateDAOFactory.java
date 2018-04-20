package com.epam.chat.dao;

import com.epam.chat.dao.jdbc.hibernate.HibernateMessageDAO;
import com.epam.chat.dao.jdbc.hibernate.HibernateUserDAO;

public class HibernateDAOFactory extends DAOFactory {

  @Override
  public UserDAO getUserDAO() {

    return new HibernateUserDAO();
  }

  @Override
  public MessageDAO getMessageDAO() {

    return new HibernateMessageDAO();
  }
}
