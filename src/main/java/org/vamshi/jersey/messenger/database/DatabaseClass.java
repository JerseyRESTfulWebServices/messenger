package org.vamshi.jersey.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.vamshi.jersey.messenger.model.Message;
import org.vamshi.jersey.messenger.model.Profile;

public class DatabaseClass {
	public static Map<Long,Message> messages = new HashMap<>();
	public static Map<Long,Profile> profiles = new HashMap<>();
	public static Map<Long,Message> getMessages(){
		return messages;
	}
	public static Map<Long,Profile> getProfiles(){
		return profiles;
	}
}