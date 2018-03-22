package com.epam.chat.test;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import com.epam.chat.dao.jdbc.hibernate.HibernateUtil;
import com.epam.chat.elements.User;
import com.epam.chat.elements.UserRole;
import com.epam.chat.elements.UserStatus;

public class DaoImpl {
	public void addBus(User bus) throws SQLException {
	    Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      session.save(bus);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
	    } finally {
	      if (session != null && session.isOpen()) {

	        session.close();
	      }
	    }
	  }
}
