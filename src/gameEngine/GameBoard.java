package gameEngine;

/*
 * This class is used to contain the gameboard of the game, it is predefined.
 * There is two arrays, this is done to makes sure that we can get the values from both
 * the given field and the ownable values connected to the field.
 * 
 */
public class GameBoard {
	
	Gade[] gader = new Gade[]{
			new Gade("Rødovrevej", 1200, 50, "blue", 1000), 					
			new Gade("Hvidovrevej", 1200, 50, "blue", 1000),
			new Gade("Roskildevej", 2000, 100, "pink", 1000),
			new Gade("Valby Langgade", 2000, 100, "pink", 1000),
			new Gade("Allegade", 2400, 150, "pink", 1000), 						
			new Gade("Frederiksberg Alle", 2800, 200, "green", 2000),
			new Gade("Bülowsvej", 2800, 200, "green", 2000),
			new Gade("Gl. Kongevej", 3200, 250, "green", 2000),
			new Gade("Bernstoffsvej", 3600, 300, "grey", 2000),
			new Gade("Hellerupvej", 3600, 300, "grey", 2000), 
			new Gade("Strandvej", 4000, 350, "grey", 2000),
			new Gade("Trianglen", 4400, 350, "red", 3000),
			new Gade("Østerbrogade", 4400, 350, "red", 3000), 					
			new Gade("Grønningen", 4800, 400, "red", 3000), 
			new Gade("Bredgade", 5200, 450, "white", 3000), 
			new Gade("Kgs. Nytorv", 5200, 450, "white", 3000),
			new Gade("Østergade", 5600, 500, "white", 3000),
			new Gade("Amagertorv", 6000, 550, "yellow", 4000),
			new Gade("Vimmelskaftet", 6000, 550, "yellow", 4000), 
			new Gade("Nygade", 6400, 600, "yellow", 4000),
			new Gade("Frederiksberggade", 7000, 700, "purple", 4000),
			new Gade("Rådhuspladsen", 8000, 1000, "purple", 4000)
		};
	{
	
	gader[0].setHouseRent(250,750,2250,4000,6000);
	gader[1].setHouseRent(250,750,2250,4000,6000);
	gader[2].setHouseRent(600,1800,5400,8000,11000);
	gader[3].setHouseRent(600,1800,5400,8000,11000);
	gader[4].setHouseRent(800,2000,6000,9000,12000);
	gader[5].setHouseRent(1000,3000,9000,12500,15000);
	gader[6].setHouseRent(1000,3000,9000,12500,15000);
	gader[7].setHouseRent(1250,3750,10000,14000,18000);
	gader[8].setHouseRent(1400,4000,11000,15000,19000);
	gader[9].setHouseRent(1400,4000,11000,15000,19000);
	gader[10].setHouseRent(1600,4400,12000,16000,20000);
	gader[11].setHouseRent(1800,5000,14000,17500,21000);
	gader[12].setHouseRent(1800,5000,14000,17500,21000);
	gader[13].setHouseRent(2000,6000,15000,18500,22000);
	gader[14].setHouseRent(2200,6600,16000,19500,23000);
	gader[15].setHouseRent(2200,6600,16000,19500,23000);
	gader[16].setHouseRent(2400,7200,17000,20500,24000);
	gader[17].setHouseRent(2600,7800,18000,22000,25000);
	gader[18].setHouseRent(2600,7800,18000,22000,25000);
	gader[19].setHouseRent(3000,9000,20000,24000,28000);
	gader[20].setHouseRent(3500,10000,22000,26000,30000);
	gader[21].setHouseRent(4000,12000,28000,34000,40000);
	
	
	}
	
	Ownable[] ownables = new Ownable[]{
		new Gade("Rødovrevej", 1200, 50, "blue", 1000), 						//0
		new Gade("Hvidovrevej", 1200, 50, "blue", 1000),
		new Rederi("SFL Færgerne", 4000),
		new Gade("Roskildevej", 2000, 100, "pink", 1000),
		new Gade("Valby Langgade", 2000, 100, "pink", 1000),
		new Gade("Allegade", 2400, 150, "pink", 1000), 						//5
		new Gade("Frederiksberg Alle", 2800, 200, "green", 2000),
		new Bryggeri("Tuborg Bryggeri", 3000),
		new Gade("Bülowsvej", 2800, 200, "green", 2000),
		new Gade("Gl. Kongevej", 3200, 250, "green", 2000),
		new Rederi("DSB Rederierne Kalundborg/Aarhus", 4000), 	//10
		new Gade("Bernstoffsvej", 3600, 300, "grey", 2000),
		new Gade("Hellerupvej", 3600, 300, "grey", 2000), 
		new Gade("Strandvej", 4000, 350, "grey", 2000),
		new Gade("Trianglen", 4400, 350, "red", 3000),
		new Gade("Østerbrogade", 4400, 350, "red", 3000), 					//15
		new Gade("Grønningen", 4800, 400, "red", 3000), 
		new Rederi("DFDS Seaways", 4000),
		new Gade("Bredgade", 5200, 450, "white", 3000), 
		new Gade("Kgs. Nytorv", 5200, 450, "white", 3000),
		new Bryggeri("Coca-Cola Tapperi", 3000),				//20 
		new Gade("Østergade", 5600, 500, "white", 3000),
		new Gade("Amagertorv", 6000, 550, "yellow", 4000),
		new Gade("Vimmelskaftet", 6000, 550, "yellow", 4000), 
		new Gade("Nygade", 6400, 600, "yellow", 4000),
		new Rederi("DSB Rederierne Halvskov/Knudshoved2", 4000),//25
		new Gade("Frederiksberggade", 7000, 700, "purple", 4000),
		new Gade("Rådhuspladsen", 8000, 1000, "purple", 4000)
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



