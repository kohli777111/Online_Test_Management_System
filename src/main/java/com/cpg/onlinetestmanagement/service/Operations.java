package com.cpg.onlinetestmanagement.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cpg.onlinetestmanagement.bean.Questions;
import com.cpg.onlinetestmanagement.bean.Test;
import com.cpg.onlinetestmanagement.bean.User;
import com.cpg.onlinetestmanagement.dao.DatabaseDao;
import com.cpg.onlinetestmanagement.dao.UserOperationsDao;
import com.cpg.onlinetestmanagement.exceptions.MyException;


public class Operations {
	
	BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
	
	UserOperationsDao dobj = new UserOperationsDao();
	
	
// CHOOSE USER OR ADMIN
	public void userOrAdmin(Operations obj) {
		
		int choice=0;
		
		System.out.println(("Welcome to Online test. Are you User or Admin? \n 1) Admin \n 2) User"));
		
		try {
			choice=Integer.parseInt(buff.readLine());
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		switch(choice) {
		
		case 1: obj.validateUser(obj);
				break;

		case 2: obj.validateUser(obj);
				break;
		
		default: System.out.println("Invalid choice. Please choose again");
			obj.userOrAdmin(obj);
		
		}	
	}
	

	
//VALIDATE THE USERNAME TO LOGIN
	public void validateUser(Operations obj) {
		
		String username;
		
		boolean flag=false;
		
		System.out.println("Please enter your username to Login: ");
		
		try {
			username=buff.readLine();
			
			Set<Long> set = DatabaseDao.hm1.keySet();
			
			Iterator<Long> i = set.iterator();
			
			while(i.hasNext()) {
				
				Object key = i.next();
				
				if(DatabaseDao.hm1.get(key).getUserName().equals(username)) {
					flag=true;
					break;
				}
			}
			
			if(flag==true) {
				
				obj.validatePassword(obj,username);
			}
			
			else {
				System.out.println("Username unavailable:\n 1) SIGN IN \n 2) SIGN UP new user");
				
				int choice = Integer.parseInt(buff.readLine());
				
				switch(choice) {
				
				case 1: obj.validateUser(obj);
					break;
				
				case 2: obj.newUser(obj);
					break;
				
				default: System.out.println("Enter a valid choice ");
				
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
//VALIDATE THE PASSWORD TO LOGIN
	public void validatePassword(Operations obj,String username) {
		String password = null;
		Object key = null;
		
		System.out.println("Enter password");
		try {
		
			password = buff.readLine();
		
		} catch (IOException e) {
				e.printStackTrace();
			}
			
		Set set = DatabaseDao.hm1.keySet();
		Iterator i = set.iterator();
					
					
		while(i.hasNext()) {
						
			key=i.next();
						
			if(DatabaseDao.hm1.get(key).getUserName().equals(username)) {
				break;
			}
		}
					
		String password2 = DatabaseDao.hm1.get(key).getUserPassword();
				
		if(password2.equals(password)) {
							
			if(DatabaseDao.hm1.get(key).getIsAdmin()==true) {
				
				System.out.println("WELCOME ADMIN");
				obj.adminTask(obj);
							
			}
							
			else {
				
				System.out.println("WELCOME STUDENT");			
				obj.userTask(obj, username);		
							
			}
							
		}
						
		else {
			
			boolean flag = true;
			
			while(flag) {
				System.out.println("invalid password");
				System.out.println("1) TRY AGAIN   2) FORGOT PASSWORD");
				int choice=0;
				try {
					choice = Integer.parseInt(buff.readLine());
					switch(choice) {
					case 1: obj.validatePassword(obj, username);
							break;
					case 2: obj.forgotPassword(obj,username);
							break;
					default: System.out.println("Invalid choice.");
					}
						
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
			}	
		
		}
								
	}
	
	
	
	public void forgotPassword(Operations obj,String username) {
		
		System.out.println("Enter your new password");
		String pass;
		try {
			pass = buff.readLine();
			if(dobj.passwordValidator(pass)) {
				Object key2=null;
				Set set2 = DatabaseDao.hm1.keySet();
				Iterator i2 = set2.iterator();
				while(i2.hasNext()) {
					key2 = i2.next();
					if(DatabaseDao.hm1.get(key2).getUserName().equals(username))
						break;
				}
				DatabaseDao.hm1.get(key2).setUserPassword(pass);
				System.out.println(DatabaseDao.hm1.get(key2).getUserPassword());
				System.out.println("Password changed successfully. Please login again.");
				boolean flag=false;
				obj.validateUser(obj);
			}
			
			else {
				System.out.println("Password should contain 1 UC , 1 LC , 1 D and 1 SC");
				obj.forgotPassword(obj, username);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
//REFISTER NEW USER
	public void newUser(Operations obj) {
		
		String username;
		String password;
		boolean flag=false;
	
		
	
		try {
			
			System.out.println("Please provide a userName");
			username=buff.readLine();
			
			Set<Long> set = DatabaseDao.hm1.keySet();
			Iterator<Long> i = set.iterator();
			
			while(i.hasNext()) {
				
				Object key = i.next();
				
				if(username.equals(DatabaseDao.hm1.get(key).getUserName())) {
					flag=true;
					break;
				}
			}
					
			if(flag==true) {
				
				System.out.println("Username already exist. Please provide a new username");
				obj.newUser(obj);
			}
				
			else {
				
				System.out.println("Enter password -> 1 UPPERCASE , 1 lowercase , 1 numeric , 1 special char");
				
				password = buff.readLine();
				
				if(dobj.passwordValidator(password)) {
					
					System.out.println("User Registered");
					
					User u = new User(username, password, false,null);
					
					DatabaseDao.hm1.put(76l, u );
					
					obj.validateUser(obj);
				
				}
				
				else {
					
					System.out.println("Password should contain 1 UC , 1 LC , 1 D and 1 SC");
					
					obj.newUser(obj);
				
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

//ASK ADMIN TASK TO BE PERFORMED
	public void adminTask(Operations obj) {
		
		
		
		int choice=0;
		
		try {
			
			System.out.println("Choose a task: \n 1) ADD TEST \n 2) UPDATE TEST \n 3) DELETE TEST \n "
					+ "4) ASSIGN TEST \n 5) ADD QUESTION \n 6) UPDATE QUESTION \n 7) DELETE QUESTION ");
			
			choice = Integer.parseInt(buff.readLine());
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		switch(choice) {
		
		case 1: obj.addTest(obj);
			break;
		
		case 2: obj.updateTest();
			break;
		
		case 3: obj.deleteTest();
			break;
		
		case 4: obj.assignTest(obj);
			break;
		
		case 5: obj.addQuestion(obj);
			break;
		
		case 6: obj.updateQuestion();
			break;
		
		case 7: obj.deleteQuestion();
			break;
		
		default: System.out.println("invalid choice. Choose again");
			obj.adminTask(obj);
		
		}
	}
	
	
	
//ASK USER TASK TO BE PERFORMED
	public void userTask(Operations obj,String username) {
		
		
		int choice = 0;
		try {
			
			System.out.println("What do you want to do? \n 1) GIVE TEST \n 2) GET RESULT \n "
									+ "3) CALCULATE TOTAL MARKS \n 4) EXIT");
			
			choice = Integer.parseInt(buff.readLine());
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		switch(choice) {
		
		case 1: obj.giveTest(obj,username);
			break;
		
		case 2:	try {
				obj.getResult(obj,username);
			} catch (MyException e) {
				e.printStackTrace();
			}
			break;
		
		case 3: obj.calculateTotalMarks(obj);
			break;
			
		case 4: obj.userOrAdmin(obj);
		
		default: System.out.println("Invalid choice");
		
		}
	}
	
	
//ADMIN -> ASSIGN TEST TO USER
	public void assignTest(Operations obj) {
		
		Long userId=0L;
		Long testId=0L;
		try {
			System.out.println("Enter userId of student");
			userId = Long.parseLong(buff.readLine());
			
			System.out.println("Enter testId to assign");
			testId = Long.parseLong(buff.readLine());
	
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		User current_user=DatabaseDao.hm1.get(userId);
		
		Test current_test = DatabaseDao.thm.get(testId);
		
		current_user.setUserTest(DatabaseDao.thm.get(testId));
		
		System.out.println(current_test.getTestTitle()+" successfully assigned to student "+current_user.getUserName());
		
		obj.userOrAdmin(obj);
//		current_user.getUserTest().getTestQuestions().forEach((question)->{
//		 Questions current_question=question.getValue();
//		 System.out.println(current_question);
//		System.out.println(current_question.questionTitle);
//		for(String option:current_question.questionOptions) {
//			System.out.println(option);	
//		}
//		int correct_answer=current_question.questionAnswer;
//		int user_choice=0;
//		try {
//			user_choice=Integer.parseInt(buff.readLine());
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		if(user_choice==correct_answer) {
//			current_user.setMarks_scored(current_user.getMarks_scored()+current_question.questionMarks);
//		}
//		else {
//			current_user.setMarks_scored(current_user.getMarks_scored());
//		}
//		
//		System.out.println(current_user.getMarks_scored());
//		
//		
//	});
	//	Database.hm1.get(userId).setUserTest(Database.thm.get(testId));
		
		
	}
	
	
//ADMIN -> ADD A NEW TEST IN DATABASE
	public void addTest(Operations obj) {
		
		long testId=0L;
		String testTitle="";
		
		try {
//			System.out.println("Enter Test ID: ");
//			testId = Long.parseLong(buff.readLine()+"L");
			System.out.println("Enter Test Title: ");
			testTitle = buff.readLine();
			
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Set<Entry<Long, Questions>> mSet = DatabaseDao.qhm.entrySet();
		Double testTotalMarks = 25.0D;
		Test tt = new Test(testTitle, LocalTime.now(), mSet, testTotalMarks, -1.0D);
		
		Long key = null;
		Set set = DatabaseDao.thm.keySet();
		Iterator i = set.iterator();
		while(i.hasNext()) {
			key = (Long) i.next();
		}
		
		DatabaseDao.thm.put(key+1, tt);
		obj.userOrAdmin(obj);
		
	}
	
//ADMIN -> UPDATE TEST IN DATABASE
	public void updateTest() {
		
	}
	
//ADMIN -> DELETE TEST FROM DATABASE
	public void deleteTest() {
		
	}
	
	
//STUDENT -> GIVE TEST
	public void giveTest(Operations obj,String username) {
		System.out.println("hello");
		Object key = null;
		
		Set set = DatabaseDao.hm1.keySet();
		Iterator i = set.iterator();
		
		
		while(i.hasNext()) {
			
			key=i.next();
			
			if(DatabaseDao.hm1.get(key).getUserName().equals(username)) {
				break;
			}
		}
		
		final User current_user = DatabaseDao.hm1.get(key);
		
		System.out.println("Welcome to the test portal " +username);
	
		if(DatabaseDao.hm1.get(key).getUserTest()==null) {
			
			System.out.println("Sorry, you do not have any tests assigned. Please contact your admin.");
			
			obj.userTask(obj, username);
		
		}
		
		else {
			
			System.out.println("Welcome to the Test ");
			current_user.getUserTest().getTestQuestions().forEach((question) -> {
				
				Questions current_question = question.getValue();
				
				System.out.println(current_question);
				
				System.out.println(current_question.getQuestionTitle());
				
				System.out.println("Choose correct option: ");
				
				for(String options:current_question.getQuestionOptions()) {
					System.out.println(options);
				}
				
				int user_choice=0;
				
				try {
					user_choice = Integer.parseInt(buff.readLine());
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				if(user_choice==current_question.getQuestionAnswer()) {
					current_user.getUserTest().setTestMarksScored(current_user.getUserTest().getTestMarksScored()
												+current_question.getQuestionMarks());
				}
				else {
					current_user.getUserTest().setTestMarksScored(current_user.getUserTest().getTestMarksScored());
				}
				
			});
		}
		
		System.out.println("Please login again to view your result.");
		
		obj.userTask(obj, username);
	}
	
	
	
	public void addQuestion(Operations obj){
		
		System.out.println("Choose a test to add a question to: ");
		Set set  = DatabaseDao.thm.keySet();
		Iterator i = set.iterator();
		
		Object key=null;
		int j=1;
		while(i.hasNext()) {
			key = i.next();
			System.out.println(j+") "+DatabaseDao.thm.get(key).getTestTitle());
			j++;
		}
		
		Long currentTest=0L;
		try {
			currentTest = Long.parseLong(buff.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Object key2=null;
		Set set2 = DatabaseDao.thm.keySet();
		Iterator i2 = set2.iterator();
		while(i.hasNext()) {
			key = i.next();
			if(DatabaseDao.thm.get(key2).toString()==currentTest.toString()) {
				break;
			}
		}
		
		
		String questionTitle = null;
		String[] questionOptions = new String[4];
		int questionAnswer = 0;
		double questionMarks = 0;
		int testChoice=0;
		
		try {
			
			System.out.println("Enter Question Title: ");
			questionTitle = buff.readLine();
		
			System.out.println("Enter Question options: ");
			
			for(int j1=0;j1<4;j1++) {
				questionOptions[j1]=buff.readLine();
			}
			
			System.out.println("Enter correct choice: ");
			questionAnswer = Integer.parseInt(buff.readLine());
			
			System.out.println("Enter question marks: ");
			questionMarks = Double.parseDouble(buff.readLine());
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Set<Long> set3 = DatabaseDao.qhm.keySet();
		Iterator<Long> i3 = set3.iterator();
	
		Long key3=null;
		//FIND LAST KEY OF QUESTION
		while(i3.hasNext()) {
			key3 = Long.parseLong(i3.next().toString());
		}
		
		
		Questions qq = new Questions(questionTitle , questionOptions, questionAnswer, questionMarks);
		DatabaseDao.qhm.put(key3+1, qq);
		
		String testTitle = DatabaseDao.thm.get(currentTest).getTestTitle();
		Set qSet = DatabaseDao.qhm.entrySet();
		double testTotalMarks = DatabaseDao.thm.get(currentTest).getTestTotalMarks()+DatabaseDao.qhm.get(key3).getQuestionMarks();
		
		Test tt = new Test(testTitle, LocalTime.now(), qSet, testTotalMarks, -1.0D);
		obj.userOrAdmin(obj);
		
	}
	
	public void updateQuestion() {
		
	}
	
	public void deleteQuestion() {
		
	}
	
	
	
	public void getResult(Operations obj,String username) throws MyException {
		
		Object key = null;
		
		Set set = DatabaseDao.hm1.keySet();
		Iterator i = set.iterator();
		
		
		while(i.hasNext()) {
			
			key=i.next();
			
			if(DatabaseDao.hm1.get(key).getUserName().equals(username)) {
				break;
			}
		}
		
		User current_user = DatabaseDao.hm1.get(key);
		
		if(current_user.getUserTest().getTestMarksScored()==-1.0D) {
			throw new MyException("You have not given any test.");
		}
		else {
			System.out.println("Marks scored in: "+current_user.getUserTest().getTestTitle()+ 
								" = "+(current_user.getUserTest().getTestMarksScored()+1) );
		}
		
		
	}

	
	
	
	public void calculateTotalMarks(Operations obj) {
		
	}

	
	
	
	
	
	
	
	public void printHashmap(DatabaseDao database) {
		
		
		Set<Test> set = DatabaseDao.thm2.keySet();
		Iterator<Test> i = set.iterator();
		while(i.hasNext()) {
			Object key = i.next();
			HashMap<Long,Questions> hmm = DatabaseDao.thm2.get(key);
			Set set2 = hmm.keySet();
			Iterator i2 = set2.iterator();
			while(i2.hasNext()) {
				Object key2 = i2.next();
				System.out.println(hmm.get(key2).getQuestionTitle());
			}
		}
	}

}
