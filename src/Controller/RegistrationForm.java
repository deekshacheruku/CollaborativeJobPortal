package Controller;

import java.util.Scanner;

import businesslogic.ValidateRegisterForm;
import model.Login;
import model.User;

//Registration Form
public class RegistrationForm{
	Scanner sc=new Scanner(System.in);
	public boolean Form(){
		//Validation of the Registration Form
		ValidateRegisterForm vr=new ValidateRegisterForm();
		String name,email,Designation,password,gender,phoneno,confirmpassword;
		//Check for the Name
		while(true) {
			System.out.println("Enter Your Name: ");
			name=sc.nextLine();
			if (!vr.ValidateName(name)) {
				System.out.println("Invalid Name! Try Again!");
				continue;
			}
			break;
		}
		//Check for the Email id
		while(true) {
			System.out.println("Enter Your Email Address: ");
			email=sc.nextLine();
			if (!vr.ValidateEmail(email)) {
				System.out.println("Invalid Email! Try Again!");
				continue;
			}
			break;
		}
		//Check for the designation
		while(true) {
			System.out.println("Enter Your Designation(HR/Applicant): ");
			Designation=sc.nextLine();
			if (!vr.ValidateDesignation(Designation)) {
				System.out.println("Invalid Designation! Try Again!");
				continue;
			}
			break;
		}
		//Check for the Password
		while(true) {
			System.out.println("Enter Your Password(Atleast 1 Uppercase, 1 Lowercase, minimum of 8 and maximum of 20 characters): ");
			password=sc.nextLine();
			System.out.println("Re Enter your password: ");
			confirmpassword=sc.nextLine();
			if (!vr.ValidatePassword(password,confirmpassword)) {
				System.out.println("Invalid Password! Try Again!");
				continue;
			}
			break;
		}
		//Check for the Gender
		while(true) {
			System.out.println("Enter Your Gender(Male/Female): ");
			gender=sc.nextLine();
			if (!vr.ValidateGender(gender)) {
				System.out.println("Invalid Gender! Try Again!");
				continue;
			}
			break;
		}
		//Check for the Phone Number
		while(true) {
			System.out.println("Enter Your Phone Number: ");
			phoneno=sc.nextLine();
			if (!vr.ValidatePhone(phoneno)) {
				System.out.println("Invalid Phone Number! Try Again!");
				continue;
			}
			break;
		}
		//Creation of the User
		User user=new User(name,email,Designation,password,gender,phoneno);
		Login l=new Login();
		//storing the email id and user instance for checking the login credentials
		l.setDetails(user.getEmail(), user);
		return true;
	}
}
