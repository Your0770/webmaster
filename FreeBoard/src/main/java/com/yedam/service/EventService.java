package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.EventVO;

public interface EventService {
	List<EventVO> eventList();
	boolean insertEvent(EventVO event);
	boolean deleteEvent(EventVO event);
	EventVO selectEvent(EventVO event);
	List<Map<String, Object>> eventListMap();
}
