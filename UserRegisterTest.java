package com.blz.junitlearning;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserRegisterTest {

	@Test
	public void testUserFirstName() {
		UserRegister objFirstName = new UserRegister();

		// FIRST NAME HAPPY TEST-CASE
		boolean expectedEntry1 = true;
		boolean actualEntry1 = objFirstName.mainUserFirstName("Rama");
		assertEquals(expectedEntry1, actualEntry1);

		// FIRST NAME SAD TEST-CASE
		boolean expectedEntry2 = false;
		boolean actualEntry2 = objFirstName.mainUserFirstName("ali");
		assertEquals(expectedEntry2, actualEntry2);
	}

	@Test
	public void testUserLastName() {
		UserRegister objLastName = new UserRegister();

		// LAST NAME HAPPY TEST-CASE
		boolean expectedEntry1 = true;
		boolean actualEntry1 = objLastName.mainUserLastName("Devi");
		assertEquals(expectedEntry1, actualEntry1);

		// LAST NAME SAD TEST-CASE
		boolean expectedEntry2 = false;
		boolean actualEntry2 = objLastName.mainUserLastName("das");
		assertEquals(expectedEntry2, actualEntry2);
	}

	@Test
	public void testUserEmailID() {
		UserRegister objEmailID = new UserRegister();

		// EMAIL-ID NAME HAPPY TEST-CASE
		boolean expectedEntry1 = true;
		boolean actualEntry1 = objEmailID.mainUserEmailID("abc.xyz@bl.co.in");
		assertEquals(expectedEntry1, actualEntry1);

		// EMAIL-ID NAME SAD TEST-CASE
		boolean expectedEntry2 = false;
		boolean actualEntry2 = objEmailID.mainUserEmailID(".fgh@.in");
		assertEquals(expectedEntry2, actualEntry2);
	}

	@Test
	public void testUserMobileNo() {
		UserRegister objMobileNo = new UserRegister();

		// MOBILE NUMBER HAPPY TEST-CASE
		boolean expectedEntry1 = true;
		boolean actualEntry1 = objMobileNo.mainUserMobileNo("91 1234567890");
		assertEquals(expectedEntry1, actualEntry1);

		// MOBILE NUMBER SAD TEST-CASE
		boolean expectedEntry2 = false;
		boolean actualEntry2 = objMobileNo.mainUserMobileNo("871235645643");
		assertEquals(expectedEntry2, actualEntry2);
	}

	@Test
	public void testUserPassword() {
		UserRegister objPassword = new UserRegister();

		// PASSWORD HAPPY TEST-CASE
		boolean expectedEntry1 = true;
		boolean actualEntry1 = objPassword.mainUserPassword("fS 81a4");
		assertEquals(expectedEntry1, actualEntry1);

		// PASSWORD SAD TEST-CASE
		boolean expectedEntry2 = false;
		boolean actualEntry2 = objPassword.mainUserPassword("bdjagikai");
		assertEquals(expectedEntry2, actualEntry2);
	}

}