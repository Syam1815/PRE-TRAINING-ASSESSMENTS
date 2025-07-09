package com.litmus7.registeruser.controller;

import com.litmus7.registeruser.constants.StatusConstant;
import com.litmus7.registeruser.dto.Response;
import com.litmus7.registeruser.dto.User;
import com.litmus7.registeruser.exception.InvalidAgeException;
import com.litmus7.registeruser.exception.InvalidEmailException;
import com.litmus7.registeruser.exception.UserServiceException;
import com.litmus7.registeruser.exception.WeakPasswordException;
import com.litmus7.registeruser.service.UserRegistrationService;
import com.litmus7.registeruser.util.UserInputValidation;

public class UserRegistrationController {

	private UserRegistrationService userService = new UserRegistrationService();
	private UserInputValidation userInputValidation = new UserInputValidation();

	public Response<User> registerUser(User user) {
		Response<User> response = new Response<User>();

		if (userInputValidation.isNull(user)) {
			response.setStatusCode(StatusConstant.INVALID_DATA);
			response.setErrorMessage("Empty user details");
			return response;
		}

		if (userInputValidation.isValidString(user.getUsername())) {
			response.setStatusCode(StatusConstant.INVALID_DATA);
			response.setErrorMessage("Please enter your username !");
			return response;
		}

		try {
			if (userService.checkUsernameAlreadyExist(user.getUsername())) {
				response.setErrorMessage("Username already exists");
				response.setStatusCode(StatusConstant.ERROR);
			} else {

				user = userService.registerUser(user);
				response.setData(user);
				response.setStatusCode(StatusConstant.SUCCESS);
				response.setStatusMessage("Record added successfully");
			}

		} catch (InvalidAgeException | InvalidEmailException | WeakPasswordException | UserServiceException e) {
			response.setErrorMessage(e.getMessage());
			response.setStatusCode(StatusConstant.ERROR);
		} catch (Exception e) {
			response.setErrorMessage("Some internal error happened");
			response.setStatusCode(StatusConstant.ERROR);
		}

		return response;
	}

	public Response<User> searchUserByUsername(String username) {

		Response<User> response = new Response<User>();
		User user;
		
		if(userInputValidation.isValidString(username)) {
			response.setStatusCode(StatusConstant.INVALID_DATA);
			response.setErrorMessage("Please enter the requred username !");
			return response;
		}
		
		try {
			user = userService.searchUserByUsername(username);
			response.setStatusCode(StatusConstant.SUCCESS);
			response.setData(user);

			if (user != null) {
				response.setStatusMessage("User Found");
			} else {
				response.setStatusMessage("User Do Not Exist !");
			}

		} catch (UserServiceException e) {
			response.setErrorMessage(e.getMessage());
			response.setStatusCode(StatusConstant.ERROR);
		} catch (Exception e) {
			response.setErrorMessage("Some internal error happened");
			response.setStatusCode(StatusConstant.ERROR);
		}
		return response;
	}
}
