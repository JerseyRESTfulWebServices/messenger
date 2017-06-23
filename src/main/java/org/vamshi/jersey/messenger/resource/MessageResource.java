package org.vamshi.jersey.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vamshi.jersey.messenger.model.Message;
import org.vamshi.jersey.messenger.service.MessageService;
@Path("/messages")	//EndPoint
public class MessageResource {
	@GET	//HTML Method
	@Produces(MediaType.TEXT_PLAIN)		//specifies return type
	@Path("/getStringMessages")
	public String getStringMessages(){
		return "Hello World";
	}
	
	MessageService messageService=new MessageService();
	@GET	//HTML Method
	@Produces(MediaType.APPLICATION_XML)		//specifies return type
	@Path("/getXMLMessages")
	public List<Message> getXMLMessages(){
		return messageService.getAllMessages();
	}
	
	@GET	//HTML Method
	@Produces(MediaType.APPLICATION_JSON)		//specifies return type
	@Path("/getJSONMessages")
	public List<Message> getJSONMessages(){
		return messageService.getAllMessages();
	}
	
	@GET	//HTML Method
	@Produces(MediaType.APPLICATION_XML)		//specifies return type
	@Path("/getXMLMessage/{messageId}")
	public Message getXMLMessage(@PathParam("messageId") long Id){
		//JAX-RS converts String to long .. cool
		return messageService.getMessage(Id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addMessage")
	/*Headers:
	 * Content-Type:application/json
	 *Message Body:
	 * {
        "author": "v4",
        "created": "2017-06-23T14:48:10.128",
        "message": "m4"
    	}
     */
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
}
