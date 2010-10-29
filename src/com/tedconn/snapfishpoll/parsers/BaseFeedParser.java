package com.tedconn.snapfishpoll.parsers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


public abstract class BaseFeedParser implements FeedParser 
{
	static final String POLL = "Poll";
	static final String QUESTION = "Question";
	static final String ANSWER = "Answer";
	static final String ANSWERS = "Answers";
	
	private final URI feedURL;
	
	protected BaseFeedParser(String feedURL)
	{
		try {
			this.feedURL = new URI(feedURL);
		} catch (URISyntaxException e){
			throw new RuntimeException(e);
		}
	}
	
	protected String getXMLString()
	{
		try{
			HttpClient httpClient = new DefaultHttpClient();
	    	HttpPost httppost = new HttpPost(feedURL);
	    	
	    	/*List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	    	nameValuePairs.add(new BasicNameValuePair("poll_id","favoriteLanguage"));
	    	httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));*/
	    	
	    	ResponseHandler<String> responseHandler = new BasicResponseHandler();
	    	String responseBody = httpClient.execute(httppost,responseHandler);
	    	return responseBody;
	    	
		} catch (IOException e){
			throw new RuntimeException(e);
		}
	}

}
