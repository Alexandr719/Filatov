package com.epam.chat.elements;


import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserStatus {

  

  private int idStatus;
  private String nameStatus;
  private String descriptionStatus;

  public UserStatus() {
    // TODO Auto-generated constructor stub
  }

  public UserStatus(int idStatus, String nameStatus, String descriptionStatus) {
    super();
    this.nameStatus = nameStatus;
    this.descriptionStatus = descriptionStatus;
    this.idStatus = idStatus;
  }

}
