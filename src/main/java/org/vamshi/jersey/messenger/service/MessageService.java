package org.vamshi.jersey.messenger.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.vamshi.jersey.messenger.database.DatabaseClass;
import org.vamshi.jersey.messenger.model.Message;
public class MessageService {
	private Map<Long,Message> messages = DatabaseClass.getMessages(); 
	public MessageService(){
		messages.put(1L, new Message(1, "m1", "v1"));
		messages.put(2L, new Message(2, "m2", "v2"));
		messages.put(3L, new Message(3, "m3", "v3"));
	}
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	public Message getMessage(long id){
		return messages.get(id);
	}
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	public Message UpdateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	public Message RemoveMessage(Message message){
		messages.remove(message.getId());
		return message;
	}
}
