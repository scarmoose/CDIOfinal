package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestsPlayer {
	Player testPlay;
	@Before
	public void setup() throws Exception{
	testPlay = new Player("PlayerOne");
	}
	
	@Test //Checking if the contruct is properly made with the correct name.
	public void testPlayer() {
		
		assertEquals(testPlay.getName(),"PlayerOne");
	}

	@Test //checks and sees if the name has been changed
	public void testSetName() {
		testPlay.setName("TestName");
		assertEquals(testPlay.getName(),"TestName");
	}

	@Test //tests that the method returns the name of the initialized player
	public void testGetName() {
		assertEquals(testPlay.getName(),"PlayerOne");
	}

	@Test //tests to see if the playerAcc is properly translated into a string
	public void testToString() {
		System.out.println(testPlay.toString());
		assertTrue(testPlay.toString().contains("30000"));
	}

}
