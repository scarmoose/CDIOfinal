package gameEngine;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class TerritoryTest {
	
	Player owner;
	Player lander;
	Territory territory;
	
	@Before
	public void setup(){
		owner = new Player("owner");
		lander = new Player("lander");
		territory = new Territory("Tribal Encampment",1,1000,100);
	}
	
	/*
	 * Test of the  rent required when a player lands on a field.
	 * In this case the rent of field 1 (Tribal Encampment) is 100 points. 
	 */
	@Test
	public void testTerritory(){
		assertEquals(territory.getRent(),100);
	
	}
	
	/*
	 * This test is able to check if landOnField() deposits and withdraws as implemented in the code.
	 */
	
	@Test
	public void testLandOnField() {
		territory.buyProperty(owner);
		int ownerActual1 = owner.getAccount().getBalance();
		int ownerExpected1 = 29000;
		assertEquals(ownerExpected1, ownerActual1);
		territory.landOnField(lander);
		int ownerActual2 = owner.getAccount().getBalance();
		int ownerExpected2 = 29100;
		assertEquals(ownerExpected2, ownerActual2);
		int landerActual = lander.getAccount().getBalance();
		int landerExpected = 29900;
		assertEquals(landerExpected, landerActual);
	} 
	
	@Test //pop up message saying insufficient funds will appear
	public void testBuyPropertyInsufficientFunds() {
		owner.getAccount().setBalance(500);
		territory.buyProperty(owner);
		int expected = 500;
		int actual = owner.getAccount().getBalance();
		assertEquals(expected, actual);
				
	}
	
	@Test //will ask whether lander wants to buy the field
	public void landOnFreeField() {
		territory.landOnField(lander);
	} 
	
	
	


}

