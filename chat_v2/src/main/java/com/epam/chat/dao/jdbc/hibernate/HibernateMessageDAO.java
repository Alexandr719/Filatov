package com.epam.chat.dao.jdbc.hibernate;

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
		
		MessageAction action = new MessageAction();
		action.setNameAction("MESSAGE");
		action.setDesctiptionAction("Отправил сообщение");
		ChatMessage message1 = new ChatMessage();
		message1.setAction(action);
		message1.setId( 1);
		message1.setTextMessage("Hello ");
		message1.setTimeStamp((long) 312312312);
		User user = new User();
		user.setLogin("login1");
		message1.setUser(user);
		
		
				
				
				    try {
				      session = HibernateUtil.getSessionFactory().openSession();
				      session.beginTransaction();
				      session.save(message1);
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
		// TODO Auto-generated method stub
		return null;
	}

}
