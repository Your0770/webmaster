package com.yedam.control.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.EventService;
import com.yedam.service.EventServiceImpl;
import com.yedam.vo.EventVO;

public class selectEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 
		String title = req.getParameter("title");
		String startDate = req.getParameter("start");
		String endDate = req.getParameter("end");
		if(startDate.length() > 19) startDate = startDate.substring(0, 19);
		if(endDate.length() > 19) endDate = endDate.substring(0, 19);

		EventVO event = new EventVO();
		event.setTitle(title);
		event.setStartDate(startDate);
		event.setEndDate(endDate);

		EventService svc = new EventServiceImpl();
		EventVO result = svc.selectEvent(event);
		

	}

}
