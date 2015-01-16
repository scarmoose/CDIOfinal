package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GadeTest {

	Spiller owner;
	Spiller lander;
	Gade gade;
	
	@Before
	public void setup(){
		owner = new Spiller("owner");
		lander = new Spiller("lander");
		gade = new Gade("Rødovrevej", 1200, 50, "blue", 1000);
	}
	
	/*
	 * Test of the  rent required when a player lands on a field.
	 * In this case the rent of field 1 (Tribal Encampment) is 100 points. 
	 */
	
	@Test
	public void testGade(){
		assertEquals(gade.getRent(),50);
	}
	
	/*
	 * This test is able to check if landOnField() deposits and withdraws as implemented in the code.
	 */
	
	@Test
	public void testLandOnField() {
		gade.buyProperty(owner);
		int ownerActual1 = owner.getAccount().getBalance();
		int ownerExpected1 = 28800;
		assertEquals(ownerExpected1, ownerActual1);
		gade.landOnField(lander);
		int ownerActual2 = owner.getAccount().getBalance();
		int ownerExpected2 = 28850;
		assertEquals(ownerExpected2, ownerActual2);
		gade.landOnField(owner);
		int landerActual = lander.getAccount().getBalance();
		int landerExpected = 29950;
		assertEquals(landerExpected, landerActual);
	} 
	
	@Test //pop up message saying insufficient funds will appear
	public void testBuyPropertyInsufficientFunds() {
		owner.getAccount().setBalance(500);
		gade.buyProperty(owner);
		int expected = 500;
		int actual = owner.getAccount().getBalance();
		assertEquals(expected, actual);
				
	}
	
	@Test //will ask whether lander wants to buy the field
	public void landOnFreeField() {
		gade.landOnField(lander);
	} 

}


