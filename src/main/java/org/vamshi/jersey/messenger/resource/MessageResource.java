package org.vamshi.jersey.messenger.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vamshi.jersey.messenger.model.Message;
import org.vamshi.jersey.messenger.service.MessageService;
@Path("/messages")	//EndPoint
public class MessageResource {
	@GET	//HTML Method
	@Produces(MediaType.TEXT_PLAIN)		//specifies rerurn type
	@Path("/getStringMessage")
	public String getStringMessages(){
		return "Hello World";
	}
	MessageService messageService=new MessageService();
	@GET	//HTML Method
	@Produces(MediaType.APPLICATION_XML)		//specifies rerurn type
	@Path("/getXMLMessage")
	public List<Message> getXMLMessage(){
		return messageService.getAllMessages();
	}
}
