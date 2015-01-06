package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RefugeTest {
	
	Refuge ref1; 
	Player player1;

	@Before
	public void setUp() throws Exception {
		ref1 = new Refuge("Walled City", 5, 5000); //fieldNumber set to 5
		player1 = new Player("PlayerOne"); //contructs player with balance = 30000
	}

	@Test
	public void testLandOnField() {
		ref1.landOnField(player1);
		assertEquals(35000, player1.getAccount().getBalance());
		
	}
}
