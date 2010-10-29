package com.tedconn.snapfishpoll.parsers;

import java.util.ArrayList;
import java.util.List;

import com.tedconn.snapfishpoll.vo.AnswerVO;
import com.tedconn.snapfishpoll.vo.PollVO;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.util.Log;
import android.util.Xml;

public class PollListParser extends BaseFeedParser {

	static final String POLL_LIST = "PollList";
	
	public PollListParser(String feedURL)
	{
		super(feedURL);
	}
	
	@Override
	public List<PollVO> parse() 
	{
		final PollVO currentPoll = new PollVO();
		RootElement root = new RootElement(POLL_LIST);
		final List<PollVO> polls = new ArrayList<PollVO>();
		final List<AnswerVO> finalAnswers = new ArrayList<AnswerVO>();
		Element poll = root.getChild(POLL);
		
		poll.setEndElementListener(new EndElementListener() {			
			public void end() {
				polls.add(currentPoll.copy());
			}
		});
		poll.getChild(QUESTION).setEndTextElementListener(new EndTextElementListener() {
			public void end(String q) {
				Log.d("PollList", q);
				currentPoll.setQuestion(q);
			}
		});
		
		/*answers.getChild(ANSWER).setEndTextElementListener(new EndTextElementListener() {
			public void end(String a) {
				AnswerVO tempAnswer = new AnswerVO();
				tempAnswer.setAnswer(a);
				finalAnswers.add(tempAnswer);
				currentPoll.setAnswers(finalAnswers);
			}
		});*/
		
		try{
			Xml.parse(this.getXMLString(), root.getContentHandler());
		} catch(Exception e){
			throw new RuntimeException(e);
		}
		return polls;
	}

}
