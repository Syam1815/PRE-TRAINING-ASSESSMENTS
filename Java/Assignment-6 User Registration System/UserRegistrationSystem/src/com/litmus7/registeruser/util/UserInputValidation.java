package com.litmus7.registeruser.util;

public class UserInputValidation {
	public boolean isNull(Object object ) {
		return object==null;
	}
	public boolean isValidString(String string) {
		return string!=null && string.trim().isEmpty();
	}
}
