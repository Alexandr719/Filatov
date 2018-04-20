package com.epam.chat.controllers;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.epam.chat.dao.*;
import com.epam.chat.elements.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@SessionAttributes("sessionUser")
public class LoginController {
 
  public static final String DEFAULTIMAGE="files/default.png";
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView main(ModelMap model) throws SQLException {

    DAOFactory dao = DAOFactory.getDAOFactory();
    // MessageDAO messageDAO = dao.getMessageDAO();
    // UserDAO userDAO = dao.getUserDAO();
    // ChatMessage message = new ChatMessage();
    // User user = new User();
    // user.setLogin("Alex");
    // userDAO.login(user);
    // message.setUser(user);
    // MessageAction messageAction = new MessageAction(1,"SEND","Пользователь
    // оставил сообщение");
    // message.setAction(messageAction);
    // java.util.Date date = new java.util.Date();
    // message.setTimeStamp(date);
    // messageDAO.sentMessage(message);
    //

    return new ModelAndView("home", "dao", dao);
  }

  @RequestMapping(value = "/login_user", method = RequestMethod.POST, produces = "text/html")
  @ResponseBody
  public String loginUser(@RequestParam("formData") String loginData, User user, ModelMap model) throws IOException {
    String loginResult = "error";

    ObjectMapper objectMapper = new ObjectMapper();
    user = objectMapper.readValue(loginData, User.class);

    DAOFactory dao = DAOFactory.getDAOFactory();
    UserDAO userDAO = dao.getUserDAO();

    if (userDAO.checkLogIn(user)) {
      user = userDAO.getUserByNick(user.getLogin());
      loginResult = "success";
      model.addAttribute("sessionUser", user);
    } else {
      loginResult = "invalidUserOrPassword";
    }
    return loginResult;
  }

  @RequestMapping(value = "/registration_user", method = RequestMethod.POST, produces = "text/html")
  @ResponseBody
  public String registrationUser(@RequestParam("formData") String registrationDate, @ModelAttribute User user,
      ModelMap model) throws IOException {
    String registrationResult;
    ObjectMapper objectMapper = new ObjectMapper();
    user = objectMapper.readValue(registrationDate, User.class);

    DAOFactory dao = DAOFactory.getDAOFactory();
    UserDAO userDAO = dao.getUserDAO();
    if (userDAO.isLogged(user)) {
      registrationResult = "invalidUser";

    } else {
      user.setPathToFoto(DEFAULTIMAGE);
      userDAO.login(user);
      registrationResult = "success";
      model.addAttribute("sessionUser", user);

    }

    return registrationResult;

  }

  @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = "text/html")
  @ResponseBody
  public void exitUser(SessionStatus sessionStatus, ModelMap model) {

    DAOFactory dao = DAOFactory.getDAOFactory();
    UserDAO userDAO = dao.getUserDAO();
    User logoutUser = (User) model.get("sessionUser");
    userDAO.logout(logoutUser);
    sessionStatus.setComplete();

  }

}
