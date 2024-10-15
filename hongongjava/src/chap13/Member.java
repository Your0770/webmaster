package chap13;

public class Member {
	//field
	public String name;
	public int age;
	
	//constructor
	public Member(String name, int age) {
		this.name = name;
		this.age = age; 
	}
	
	//method
//	/*
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return (member.name.equals(name)) && (member.age ==age);
		} else {
			return false;
		}
	}
//	/*
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
//	*/
	
	
	
}
