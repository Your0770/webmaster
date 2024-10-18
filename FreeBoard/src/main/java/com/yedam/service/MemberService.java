package com.yedam.service;

import java.util.List;

import com.yedam.vo.MemberVO;

//업무 처리 로직
public interface MemberService {
	boolean addMember(MemberVO member);
	boolean retireMember(String memberId);
	
	//회원목록
	List<MemberVO> memberList();
	MemberVO loginCheck(String id, String pw);
}
