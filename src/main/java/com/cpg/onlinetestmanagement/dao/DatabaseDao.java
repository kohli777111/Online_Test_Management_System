package com.cpg.onlinetestmanagement.dao;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.cpg.onlinetestmanagement.bean.Questions;
import com.cpg.onlinetestmanagement.bean.Test;
import com.cpg.onlinetestmanagement.bean.User;

import java.util.Set;

public class DatabaseDao {
	
	public static  HashMap<Long,Questions> qhm = new HashMap<Long,Questions>();
	public static HashMap<Long,Test> thm = new HashMap<Long,Test>();
	public static HashMap<Test,HashMap<Long,Questions>> thm2 = new HashMap<Test, HashMap<Long,Questions>>();
	public static HashMap<Long,User> hm1 = new HashMap<Long,User>();
	
		
	public static void enterUser() {
		
		User u1 = new User("001", "001", true,null);
		User u2 = new User("userName002", "password002", true,null);
		User u3 = new User("userName003", "password003", false,null);
		User u4 = new User("userName004", "password004", false,null);
		User u5 = new User("userName005", "password005", false,null);
		User u6 = new User("userName006", "password006", false,null);
		User u7 = new User("userName007", "password007", false,null);
		User u8 = new User("userName008", "password008", false,null);
		User u9 = new User("userName009", "password009", false,null);
		
		hm1.put(1L, u1);
		hm1.put(2L, u2);
		hm1.put(3L, u3);
		hm1.put(4L, u4);
		hm1.put(5L, u5);
		hm1.put(6L, u6);
		hm1.put(7L, u7);
		hm1.put(8L, u8);
		hm1.put(9L, u9);
	}
	
	public static void enterQuestions() {
		
		Questions q1 = new Questions("Q1) Vehicle",new String[] {"1) Laptop","2) Pencil","3) Car","4) Table"}, 3 , 5.0d);
		Questions q2 = new Questions("Q2) Capital of India",new String[] {"1) Mumbai","2) New Delhi","3) Noida","4) Gurgaon"}, 2, 5.0d);
		Questions q3 = new Questions("Q3) Programming Language", new String[] {"1) JAVA","2) df","3) vvgg","4) lkas"}, 1, 5.0d);
		Questions q4 = new Questions("Q4) Not a laptop", new String[] {"1) HP","2) DELL","3) Lenovo","4) coke"}, 4, 5.0d);
		Questions q5 = new Questions("Q5) Apple Mobile", new String[] {"1) galaxy","2) vivo","3) iphone 11","4) oreo"}, 3, 5.0d);
		
		qhm.put(1l, q1);
		qhm.put(2l, q2);
		qhm.put(3l, q3);
		qhm.put(4l, q4);
		qhm.put(5l, q5);
	}
	
	public static void enterTest() {
		
		Set<Entry<Long, Questions>> mSet = qhm.entrySet();
		
		
		Test t1 = new Test("General Test", LocalTime.now(), mSet , 25.0d, -1.0D);
		Test t2 = new Test("Aptitude Test",LocalTime.now(),mSet, 25.0d, -1.0D);
		thm.put(1L, t1);
		thm.put(2L,t2);

		
//PUT QUESTIONS IN TEST 1`
		//thm2.put(t1, qhm);
	}
	
	
}
