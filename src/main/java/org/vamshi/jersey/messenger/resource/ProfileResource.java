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
import org.vamshi.jersey.messenger.model.Profile;
import org.vamshi.jersey.messenger.service.ProfileService;
@Path("/profiles")	//EndPoint
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	private ProfileService profileService=new ProfileService();
	
	@GET	//HTML Method
	public List<Profile> getProfiles(){
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName){
		return profileService.getProfile(profileName);
	}
	
	@POST
	public Profile addProfile(Profile profile){
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateMessage(@PathParam("profileName") String profileName,Profile profile){
		profile.setProfileName(profileName);
		return profileService.UpdateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public Profile deleteMessage(@PathParam("profileName") String profileName){
		return profileService.RemoveProfile(profileService.getProfile(profileName));
	}
}
