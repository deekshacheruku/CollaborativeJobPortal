package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//post class with appropriate attributes
// has constructor and getters and setters
public class Post {
	private int jobid;
	private String jobtitle;
	private String skillsrequired;
	private String passout;
	private LocalDate postedon;
	private String description;
	private float salary;
	private String Company;
	protected List<User> applicant=new ArrayList<User>();
	protected HashMap<User,String> comments=new HashMap<User,String>();

	public Post(int id, String jobtitle, String skillsrequired, String passout, String description, float salary,
			LocalDate date, String company) {
		this.setJobid(id);
		this.setJobtitle(jobtitle);
		this.setSkillsrequired(skillsrequired);
		this.setPassout(passout);
		this.setDescription(description);
		this.setSalary(salary);
		this.setPostedon(date);
		this.setCompany(company);
	}
	
	public HashMap<User, String> getComments() {
		return comments;
	}

	public void setComments(User user, String comments) {
		this.comments.put(user, comments);
	}
	
	public List<User> getApplicant() {
		return applicant;
	}

	public void setApplicant(User user) {
		this.applicant.add(user);
	}

	public int getJobid() {
		return jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getSkillsrequired() {
		return skillsrequired;
	}

	public void setSkillsrequired(String skillsrequired) {
		this.skillsrequired = skillsrequired;
	}

	public String getPassout() {
		return passout;
	}

	public void setPassout(String passout) {
		this.passout = passout;
	}

	public LocalDate getPostedon() {
		return postedon;
	}

	public void setPostedon(LocalDate postedon) {
		this.postedon = postedon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		this.Company = company;
	}
	
	

	
}
