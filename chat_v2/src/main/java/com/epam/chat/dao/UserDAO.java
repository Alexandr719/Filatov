package com.epam.chat.dao;

import java.util.List;

import com.epam.chat.elements.User;
import com.epam.chat.elements.UserRole;

public interface UserDAO {

  void login(User loginingUser);

  boolean isLogged(User user);

  boolean checkLogIn(User user);

  void kick(User kickableUser);

  void unkick(User user);

  boolean isKicked(User user);

  void logout(User logoutingUser);

  List<User> getAllLogged();

  UserRole getRoleByNick(String nick);

  User getUserByNick(String nick);
  
  void updateUser(User user);  
  
  

}
