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

@Controller
@SessionAttributes("sessionUser")
public class FileUploadController {
  public static final String absolutePath="D:\\Filatov\\Programs\\JAVA\\Images\\UserImages";
  public static final String relativePath="files";
  
  
  
  
  @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
  @ResponseBody
  public String  uploadFile(@RequestParam("uploadfile") MultipartFile file,ModelMap model) {
    
    	
    
      String fileName = null;
      User user = (User) model.get("sessionUser");
     

	if (!file.isEmpty()) {
		try {
			byte[] bytes = file.getBytes();
			fileName = file.getOriginalFilename();
			File dir = new File(absolutePath + File.separator + user.getIdUser());
			user.setPathToFoto(relativePath + "/" + user.getIdUser() + "/" + fileName);
			System.out.println(dir);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			File uploadedFile = new File(dir.getAbsolutePath() + File.separator + fileName);

			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
			stream.write(bytes);
			stream.flush();
			stream.close();
			 User userTwo = (User) model.get("sessionUser");
			 System.out.println(userTwo);
			//logger.info("uploaded: " + uploadedFile.getAbsolutePath());

			 DAOFactory dao = DAOFactory.getDAOFactory();
			 UserDAO userDAO = dao.getUserDAO();
			 userDAO.updateUser(user);
			 
			 
			return "You successfully uploaded file=" + fileName;

		} catch (Exception e) {
			return "You failed to upload " + fileName + " => " + e.getMessage();
		}
	} else {
		return "You failed to upload " + fileName + " because the file was empty.";
	}
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
