package menubar;

import java.util.Scanner;

public class Registration extends Login {

	public static void main(String[] args) {

		Register register = new Register();
		try (Scanner sc = new Scanner(System.in)) {

			System.out.print("Enter first name :");
			String firstName = sc.nextLine();
			register.setFirstName(firstName);
			System.out.println("===================");

			System.out.print("Enter last name :");
			String lastName = sc.nextLine();
			register.setLastName(lastName);
			System.out.println("===================");

			System.out.print("Email address :");
			String emailID = sc.nextLine();
			register.setEmailID(emailID);
			System.out.println("===================");

			System.out.print("Enter password");
			String password = sc.nextLine();
			register.setPassword(password);
			System.out.println();
			System.out.println("===================");

			printRegisterData(register);
		}

	}

	protected static void printRegisterData(Register register) {
		System.out.println(register.getFirstName());
		System.out.println(register.getLastName());
		System.out.println(register.getEmailID());
		System.out.println(register.getPassword());
	}
}

class Register {
	private String firstName;
	private String lastName;
	private String emailID;
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

