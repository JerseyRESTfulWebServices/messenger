package org.vamshi.jersey.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateMessage/{messageId}")
	/*
	 * http://localhost:8080/messenger/webapi/messages/updateMessage/1
	 * {
        "author": "v1",
        "created": "2017-06-26T13:14:39.045",
        "message": "m1!"
    }
	 */
	public Message updateMessage(@PathParam("messageId") long Id,Message message){
		message.setId(Id);
		return messageService.UpdateMessage(message);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/deleteMessage/{messageId}")
	/*
	 * http://localhost:8080/messenger/webapi/messages/updateMessage/1
	 * {
        "author": "v1",
        "created": "2017-06-26T13:14:39.045",
        "message": "m1!"
    }
	 */
	public Message deleteMessage(@PathParam("messageId") long Id){
		return messageService.RemoveMessage(messageService.getMessage(Id));
	}
}
