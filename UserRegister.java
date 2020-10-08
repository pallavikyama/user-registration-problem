package com.blz.junitlearning;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FunctionalInterface
interface Register {
	public void entry();
}

public class UserRegister {
	static String firstName, lastName;
	static boolean x;
	static Scanner input = new Scanner(System.in);
	static Scanner input1 = new Scanner(System.in);
	static Scanner input2 = new Scanner(System.in);
	static String formula1 = "^[A-Z][A-Za-z]{2,}$";
	static Pattern code1 = Pattern.compile(formula1);
	static String formula2 = "^[A-Z][A-Za-z]{2,}$";
	static Pattern code2 = Pattern.compile(formula2);
	static String formula3 = "^[a-zA-Z0-9]+(?:[_\\-\\+\\.][a-zA-Z0-9]+)*@(?:[a-zA-Z0-9]+\\.){1,2}[a-zA-Z]{2,}$";
	static Pattern code3 = Pattern.compile(formula3);
	static String formula4 = "^[0-9]{2} [0-9]{10}$";
	static Pattern code4 = Pattern.compile(formula4);
	static String formula5 = "^(?=.*[A-Z])(?=.*[0-9])[\\w^_]*[\\W_][\\w^_]*{8,}$";
	static Pattern code5 = Pattern.compile(formula5);

	// FIRST NAME VALIDATION
	public void invalidFirstName(String firstName) throws FirstNameException {
		Matcher check = code1.matcher(firstName);
		if (check.matches())
			x = true;
		else
			throw new FirstNameException("Your First Name entered is not following the pattern. Please try again.");
	}

	// LAST NAME VALIDATION
	public void invalidLastName(String lastName) throws LastNameException {
		Matcher check = code2.matcher(lastName);
		if (check.matches())
			x = true;
		else {
			x = false;
			throw new LastNameException(
					firstName + ", your last Name entered is not following the pattern. Please try again.");
		}
	}

	// VARIOUS SAMPLE EMAIL-ID VALIDATION
	public void invalidEmailID(String emailID) throws EmailIDException {
		Matcher check = code3.matcher(emailID);
		if (check.matches())
			x = true;
		else {
			x = false;
			throw new EmailIDException(firstName + " " + lastName
					+ ", your Email-ID entered is not following the pattern. Please try again.");
		}
	}

	// MOBILE NUMBER VALIDATION
	public void invalidMobileNo(String mobileNo) throws MobileNoException {
		Matcher check = code4.matcher(mobileNo);
		if (check.matches())
			x = true;
		else {
			x = false;
			throw new MobileNoException(firstName + " " + lastName
					+ ", your Mobile Number entered is not following the pattern. Please try again.");
		}
	}

	// PASSWORD RULES-1,2,3,4 VALIDATION
	public void invalidPassword(String password) throws PasswordException {
		Matcher check = code5.matcher(password);
		if (check.matches()) {
			x = true;
			System.out.println("Welcome " + firstName + " " + lastName + "!");
		} else {
			x = false;
			throw new PasswordException(firstName + " " + lastName
					+ ", your Password entered is not following the pattern. Please try again.");
		}
	}

	// TESTING METHODS
	public boolean mainUserFirstName(String mainFirstName) {
		Matcher check = code1.matcher(mainFirstName);
		return check.matches();
	}

	public boolean mainUserLastName(String mainLastName) {
		Matcher check = code2.matcher(mainLastName);
		return check.matches();
	}

	public boolean mainUserEmailID(String mainEmailID) {
		Matcher check = code3.matcher(mainEmailID);
		return check.matches();
	}

	public boolean mainUserMobileNo(String mainMobileNo) {
		Matcher check = code4.matcher(mainMobileNo);
		return check.matches();
	}

	public boolean mainUserPassword(String mainPassword) {
		Matcher check = code5.matcher(mainPassword);
		return check.matches();
	}

	public static void main(String[] args) {
		System.out.println("NEW USER REGISTRATION.");
		UserRegister user = new UserRegister();

		// FIRST NAME ENTRY
		Register userFirstName = () -> {
			do {
				System.out.println("Enter your first name: ");
				firstName = input.next();
				try {
					user.invalidFirstName(firstName);
				} catch (FirstNameException e) {
					e.printStackTrace();
				}
			} while (!x);
		};

		// LAST NAME ENTRY
		Register userLastName = () -> {
			do {
				System.out.println(firstName + ", enter your last name: ");
				lastName = input.next();
				try {
					user.invalidLastName(lastName);
				} catch (LastNameException e) {
					e.printStackTrace();
				}
			} while (!x);
		};

		// EMAIL-ID ENTRY
		Register userEmailID = () -> {
			do {
				System.out.println(firstName + " " + lastName + ", enter your Email-ID: ");
				String emailID = input.next();
				try {
					user.invalidEmailID(emailID);
				} catch (EmailIDException e) {
					e.printStackTrace();
				}
			} while (!x);
		};

		// MOBILE NUMBER ENTRY
		Register userMobileNo = () -> {
			do {
				System.out.println(firstName + " " + lastName
						+ ", enter your mobile number\n(2-digit country code, followed by a space, followed by a 10-digit mobile number): ");
				String mobileNo = input1.nextLine();
				try {
					user.invalidMobileNo(mobileNo);
				} catch (MobileNoException e) {
					e.printStackTrace();
				}
			} while (!x);
		};

		// PASSWORD WITH RULES-1,2,3,4 ENTRY
		Register userPassword = () -> {
			do {
				System.out.println(firstName + " " + lastName
						+ ", enter your password:\n(Rule-1:Minimum 8 characters\n Rule-2:Atleast one upper case\n Rule-3:Atleast one numeric\n Rule-4:Exactly one special character) ");
				String password = input2.nextLine();
				try {
					user.invalidPassword(password);
				} catch (PasswordException e) {
					e.printStackTrace();
				}
			} while (!x);
		};
		userFirstName.entry();
		userLastName.entry();
		userEmailID.entry();
		userMobileNo.entry();
		userPassword.entry();
		input.close();
		input1.close();
		input2.close();
	}
}