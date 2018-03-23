package com.epam.chat.dao;

public abstract class  DAOFactory {
	// TODO преобразовать в bean
	
//	 public abstract MessageDAO getMessageDAO();
//
	 public abstract UserDAO getUserDAO();

	  public static DAOFactory getDAOFactory() {
		
	            return new HibernateDAOFactory();
	       
	    }
	 
	 
	 

}
