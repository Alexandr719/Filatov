package com.epam.chat.elements;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class UserRole {

  private int idRole;
  private String nameRole;
  private String descriptionRole;

  public UserRole(int idRole, String nameRole, String descriptionRole) {
    super();
    this.nameRole = nameRole;
    this.descriptionRole = descriptionRole;
    this.idRole = idRole;
  }

  public UserRole() {
    // TODO Auto-generated constructor stub
  }

  public int getIdRole() {
    return idRole;
  }

  public void setIdRole(int idRole) {
    this.idRole = idRole;
  }

  public String getNameRole() {
    return nameRole;
  }

  public void setNameRole(String nameRole) {
    this.nameRole = nameRole;
  }

  public String getDescriptionRole() {
    return descriptionRole;
  }

  public void setDescriptionRole(String descriptionRole) {
    this.descriptionRole = descriptionRole;
  }

}
