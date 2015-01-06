package gameEngine;

/*
 * This class is used to contain the gameboard of the game, it is predefined.
 * There is two arrays, this is done to makes sure that we can get the values from both
 * the given field and the ownable values connected to the field.
 * 
 */
public class GameBoard {
	
	Ownable[] ownables = new Ownable[]{
		new Territory("Crater", 2, 1500, 300),
		new Fleet("Second Sail", 3, 4000),
		new Territory("Tower", 4, 6000, 3200),
		new Territory("Cold Desert", 6, 3000, 700),
		new LaborCamp("Huts in the Mountain", 7, 2500),
		new Territory("The Werewall", 8, 4300, 1300),
		new Fleet("Sea Grover", 9, 4000),
		new Territory("Black Cave", 11, 4000, 1000),
		new Territory("Tribe Encampment", 12, 1000, 100),
		new Fleet("The Buccaneers", 13, 4000),
		new Territory("South Citadel", 14, 5000, 2000),
		new Territory("Mountain", 16, 2000, 500), 
		new Territory("Palace Gates", 17, 5500, 2600),
		new Fleet("Privateer Armade", 18, 4000),
		new Territory("Mountain Village", 19, 4750, 1600),
		new LaborCamp("The Pit", 20, 2500),
		new Territory("Castle", 21, 8000, 4000),
	};
	
	Fields[] fields = new Fields[]{
		new Tax("Start",1,0,0),
		ownables[0],
		ownables[1],
		ownables[2],
		new Tax("Goldmine", 5, 2000, 0),
		ownables[3],
		ownables[4],
		ownables[5],
		ownables[6],
		new Refuge("Walled City", 10, 5000), 
		ownables[7],
		ownables[8],
		ownables[9],
		ownables[10],
		new Tax("Caravan", 15, 4000, 10),
		ownables[11],
		ownables[12],
		ownables[13],
		ownables[14],
		ownables[15],
		ownables[16],
		new Refuge("Monastery", 22, 500)
	};
}



