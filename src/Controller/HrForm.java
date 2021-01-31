package Controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Utility.CheckPost;
import model.Post;
import model.User;

//Hr Form
//has appropriate getters and setters
public class HrForm {
	//User instance
	private User user;
	//Details of the post in a hash map
	protected static final HashMap<Integer,Post> postdetails=new HashMap<Integer,Post>();
	Scanner sc=new Scanner(System.in);
	
	public HrForm() {
		
	}
	
	public HrForm(User user) {
		this.setUser(user);
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public HashMap<Integer, Post> getPostdetails() {
		return postdetails;
	}
	
	public void setPostDetails(int jobid, Post post) {
		postdetails.put(jobid, post);
	}
	
	//creation of job post
	public void create() {
		System.out.println("Enter Job Id");
		int id=sc.nextInt();
		sc.nextLine();
		
		//checks for duplicate post
		boolean duplicate=CheckDuplicateJobId(id);
		if(duplicate) {
			System.out.println("Already a Job Exists with the same ID! Kindly give another Id");
		}
		
		else {
			System.out.println("Enter JobTitle");
			String jobtitle=sc.nextLine();
			System.out.println("Enter Skills Required in a single line separated by comma");
			String skillsrequired=sc.nextLine();
			System.out.println("Enter the required candidate's passout");
			String passout=sc.nextLine();
			System.out.println("Enter Job Description");
			String description =sc.nextLine();
			System.out.println("Enter Company Name");
			String company=sc.nextLine();
			System.out.println("Enter Expected Salary(lpa)");
			float salary=sc.nextFloat();
			
			//creation of post class instance
			Post p=new Post(id,jobtitle,skillsrequired,passout,description,salary,LocalDate.now(),company);
			
			//Checks for any offensive words
			CheckPost cp=new CheckPost();
			boolean flag=cp.checkPost(p);
			
			if(flag) {
				postdetails.put(p.getJobid(),p);
				System.out.println("Job Post created with Job Id "+p.getJobid());
			}
			else
				System.out.println("Job Post had Offensive Words! Try Again!");
		}
	}
	
	public void update(int id) {
		//looks up for id in the hash map
		if(postdetails.containsKey(id)) {
			Post p=postdetails.get(id);
			//gives option for which to update
			System.out.println("Select one form the list below and return the corresponding number");
			System.out.println("1. JobTitle");
			System.out.println("2. Skills Required");
			System.out.println("3. Passout");
			System.out.println("4. Job Description");
			System.out.println("5. Salary");
			System.out.println("6. Company Name");
			int n=sc.nextInt();
			sc.nextLine();
			switch(n) {
			//updates job title
			case 1: System.out.println("Enter new JobTitle");
					String title=sc.nextLine();
					p.setJobtitle(title);
					postdetails.put(id, p);
					break;
			//updates skills required
			case 2: System.out.println("Enter new Skills Required");
					String skills=sc.nextLine();
					p.setSkillsrequired(skills);
					postdetails.put(id, p);
					break;
			//updates pass out
			case 3: System.out.println("Enter new Passout");
					String passout=sc.nextLine();
					p.setPassout(passout);
					postdetails.put(id, p);
					break;
			//updates job description
			case 4: System.out.println("Enter new Job Description");
					String description=sc.nextLine();
					p.setDescription(description);
					postdetails.put(id, p);
					break;
			//updates salary
			case 5: System.out.println("Enter new Salary(lpa)");
					float salary=sc.nextFloat();
					p.setSalary(salary);
					postdetails.put(id, p);
					break;
			//updates company name
			case 6: System.out.println("Enter new Company name");
					String company=sc.nextLine();
					p.setCompany(company);
					postdetails.put(id,p);
			//invalid case
			default:System.out.println("Invalid Number");
					break;
			}
		}
		//if job id not found
		else {
			System.out.println("Job Id not found!");
		}
	}
	
	public void delete(int id) {
		//checks for job id
		if(postdetails.containsKey(id)) {
			postdetails.remove(id);
			System.out.println("Successfully removed the Job!");
		}
		//if job id not found
		else {
			System.out.println("Can't find the Job ID");
		}
	}
	
	public void display() {
		//traverses the map and displays all the details
		for( Map.Entry<Integer, Post> entry : postdetails.entrySet() ){
			Post p=entry.getValue();
		    System.out.println( "Job id: " + entry.getKey());
		    System.out.println("Job Title: "+p.getJobtitle());
		    System.out.println("Skills Required: "+p.getSkillsrequired());
		    System.out.println("Passout: "+p.getPassout());
		    System.out.println("Description: "+p.getDescription());
		    System.out.println("Salary: "+p.getSalary()+"LPA");
		    System.out.println("Posted On: "+p.getPostedon());
		    System.out.println("Company Name: "+p.getCompany());
		    
		    List<User> applicants=p.getApplicant();
		    //checks for the applicants
		    if (applicants.size() == 0)
		    	System.out.println("There are no applicants for this Job!");
		    else {
		    	System.out.println("Following are the applicants of the Job");
		    	for(int i=0;i<applicants.size();i++) {
		    		System.out.println(applicants.get(i).getName());
		    	}
		    }
		    
		    HashMap<User,String> comments=p.getComments();
		    //checks for the comments
		    if (comments.size() == 0)
		    	System.out.println("There are no comments for this Job!");
		    else {
		    	System.out.println("Following are the comments of the Job");
		    	for(Map.Entry<User, String> entry1: comments.entrySet()) {
					User u=entry1.getKey();
					System.out.println("User's Email: "+u.getEmail());
					System.out.println("User's Comment: "+entry1.getValue());
				}
		    }
		    System.out.println();
		}
		//checks for the availability of the posts
		if(postdetails.size() == 0)
			System.out.println("No job Posts!");
	}
	
	//checks for the duplicate jobs
	public boolean CheckDuplicateJobId(int id) {
		for(Map.Entry<Integer,Post> entry: postdetails.entrySet()) {
			if (entry.getKey() == id)
				return true;
		}
		return false;
	}
	
	//display any one post
	public void displayOne(int id) {
		//flag variable for checking whether the post is available or not
		boolean flag=false;
		
		//traverse through the hash map and prints the details
		for(Map.Entry<Integer,Post> entry: postdetails.entrySet()) {
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
			    
			    List<User> applicants=p.getApplicant();
			    //checks for the applicants
			    if (applicants.size() == 0)
			    	System.out.println("There are no applicants for this Job!");
			    else {
			    	System.out.println("Following are the applicants of the Job");
			    	for(int i=0;i<applicants.size();i++) {
			    		System.out.println(applicants.get(i).getName());
			    	}
			    }
			    
			    HashMap<User,String> comments=p.getComments();
			    //checks for the comments
			    if (comments.size() == 0)
			    	System.out.println("There are no comments for this Job!");
			    else {
			    	System.out.println("Following are the comments of the Job");
			    	for(Map.Entry<User, String> entry1: comments.entrySet()) {
						User u=entry1.getKey();
						System.out.println("User's Email: "+u.getEmail());
						System.out.println("User's Comment: "+entry1.getValue());
					}
			    }
			    System.out.println();
			}
		}
		//if job id not found
		if(flag == false)
			System.out.println("Job ID not found.");
	}
	
	
}
