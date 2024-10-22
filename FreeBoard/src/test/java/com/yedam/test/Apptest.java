package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class Apptest {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
				
		ReplyVO rep = new ReplyVO();
		rep.setReply("댓글테스트");
		rep.setReplyer("user1");
		rep.setBoardNo(121);
		
	
		
		ReplyService svc = new ReplyServiceImpl();
//		svc.addReply(rep);
//		svc.removeReply(1);
		System.out.println(svc.getReply(2).toString());
		System.out.println();
		
		List<ReplyVO> list = svc.replyList(121);
		for(ReplyVO li : list) {
			System.out.println(li.toString());
		}
		
	}
}
