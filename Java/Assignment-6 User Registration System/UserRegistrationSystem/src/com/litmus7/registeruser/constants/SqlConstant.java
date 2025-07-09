package com.litmus7.registeruser.constants;

public class SqlConstant {
	public final static String INSERT_USER = "INSERT INTO user(user_name,age,email,password) VALUES(?,?,?,?)";
	public final static String FIND_USER = "SELECT user_id ,user_name,age,email,password FROM user WHERE user_name = ? "; 
	public final static String FIND_USERNAME = "SELECT user_name FROM user WHERE user_name = ? ";

}
