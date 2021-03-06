package com.epam.chat.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.epam.chat.dao.*;
import com.epam.chat.elements.User;
import com.epam.chat.elements.UserStatus;
import com.epam.chat.handler.FileUploader;

@Controller
@SessionAttributes("sessionUser")
public class LoginController {

  public static final String DEFAULTIMAGE = "files/default.png";

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView main(ModelMap model) throws SQLException {

    DAOFactory dao = DAOFactory.getDAOFactory();

    return new ModelAndView("home", "dao", dao);
  }

  @RequestMapping(value = "/login_user", method = RequestMethod.POST)
  @ResponseBody
  public User loginUser(User user, ModelMap model, HttpServletResponse response) throws IOException {
    UserStatus status = null;
    DAOFactory dao = DAOFactory.getDAOFactory();
    UserDAO userDAO = dao.getUserDAO();

   
    
    
    if (userDAO.checkLogIn(user)) {
      user = userDAO.getUserByNick(user.getLogin());
      System.out.println(user.getUserStatus().getIdStatus());
      if(user.getUserStatus().getIdStatus() != 3) {  //если пользователь не забанен
	 status = new UserStatus(1, "ONLINE", "Пользователь в сети");
	 user.setUserStatus(status);
	 userDAO.updateUser(user);
	 }
      
     
      model.addAttribute("sessionUser", user);
    } else {
      status = new UserStatus(4, "InvalidLoginOrPassword", "Неправильный логин или пароль");
      user.setUserStatus(status);
     
    }
    return user;
  }

  @RequestMapping(value = "/registration_user", method = RequestMethod.POST)
  @ResponseBody
  public User registrationUser(@RequestParam("photo") MultipartFile file, User user, ModelMap model)
      throws IOException {
    

   
    DAOFactory dao = DAOFactory.getDAOFactory();
    UserDAO userDAO = dao.getUserDAO();
    if (userDAO.isLogged(user)) {
      UserStatus status = new UserStatus(5, "InvalidUser", "Неправильный логин или пароль");
      user.setUserStatus(status);
      

    } else {
      user.setPathToFoto(DEFAULTIMAGE);
      userDAO.login(user);
   
      model.addAttribute("sessionUser", user);

      FileUploader uploader = new FileUploader();

      if (uploader.downloadFile(user, file)) {
	user = uploader.getUser();
	userDAO.updateUser(user);
      }
    }
    return user;

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

  @RequestMapping(value = "/checkSession", method = RequestMethod.POST)
  @ResponseBody
  public User checkSession(ModelMap model) throws JsonGenerationException, JsonMappingException, IOException {

    User sessionUser = (User) model.get("sessionUser");
    
    if(sessionUser !=  null) {
      	 DAOFactory dao = DAOFactory.getDAOFactory();
         UserDAO userDAO = dao.getUserDAO();
         return userDAO.getUserByNick(sessionUser.getLogin());
    }
    
    return sessionUser;
  }
  
  @RequestMapping(value = "/banned", method = RequestMethod.POST)
  @ResponseBody
  public void banUser(User user) {
    DAOFactory dao = DAOFactory.getDAOFactory();
    UserDAO userDAO = dao.getUserDAO();
   
    
    User bannedUser = userDAO.getUserByNick(user.getLogin());
    if(bannedUser.getUserStatus().getIdStatus() != 3) {
      
       userDAO.kick(bannedUser);
    }else {
     
      userDAO.unkick(bannedUser);
    }
    
    
   
   
  }
  
  
  
  
  
  

}
