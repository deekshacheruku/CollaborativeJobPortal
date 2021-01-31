package Controller;

import java.util.Scanner;
import model.Login;
import model.User;

//Login Form
public class LoginForm {
	Scanner sc=new Scanner(System.in);
	public void Form() {
		Login l=new Login();
		String email,pass;
		User user;
		//Prompts for Email ID and Password
		while(true) {
			System.out.println("Enter Email ID");
			email=sc.nextLine();
			System.out.println("Enter password");
			pass=sc.nextLine();
			//Checks for the credentials 
			if(l.loginCheck(email,pass)) {
				System.out.println("Login Successful!");
				//Initializing the user object with the Email ID
				user=l.getUser(email);
				break;
			}
			else {
				System.out.println("Invalid credentials!");
				continue;
			}
		}
		
		//Checks for the user's Designation
		if (user.getDesignation().toLowerCase().equals("hr")) {
			//Initiates Hr Form
			HrForm hf=new HrForm(user);
			System.out.println("Welcome "+user.getName()+"!");
			while(true) {
				System.out.println("Please select one from the below options and give its corresponding number");
				System.out.println("1. Create Post");
				System.out.println("2. Update Post");
				System.out.println("3. Delete Post");
				System.out.println("4. Display All Posts");
				System.out.println("5. Display with Job ID");
				System.out.println("6. Exit");
				int n=sc.nextInt();
				switch(n){
				//Create Post
				case 1:	hf.create();
					   	break;
				//Update Post	   
				case 2:	System.out.println("Enter Job Id");
						int id =sc.nextInt();
						hf.update(id);
						break;
				//Delete Post
				case 3:	System.out.println("Enter Job Id");
						int id1 =sc.nextInt();
						hf.delete(id1);
						break;
				//Display All Posts
				case 4: hf.display();
						break;
				//Display Any Particular Post
				case 5: System.out.println("Enter Job Id");
						int id2=sc.nextInt();
						hf.displayOne(id2);
						break;
				//Exits Form
				case 6:break;
				//Invalid Case
				default:System.out.println("Invalid number");
					break;
				}
				//Calls for the Main Page Again
				if(n == 6) {
					System.out.println("Exit!");
					Main_Method.main(null);
					break;
					}
				}	
			}
			//Applicants's Form
			else {
				ApplicantForm af=new ApplicantForm(user);
				System.out.println("Welcome "+user.getName()+"!");
				while(true) {
					System.out.println("Please select one from the below options and give its corresponding number");
					System.out.println("1. View All Post");
					System.out.println("2. View Post with Job ID");
					System.out.println("3. Apply To Job Post");
					System.out.println("4. All Applications");
					System.out.println("5. Share Post");
					System.out.println("6. Comment On Post with Job ID");
					System.out.println("7. View Comments On a Post");
					System.out.println("8. Exit");
					int n=sc.nextInt();
					switch(n){
					//Displays All Posts
					case 1:	af.displayAll();
						   	break;
					//Displays one particular post
					case 2:	System.out.println("Enter Job Id");
							int id =sc.nextInt();
							af.display(id);
							break;
					//Application to any one Job
					case 3:	System.out.println("Enter Job Id");
							int id1 =sc.nextInt();
							af.apply(id1);
							break;
					//Displays all Applications
					case 4: af.applications();
							break;
					//Sharing a post
					case 5: System.out.println("Enter Job Id");
							int id2 =sc.nextInt();
							af.share(id2);
							break;
					//Comment on a post
					case 6: System.out.println("Enter Job Id");
							int id3=sc.nextInt();
							sc.nextLine();
							System.out.println("Enter the comment");
							String comment=sc.nextLine();
							af.comment(id3,comment);
							break;
					//View all the comments on the post
					case 7: System.out.println("Enter Job id");
							int id4=sc.nextInt();
							af.ViewComment(id4);
							break;
					//Exit 
					case 8:	break;
					default:System.out.println("Invalid number");
							break;
					}
					//Exit and call the main method
					if(n == 8) {
						System.out.println("Exit!");
						Main_Method.main(null);
						break;
					}
				}	
			}
		}
}
