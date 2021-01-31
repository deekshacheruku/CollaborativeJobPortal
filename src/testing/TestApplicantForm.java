package testing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import Controller.ApplicantForm;
import model.Post;


public class TestApplicantForm {
	private static List<Post> providedList = new ArrayList<Post>();
	
	static ApplicantForm af=new ApplicantForm();
	
	static Post post1 = new Post ( 1,"Java Developer","Java,oops","2021","Java developer",(float) 6.5,LocalDate.now(),"ThoughtWorks");
	static Post post2 = new Post ( 2,"Python Developer","Python,oops","2022","Python developer",(float) 7.5,LocalDate.now(),"Face");
	static Post post3 = new Post ( 3,"c++ Developer","c++,oops","2020","c++ developer",(float) 5.5,LocalDate.now(),"ProGrad");
	
	
	@BeforeClass
	public static void Initialize() {
	
		af.setAppliedlist(post1);
		af.setAppliedlist(post2);
		af.setAppliedlist(post3);
	
		providedList.add(post1);
		providedList.add(post2);
		providedList.add(post3);

	}
	
	@Test
	public void ApplicantList(){
		Assert.assertNotNull("Provided List is null;", providedList);
        Assert.assertNotNull("Received List is null;", af.getAppliedlist());
        Assert.assertEquals("Size mismatch for lists;", providedList.size(), af.getAppliedlist().size());
	}
	
	
}
