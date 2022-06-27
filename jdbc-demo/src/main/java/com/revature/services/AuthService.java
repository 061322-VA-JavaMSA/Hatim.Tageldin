package com.revature.services;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import com.revature.Screens;
import com.revature.dao.UserDao;
import com.revature.dao.UserPostgres;
import com.revature.exceptions.AuthException;
import com.revature.models.User;
import com.revature.util.Validator;

public class AuthService {
	
	private UserDao ud = new UserPostgres();
	
	public User login(String username, String password) throws AuthException, LoginException{

		if(!Validator.validateUsername(username) || !Validator.validatePassword(password)) {
			System.out.println("Empty values were given. No empty values.");
			try {
				Screens.loginScreen();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Calling getByUserName from the UserPostgresController. This will perform logic that will retrieve the user from the database if one matches the username.
		User u = ud.getByUsername(username); // UserPostgresController needs to be set up.
		
		if(u.getId() == null || !u.getPassword().equals(password)) {
		}
		return u;
	}
}