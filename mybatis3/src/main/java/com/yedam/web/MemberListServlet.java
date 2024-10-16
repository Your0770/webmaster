package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

/**
 * Servlet implementation class MemberListServlet
 */
//IOC (제어의 역전)
//객체 생성 -> init() -> service() -> destroy() : 서블릿의 생명주기
@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		List<Member> result = dao.members();
		/*
		for(Member member : result) {
			out.print(member.toString());
			out.print("<br>");
		}
		*/
		
		out.print("<table width=500px height=300px style='border-collapse:collapse' border = 1px solid black>");
		out.print("<thead><tr>");
		out.print("<th>아이디</th>");
		out.print("<th>비밀번호</th>");
		out.print("<th>이름</th>");
		out.print("<th>연락처</th>");
		out.print("</tr></thead><tbody>");
		for(Member member : result) {
			out.print("<tr>");
			out.print("<td><a href='member.action?mid=" + member.getMemberId() + "'>" + member.getMemberId() +  "</a></td>");
			out.print("<td>" + member.getPassword() +  "</td>");
			out.print("<td>" + member.getMemberName() +  "</td>");
			out.print("<td>" + member.getPhone() +  "</td>");
			out.print("</tr>");
		}
		out.print("</tbody></table>");
		out.print("<a href='./'>첫페이지</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
