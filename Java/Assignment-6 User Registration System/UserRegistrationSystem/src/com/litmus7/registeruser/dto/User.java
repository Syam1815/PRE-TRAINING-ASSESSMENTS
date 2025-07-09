/**
 * 
 */
package com.litmus7.registeruser.dto;

/**
 * 
 */
public class User {
	private int userId;
	private String username;
	private int age;
	private String email;
	private String password;
	
	/**
	 * @param username
	 * @param age
	 * @param email
	 * @param password
	 */
	public User(String username, int age, String email, String password) {
		this.username = username;
		this.age = age;
		this.email = email;
		this.password = password;
	}

	/**
	 * @param userId
	 * @param username
	 * @param age
	 * @param email
	 * @param password
	 */
	public User(int userId, String username, int age, String email, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.age = age;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", age=" + age + ", email=" + email + ", password="
				+ password + "]";
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
 
	
}
