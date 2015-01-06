package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaxTest {

	Player playerTestLand;
	Tax caravan;
	Tax goldmine;
	
	@Before
	public void setUp() throws Exception {
		playerTestLand = new Player("test1");
		caravan = new Tax("Caravan", 2, 4000, 10);
		goldmine = new Tax("Goldmine", 3, 2000, 0);
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
