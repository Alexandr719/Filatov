package com.epam.chat.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

@Controller
public class FileUploadController {

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile,
			HttpServletRequest request) {
		try {

			String filename = uploadfile.getOriginalFilename();
			String directory = File.separator + "resources" + File.separator + "images" + File.separator + "userImages"
					+ File.separator + "777";
			String realPathtoUploads = request.getSession().getServletContext().getRealPath(directory);
			System.out.println(realPathtoUploads);
			
			
		
//			String[] parts = realPathtoUploads.split("resources");
//			
//			String part2 = "\\resources" + parts[1]; 
//			
//			System.out.println(part2);
			
					
			
			
			String filepath = Paths.get(realPathtoUploads, filename).toString();

			// Save the file locally
			File uploaderFile = new File(realPathtoUploads);
			uploaderFile.mkdir();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			stream.write(uploadfile.getBytes());
			stream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(HttpStatus.OK);
	} // method uploadFile

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
