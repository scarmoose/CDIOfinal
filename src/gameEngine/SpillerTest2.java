package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SpillerTest2 {
	
	Spiller player1;
	Rederi fleet1;
	Rederi fleet2;

	

	@Before
	public void setup() throws Exception{
		player1 = new Spiller("PlayerOne");
		fleet1 = new Rederi("fleet1", 4000);
		fleet2 = new Rederi("fleet2", 4000);
	}
	
	@Test 
	public void testPlayer() {	
		assertEquals(player1.getName(),"PlayerOne");
	}

	@Test
	public void testSetName() {
		System.out.println("ostemad");
		player1.setName("TestName");
		assertEquals(player1.getName(),"TestName");
	}
	
	@Test
	public void testGetName() {
		assertEquals(player1.getName(),"PlayerOne");
	}

	@Test 
	public void testToString() {
		System.out.println(player1.toString());
		assertTrue(player1.toString().contains("30000"));
	}
	
	@Test
	public void testPlayerPosition() {
		player1.setCurrentPos(10); //sets 10-1, to fit in the field array
		int actual = player1.getCurrentPos();
		int expected = 9;
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testBreweriesOwned() {
		player1.incrementBreweriesOwned();
		player1.incrementBreweriesOwned();
		player1.incrementBreweriesOwned();
		int actual = player1.getBreweriesOwned();
		int expected = 3;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBuyFleet() {
		fleet1.buyProperty(player1);
		fleet2.buyProperty(player1);
		int actual = player1.getFleetsOwned();
		int expected = 2;
		assertEquals(expected, actual);
		int actualBalance = player1.getAccount().getBalance();
		int expectedBalance = 22000;
		assertEquals(expectedBalance, actualBalance);
		
	}
	
	


}
