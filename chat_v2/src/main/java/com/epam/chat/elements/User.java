package com.epam.chat.elements;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class User {
  private int idUser;
  private String login;
  private String password;
  private String name;
  private String surname;
  private String telephone;
  private String email;
  private UserRole userRole;
  private UserStatus userStatus;
  private String pathToFoto;

  public User() {
    // TODO Auto-generated constructor stub
  }

  public User(String login, String password) {
    super();
    this.login = login;
    this.password = password;
  }

  


  @Override
  public String toString() {
    return "User [login=" + login + ", path=" + pathToFoto + "]";
  }



}
