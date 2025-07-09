package com.litmus7.registeruser.ui;

import com.litmus7.registeruser.controller.UserRegistrationController;
import com.litmus7.registeruser.dto.Response;
import com.litmus7.registeruser.dto.User;

public class RegistrationApp {

	public static void main(String[] args) {
		UserRegistrationController userRegistrationController = new UserRegistrationController();

		// Add a user
		User user1 = new User("Hari", 25, "hari@example.com", "hari123");
		Response<User> response1 = userRegistrationController.registerUser(user1);

		if (response1.getStatusCode() == 200) {
			System.out.println(response1.getStatusMessage() + "\n" + response1.getData());
		} else {
			System.err.println(response1.getErrorMessage());
		}

		// Add user with invalid age
		User user2 = new User("Ravi", 10, "ravi@example.com", "ravi123");
		Response<User> response2 = userRegistrationController.registerUser(user2);

		if (response2.getStatusCode() == 200) {
			System.out.println(response2.getStatusMessage() + "\n" + response2.getData());
		} else {
			System.err.println(response2.getErrorMessage());
		}

		// Add user with invalid email
		User user3 = new User("Ravi", 20, "invalidemail", "ravi123");
		Response<User> response3 = userRegistrationController.registerUser(user3);

		if (response3.getStatusCode() == 200) {
			System.out.println(response3.getStatusMessage() + "\n" + response3.getData());
		} else {
			System.err.println(response3.getErrorMessage());
		}

		// Add user with weak password
		User user4 = new User("Ravi", 20, "ravi@example.com", "ravi");
		Response<User> response4 = userRegistrationController.registerUser(user4);

		if (response4.getStatusCode() == 200) {
			System.out.println(response4.getStatusMessage() + "\n" + response4.getData());
		} else {
			System.err.println(response4.getErrorMessage());
		}

		// Add user in correct way
		User user5 = new User("Ravi", 20, "ravi@example.com", "ravi#456");
		Response<User> response5 = userRegistrationController.registerUser(user5);

		if (response5.getStatusCode() == 200) {
			System.out.println(response5.getStatusMessage() + "\n" + response5.getData());
		} else {
			System.err.println(response5.getErrorMessage());
		}

		// Search for user
		Response<User> response6 = userRegistrationController.searchUserByUsername("Hari");

		if (response6.getStatusCode() == 200) {
			System.out.println(response6.getStatusMessage() + "\n" + response6.getData());
		} else {
			System.err.println(response6.getErrorMessage());
		}

		// Add already existing user
		User user7 = new User("Ravi", 51, "ravi1974@example.com", "ravi1974");

		Response<User> response7 = userRegistrationController.registerUser(user7);

		if (response7.getStatusCode() == 200) {
			System.out.println(response6.getStatusMessage());
		} else {
			System.err.println(response7.getErrorMessage());
		}
	}
}
