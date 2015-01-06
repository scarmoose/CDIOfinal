package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SkatTest {

	Spiller playerTestLand;
	Skat caravan;
	Skat goldmine;
	
	@Before
	public void setUp() throws Exception {
		playerTestLand = new Spiller("test1");
		caravan = new Skat("Caravan", 2, 4000, 10);
		goldmine = new Skat("Goldmine", 3, 2000, 0);
	}
	
	@Test
	public void test10percentLandOnField() {
		//playerTestLand.getAccount().setBalance(30000);
		caravan.landOnField(playerTestLand);
		System.out.println(playerTestLand.getAccount().getBalance());
		assertEquals(playerTestLand.getAccount().getBalance(),27000);
	} 
	
	@Test
	public void test4000LandOnField() {
		caravan.landOnField(playerTestLand);
		System.out.println(playerTestLand.getAccount().getBalance());
		assertEquals(playerTestLand.getAccount().getBalance(), 26000);
	}
 
}
