package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

//import com.yedam.dao.MemberDAO;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;
public class AppTest {

	public static void main(String[] args) {
//		MemberDAO dao = new MemberDAO();
//		List<Member> result = dao.memberList();
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		Member mbr = new Member();
		mbr.setMemberId("test99");
		mbr.setMemberName("연습9999");
		mbr.setPassword("9999");
		mbr.setPhone("010-9999-9999");
		
		
//		if(dao.insertMember(mbr) == 1) {
//			sqlSession.commit();
//		}
		
//		if(dao.updateMember(mbr) == 1) {
//			sqlSession.commit();
//		}
		
		if(dao.deleteMember(mbr.getMemberId()) == 1) {
			sqlSession.commit();
		}
		
		List<Member> result = dao.members();
		for(Member member : result) {
			System.out.println(member.toString());
		}
		

	}//main

}
