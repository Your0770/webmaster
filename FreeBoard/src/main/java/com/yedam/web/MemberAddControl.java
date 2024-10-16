package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberAddControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MemberAddControl");
		String id = req.getParameter("mid");
		String name = req.getParameter("mname");
		String pw = req.getParameter("pwd");
		String tel = req.getParameter("phone");

		MemberVO mvo = new MemberVO();
		mvo.setMemberId(id);
		mvo.setMemberName(name);
		mvo.setPassword(pw);
		mvo.setPhone(tel);

		MemberService svc = new MemberServiceImpl();
		try {
			svc.addMember(mvo);
			// 목록페이지로 이동
			resp.sendRedirect("memberList.do");  //url 바뀜
		} catch (Exception e) {
			// 등록화면으로 이동
			e.printStackTrace();
			resp.sendRedirect("memberAddForm.do");  //url 바뀜
//			req.getRequestDispatcher("memberAddForm.do").forward(req, resp);  //url은 안바뀌고 값이 추가됨
		}
	}

}
