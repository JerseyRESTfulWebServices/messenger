package org.vamshi.jersey.messenger.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.vamshi.jersey.messenger.database.DatabaseClass;
import org.vamshi.jersey.messenger.model.Profile;

public class ProfileService {
	private Map<String,Profile> profiles = DatabaseClass.getProfiles(); 
	public ProfileService(){
		profiles.put("vamshi",new Profile(1L, "vamshi","vamshi","chinta"));
		profiles.put("krishna",new Profile(1L, "krishna","krishna","chinta"));
	}
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	public Profile getProfile(String ProfileName){
		return profiles.get(ProfileName);
	}
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	public Profile UpdateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	public Profile RemoveProfile(Profile profileName){
		return profiles.remove(profileName);
	}
}
