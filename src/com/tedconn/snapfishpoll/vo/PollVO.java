package com.tedconn.snapfishpoll.vo;

import java.util.List;

public class PollVO 
{
	private String question;
	private List<AnswerVO> answers;
	
	public String getQuestion()
	{
		return question;
	}
	
	public void setQuestion(String q)
	{
		question = q;
	}
	
	public List<AnswerVO> getAnswers()
	{
		return answers;
	}
	
	public void setAnswers(List<AnswerVO> a)
	{
		answers = a;
	}
	
	public PollVO copy(){
		PollVO copy = new PollVO();
		copy.question = question;
		copy.answers = answers;
		return copy;
	}
}
