package testing;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import Controller.HrForm;
import model.Post;
import Utility.CheckPost;

public class TestHrForm {
	private static HashMap<Integer, Post> providedMap = new HashMap<Integer,Post>();
	
	static HrForm hr=new HrForm();
	
	static Post post1 = new Post ( 1,"Java Developer","Java,oops","2021","Java developer",(float) 6.5,LocalDate.now(),"ThoughtWorks");
	static Post post2 = new Post ( 2,"Python Developer","Python,oops","2022","Python developer",(float) 7.5,LocalDate.now(),"Face");
	static Post post3 = new Post ( 3,"c++ Developer","c++,oops","2020","c++ developer",(float) 5.5,LocalDate.now(),"ProGrad");
	static Post post4 = new Post ( 3,"c++ Developer ass","c++,oops","2020","c++ developer",(float) 5.5,LocalDate.now(),"ProGrad");
	
	
	@BeforeClass
	public static void Initialize() {
	
		hr.setPostDetails(1, post1);
		hr.setPostDetails(2, post2);
		hr.setPostDetails(3, post3);
	
		providedMap.put(1, post1);
		providedMap.put(2, post2);
		providedMap.put(3, post3);

	}
	
	@Test
	public void HrHashMap(){
		Assert.assertNotNull("Provided Map is null;", providedMap);
        Assert.assertNotNull("Received Map is null;", hr.getPostdetails());
        Assert.assertEquals("Size mismatch for maps;", providedMap.size(), hr.getPostdetails().size());
        Assert.assertTrue("Missing keys in received map;", hr.getPostdetails().keySet().containsAll(providedMap.keySet()));

        providedMap.keySet().stream().forEach((key) -> {
            Assert.assertEquals("Value mismatch for key '" + key + "';", providedMap.get(key), hr.getPostdetails().get(key));
        });
	}
	
	@Test
	public void CheckPost() {
		CheckPost cp=new CheckPost();
		assertEquals(true,cp.checkPost(post1));
		assertEquals(true,cp.checkPost(post2));
		assertEquals(true,cp.checkPost(post3));
		assertEquals(false,cp.checkPost(post4));
		try {
			assertEquals(false,cp.checkPost(null));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
