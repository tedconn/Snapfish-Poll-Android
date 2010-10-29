package com.tedconn.snapfishpoll.parsers;

import java.util.List;

import com.tedconn.snapfishpoll.vo.PollVO;

public interface FeedParser 
{
	List<PollVO> parse();
}
