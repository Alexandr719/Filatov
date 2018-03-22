package com.epam.chat.dao.jdbc.hibernate;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import com.epam.chat.dao.UserDAO;
import com.epam.chat.elements.User;
import com.epam.chat.elements.UserRole;
import com.epam.chat.elements.UserStatus;

public class HibernateUserDAO implements UserDAO {

	@Override
	public void login(User loginingUser) {
		 Session session = null;
		// TODO :Добавить проверку залогиненых пользователей
		// TODO :Закинуть роль и статус в файл конфигураций
		UserRole role = new UserRole("USER", "Роль пользователя");
		UserStatus status = new UserStatus("ONLINE","Пользоватeль в сети");
		loginingUser.setUserRole(role);
		loginingUser.setUserStatus(status);
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.save(loginingUser);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке объекта User", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
	
	}

	@Override
	public boolean isLogged(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void kick(User kickableUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unkick(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isKicked(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logout(User logoutingUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllLogged() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRole getRoleByNick(String nick) {
		// TODO Auto-generated method stub
		return null;
	}

}
