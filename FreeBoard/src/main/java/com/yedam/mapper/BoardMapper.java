package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> listWithPage(SearchDTO search);
	int insertBoard(BoardVO board);
	int updateBoard(BoardVO board);
	int deleteBoard(int boardNo);
	BoardVO selectBoard(int boardNo);
	int updateCount(int boardNo);
	int selectCount(SearchDTO search);
	
	//사용자별 게시글 작성 건수
	List<Map<String, Object>> countByWriter();	
}
