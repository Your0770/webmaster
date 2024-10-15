package chap13;

public class Student {
	
	public int stNum;
	public String name;
	
	public Student(int stNum, String name) {
		this.stNum = stNum;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return stNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student) obj;
			return (std.stNum == stNum); //&&(std.name.equals(name)) ;
		}else {
			return false;
		}
	}
}
