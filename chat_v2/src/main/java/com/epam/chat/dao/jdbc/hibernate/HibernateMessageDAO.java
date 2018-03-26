package com.epam.chat.dao.jdbc.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import com.epam.chat.dao.MessageDAO;
import com.epam.chat.elements.ChatMessage;
import com.epam.chat.elements.MessageAction;
import com.epam.chat.elements.User;
import com.epam.chat.elements.UserRole;
import com.epam.chat.elements.UserStatus;

public class HibernateMessageDAO implements MessageDAO {

	@Override
	public void sentMessage(ChatMessage message) {
		 Session session = null;
		// TODO :Добавить проверку залогиненых пользователей
				// TODO :Закинуть роль и статус в файл конфигураций
							
				    try {
				      session = HibernateUtil.getSessionFactory().openSession();
				      session.beginTransaction();
				      session.save(message);
				      session.getTransaction().commit();
				    } catch (Exception e) {
				      JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке объекта MEssage", JOptionPane.OK_OPTION);
				    } finally {
				      if (session != null && session.isOpen()) {
				        session.close();
				      }
				    }
		
	}

	@Override
	public List<ChatMessage> getLast(int count) {
		Session session = null;
	    List messages = new ArrayList<ChatMessage>();
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      messages = session.createCriteria(ChatMessage.class).list();
	    } catch (Exception e) {
	      JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка вывода всх пользователей", JOptionPane.OK_OPTION);
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return messages;
	}

}
