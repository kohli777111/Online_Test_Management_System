package com.cpg.onlinetestmanagement.bean;

import java.math.*;
import java.util.Arrays;

public class Questions {
	
	private Long questionId;
	private String[] questionOptions;
	private String questionTitle;
	private int questionAnswer;
	private Double questionMarks;
	private int chosenAnswer;
	private Double marksStored;
	
	
//	
//	@Override
//	public String toString() {
//		return "Questions [questionId=" + questionId + ", questionOptions=" + Arrays.toString(questionOptions)
//				+ ", questionTitle=" + questionTitle + ", questionAnswer=" + questionAnswer + ", questionMarks="
//				+ questionMarks + ", chosenAnswer=" + chosenAnswer + ", marksStored=" + marksStored + "]";
//	}



	public Questions(String questionTitle,String[] questionOptions, int questionAnswer,
			Double questionMarks) {

		this.questionId = questionId;
		this.questionOptions = questionOptions;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.chosenAnswer = chosenAnswer;
		this.marksStored = marksStored;
	}



	public Long getQuestionId() {
		return questionId;
	}



	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}



	public String[] getQuestionOptions() {
		return questionOptions;
	}



	public void setQuestionOptions(String[] questionOptions) {
		this.questionOptions = questionOptions;
	}



	public String getQuestionTitle() {
		return questionTitle;
	}



	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}



	public int getQuestionAnswer() {
		return questionAnswer;
	}



	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}



	public Double getQuestionMarks() {
		return questionMarks;
	}



	public void setQuestionMarks(Double questionMarks) {
		this.questionMarks = questionMarks;
	}



	public int getChosenAnswer() {
		return chosenAnswer;
	}



	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}



	public Double getMarksStored() {
		return marksStored;
	}



	public void setMarksStored(Double marksStored) {
		this.marksStored = marksStored;
	}

	
}

