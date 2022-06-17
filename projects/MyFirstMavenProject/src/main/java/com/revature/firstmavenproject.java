package com.revature;
import java.util.Scanner;

public class firstmavenproject {

	public static void main(String[] args) {
		//Initializing scanner and variables
		Scanner scan = new Scanner(System.in);
		char a;
		int score = 0;
		String username = "admin";
		String password = "pass";
		//print statements with multiple choice
		System.out.println("1. Select the correct answer to be allowed login");
		System.out.println();
		System.out.println("A. I work here");
		System.out.println("B. Please log me in");
		System.out.println("C. I shop here all the time");
		System.out.println("D. Please log me in");
		System.out.println();
		
		a = scan.next().charAt(0);
			
		switch(a) {
		case 'D':
			System.out.println("Stop crying already, you're allowed to login");
			score++;
			break;
			default:
				System.out.println("Invalid answer try again in 362 days");
		}
					
		
			String inputUser;
			String inputPass;
			boolean correct = false;
			do {
				System.out.println("Please enter your username: ");
				System.out.println();
				inputUser = scan.nextLine();
				System.out.println("Please enter your password: ");
				inputPass = scan.nextLine();
				
				if(inputUser.equals(username) && inputPass.equals(password)) {
					correct = true;
				} else {
					System.out.println("Invaled credentials input, please try again");
					correct = false;
				}
			} while (correct == false);
		
		System.out.println("Menu. Welcome to MainMenu, please choose a free item");
		System.out.println();
		System.out.println("1. GATORADE");
		System.out.println("2. IZZE SPARKLING JUICE");
		System.out.println("3. BRISK");
		System.out.println("4. STARBUCKS");
		System.out.println();
		
		a = scan.next().charAt(0);
		
		switch(a) {
		case '1':
			System.out.println("No free items for you lol, try again");
			score++;
			break;
		case '2':
			System.out.println("Did you realy choose number 2? :)");
			break;
		case '3':
			System.out.println("Bad selection not a free item");
			break;
			default:
				System.out.println("No free items for you lol");
		}
		System.out.println("Your score is "+score+"/3");
		
}
}
