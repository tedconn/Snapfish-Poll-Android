package com.tedconn.snapfishpoll.parsers;


public class FeedParserFactory 
{
	static String feedURL = "http://3.latest.snappypoll.appspot.com/snapfish_poll/";
	
	public static FeedParser getParser(){
		return getParser(ParserType.POLL_LIST);
	}
	
	public static FeedParser getParser(ParserType type)
	{
		switch(type)
		{
			case POLL_LIST:
				return new PollListParser(feedURL);
			default: return null;
		}
	}
}
