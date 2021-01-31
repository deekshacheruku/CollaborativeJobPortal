package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Post;
import model.User;

//applicant form has appropriate getters and setters
public class ApplicantForm {
	//user instance
	private User user;
	
	//list for storing the application job posts
	protected static final List<Post> AppliedList =new ArrayList<Post>();

	public ApplicantForm() {}

	public ApplicantForm(User user) {
		this.user = user;
	}
	
	public List<Post> getAppliedlist() {
		return AppliedList;
	}
	
	public void setAppliedlist(Post post) {
		AppliedList.add(post);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	//displays all the available post 
	public void displayAll() {
		//traverse through the hrform's post details hash map and prints the details
		for( Map.Entry<Integer, Post> entry : HrForm.postdetails.entrySet() ){
			Post p=entry.getValue();
		    System.out.println( "Job id: " + entry.getKey());
		    System.out.println("Job Title: "+p.getJobtitle());
		    System.out.println("Skills Required: "+p.getSkillsrequired());
		    System.out.println("Passout: "+p.getPassout());
		    System.out.println("Description: "+p.getDescription());
		    System.out.println("Salary: "+p.getSalary()+"LPA");
		    System.out.println("Posted On: "+p.getPostedon());
		    System.out.println("Company Name: "+p.getCompany());
		    System.out.println();
		}
		//checks for the empty hash map
		if(HrForm.postdetails.size() == 0)
			System.out.println("No Job Posts!");
	}
	
	//display particular post
	public void display(int id) {
		//flag variable for checking the existing of the post
		boolean flag = false;
		//traverse through the hash map and print the details
		for(Map.Entry<Integer,Post> entry: HrForm.postdetails.entrySet()) {
			if (entry.getKey() == id) {
				flag=true;
				Post p=entry.getValue();
			    System.out.println( "Job id: " + entry.getKey());
			    System.out.println("Job Title: "+p.getJobtitle());
			    System.out.println("Skills Required: "+p.getSkillsrequired());
			    System.out.println("Passout: "+p.getPassout());
			    System.out.println("Description: "+p.getDescription());
			    System.out.println("Salary: "+p.getSalary()+"LPA");
			    System.out.println("Posted On: "+p.getPostedon());
			    System.out.println("Company Name: "+p.getCompany());
			    System.out.println();
			}
		}
		//if job id not found
		if(flag == false)
			System.out.println("No Job Id Found!");
	}
	
	//apply to job id
	public void apply(int id) {
		//check if job id is not found
		boolean flag=false;
		//traverse through the hash map and apply
		for(Map.Entry<Integer,Post> entry: HrForm.postdetails.entrySet()) {
			if (entry.getKey() == id) {
				flag=true;
				Post p=entry.getValue();
				//setting the applicant for the post
				p.setApplicant(user);
				//add to the applicant's list
				AppliedList.add(p);
				System.out.println("Successfully applied to the job with ID "+id);
			}
		}
		//if job id not found
		if(flag == false)
			System.out.println("No Job Id found!");
	}
	
	//view all the applications
	public void applications() {
		//checks if applied or not
		if (AppliedList.size() == 0)
			System.out.println("You have not applied for any Job!");
		else {
			//prints the details
			System.out.println("Following are the Job Posts You applied for!");
			for(int i=0;i<AppliedList.size();i++)
				System.out.println(AppliedList.get(i).getJobid());
		}
	}
	
	//sharing the post
	public void share(int id) {
		//flag variable for checking if job exists or not
		boolean flag=false;
		//traverse through the map and prints the details
		for(Map.Entry<Integer,Post> entry: HrForm.postdetails.entrySet()) {
			if (entry.getKey() == id) {
				flag=true;
				System.out.println("Following is the data related to the Job ID, you can copy the same and post it in your community!");
				Post p=entry.getValue();
			    System.out.println( "Job id: " + entry.getKey());
			    System.out.println("Job Title: "+p.getJobtitle());
			    System.out.println("Skills Required: "+p.getSkillsrequired());
			    System.out.println("Passout: "+p.getPassout());
			    System.out.println("Description: "+p.getDescription());
			    System.out.println("Salary: "+p.getSalary()+"LPA");
			    System.out.println("Posted On: "+p.getPostedon());
			    System.out.println("Company Name: "+p.getCompany());
			    System.out.println();
			}
		}
		//if there is no job id found
		if (flag == false)
			System.out.println("Can't find the Job ID");
	}
	
	//comment
	public void comment(int id,String comment) {
		//flag variable for checking the job id exists or not
		boolean flag=false;
		//traverse through the map and prints the comment 
		for(Map.Entry<Integer,Post> entry: HrForm.postdetails.entrySet()) {
			if (entry.getKey() == id) {
					flag=true;
					Post p=entry.getValue();
					p.setComments(user, comment);
					System.out.println("Your Comment has been added!");
				}
			}
		//if job doesn't exists
		if(flag == false)
			System.out.println("Can't find the Job ID");
	}
	
	//view all the comments for a particular job
	public void ViewComment(int id) {
		// flag variable for checking the job post exists or not
		boolean flag=false;
		//traverse through the map and print the details
		for(Map.Entry<Integer,Post> entry: HrForm.postdetails.entrySet()) {
			if (entry.getKey() == id) {
					flag=true;
					Post p=entry.getValue();
					//get the hash map of comments form the post 
					HashMap<User,String> comment=p.getComments();
					//if there are no comments
					if(comment.size() == 0)
						System.out.println("No comments!");
					else {
						//prints the comment with user email id
						System.out.println("Following are the comments on the post");
						for(Map.Entry<User, String> entry1: comment.entrySet()) {
							User u=entry1.getKey();
							System.out.println("User's Email: "+u.getEmail());
							System.out.println("User's Comment: "+entry1.getValue());
						}
					}
				}
			}
		//if job id doesn't exists
		if(flag == false)
			System.out.println("Can't find the Job ID");
	}
}
