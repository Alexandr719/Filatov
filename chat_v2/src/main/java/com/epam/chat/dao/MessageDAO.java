package com.epam.chat.dao;

import java.util.List;

import com.epam.chat.elements.ChatMessage;

public interface MessageDAO {

  void sentMessage(ChatMessage message);

  List<ChatMessage> getLast(int count);
}
