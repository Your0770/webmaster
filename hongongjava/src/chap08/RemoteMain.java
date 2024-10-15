package chap08;

public class RemoteMain {

	public static void main(String[] args) {
		RemoteControl rc;
		
		rc = new Tv();
		rc.turnOn();
		rc.setVolume(50);
		rc.setVolume(-5);
		rc.setVolume(7);
		rc.turnOff();
		
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(50);
		rc.setVolume(-5);
		rc.setVolume(7);
		rc.turnOff();
		
	}

}
