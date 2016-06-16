package myGit;

public class Button implements Clickable {

	DoorBell doorbell;
	
	@Override
	public void click() {
		doorbell.ring();
	}
	
	public void doubleClick() {
		doorbell.ring();
		doorbell.ring();
		doorbell.ring();
		doorbell.ring();

	}

}
