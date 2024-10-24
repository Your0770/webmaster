package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.EventMapper;
import com.yedam.vo.EventVO;

public class EventServiceImpl implements EventService{

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	EventMapper mapper = sqlSession.getMapper(EventMapper.class);
	
	@Override
	public List<EventVO> eventList() {
		return mapper.selectAll();
	}

	@Override
	public boolean insertEvent(EventVO event) {
		return mapper.insertEvent(event) == 1;
	}

	@Override
	public boolean deleteEvent(EventVO event) {
		return mapper.deleteEvent(event) == 1;
	}

	@Override
	public EventVO selectEvent(EventVO event) {
		return mapper.selectEvent(event);
	}
	
	@Override
	public List<Map<String, Object>> eventListMap() {
		return mapper.selectMap();
	}

}
