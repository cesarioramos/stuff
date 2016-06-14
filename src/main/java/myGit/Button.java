package myGit;

public class Button implements Clickable {

	DoorBell doorbell;
	
	@Override
	public void click() {
		doorbell.ring();
	}

}
