package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class Apptest {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		SearchDTO search = new SearchDTO();
		search.setKeyword("1111");
		search.setSearchCondition("T");
		search.setPage(2);
		
		List<BoardVO> list = mapper.listWithPage(search);
		for(BoardVO bvo : list) {
			System.out.println(bvo.toString());
		}
		
	}
}
