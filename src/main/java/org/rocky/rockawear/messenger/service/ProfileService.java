package org.rocky.rockawear.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rocky.rockawear.messenger.database.DataBaseClass;
import org.rocky.rockawear.messenger.model.Profile;

public class ProfileService {


	private Map<String, Profile> profiles = DataBaseClass.getProfiles();
		
	
		public ProfileService(){
			profiles.put("Rocky",  new Profile(1L, "Lilian", "Hello Roro", "Rocky"));
		}
	
		public List<Profile> getAllProfiles(){
			return new ArrayList<Profile>(profiles.values());
		}
		
		public Profile getProfile(String profileName){
			return profiles.get(profileName);
		}
		
		public Profile removeProfile(String profileName){
			return profiles.remove(profileName);
		}
		
		public Profile updateProfile(Profile profile){
			if (profile.getProfileName().isEmpty()) {
				return null;
			}
			
			profiles.put(profile.getProfileName(), profile);
			return profile;
			}
	 
		public Profile addProfile(Profile profile){
			profile.setId( profiles.size() + 1);
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
}
