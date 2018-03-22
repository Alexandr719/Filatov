package com.epam.chat.dao;

import com.epam.chat.dao.jdbc.hibernate.HibernateFactoryDAO;


public abstract class  FactoryDAO {
	// TODO преобразовать в bean
	
	 public abstract MessageDAO getMessageDAO();

	 public abstract UserDAO getUserDAO();

	  public static FactoryDAO getDAOFactory() {
		
	            return new HibernateFactoryDAO();
	       
	    }
	 
	 
	 

}
