package com.epam.chat.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

import com.epam.chat.dao.DAOFactory;
import com.epam.chat.dao.UserDAO;
import com.epam.chat.elements.User;
import com.epam.chat.handler.FileUploader;

@Controller
@SessionAttributes("sessionUser")
public class FileUploadController {

  @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
  @ResponseBody
  public String uploadFile(@RequestParam("uploadfile") MultipartFile file, ModelMap model) {
    DAOFactory dao = DAOFactory.getDAOFactory();
    UserDAO userDAO = dao.getUserDAO();
    String fileName = null;
    User user = (User) model.get("sessionUser");
    FileUploader uploader = new FileUploader();
      
    if(uploader.downloadFile(user, file)) {
      user = uploader.getUser();
      userDAO.updateUser(user); 
    }
    
   
   
    
    
  
    
    return "successfull";
  }

  @Bean
  public CommonsMultipartResolver multipartResolver() {
    CommonsMultipartResolver multipart = new CommonsMultipartResolver();
    multipart.setMaxUploadSize(3 * 1024 * 1024);
    return multipart;
  }

  @Bean
  @Order(0)
  public MultipartFilter multipartFilter() {
    MultipartFilter multipartFilter = new MultipartFilter();
    multipartFilter.setMultipartResolverBeanName("multipartResolver");
    return multipartFilter;
  }

}
