package gameEngine;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class BryggeriTest {

	//We're getting players from the player class, dice from Die class and the method Labor from LaberCamp class

	Spiller playerWhoLandedOnField;
	Terning diceRoll;
	Bryggeri bryggeri;	
	Ownable ownable;
	GameBoard gameboard;
	
	//Initializing the above
	@Before
	public void setup(){
		playerWhoLandedOnField = new Spiller("Lander-Guy");
		diceRoll = new Terning();
		bryggeri = new Bryggeri("Turborg", 3000);
	}
	
	//Tests if BaseRent is equal to what we expected: The facevalue of the dice*100,
	//example: value of dice is 9, getRent() is then = 900
	//Because of changes, the FaceValue is set to 30, resulting in getRent()=300
	@Test
	public void testLaborCamp() {
		Terning testDie = new Terning();
		testDie.setLastRoll(12);
		assertEquals(bryggeri.getRent(), 1200);		
	}

	//Tests if the player who lands on a specific field can buy the property
	//and if the price is subtracted from the players account
	//When you see the prints, playerWhoLandedOnField's balance is also shown. This is because of
	//the toString() in Player.java: 	public String toString() {
	//										return name + "'s " + playerAcc.toString();
	//									}
	
	@Test
	public void testBuyProperty(){
		bryggeri.buyProperty(playerWhoLandedOnField);
		assertTrue(playerWhoLandedOnField.getAccount().getBalance()<30000);
		System.out.println(playerWhoLandedOnField + " landed on " + bryggeri.getFieldName());
		System.out.println(playerWhoLandedOnField + " bought " + bryggeri.getFieldName() + " for " + bryggeri.getPrice());
	}
	//Tests if playerWhoLandedOnField actually buys the property he lands on
	//Using system.out.print to visualize it
	@Test
	public void testLandOnField() {
	
		GameBoard spillerplade = new GameBoard();
		Terning testDie = new Terning();
		testDie.setLastRoll(12);
		
		playerWhoLandedOnField = new Spiller("Lander-Guy");
		playerWhoLandedOnField.updateCurrentPos(12);
		System.out.println(playerWhoLandedOnField.getName() +" står nu på " + playerWhoLandedOnField.getCurrentPos());
		
		
//		bryggeri.landOnField(playerWhoLandedOnField);; //imports the m
//		assertTrue(playerWhoLandedOnField.getAccount().getBalance()<30000);
//		System.out.println(playerWhoLandedOnField + " now owns " + bryggeri.getFieldName());
		
	}
	}
