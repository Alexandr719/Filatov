package com.epam.chat.dao.jdbc.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.epam.chat.dao.UserDAO;
import com.epam.chat.elements.User;
import com.epam.chat.elements.UserRole;
import com.epam.chat.elements.UserStatus;

@Repository
public class HibernateUserDAO implements UserDAO {

  @Override
  public void login(User loginingUser) {
    Session session = null;
    System.out.println("В логине пользователя");
    // TODO :Добавить проверку залогиненых пользователей
    // TODO :Закинуть роль и статус в файл конфигураций
    UserRole role = new UserRole(2, "USER", "Пользователь");
    UserStatus status = new UserStatus(1, "ONLINE", "Пользователь в сети");
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
    Session session = null;
    boolean result = false;

    try {
      session = HibernateUtil.getSessionFactory().openSession();
      Criteria userCriteria = session.createCriteria(User.class);
      userCriteria.add(Restrictions.eq("login", user.getLogin()));
      user = (User) userCriteria.uniqueResult();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке объекта User", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
	session.close();
      }
    }

    if (user != null) {
      result = true;
    }

    return result;

  }

  @Override
  public void kick(User kickableUser) {
    UserStatus status = new UserStatus(3, "BANNED", "Пользователь забанен");
    kickableUser.setUserStatus(status);
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.update(kickableUser);
      session.getTransaction().commit();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
	session.close();
      }
    }

  }

  @Override
  public void unkick(User user) {
    UserStatus status = new UserStatus(2, "OFFLINE", "Пользователь не в сети");
    user.setUserStatus(status);
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.update(user);
      session.getTransaction().commit();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
	session.close();
      }
    }

  }

  @Override
  public boolean isKicked(User user) {
    Session session = null;
    boolean result = false;

    try {
      session = HibernateUtil.getSessionFactory().openSession();
      Criteria userCriteria = session.createCriteria(User.class);
      userCriteria.add(Restrictions.eq("login", user.getLogin()));
      user = (User) userCriteria.uniqueResult();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке объекта User", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
	session.close();
      }
    }

    if (user != null && (user.getUserStatus().getNameStatus()).equals("BANNED")) {
      result = true;
      System.out.println("Забанен");
    }

    return result;
  }

  @Override
  public void logout(User logoutingUser) {
    UserStatus status = new UserStatus(2, "OFFLINE", "Пользователь не в сети");
    logoutingUser.setUserStatus(status);
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.update(logoutingUser);
      session.getTransaction().commit();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
	session.close();
      }
    }

  }

  @SuppressWarnings("unchecked")
  @Override
  public List<User> getAllLogged() {
    Session session = null;
    List<User> users = new ArrayList<User>();
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      users = session.createCriteria(User.class).list();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка вывода всх пользователей", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
	session.close();
      }
    }
    return users;
  }

  @Override
  public UserRole getRoleByNick(String nick) {
    Session session = null;
    User user = new User();

    try {
      session = HibernateUtil.getSessionFactory().openSession();
      Criteria userCriteria = session.createCriteria(User.class);
      userCriteria.add(Restrictions.eq("login", nick));
      user = (User) userCriteria.uniqueResult();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке объекта User", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
	session.close();
      }
    }

    return user.getUserRole();
  }

  @Override
  public User getUserByNick(String nick) {
    Session session = null;
    User celectedUser = new User();

    try {
      session = HibernateUtil.getSessionFactory().openSession();
      Criteria userCriteria = session.createCriteria(User.class);
      userCriteria.add(Restrictions.eq("login", nick));
      celectedUser = (User) userCriteria.uniqueResult();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке объекта User", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
	session.close();
      }
    }

    return celectedUser;
  }

  @Override
  public boolean checkLogIn(User user) {
    Session session = null;
    User celectedUser = new User();

    try {
      session = HibernateUtil.getSessionFactory().openSession();
      Criteria userCriteria = session.createCriteria(User.class);
      userCriteria.add(Restrictions.eq("login", user.getLogin()));
      celectedUser = (User) userCriteria.uniqueResult();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке объекта User", JOptionPane.OK_OPTION);
    } finally {
      if (session != null && session.isOpen()) {
	session.close();
      }
    }

    if (celectedUser != null && user.getPassword().equals(celectedUser.getPassword())) {
      return true;
    }

    return false;
  }

  @Override
  public void updateUser(User user) {
    Session session = null;
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.update(user);
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
