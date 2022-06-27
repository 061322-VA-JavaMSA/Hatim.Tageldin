package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserPostgres implements UserDao {
	
	private static Logger log = LogManager.getLogger(UserPostgres.class);

	@Override
	public User createUser(User u) {
		String sql = "insert into users (username, password, first_name, last_name, level) values (?, ?, initcap(?), initcap(?), ?) returning id;";
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setInt(5, u.getLevel());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u.setId(rs.getInt("id"));
				log.info("User " + u.getUsername() + " was created.");
			}
		} catch (SQLException e) {
			log.error("Failed to create user " + u.getUsername() + "." + e.getMessage());
		}
		return u;
	}

	@Override
	public User getUserById(int id) {
		
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		String sql = "select * from users where username = ?;";
		User u = null;
		
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setLevel(rs.getInt("level"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
			}
		} catch (SQLException e) {
			System.out.println("User not found.");
		}
		return u;
	}
	
	@Override
	public List<User> getUsers() {
		String sql = "select * from users;";
		List<User> users = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setLevel(rs.getInt("level"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				
				users.add(u);
			}
		} catch (SQLException e) {
			System.out.println("Unable to retrieve data.");
		}
		
		return users;
	}

	@Override
	public List<User> getUsers(String level) {
		String sql = "select * from users where level " + level + ";";
		List<User> users = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setLevel(rs.getInt("level"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				
				users.add(u);
			}
		} catch (SQLException e) {
			System.out.println("Unable to retrieve data.");
		}
		
		return users;
	}

	@Override
	public boolean updateUserById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUserById(int id) {
		String sql = "delete from users where id = ?;";
		int rowsChanged = -1;
		
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();
			
		} catch (SQLException e) {
			return false;
		}
		
		if (rowsChanged < 1) {
			return false;
		}
		
		return true;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createNewUser(User newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User userToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User uuid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> retrieveUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User retrieveUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User retrieveUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(UUID id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserById(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}
}
