package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParkeringTest {
	
	Parkering ref1; 
	Spiller player1;

	@Before
	public void setUp() throws Exception {
		ref1 = new Parkering("Parkering", 500); 
		player1 = new Spiller("Player1"); 
	}

	@Test
	public void testLandOnField() {
		ref1.landOnField(player1);
		assertEquals(35000, player1.getAccount().getBalance());

	}
}
