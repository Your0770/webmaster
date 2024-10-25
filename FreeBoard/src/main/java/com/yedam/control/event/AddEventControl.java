package com.yedam.control.event;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.EventService;
import com.yedam.service.EventServiceImpl;
import com.yedam.vo.EventVO;

public class AddEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// parameter 3개 event
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
		
		Map<String, Object> result = new HashMap<>();
		try {
			// {retCode:OK, retVal:event}
			svc.insertEvent(event);
			result.put("retCode", "OK");
			result.put("retVal", event);
		}catch(Exception e) {
			e.printStackTrace();
			
			result.put("retCode", "FAIL");
			result.put("retVal", event);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		resp.getWriter().print(gson.toJson(result));

	}

}
