package com.yedam.control.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;

public class LogoutControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//session 삭제
		HttpSession session = req.getSession();
		session.invalidate();
		
		req.getRequestDispatcher("WEB-INF/jsp/logForm.jsp").forward(req, resp);
	}

}
