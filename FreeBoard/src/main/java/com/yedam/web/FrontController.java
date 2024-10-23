package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.control.javascriptControl;
import com.yedam.control.board.AddBoardControl;
import com.yedam.control.board.AddBoardForm;
import com.yedam.control.board.BoardControl;
import com.yedam.control.board.BoardListControl;
import com.yedam.control.board.ModifyBoardControl;
import com.yedam.control.board.RemoveBoardControl;
import com.yedam.control.member.AddMemberControl;
import com.yedam.control.member.LoginControl;
import com.yedam.control.member.LogoutControl;
import com.yedam.control.member.MemberAddControl;
import com.yedam.control.member.MemberAddFormControl;
import com.yedam.control.member.MemberJsonControl;
import com.yedam.control.member.MemberListControl;
import com.yedam.control.member.RemoveMemberControl;
import com.yedam.control.reply.AddReplyControl;
import com.yedam.control.reply.RemoveReplyControl;
import com.yedam.control.reply.ReplyCountControl;
import com.yedam.control.reply.ReplyListControl;

//@WebServlet("*.do")
public class FrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Map<String, Control> map;
	
	public FrontController() {
//		System.out.println("객체 생성");
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
//		System.out.println("init 호출");
		map.put("/memberList.do", new MemberListControl());
		// 회원등록 1)등록화면 2)등록처리 
		map.put("/memberAddForm.do", new MemberAddFormControl());
		map.put("/memberAdd.do", new MemberAddControl());
		
		map.put("/boardList.do", new BoardListControl());
		map.put("/board.do", new BoardControl());
		// 글등록 (등록화면 -> 화면처리)
		map.put("/addBoardForm.do", new AddBoardForm());
		map.put("/addBoard.do", new AddBoardControl());
		// 글수정 (수정화면 -> 변경처리)
		map.put("/modifyBoard.do", new ModifyBoardControl());
		map.put("/removeBoard.do", new RemoveBoardControl());
		map.put("/loginForm.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		map.put("/javascript.do", new javascriptControl());
		
		//json 관련
		map.put("/memberJson.do", new MemberJsonControl());
		map.put("/addMemberJson.do", new AddMemberControl());
		map.put("/removeMemberJson.do", new RemoveMemberControl());
		
		//댓글
		map.put("/replyList.do", new ReplyListControl());
		map.put("/removeReply.do", new RemoveReplyControl());
		map.put("/addReply.do", new AddReplyControl());
		map.put("/replyCount.do", new ReplyCountControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("service 호출");
		//요청페이지?
		String uri = req.getRequestURI();        //        /FreeBoard/123.do
		String context = req.getContextPath();   //        /FreeBoard        (프로젝트 이름)
		String page = uri.substring(context.length()); //  /123.do
		
		Control control = map.get(page);
		if(control == null) {
			resp.getWriter().print("page error 500");
			return;
		}
		control.exec(req, resp);
		
	}
}
