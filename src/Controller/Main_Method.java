package Controller;


import java.util.Scanner;


public class Main_Method{
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args){
		System.out.println("Welcome To The Collaborative Job Potal! ");
		System.out.println("Are You a Existing User ? If Yes please Type Yes Ortherwise No ");
		System.out.println("If you want to Exit then please type Exit!");
		String ans=sc.nextLine().toLowerCase();
		if(ans.equals("yes")) {
			//Initiates the Login Form
			LoginForm lf=new LoginForm();
			lf.Form();
		}
		else if (ans.equals("no")){
			//Initiates Registration Form
			RegistrationForm rf=new RegistrationForm();
			if(rf.Form()) {
				System.out.println("Sign Up Sucessfull! ReLogin Again!");
				//Initiates Re-Logging Option
				LoginForm lf=new LoginForm();
				lf.Form();
			}
			else {
				System.out.println("Error in Sign Up! Try Again!");
			}	
		}
		else {
			//Pulls you out of the Portal
			System.out.println("Succesfully you have come out of the portal!");
		}
		
	}
}
