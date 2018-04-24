package com.epam.chat.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProxyController extends HttpServlet {

  private static final long serialVersionUID = 1L;
  public static final String DEFAULTIMAGE = "D://Filatov//Programs//JAVA//Images//";

  @Override
  @RequestMapping(value = "/files/**", method = RequestMethod.GET)
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("image/jpeg");
    File fileSaveDir = new File(DEFAULTIMAGE + request.getRequestURI());

    byte[] bytes = Files.readAllBytes(fileSaveDir.toPath());
    response.setContentLength((int) bytes.length);
    ServletOutputStream outStream = response.getOutputStream();
    outStream.write(bytes);
    outStream.close();
  }

}
