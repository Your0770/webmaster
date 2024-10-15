package 최시훈;

public class Account {
	//field
	private String ano;
	private String owner;
	private int balance;
	final static int MIN_BALANCE = 0;
	final static int MAX_BALANCE = 1000000;
	
	//constructor
	Account(){}
	
	Account(String ano, String owner, int balance){
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}

	//method
	public String getAno() {
		return ano;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//예금 메소드
	public void inMoney(int balance, int inMoney) {
		if(balance + inMoney <= MAX_BALANCE) {
			this.balance = balance + inMoney;
			System.out.println("현재 잔액: " + this.balance);
		} else {
			this.balance = balance;
			System.out.println("더 이상 예금할수 없어 예금액을 반환합니다.");
			System.out.println("반환액: " + inMoney);
			System.out.println("현재 잔액: " + this.balance);
		}
	}
	
	//출금 메소드
	public void outMoney(int balance, int outMoney) {
		if(balance - outMoney >= MIN_BALANCE) {
			this.balance = balance - outMoney;
			System.out.println("현재 잔액: " + this.balance);
		} else {
			this.balance = balance;
			System.out.println("잔액이 부족하여 출금할 수 없습니다.");
			System.out.println("현재 잔액: " + this.balance);
		}
	}
	
	
}
