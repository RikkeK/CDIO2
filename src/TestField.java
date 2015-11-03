import static org.junit.Assert.*;

import org.junit.Test;

public class TestField {

	Player player1 = new Player ("Player1");
	Field field1 = new Field ("Tower","Land on Tower",200,false);
	Field field2 = new Field ("Tower","Land on Tower",-200,false);
	Field field3 = new Field ("The Dead","Land on The Dead",-1100,false);
	Field field4 = new Field ("","",-100,true);
	
	@Test
	public void testAddPoints() {
		field1.land(player1);
		assertEquals(1200, player1.getBalance());
	}
	
	@Test
	public void testSubtractPoints() {
		field2.land(player1);
		assertEquals(800, player1.getBalance());
	}
	
	@Test
	public void testCantGetUnderZeroPoints() {
		field3.land(player1);
		assertEquals(1000, player1.getBalance());
	}
	
	@Test
	public void testGetsExtraTurn() {
		assertEquals(true, field4.getIsExtraTurn());
	}
	
	
	
	

}
