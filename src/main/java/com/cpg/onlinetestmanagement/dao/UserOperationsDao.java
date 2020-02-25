package com.cpg.onlinetestmanagement.dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class UserOperationsDao  {

	
	private Pattern pattern;
	private Matcher matcher;
	
	private static final String PASSWORD_PATTERN = 
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";
	
	
	
public boolean  passwordValidator(String password) {
		
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(password);
		return matcher.matches();
	}


	
}

