package com.blz.junitlearning;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegister {
	String firstName;
	String lastName;
	String emailID;
	String mobileNo;
	String password;
	boolean x;
	static Scanner input = new Scanner(System.in);
	static Scanner input1 = new Scanner(System.in);
	static Scanner input2 = new Scanner(System.in);

	// FIRST NAME
	public void userFirstName() {
		do {
			System.out.println("Enter your first name: ");
			firstName = input.next();
			try {
				invalidFirstName(firstName);
			} catch (FirstNameException e) {
				e.printStackTrace();
			}
		} while (!x);
		userLastName();
	}

	public void invalidFirstName(String firstName) throws FirstNameException {
		String formula1 = "^[A-Z][A-Za-z]{2,}$";
		Pattern code = Pattern.compile(formula1);
		Matcher check = code.matcher(firstName);
		if (check.matches())
			x = true;
		else {
			x = false;
			throw new FirstNameException("First Name entered is not following the pattern. Please try again.");
		}
	}

	// LAST NAME
	public void userLastName() {
		do {
			System.out.println(firstName + ", enter your last name: ");
			lastName = input.next();
			try {
				invalidLastName(lastName);
			} catch (LastNameException e) {
				e.printStackTrace();
			}
		} while (!x);
		userEmailID();
	}

	public void invalidLastName(String lastName) throws LastNameException {
		String formula2 = "^[A-Z][A-Za-z]{2,}$";
		Pattern code = Pattern.compile(formula2);
		Matcher check = code.matcher(lastName);
		if (check.matches())
			x = true;
		else {
			x = false;
			throw new LastNameException(
					firstName + ", your last Name entered is not following the pattern. Please try again.");
		}
	}

	// VARIOUS SAMPLE EMAIL-ID TESTING
	public void userEmailID() {
		do {
			System.out.println(firstName + " " + lastName + ", enter your Email-ID: ");
			emailID = input.next();
			try {
				invalidEmailID(emailID);
			} catch (EmailIDException e) {
				e.printStackTrace();
			}
		} while (!x);
		userMobileNo();
	}

	public void invalidEmailID(String emailID) throws EmailIDException {
		String formula3 = "^[a-zA-Z0-9]+(?:[_\\-\\+\\.][a-zA-Z0-9]+)*@(?:[a-zA-Z0-9]+\\.){1,2}[a-zA-Z]{2,}$";
		Pattern code = Pattern.compile(formula3);
		Matcher check = code.matcher(emailID);
		if (check.matches())
			x = true;
		else {
			x = false;
			throw new EmailIDException(firstName + " " + lastName
					+ ", your Email-ID entered is not following the pattern. Please try again.");
		}
	}

	// MOBILE NUMBER
	public void userMobileNo() {
		do {
			System.out.println(firstName + " " + lastName
					+ ", enter your mobile number\n(2-digit country code, followed by a space, followed by a 10-digit mobile number): ");
			mobileNo = input1.nextLine();
			try {
				invalidMobileNo(mobileNo);
			} catch (MobileNoException e) {
				e.printStackTrace();
			}
		} while (!x);
		userPassword();
	}

	public void invalidMobileNo(String mobileNo) throws MobileNoException {
		String formula4 = "^[0-9]{2} [0-9]{10}$";
		Pattern code = Pattern.compile(formula4);
		Matcher check = code.matcher(mobileNo);
		if (check.matches())
			x = true;
		else {
			x = false;
			throw new MobileNoException(firstName + " " + lastName
					+ ", your Mobile Number entered is not following the pattern. Please try again.");
		}
	}

	// PASSWORD RULES-1,2,3,4
	public void userPassword() {
		do {
			System.out.println(firstName + " " + lastName
					+ ", enter your password:\n(Rule-1:Minimum 8 characters\n Rule-2:Atleast one upper case\n Rule-3:Atleast one numeric\n Rule-4:Exactly one special character) ");
			password = input2.nextLine();
			try {
				invalidPassword(password);
			} catch (PasswordException e) {
				e.printStackTrace();
			}
		} while (!x);
	}

	public void invalidPassword(String password) throws PasswordException {
		String formula5 = "^(?=.*[A-Z])(?=.*[0-9])[\\w^_]*[\\W_][\\w^_]*{8,}$";
		Pattern code = Pattern.compile(formula5);
		Matcher check = code.matcher(password);
		if (check.matches()) {
			x = true;
			System.out.println("Welcome " + firstName + " " + lastName + "!");
		} else {
			x = false;
			throw new PasswordException(firstName + " " + lastName
					+ ", your Password entered is not following the pattern. Please try again.");
		}
	}

	public boolean mainUserFirstName(String mainFirstName) {
		String formula1 = "^[A-Z][A-Za-z]{2,}$";
		Pattern code = Pattern.compile(formula1);
		Matcher check = code.matcher(mainFirstName);
		return check.matches();
	}

	public boolean mainUserLastName(String mainLastName) {
		String formula2 = "^[A-Z][A-Za-z]{2,}$";
		Pattern code = Pattern.compile(formula2);
		Matcher check = code.matcher(mainLastName);
		return check.matches();
	}

	public boolean mainUserEmailID(String mainEmailID) {
		String formula3 = "^[a-zA-Z0-9]+(?:[_\\-\\+\\.][a-zA-Z0-9]+)*@(?:[a-zA-Z0-9]+\\.){1,2}[a-zA-Z]{2,}$";
		Pattern code = Pattern.compile(formula3);
		Matcher check = code.matcher(mainEmailID);
		return check.matches();
	}

	public boolean mainUserMobileNo(String mainMobileNo) {
		String formula4 = "^[0-9]{2} [0-9]{10}$";
		Pattern code = Pattern.compile(formula4);
		Matcher check = code.matcher(mainMobileNo);
		return check.matches();
	}

	public boolean mainUserPassword(String mainPassword) {
		String formula5 = "^(?=.*[A-Z])(?=.*[0-9])[\\w^_]*[\\W_][\\w^_]*{8,}$";
		Pattern code = Pattern.compile(formula5);
		Matcher check = code.matcher(mainPassword);
		return check.matches();
	}

	public static void main(String[] args) {
		System.out.println("NEW USER REGISTRATION.");
		UserRegister user1 = new UserRegister();
		user1.userFirstName();
		input.close();
		input1.close();
		input2.close();
	}
}