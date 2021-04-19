package com.thrillio.managers;

import com.thrillio.dao.UserDao;
import com.thrillio.entities.User;

public class UserManager {

	private static UserManager instance = new UserManager();
	private static UserDao dao = new UserDao();

	private UserManager() {
	}

	public static UserManager getInstance() {
		return instance;

	}

	public User createUser(long id, String firstName, String lastName, int gender, String email, String password,
			String userType) {

		User user = new User();
		
		user.setId(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setEmail(email);
		user.setPassword(password);
		user.setUserType(userType);

		return user;
	}
	
	public User[] getUsers() {
		return dao.getUsers();
	}

}
