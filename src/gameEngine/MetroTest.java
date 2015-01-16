package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MetroTest {
		Metro felt;
		Spiller pl1;

		@Before
		public void setUp() throws Exception {
			pl1 = new Spiller("PlayerOne");
			felt = new Metro("MetroFelt");
		}
		
		@Test
		public void testMetro1() {
		pl1.setCurrentPos(3);//the position to the Board number
		felt.landOnFieldTest(pl1, 2);
		int actual = pl1.getCurrentPos();
		int expected = 7;//the position on the felt array. 
		assertEquals(expected,actual);
		}
		
		@Test
		public void testMetro2() {
		pl1.setCurrentPos(3);//the position to the Board number
		felt.landOnFieldTest(pl1, 6);
		int actual = pl1.getCurrentPos();
		int expected = 36;//the position on the felt array.
		assertEquals(expected,actual);
		}

		@Test
		public void testMetro3() {
		pl1.setCurrentPos(3);//the position to the Board number
		felt.landOnFieldTest(pl1, 8);
		int actual = pl1.getCurrentPos();
		int expected = 17;//the position on the felt array.
		assertEquals(expected,actual);
		
		}

		@Test
		public void testGetMetroFine() {
			int expected = 750;
			int actual = felt.getMetroFine();
			assertEquals(expected,actual);
		}

		@Test
		public void testLandOnFieldTest1() {
			
			felt.landOnFieldTest(pl1, 1);
			int actual = pl1.getAccount().getBalance();
			int expected = 29250;
			assertEquals(expected,actual);
		}
		@Test
		public void testLandOnFieldTest2() {
			felt.landOnFieldTest(pl1, 3);
			int actual = pl1.getAccount().getBalance();
			int expected = 30500;
			assertEquals(expected,actual);
		}
		@Test
		public void testLandOnFieldTest3() {
			felt.landOnFieldTest(pl1, 5);
			int actual = pl1.getAccount().getBalance();
			int expected = 29850;
			assertEquals(expected,actual);
		}
		
	}
	
