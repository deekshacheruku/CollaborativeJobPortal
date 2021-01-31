package testing;



import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import model.User;
import model.Login;

public class TestLogin {
	
	private static HashMap<String, User> providedMap = new HashMap<String,User>();
	static Login l = new Login();
	static User user1 = new User ( "Admin1","admin1@gmail.com","hr","Admin@556","female","9999999999");
	static User user2 = new User ( "Admin2","admin2@gmail.com","hr","Admin@556","female","9999999999");
	static User user3 = new User ( "Admin3","admin3@gmail.com","hr","Admin@556","female","9999999999");
	
	@BeforeClass
	public static void Initialize() {
	
		l.setDetails(user1.getEmail(), user1);
		l.setDetails(user2.getEmail(),user2);
		l.setDetails(user3.getEmail(),user3);
	
		providedMap.put("admin1@gmail.com", user1);
		providedMap.put("admin2@gmail.com", user2);
		providedMap.put("admin3@gmail.com", user3);

	}
	
	@Test
	public void LoginHashMap(){
		Assert.assertNotNull("Provided Map is null;", providedMap);
        Assert.assertNotNull("Received Map is null;", l.getDetails());
        Assert.assertEquals("Size mismatch for maps;", providedMap.size(), l.getDetails().size());
        Assert.assertTrue("Missing keys in received map;", l.getDetails().keySet().containsAll(providedMap.keySet()));

        providedMap.keySet().stream().forEach((key) -> {
            Assert.assertEquals("Value mismatch for key '" + key + "';", providedMap.get(key), l.getDetails().get(key));
        });
	}
	
	@Test
	public void loginCheck() {
		assertEquals(true,l.loginCheck("admin1@gmail.com","Admin@556"));
		assertEquals(true,l.loginCheck("admin2@gmail.com","Admin@556"));
		assertEquals(true,l.loginCheck("admin3@gmail.com","Admin@556"));
		assertEquals(false,l.loginCheck("admin@gmail.com","Admin@556"));
		assertEquals(false,l.loginCheck("admin2@gmail.com","Admi@556"));
		try {
			assertEquals(false,l.loginCheck(null,"Admi@556"));
			assertEquals(false,l.loginCheck("admin2@gmail.com",null));
			assertEquals(false,l.loginCheck(null,null));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getUser() {
		assertEquals(user1,l.getUser("admin1@gmail.com"));
		assertEquals(user2,l.getUser("admin2@gmail.com"));
		assertEquals(user3,l.getUser("admin3@gmail.com"));
		try {
			assertEquals(null,l.getUser(null));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
