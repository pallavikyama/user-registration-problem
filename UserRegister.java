package com.blz.junitlearning;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegister {
	String firstName;
	boolean x;
	static Scanner input = new Scanner(System.in);

	public void userFirstName() {
		do {
			// FIRST NAME
			System.out.println("Enter your first name: ");
			firstName = input.next();
			String formula1 = "^[A-Z][A-Za-z]{2,}$";
			Pattern code = Pattern.compile(formula1);
			Matcher check = code.matcher(firstName);
			if (check.matches()) {
				x = true;
				System.out.println("Welcome " + firstName + "!");
			} else {
				System.out.println("First Name entered is not following the pattern.\nPlease try again.");
				x = false;
			}
		} while (!x);
	}

	public static void main(String[] args) {
		System.out.println("NEW USER REGISTRATION.");
		UserRegister user1 = new UserRegister();
		user1.userFirstName();
		input.close();
	}
}