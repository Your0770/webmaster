package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.vo.EventVO;


public interface EventMapper {
	List<EventVO> selectAll();
	int insertEvent(EventVO event);
	int deleteEvent(EventVO event);
	EventVO selectEvent(EventVO envent);
	List<Map<String, Object>> selectMap();
	
}
