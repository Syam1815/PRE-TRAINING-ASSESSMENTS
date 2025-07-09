package com.litmus7.registeruser.service;

import com.litmus7.registeruser.dao.UserDao;
import com.litmus7.registeruser.dto.User;
import com.litmus7.registeruser.exception.InvalidAgeException;
import com.litmus7.registeruser.exception.InvalidEmailException;
import com.litmus7.registeruser.exception.UserDataAccessException;
import com.litmus7.registeruser.exception.UserServiceException;
import com.litmus7.registeruser.exception.WeakPasswordException;
import com.litmus7.registeruser.util.UserValidationUtil;

public class UserRegistrationService {

	private UserDao userDao = new UserDao();
	private UserValidationUtil userValidationUtil = new UserValidationUtil();

	public User registerUser(User user)
			throws InvalidAgeException, InvalidEmailException, WeakPasswordException, UserServiceException {

		try {
			
			
			if (!userValidationUtil.validateAge(user.getAge())) {
				throw new InvalidAgeException("Error: Age must be between 18 and 60. ");
			}
			if (!userValidationUtil.validateEmail(user.getEmail())) {
				throw new InvalidEmailException("Error: Invalid email format.");
			}
			if (!userValidationUtil.validatePassword(user.getPassword())) {
				throw new WeakPasswordException("Error: Password too weak. Must be at least 6 characters. ");
			}

			user = userDao.registerUserToDB(user);

		} catch (UserDataAccessException e) {
			throw new UserServiceException(e.getMessage(), e);
		}
		return user;

	}

	public boolean checkUsernameAlreadyExist(String username) throws UserServiceException {
		try {
			return userDao.checkUsernameAlreadyExist(username);
		} catch (UserDataAccessException e) {
			throw new UserServiceException(e.getMessage(), e);

		}
	}

	public User searchUserByUsername(String username) throws UserServiceException {
		User user;
		try {
			user = userDao.searchUserByUsername(username);
		} catch (UserDataAccessException e) {
			throw new UserServiceException(e.getMessage(), e);
		}
		return user;

	}
}
