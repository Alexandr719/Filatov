package com.epam.chat.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.chat.dao.DAOFactory;


@Controller
public class ProxyController extends HttpServlet {
  
 
	private static final long serialVersionUID = 1L;
	 public static final String DEFAULTIMAGE="D://Filatov//Programs//JAVA//Images//";
	
	
        @Override
        @RequestMapping(value = "/files/**", method = RequestMethod.GET)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  System.out.println("Контроллер картипнок");
	  System.out.println(request.getRequestURI());
	  response.setContentType("image/jpeg");
	  File fileSaveDir = new File(DEFAULTIMAGE + request.getRequestURI() );
	  System.out.println(fileSaveDir.getName());
	  
	  
		//парсим id картинки из запроса
		
//		int imageId = Integer.parseInt(request.getParameter("id"));
//		//Тут вы получаете  Entity вашей картинки, одно из полей у которого является массивом байт
//		//Preview preview = previewService.getByImageId(imageId);
//		
//		//Получаю фото из request!!!!!!!
//		
		byte[] bytes  = Files.readAllBytes(fileSaveDir.toPath());
		response.setContentLength((int) bytes.length);		
//		// получаете поток для своих нужд
		ServletOutputStream outStream = response.getOutputStream();
//		// отсылаете картинку на клиента
		outStream.write(bytes);
//		// закрываете поток
		outStream.close();
	}

  }


