package chap13;

public class Board {
	//field
	String subject;
	String content;
	String writer;
	
	//constructor
	public Board(String subject, String content, String writer) {
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
	
	
	//method
	@Override
	public String toString() {
		return subject + " : " + content + " : " + writer;
	}


	public String getSubject() {
		return subject;
	}


	public String getContent() {
		return content;
	}


	public String getWriter() {
		return writer;
	}
	
}
