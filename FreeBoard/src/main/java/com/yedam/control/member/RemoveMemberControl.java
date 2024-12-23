package com.yedam.control.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class RemoveMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// id 만 넘어옴
		String id = req.getParameter("id");
		MemberService svc = new MemberServiceImpl();
		if(svc.retireMember(id)) {
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		} else {
			resp.getWriter().print("{\"retCode\": \"FAIL\"}");
		}

	}

}
