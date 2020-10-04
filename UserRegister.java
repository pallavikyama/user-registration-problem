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

	public void userFirstName() {
		do {
			// FIRST NAME
			System.out.println("Enter your first name: ");
			firstName = input.next();
			String formula1 = "^[A-Z][A-Za-z]{2,}$";
			Pattern code = Pattern.compile(formula1);
			Matcher check = code.matcher(firstName);
			if (check.matches())
				x = true;
			else {
				System.out.println("First Name entered is not following the pattern.\nPlease try again.");
				x = false;
			}
		} while (!x);
		userLastName();
	}

	public void userLastName() {
		do {
			// LAST NAME
			System.out.println(firstName + ", enter your last name: ");
			lastName = input.next();
			String formula2 = "^[A-Z][A-Za-z]{2,}$";
			Pattern code = Pattern.compile(formula2);
			Matcher check = code.matcher(lastName);
			if (check.matches())
				x = true;
			else {
				System.out.println(
						firstName + ", your last Name entered is not following the pattern.\nPlease try again.");
				x = false;
			}
		} while (!x);
		userEmailID();
	}

	public void userEmailID() {
		do {
			// EMAIL-ID
			System.out.println(firstName + " " + lastName + ", enter your Email-ID: ");
			emailID = input.next();
			String formula3 = "^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*@(?:[a-zA-Z0-9]+\\.){1,2}[a-zA-Z]+$";
			Pattern code = Pattern.compile(formula3);
			Matcher check = code.matcher(emailID);
			if (check.matches())
				x = true;
			else {
				System.out.println(firstName + " " + lastName
						+ ", your Email-ID entered is not following the pattern.\nPlease try again.");
				x = false;
			}
		} while (!x);
		userMobileNo();
	}

	public void userMobileNo() {
		do {
			// MOBILE NUMBER
			System.out.println(firstName + " " + lastName
					+ ", enter your mobile number\n(2-digit country code, followed by a space, followed by a 10-digit mobile number): ");
			mobileNo = input1.nextLine();
			String formula4 = "^[0-9]{2} [0-9]{10}$";
			Pattern code = Pattern.compile(formula4);
			Matcher check = code.matcher(mobileNo);
			if (check.matches())
				x = true;
			else {
				System.out.println(firstName + " " + lastName
						+ ", your Mobile Number entered is not following the pattern.\nPlease try again.");
				x = false;
			}
		} while (!x);
		userPassword();
	}

	public void userPassword() {
		do {
			// PASSWORD RULES-1,2,3
			System.out.println(firstName + " " + lastName
					+ ", enter your password:\n(Rule-1:Minimum 8 characters\n Rule-2:Atleast one upper case\n Rule-3:Atleast one numeric) ");
			password = input2.nextLine();
			String formula5 = "^(?=.*[A-Z])(?=.*[0-9]).{8,}$";
			Pattern code = Pattern.compile(formula5);
			Matcher check = code.matcher(password);
			if (check.matches()) {
				x = true;
				System.out.println("Welcome " + firstName + " " + lastName + "!");
			} else {
				System.out.println(firstName + " " + lastName
						+ ", your Password entered is not following the pattern.\nPlease try again.");
				x = false;
			}
		} while (!x);
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