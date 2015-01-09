package gameEngine;

/*
 * This class is used to contain the gameboard of the game, it is predefined.
 * There is two arrays, this is done to makes sure that we can get the values from both
 * the given field and the ownable values connected to the field.
 * 
 */
public class GameBoard {
	
	Ownable[] ownables = new Ownable[]{
		new Gade("Rødovrevej", 1200, 50, "blue"), 						//0
		new Gade("Hvidovrevej", 1200, 50, "blue"),
		new Rederi("SFL Færgerne", 4000),
		new Gade("Roskildevej", 2000, 100, "pink"),
		new Gade("Valby Langgade", 2000, 100, "pink"),
		new Gade("Allegade", 2400, 150, "pink"), 						//5
		new Gade("Frederiksberg Alle", 2800, 200, "green"),
		new Bryggeri("Tuborg Bryggeri", 3000),
		new Gade("Bülowsvej", 2800, 200, "green"),
		new Gade("Gl. Kongevej", 3200, 250, "green"),
		new Rederi("DSB Rederierne Kalundborg/Aarhus", 4000), 	//10
		new Gade("Bernstoffsvej", 3600, 300, "grey"),
		new Gade("Hellerupvej", 3600, 300, "grey"), 
		new Gade("Strandvej", 4000, 350, "grey"),
		new Gade("Trianglen", 4400, 350, "red"),
		new Gade("Østerbrogade", 4400, 350, "red"), 					//15
		new Gade("Grønningen", 4800, 400, "red"), 
		new Rederi("DFDS Seaways", 4000),
		new Gade("Bredgade", 5200, 450, "white"), 
		new Gade("Kgs. Nytorv", 5200, 450, "white"),
		new Bryggeri("Coca-Cola Tapperi", 3000),				//20 
		new Gade("Østergade", 5600, 500, "white"),
		new Gade("Amagertorv", 6000, 550, "yellow"),
		new Gade("Vimmelskaftet", 6000, 550, "yellow"), 
		new Gade("Nygade", 6400, 600, "yellow"),
		new Rederi("DSB Rederierne Halvskov/Knudshoved2", 4000),//25
		new Gade("Frederiksberggade", 7000, 700, "purple"),
		new Gade("Rådhuspladsen", 8000, 1000, "purple")
	};
	
	Felt[] fields = new Felt[]{
		new Skat("Start",0,0),									//0
		ownables[0],
		new Metro("Metro"),
		ownables[1],
		new Skat("Indkomstskat", 4000, 10),
		ownables[2],											//5
		ownables[3],
		new Metro("Metro"), 
		ownables[4],
		ownables[5],
		new Skat("Fængsel", 0, 0),								//10
		ownables[6], 
		ownables[7],
		ownables[8],
		ownables[9],
		ownables[10],											//15
		ownables[11],
		new Metro("Metro"),
		ownables[12],
		ownables[13],
		new Parkering("Ægte Parkering", 500),					//20
		ownables[14],
		new Metro("Metro"),
		ownables[15],
		ownables[16],
		ownables[17], //DFDS									//25
		ownables[18],
		ownables[19],
		ownables[20],
		ownables[21],
		new Fængsel("Gå i Fængsel"),							//30
		ownables[22],
		ownables[23],
		new Metro("Metro"),
		ownables[24], 
		ownables[25],											//35
		new Metro("Metro"),
		ownables[26],
		new Skat("Statsskat", 2000, 0),
		ownables[27]											//39
	};
}



