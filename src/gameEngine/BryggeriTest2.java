package gameEngine;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;

public class BryggeriTest2 {

		//We're getting players from the player class, dice from Die class and the method Labor from LaberCamp class

		Spiller playerWhoLandedOnField;
		Spiller playerWhoLandedOnField2;
		Terning diceRoll;
		Bryggeri bryggeri;	
		Ownable ownable;
		GameBoard gameboard;
		
		
		//Initializing the above
		@Before
		public void setup(){
			playerWhoLandedOnField = new Spiller("Lander-Guy");
			playerWhoLandedOnField2 = new Spiller("Owner-Guy");
			diceRoll = new Terning();
			bryggeri = new Bryggeri("Turborg", 3000);
		}
		
		//Tests if BaseRent is equal to what we expected: The facevalue of the dice*100,
		//example: value of dice is 9, getRent() is then = 900
		//We have set the diceroll to 12 - the getRent() will then be = 1200
		
		@Test
		public void testBreweriRent() {
			
			bryggeri.setOwner(playerWhoLandedOnField2);
			playerWhoLandedOnField2.incrementBreweriesOwned();
			
			Terning testDie = new Terning();
			testDie.setLastRoll(12);
		
			bryggeri.landOnField(playerWhoLandedOnField);
			
			assertEquals(playerWhoLandedOnField.getAccount().getBalance(), 28800);	
			assertEquals(playerWhoLandedOnField2.getAccount().getBalance(), 31200);		
		}

		//Tests if the player who lands on a specific field can buy the property
		//and if the price is subtracted from the players account
		
		@Test
		public void testBuyProperty(){
			bryggeri.buyProperty(playerWhoLandedOnField);
			assertTrue(playerWhoLandedOnField.getAccount().getBalance()<30000);
		}
		
		//Tests if the player actually buys the property he lands on if no one else owns it
		
		@Test
		public void landOnFieldTest() { 
		
		Terning testDie = new Terning();
		testDie.setLastRoll(12);
		bryggeri.setOwner(playerWhoLandedOnField2);
			
			if(bryggeri.getOwner() != null){
				playerWhoLandedOnField.getAccount().withdraw(bryggeri.getRent());
				bryggeri.getOwner().getAccount().deposit(bryggeri.getRent());	
			}
			else{
				bryggeri.buyProperty(playerWhoLandedOnField);
			}
		}
	}

	
	

