package testing;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;

import model.Post;

public class TestPost {
	Post post = new Post ( 1,"Java Developer","Java,oops","2021","Java developer",(float) 6.5,LocalDate.now(),"ThoughtWorks");
	
	@Test
	public void testSetterGetter() {
		post.setJobid(1);
		post.setJobtitle("Java Developer");
		post.setSkillsrequired("Java,oops");
		post.setPassout("2021");
		post.setDescription("Java developer");
		post.setSalary((float)6.5);
		post.setPostedon(LocalDate.now());
		post.setCompany("ThoughtWorks");
		assertEquals(1,post.getJobid());
		assertEquals("Java Developer",post.getJobtitle());
		assertEquals("Java,oops",post.getSkillsrequired());
		assertEquals("2021",post.getPassout());
		assertEquals("Java developer",post.getDescription());
		assertEquals(LocalDate.now(),post.getPostedon());
		assertEquals("ThoughtWorks",post.getCompany());
		try {
			post.setJobid(0);
			post.setJobtitle(null);
			post.setSkillsrequired(null);
			post.setPassout(null);
			post.setDescription(null);
			post.setSalary((float)0.0);
			post.setCompany(null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

