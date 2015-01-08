package gameEngine;

/*
 * This class is used to contain the gameboard of the game, it is predefined.
 * There is two arrays, this is done to makes sure that we can get the values from both
 * the given field and the ownable values connected to the field.
 * 
 */
public class GameBoard {
	
	Ownable[] ownables = new Ownable[]{
		new Gade("Rødovrevej", 1200, 50),
		new Gade("Hvidovrevej", 1200, 50),
		new Rederi("SFL Færgerne", 4000),
		new Gade("Roskildevej", 2000, 100),
		new Gade("Valby Langgade", 2000, 100),
		new Gade("Allegade", 2400, 150),
		new Gade("Frederiksberg Alle", 2800, 200),
		new Bryggeri("Tuborg Bryggeri")
	};
	
	Felt[] fields = new Felt[]{
		new Skat("Start",1,0,0),
		ownables[0],
		ownables[1],
		ownables[2],
		new Skat("Goldmine", 5, 2000, 0),
		ownables[3],
		ownables[4],
		ownables[5],
		ownables[6],
		new Parkering("Walled City", 10, 5000), 
		ownables[7],
		ownables[8],
		ownables[9],
		ownables[10],
		new Skat("Caravan", 15, 4000, 10),
		ownables[11],
		ownables[12],
		ownables[13],
		ownables[14],
		ownables[15],
		ownables[16],
		new Parkering("Monastery", 22, 500)
	};
}



