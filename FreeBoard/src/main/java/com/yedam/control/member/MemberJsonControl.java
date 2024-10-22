package com.yedam.control.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberJsonControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		// 회원 목록을 json 반환
		MemberService svc = new MemberServiceImpl();
		List<MemberVO> list = svc.memberList();
		
		// [{"memberId": "user01", "memberName": "사용자1", ...},
		//  {.............},
		//  {.............}]
		String json = "[";
		for(int i = 0 ; i < list.size(); i++) {
			json += "{\"memberId\":\"" + list.get(i).getMemberId() + "\", \"memberName\":\"" 
					+ list.get(i).getMemberName() + "\", \"phone\":\"" + list.get(i).getPhone() + "\"}";
			if(i != list.size()-1) {
				json += ",";
			}
			
		}
		json += "]";
		resp.getWriter().print(json);

	}

}
