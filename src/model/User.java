package model;

//User class with all the attributes 
//Has a public constructor with appropriate getters and setters
public class User {
	private String name;
	private String email;
	private String designation;
	private String password;
	private String gender;
	private String phoneno;
	public User(String name, String email, String designation, String password, String gender,String phoneno) {
		this.name = name;
		this.email = email;
		this.designation = designation;
		this.password = password;
		this.gender = gender;
		this.phoneno = phoneno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
}
