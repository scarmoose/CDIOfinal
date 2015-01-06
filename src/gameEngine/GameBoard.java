package gameEngine;

/*
 * This class is used to contain the gameboard of the game, it is predefined.
 * There is two arrays, this is done to makes sure that we can get the values from both
 * the given field and the ownable values connected to the field.
 * 
 */
public class GameBoard {
	
	Ownable[] ownables = new Ownable[]{
		new Gade("Crater", 2, 1500, 300),
		new Rederi("Second Sail", 3, 4000),
		new Gade("Tower", 4, 6000, 3200),
		new Gade("Cold Desert", 6, 3000, 700),
		new Bryggeri("Huts in the Mountain", 7, 2500),
		new Gade("The Werewall", 8, 4300, 1300),
		new Rederi("Sea Grover", 9, 4000),
		new Gade("Black Cave", 11, 4000, 1000),
		new Gade("Tribe Encampment", 12, 1000, 100),
		new Rederi("The Buccaneers", 13, 4000),
		new Gade("South Citadel", 14, 5000, 2000),
		new Gade("Mountain", 16, 2000, 500), 
		new Gade("Palace Gates", 17, 5500, 2600),
		new Rederi("Privateer Armade", 18, 4000),
		new Gade("Mountain Village", 19, 4750, 1600),
		new Bryggeri("The Pit", 20, 2500),
		new Gade("Castle", 21, 8000, 4000),
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



