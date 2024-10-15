package chap13;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {

	public List<Board> getBoardList() {
		List<Board> bd = new ArrayList<>();
		bd.add(new Board("제목1", "내용1", "작가1"));
		bd.add(new Board("제목2", "내용2", "작가2"));
		bd.add(new Board("제목3", "내용3", "작가3"));
		return bd;
	}

}
