package org.vamshi.jersey.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.vamshi.jersey.messenger.model.Message;

public class MessageService {
	public List<Message> getAllMessages(){
		Message m1=new Message(1, "m1", "v1");
		Message m2=new Message(2, "m2", "v2");
		Message m3=new Message(3, "m3", "v3");
		List<Message> list=new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		return list;
	}
}
