package menubar;

import java.util.Scanner;

public class Login {

	public static void login() {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("S T O R E || H O M E || PAGE");
			System.out.println();
			System.out.println("Enter username___:");
			System.out.println();
			String userName = sc.nextLine();
			System.out.println();
			System.out.println("Enter password___");
			System.out.println();
			String password = sc.nextLine();
			System.out.println();

			if ("admin".equals(userName) && "password".equals(password)) {
				System.out.println("Access granted");
			} else {
				System.out.println("Invalid username or password");
			}
		}
	}

}
