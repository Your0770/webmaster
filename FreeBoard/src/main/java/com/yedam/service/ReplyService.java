package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int boardNo, int page);

	boolean addReply(ReplyVO reply);

	boolean removeReply(int replyNo);

	ReplyVO getReply(int replyNo);
	
	int replyCount(int baoardNo);
}
