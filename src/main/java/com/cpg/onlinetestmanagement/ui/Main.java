package com.cpg.onlinetestmanagement.ui;

import java.util.*;

import com.cpg.onlinetestmanagement.dao.*;
import com.cpg.onlinetestmanagement.service.Operations;
import com.cpg.onlinetestmanagement.*;


public class Main {

	
	public static void main(String[] args) {
		
		Operations obj = new Operations();

		DatabaseDao.enterUser();
	
		DatabaseDao.enterQuestions();
		
		DatabaseDao.enterTest();
		
		
		obj.userOrAdmin(obj);
		
	}
	
}
