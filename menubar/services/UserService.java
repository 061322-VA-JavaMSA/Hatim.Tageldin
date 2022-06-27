package com.revature.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.message.Message;

import com.revature.Screens;
import com.revature.dao.UserDao;
import com.revature.dao.UserPostgres;
import com.revature.models.User;
import com.revature.util.Validator;

public class UserService {

	private UserDao uDao = new UserPostgres();
	static BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
	
	public List<User> getUsers() {
		return uDao.getAllUsers();
	}
	
	public User createUser(User userTBC) {
		
		// Calls a validate method that checks user input against a regex to ensure only letters are input.
		boolean onlyLetters = Validator.validateName(userTBC.getFirstName(), userTBC.getLastName());
		// Checks the returned value from the validator and calls on the register screen if the user entered anything but letters.
		if(!onlyLetters) {
			System.out.println("Names can only be letters");
			try {
				Screens.registerScreen();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Validate that the username is not already in the DB
		User dbCheck = uDao.getByUsername(userTBC.getUsername());
		if(dbCheck.getId() != null) {
			System.out.println("Username is already taken.");
			try {
				Screens.registerScreen();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		userTBC.setId(UUID.randomUUID());
		
		// Call on UserPostgresController to add the user to the DB
		 uDao.createNewUser(userTBC);
		
		
		return null;
	}
	
	public User getUserById(UUID uuid) {
		User idUser = uDao.getUserById(uuid);
		
		return idUser;
	}
	
	public boolean updateUser(User original) throws IOException{
		
		User updated = new User();
		System.out.println("Enter new first name, or press enter to continue.");
		updated.setFirstName(bufferReader.readLine());
		System.out.println("Enter new last name, or press enter to continue.");
		updated.setLastName(bufferReader.readLine());
		System.out.println("Enter new username, or press enter to continue.");
		updated.setUsername(bufferReader.readLine());
		System.out.println("Enter new password, or press enter to continue.");
		updated.setPassword(bufferReader.readLine());
		
		// Checking changed values
		if(updated.getFirstName() == null) {
			updated.setFirstName(original.getFirstName());
		} 
		if(updated.getLastName() == null) {
			updated.setLastName(original.getLastName());
		}
		if(updated.getUsername() == null) {
			updated.setUsername(original.getUsername());
		}
		if(updated.getPassword() == null) {
			updated.setPassword(original.getPassword());
		}
		
		updated.setId(original.getId());
		
		boolean result = uDao.updateUser(updated);
		
		return result;
	}
	
	public boolean deleteUser(UUID id) {
		boolean result = uDao.deleteUser(id);
		
		return result;
	}

	public Message createUser(models.User userTBC) {
		// TODO Auto-generated method stub
		return null;
	}
}