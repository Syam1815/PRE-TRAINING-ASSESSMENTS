package com.litmus7.registeruser.util;

import java.util.regex.Pattern;

import com.litmus7.registeruser.constants.ConditionConstant;

public class UserValidationUtil {

	public boolean validateAge(int age) {
		return  (age >= ConditionConstant.MINIMUM_AGE && age <= ConditionConstant.MAXIMUM_AGE);
	}

	public boolean validateEmail(String email){
		 // Regular expression to match valid email formats
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    
        // Compile the regex
        Pattern pattern = Pattern.compile(emailRegex);
      
        // Check if email matches the pattern
        return email != null && pattern.matcher(email).matches();
    }
	

	public boolean validatePassword(String password) {
		return (password.length() > 6);
	}
}
