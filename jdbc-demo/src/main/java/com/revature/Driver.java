package com.revature;

import javax.security.auth.login.LoginException;

import com.revature.util.Screens;



public class Driver {
	static String headingSeparator = "\n==========================\n";


	public static void main(String[] args) throws LoginException {
		
		System.out.println(headingSeparator + "\n~ Welcome to the PG Shop ~\n" + headingSeparator);
		// Calls the method 'welcomeScreen" to show the beginning options
		Screens.welcomeScreen();
		
	}

}