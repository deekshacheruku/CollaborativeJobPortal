package model;

import java.util.HashMap;

//Login class with a hash map of type string and user instance
//Has appropriate getters and setters
public class Login {
	private static final HashMap<String,User> details=new HashMap<String,User>();

	public HashMap<String, User> getDetails() {
		return details;
	}

	public void setDetails(String email,User user) {
		details.put(email, user);
	}
	
	//Checks for login credentials
	public boolean loginCheck(String email,String password) {
		//System.out.println(details);
		if(details.containsKey(email)) {
			User user=details.get(email);
			if(user.getPassword() == null || password == null)
				return false;
			if((password).equals(user.getPassword()))
				return true;
		}
		return false;
	}
	
	//Returns User instance 
	public User getUser(String email) {
		if(details.containsKey(email)) {
			User user=details.get(email);
			return user;
		}
		return null;
	}
}
