package com.epam.chat.elements;

import org.springframework.stereotype.Component;

@Component
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


  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserRole getUserRole() {
    return userRole;
  }

  public void setUserRole(UserRole userRole) {
    this.userRole = userRole;
  }

  public UserStatus getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(UserStatus userStatus) {
    this.userStatus = userStatus;
  }

  public String getPathToFoto() {
    return pathToFoto;
  }

  public void setPathToFoto(String pathToFoto) {
    this.pathToFoto = pathToFoto;
  }

  @Override
  public String toString() {
    return "User [login=" + login + ", password=" + password  + "]";
  }

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

}
