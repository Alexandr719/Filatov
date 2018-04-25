package com.epam.chat.elements;


import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class MessageAction {
  private int idAction;
  private String nameAction;
  private String desctiptionAction;

  public MessageAction() {
    // TODO Auto-generated constructor stub
  }

  public MessageAction(int idAction, String nameAction, String desctiptionAction) {
    super();
    this.idAction = idAction;
    this.nameAction = nameAction;
    this.desctiptionAction = desctiptionAction;
  }

 
}
