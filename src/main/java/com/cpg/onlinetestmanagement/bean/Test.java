package com.cpg.onlinetestmanagement.bean;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import java.util.Map.Entry;

public class Test {
	
	Long testId;
	String testTitle;
	LocalTime testDuration;
	Set<Entry<Long,Questions>> testQuestions;
	Double testTotalMarks;
	Double testMarksStored;
	Questions currentQuestion;
	LocalDateTime startTime;
	LocalDateTime endTime;
	
	
	
	
	public Test(String testTitle, LocalTime testDuration, Set<Entry<Long, Questions>>  testQuestions,
			Double testTotalMarks,double testMarksStored) {
		
	//	this.testId = testId;
		//setTestId(test_id);
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.testQuestions = testQuestions;
		this.testTotalMarks = testTotalMarks;
		this.testMarksStored = testMarksStored;
		this.currentQuestion = currentQuestion;
		this.startTime = startTime;
		this.endTime = endTime;
	}




	public Long getTestId() {
		return testId;
	}




	public void setTestId(Long testId) {
		this.testId = testId;
	}




	public String getTestTitle() {
		return testTitle;
	}




	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}




	public LocalTime getTestDuration() {
		return testDuration;
	}




	public void setTestDuration(LocalTime testDuration) {
		this.testDuration = testDuration;
	}




	public Set<Entry<Long, Questions>> getTestQuestions() {
		return testQuestions;
	}




	public void setTestQuestions(Set<Entry<Long, Questions>> testQuestions) {
		this.testQuestions = testQuestions;
	}




	public Double getTestTotalMarks() {
		return testTotalMarks;
	}




	public void setTestTotalMarks(Double testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}




	public Double getTestMarksScored() {
		return testMarksStored;
	}




	public void setTestMarksScored(Double testMarksScored) {
		this.testMarksStored = testMarksScored;
	}




	public Questions getCurrentQuestion() {
		return currentQuestion;
	}




	public void setCurrentQuestion(Questions currentQuestion) {
		this.currentQuestion = currentQuestion;
	}




	public LocalDateTime getStartTime() {
		return startTime;
	}




	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}




	public LocalDateTime getEndTime() {
		return endTime;
	}




	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
}
