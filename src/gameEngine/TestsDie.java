package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestsDie {

	@Before
	public void setUp() throws Exception {
	}
	/*
	 * This test is used to make sure that the rolls are falling with the Randomness we
	 * expect.
	 */
	@Test
	public void testRollDie() {


		Die die = new Die();


		int throw2 = 0;
		int throw3 = 0;
		int throw4 = 0;
		int throw5 = 0;
		int throw6 = 0;
		int throw7 = 0;
		int throw8 = 0;
		int throw9 = 0;
		int throw10 = 0;
		int throw11 = 0;
		int throw12 = 0;

		int throwValue;

		for( int i = 0 ; i < 1000000; i++){


			throwValue = die.rollDie();

			if (throwValue == 2){
				throw2 = throw2 + 1;
			}
			if (throwValue == 3){
				throw3 = throw3 + 1;
			}
			if (throwValue == 4){
				throw4 = throw4 + 1;
			}
			if (throwValue == 5){
				throw5 = throw5 + 1;
			}
			if (throwValue == 6){
				throw6 = throw6 + 1;
			}
			if (throwValue == 7){
				throw7 = throw7 + 1;
			}
			if (throwValue == 8){
				throw8 = throw8 + 1;
			}
			if (throwValue == 9){
				throw9 = throw9 + 1;
			}
			if (throwValue == 10){
				throw10 = throw10 + 1;
			}
			if (throwValue == 11){
				throw11 = throw11 + 1;
			}
			if (throwValue == 12){
				throw12 = throw12 + 1;
			}

		}
		System.out.println ("Nr. of 2 rolled: " + throw2 + "  (27800)");
		System.out.println ("Nr. of 3 rolled: " + throw3 + "  (55600)");
		System.out.println ("Nr. of 4 rolled: " + throw4 + "  (83300)");
		System.out.println ("Nr. of 5 rolled: " + throw5 + "  (111100)");
		System.out.println ("Nr. of 6 rolled: " + throw6 + "  (138900)");
		System.out.println ("Nr. of 7 rolled: " + throw7 + "  (166700)");
		System.out.println ("Nr. of 8 rolled: " + throw8 + "  (138900)");
		System.out.println ("Nr. of 9 rolled: " + throw9 + "  (111100)");
		System.out.println ("Nr. of 10 rolled: " + throw10 + "  (83300)");
		System.out.println ("Nr. of 11 rolled: " + throw11 + "  (55600)");
		System.out.println ("Nr. of 12 rolled: " + throw12 + "  (27800)");

		assertTrue(26800 < throw2 && throw2 < 28800);
		assertTrue(54600 < throw3 && throw3 < 56600);
		assertTrue(82300 < throw4 && throw4 < 84300);
		assertTrue(110100 < throw5 && throw5 < 112100);
		assertTrue(137900 < throw6 && throw6 < 139900);
		assertTrue(165700 < throw7 && throw7 < 167700);
		assertTrue(137900 < throw8 && throw8 < 139900);
		assertTrue(110100 < throw9 && throw9 < 112100);
		assertTrue(82300 < throw10 && throw10 < 84300);
		assertTrue(54600 < throw11 && throw11 < 56600);
		assertTrue(26800 < throw12 && throw12 < 28800);

	}	
}

