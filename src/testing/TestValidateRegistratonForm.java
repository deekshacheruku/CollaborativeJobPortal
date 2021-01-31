package testing;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import businesslogic.ValidateRegisterForm;

public class TestValidateRegistratonForm {
	ValidateRegisterForm vr=new ValidateRegisterForm();
	
	@Test
	public void ValidateName() {
		assertEquals(false,vr.ValidateName("de"));
		assertEquals(false,vr.ValidateName("d"));
		assertEquals(false,vr.ValidateName(""));
		assertEquals(true,vr.ValidateName("dee"));
		assertEquals(true,vr.ValidateName("deeksha"));
		assertEquals(true,vr.ValidateName("deeksha reddy"));
		try {
			assertEquals(false,vr.ValidateName(null));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ValidateEmail() {
		assertEquals(false,vr.ValidateEmail("admin.com"));
		assertEquals(false,vr.ValidateEmail("admin@com"));
		assertEquals(false,vr.ValidateEmail(".com"));
		assertEquals(false,vr.ValidateEmail("@com"));
		assertEquals(true,vr.ValidateEmail("admin@gmail.com"));
		assertEquals(true,vr.ValidateEmail("admin2@gmail.com"));
		try {
			assertEquals(false,vr.ValidateEmail(null));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ValidatePassword() {
		assertEquals(false,vr.ValidatePassword("admin","Admin"));
		assertEquals(false,vr.ValidatePassword("admin","admin"));
		assertEquals(false,vr.ValidatePassword("Admin","Admin"));
		assertEquals(false,vr.ValidatePassword("Admin1","Admin1"));
		assertEquals(false,vr.ValidatePassword("admin123","Admin123"));
		assertEquals(true,vr.ValidatePassword("Admin123","Admin123"));
		try {
			assertEquals(false,vr.ValidatePassword(null,null));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ValidatePhone() {
		assertEquals(false,vr.ValidatePhone("99999"));
		assertEquals(false,vr.ValidatePhone("999993333"));
		assertEquals(true,vr.ValidatePhone("9999999999"));
		assertEquals(true,vr.ValidatePhone("9999944444"));
		try {
			assertEquals(false,vr.ValidatePhone(null));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ValidateGender() {
		assertEquals(false,vr.ValidateGender("m"));
		assertEquals(false,vr.ValidateGender("f"));
		assertEquals(false,vr.ValidateGender("mal"));
		assertEquals(false,vr.ValidateGender("femal"));
		assertEquals(true,vr.ValidateGender("male"));
		assertEquals(true,vr.ValidateGender("female"));
		assertEquals(true,vr.ValidateGender("maLE"));
		assertEquals(true,vr.ValidateGender("FEmale"));
		assertEquals(true,vr.ValidateGender("MALE"));
		assertEquals(true,vr.ValidateGender("FEMALE"));
		try {
			assertEquals(false,vr.ValidateGender(null));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ValidateDesignation() {
		assertEquals(false,vr.ValidateDesignation("h"));
		assertEquals(false,vr.ValidateDesignation("appl"));
		assertEquals(false,vr.ValidateDesignation("applican"));
		assertEquals(true,vr.ValidateDesignation("hr"));
		assertEquals(true,vr.ValidateDesignation("applicant"));
		assertEquals(true,vr.ValidateDesignation("hR"));
		assertEquals(true,vr.ValidateDesignation("HR"));
		assertEquals(true,vr.ValidateDesignation("APPLICANT"));
		assertEquals(true,vr.ValidateDesignation("ApPLIcant"));
		try {
			assertEquals(false,vr.ValidateDesignation(null));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
