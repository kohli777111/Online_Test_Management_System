package com.cpg.onlinetestmanagement.dao;

public interface UserOperationsInterface {

	
	
//	public void userOrAdmin(UserOperationsDao obj);
	
//	public void validateUser(UserOperationsDao obj);
	
	//public void newUser(UserOperationsDao obj);
	
	public void validatePassword(UserOperationsDao obj,String username,String password);
	
//	public void userTask(UserOperationsDao obj,String username);
//	
//	public void adminTask(UserOperationsDao obj);
	
	public void addTest();
	
	public void updateTest();
	
	public void deleteTest();
	
	public void assignTest(UserOperationsDao obj);
	
	public void addQuestion();
	
	public void updateQuestion();
	
	public void deleteQuestion();
	
	public void giveTest(UserOperationsDao obj,String username);
	
//	public void getResult(UserOperationsDao obj,String username);
	
	public void calculateTotalMarks(UserOperationsDao obj);
	
	public boolean passwordValidator(String password);
	
	public void printHashmap(DatabaseDao database);
	
	
}
