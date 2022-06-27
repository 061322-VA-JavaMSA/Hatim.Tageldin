package menubar;

import java.util.Scanner;

public class Main extends Registration {
	static Scanner sc;
	private static char[] firstName;
	private static char[] printRegisterData;

	public static void main(String[] args) {
		// User choice
		int choice;

		Scanner sc = new Scanner(System.in);
		// Display Menu
		System.out.println("M E A N || S C R E E N");
		System.out.println("===========");
		System.out.println("1. login");
		System.out.println("2. sign-up");
		System.out.println("3. Exit Menu");
		System.out.println("===========");
		System.out.println("Enter choice: ");

		choice = sc.nextInt();
		String register = sc.nextLine();

		// Loop
		while (choice != 3) {
			// Choice value
			if (choice == 1) {
				System.out.println("S T O R E || H O M E || PAGE");
				System.out.println();
				System.out.println("Enter username___: ");
				System.out.println();
				String userName = sc.nextLine();
				System.out.println();
				System.out.println("Enter password___: ");
				System.out.println();
				String password = sc.nextLine();
				System.out.println();
				System.out.println("Loged in successfully");
				break;
			} else if (choice == 2) {
				System.out.print("Enter first name___: ");
				String firstName = sc.nextLine();
				
				System.out.println("===================");

				System.out.print("Enter last name___: ");
				String lastName = sc.nextLine();
				
				System.out.println("===================");

				System.out.print("Email address___: ");
				String emailID = sc.nextLine();
				
				System.out.println("===================");

				System.out.print("Enter password___:");
				String password = sc.nextLine();
				
				System.out.println();
				System.out.println("===================");
				System.out.println("You have registered as ");
				


				System.out.println("" + firstName+ " " +  " " + lastName);
				System.out.println(emailID);
				System.out.println(password);
				System.out.println("===================");
				break;
				
				
			} else if (choice == 3) {
				System.out.println("Welcome to about us page");
				System.out.println("Thank you for visiting out store");
			}
			
		}
		
	}

}
