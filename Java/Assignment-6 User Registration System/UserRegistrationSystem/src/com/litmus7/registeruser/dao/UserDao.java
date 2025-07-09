package com.litmus7.registeruser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.litmus7.registeruser.constants.SqlConstant;
import com.litmus7.registeruser.dto.User;
import com.litmus7.registeruser.exception.UserDataAccessException;
import com.litmus7.registeruser.util.DBConnectionUtil;
import java.sql.Statement;

public class UserDao {

	public User registerUserToDB(User user) throws UserDataAccessException {
		int userId = 0;
		try (Connection connection = DBConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.INSERT_USER,
						Statement.RETURN_GENERATED_KEYS);) {
			
			
			
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setInt(2, user.getAge());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());

			preparedStatement.executeUpdate();

			try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
				if (resultSet.next()) {
					userId = resultSet.getInt(1);
				}
			}

			user.setUserId(userId);

		} catch (SQLException e) {
			throw new UserDataAccessException(e.getMessage(), e);
		}
		return user;
	}

	public boolean checkUsernameAlreadyExist(String username) throws UserDataAccessException {
		try (Connection connection = DBConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.FIND_USERNAME,
						Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, username);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return true;
				}
			}
		} catch (SQLException e) {
			throw new UserDataAccessException(e.getMessage(), e);
		}
		return false;

	}

	public User searchUserByUsername(String username) throws UserDataAccessException {
		User user = null;
		try (Connection connection = DBConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.FIND_USER,
						Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, username);
			try(ResultSet resultSet = preparedStatement.executeQuery()){
			if (resultSet.next()) {
				user = new User(resultSet.getInt("user_id"), resultSet.getString("user_name"), resultSet.getInt("age"),
						resultSet.getString("email"), resultSet.getString("password"));
			}
			}
		} catch (SQLException e) {
			throw new UserDataAccessException(e.getMessage(), e);
		}
		return user;
	}
}
