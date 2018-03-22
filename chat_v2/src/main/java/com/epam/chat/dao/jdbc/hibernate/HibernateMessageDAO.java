package com.epam.chat.dao.jdbc.hibernate;

import java.util.List;

import com.epam.chat.dao.MessageDAO;
import com.epam.chat.elements.ChatMessage;

public class HibernateMessageDAO implements MessageDAO {

	@Override
	public void sentMessage(ChatMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ChatMessage> getLast(int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
