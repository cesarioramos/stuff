package myGit;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class DiscoverMockito {

	@Test
	public void basicMockito() {
		// mock creation 
		List mockedList = mock(List.class);
		// using mock object - it does not throw any "unexpected interaction" exception
		mockedList.add("one");
		mockedList.clear();
		// selective, explicit, highly readable verification
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}
	
	@Test
	public void bellShouldRing() {
		DoorBell mockedBel = mock(DoorBell.class);
		Button button = new Button();
		
		button.doorbell = mockedBel;
		
		button.click();
		
		verify(mockedBel).ring();
	}
	
	@Test
	public void crappyTest() {
		
	}
	
	@Test
	public void argumentShouldMatch() {
		LinkedList mockedList = mock(LinkedList.class);
		
		when(mockedList.add("Apple")).thenReturn(true);
		
		mockedList.add("Apple");
		
		verify(mockedList).add("Apple");
	
	}
}
