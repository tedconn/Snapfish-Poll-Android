package com.tedconn.snapfishpoll;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tedconn.snapfishpoll.parsers.FeedParser;
import com.tedconn.snapfishpoll.parsers.FeedParserFactory;
import com.tedconn.snapfishpoll.parsers.ParserType;
import com.tedconn.snapfishpoll.vo.PollVO;

public class PollList extends ListActivity {
	
	private String LOG_TAG = "PollList";
	private List<PollVO> polls;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        loadFeed(ParserType.POLL_LIST);
    }
    
	/*@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item)
	{
		super.onMenuItemSelected(featureId, item);
		return true;
	}*/
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id)
	{
		super.onListItemClick(l, v, position, id);
		Intent viewPoll = new Intent(this, Poll.class);
		this.startActivity(viewPoll);
	}
	
    private void loadFeed(ParserType type)
    {
    	try{
    		FeedParser parser = FeedParserFactory.getParser(type);
    		long start = System.currentTimeMillis();
    		polls = parser.parse();
    		long duration = System.currentTimeMillis() - start;
    		Log.i(LOG_TAG, "Parser duration: " + duration);
    		String xml = writeXML();
    		Log.i(LOG_TAG, xml);
    		List<String> pollQuestions = new ArrayList<String>(polls.size());
    		int index = 0; 
    		for(PollVO poll : polls)
    		{
    			index++;
    			pollQuestions.add(index + ". " + poll.getQuestion());
    		}
    		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row, pollQuestions);
    		this.setListAdapter(adapter);
    	} catch(Throwable t){
    		Log.e(LOG_TAG,t.getMessage(),t);
    	}
    }
    
    private String writeXML()
    {
    	return "";
    }
}