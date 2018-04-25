package com.epam.chat.elements;


import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
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

 

}
