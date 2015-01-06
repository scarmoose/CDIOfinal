package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	GameBoard currentBoard;
	Player[] playerTurn = new Player[2];

	@Before
	public void setUp() throws Exception {
		currentBoard = new GameBoard();
		playerTurn[0] = new Player("1");
		playerTurn[1] = new Player("2");
		
		
	}
	/*
	 * We used this test to check if the reset of owners worked when a given player has no 
	 * more money to play for.
	 */
	@Test
	public void testResetOwner() {
		currentBoard.fields[2].landOnField(playerTurn[0]);
		System.out.println(currentBoard.ownables[1].getOwner());
		assertTrue(currentBoard.ownables[1].getOwner().getName().equals("1"));
		
		for(int is = 0; is < currentBoard.ownables.length; is++){
//			System.out.println("--> "+(currentBoard.ownables[is].getOwner() == playerTurn[0]));
			if(currentBoard.ownables[is].getOwner() == playerTurn[0]) {
				currentBoard.ownables[is].setOwner(null);

			}
		}
		assertNull(currentBoard.ownables[1].getOwner());

	}
}
