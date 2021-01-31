package businesslogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Validate Registration Form
public class ValidateRegisterForm {
	//Pattern for password
	private static final String password_pattern="((?=.*[a-z])(?=.*[A-Z]).{8,20})";
	private Pattern pattern;
	private Matcher matcher1,matcher2;
	
	//Check for Name more than 2 letters
	public boolean ValidateName(String name) {
		if(name == null)
			return false;
		if (name.length() <= 2)
			return false;
		return true;
	}
	
	//Check for Email id having . @ and chars
	public boolean ValidateEmail(String email) {
		if(email == null)
			return false;
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
	
	//Validate password and confirm password for 1 Upper case, 1 Lower case and min 8 char and max 20 char
	public boolean ValidatePassword(String password,String confirmpassword) {
		if (confirmpassword == null || password == null)
			return false;
		 pattern = Pattern.compile(password_pattern);
		 if(password.equals(confirmpassword)) {
			 matcher1 = pattern.matcher(password);
			 matcher2 = pattern.matcher(confirmpassword);
			 return (matcher2.matches() && matcher1.matches());
		 }
		return false;
		 
	}
	
	// Validates phones number which should have 10 char
	public boolean ValidatePhone(String phoneno) {
		if(phoneno == null)
			return false;
		if(phoneno.length() == 10)
			return true;
		return false;
	}
	
	//Validates gender for male and female
	public boolean ValidateGender(String gender) {
		if(gender == null)
			return false;
		if(gender.toLowerCase().equals("male") || gender.toLowerCase().equals("female"))
			return true;
		return false;
	}
	
	// Validates designation for hr and applicant
	public boolean ValidateDesignation(String designation) {
		if(designation == null)
			return false;
		if(designation.toLowerCase().equals("hr") || designation.toLowerCase().equals("applicant"))
			return true;
		return false;
	}
}
