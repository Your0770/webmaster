package chap06;

public class BoardMain {
	
	public static void main(String[] args) {
		
	Board board1 = new Board("제목1", "내용1");
	Board board2 = new Board("제목2", "내용2", "저자2");
	Board board3 = new Board("제목3", "내용3", "저자3", "2024-09-27");
	Board board4 = new Board("제목3", "내용3", "저자3", "2024-09-27", 777);
		
	System.out.printf("%s : %s : %s : %s : %d\n", board1.title, board1.content, board1.writer, board1.date, board1.hitcount);	
	System.out.printf("%s : %s : %s : %s : %d\n", board2.title, board2.content, board2.writer, board2.date, board2.hitcount);	
	System.out.printf("%s : %s : %s : %s : %d\n", board3.title, board3.content, board3.writer, board3.date, board3.hitcount);	
	System.out.printf("%s : %s : %s : %s : %d\n", board4.title, board4.content, board4.writer, board4.date, board4.hitcount);	
		
		
		
		
		
	}//main
}
