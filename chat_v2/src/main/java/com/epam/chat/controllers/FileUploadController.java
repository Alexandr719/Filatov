package com.epam.chat.controllers;

import java.sql.SQLException;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FileUploadController {
	
	@RequestMapping(value = "/upload_file", method = RequestMethod.GET)
	public String uploadUserFoto(ModelMap model) throws SQLException  {
		
		System.out.println("Into file uploader");
		return "hello";
		
	}
	

}
