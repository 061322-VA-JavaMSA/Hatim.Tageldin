package views;

import models.*;

import java.util.*;



public class MainMenu {

    
    //logger to show class name of log class where the logs are originated
    
    static Member m;
    static Boolean running = true;
    static Boolean loggedIn = false;
    static Boolean exit = true;

    public static void display() {
        Scanner scan = new Scanner(System.in);
        m = new Member();

        while (running) {
            while (exit) {
                System.out.println("      PG B O O K | M A I N M E N U");
                System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
                System.out.println("");
                System.out.println("1) Log in");
                System.out.println("2) Create Account");
                System.out.println("3) Exit");

                String input = scan.nextLine();

                switch (input) {
                    case "1":
                        System.out.println("Enter username:");
                        String username = scan.nextLine();
                        //mLogger.info(username);

                        System.out.println("Enter password:");
                        String password = scan.nextLine();
                        //mLogger.info(password);

                        try {
                            m = new Member(username, password);
                            loggedIn = m.login();
                            loggedIn = true;
                        } catch (NullPointerException e) {
                            System.out.println("username or password incorrect");
                        }

                        if (loggedIn) {
                            if (m.getIsStaff()) {
                                Staff s = new Staff(m);
                                StaffMenu.display(s);
                            } else {
                                MemberMenu.display();
                            }
                        }
                        break;
                    case "2":
                        boolean ifNull = true;
                        username = "";
                        while (ifNull) {
                            System.out.println("Please enter a username:");
                            username = scan.nextLine();

                            if (username == "" || username == null) {
                                System.out.println("Username cannot be blank");
                            } else {
                                ifNull = false;
                            }

                        }

                        password = "";
                        ifNull = true;
                        while (ifNull) {
                            System.out.println("Enter a password:");
                            password = scan.nextLine();

                            if (password == "" || password == null) {
                                System.out.println("Password cannot be blank");
                            } else {
                                ifNull = false;
                            }
                        }

                        String name = "";
                        ifNull = true;
                        while (ifNull) {
                            System.out.println("Enter your name:");
                            name = scan.nextLine();

                            if (name == "" || name == null) {
                                System.out.println("Name cannot be blank");
                            } else {
                                ifNull = false;
                            }
                        }

                        String address = "";
                        ifNull = true;
                        while (ifNull) {
                            System.out.println("Enter your address:");
                            address = scan.nextLine();

                            if (address == "" || address == null) {
                                System.out.println("Address cannot be blank");
                            } else {
                                ifNull = false;
                            }
                        }

                        ifNull = true;
                        String phone = "";
                        while (ifNull) {
                            System.out.println("Enter your phone number (no formatting i.e.: 4244441644):");
                            phone = scan.nextLine();

                            if (phone == null || phone == "") {
                                System.out.println("Phone number cannot be blank");
                            } else {
                                ifNull = false;
                            }
                        }

                        m.createNewAccount(username, password, name, address, phone);
                        break;
                    case "3":
                        System.out.println("Shutting down...");
                        running = false;
                        exit = false;
                        break;
                    default:
                        System.out.println("Not a valid command");
                }
            }
        }

        scan.close();
    }
}