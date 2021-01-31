package testing;

import static org.junit.Assert.*;
import org.junit.Test;

import model.User;

public class TestUser {
	User user = new User ( "Admin","admin@gmail.com","hr","Admin@556","female","9999999999");
	
	@Test
	public void testSetterGetter() {
		user.setName("Admin");
		user.setEmail("amin@gmail.com");
		user.setDesignation("hr");
		user.setPassword("Admin@556");
		user.setGender("female");
		user.setPhoneno("9999999999");
		assertEquals("Admin",user.getName());
		assertEquals("amin@gmail.com",user.getEmail());
		assertEquals("hr",user.getDesignation());
		assertEquals("Admin@556",user.getPassword());
		assertEquals("female",user.getGender());
		assertEquals("9999999999",user.getPhoneno());
		try {
			user.setName(null);
			user.setEmail(null);
			user.setDesignation(null);
			user.setPassword(null);
			user.setGender(null);
			user.setPhoneno(null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

