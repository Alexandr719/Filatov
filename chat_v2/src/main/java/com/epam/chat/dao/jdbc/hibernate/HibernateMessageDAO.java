package com.epam.chat.dao.jdbc.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.epam.chat.dao.MessageDAO;
import com.epam.chat.elements.ChatMessage;

@Repository
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
      // e.printStackTrace();
      JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке объекта Message", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
	session.close();
      }
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<ChatMessage> getLast(int count) {
    Session session = null;
    List<ChatMessage> messages = new ArrayList<ChatMessage>();
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
