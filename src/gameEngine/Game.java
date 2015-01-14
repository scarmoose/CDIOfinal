
package gameEngine;

import javax.swing.JOptionPane;


import boundaryToMatador.GUI;

import gameEngine.GameBoard;

public class Game {

	//All players are created
	Spiller player1 = new Spiller("PlayerOne");
	Spiller player2 = new Spiller("PlayerTwo");
	Spiller player3 = new Spiller("PlayerThree");
	Spiller player4 = new Spiller("PlayerFour");
	Spiller player5 = new Spiller("PlayerFive");
	Spiller player6 = new Spiller("PlayerSix");
	//All the players are placed in an array
	Spiller playerTurn[] = {player1,player2,player3,player4,player5,player6}; 

	GameBoard currentBoard = new GameBoard();

	//All players are set to true. True means that they are still active and haven't lost
	private boolean playerOne = true;
	private boolean playerTwo = true;
	private boolean playerThree = true;
	private boolean playerFour = true;
	private boolean playerFive = true;
	private boolean playerSix = true;
	//All players state of activity are placed in an array
	private boolean activePlayers[]={playerOne,playerTwo,playerThree,playerFour,playerFive,playerSix};

	//The game will be running while its' true
	private boolean game = true;

	//Language used in the code, will be changed by the language setting.
	private static String typeNameOne = ""; 
	private static String typeNameTwo = "";
	private static String typeNameThree = ""; 
	private static String typeNameFour = "";
	private static String typeNameFive = ""; 
	private static String typeNameSix = "";
	//All typeNames have been placed in an array
	private static String typeNames[] = {typeNameOne, typeNameTwo,typeNameThree,typeNameFour,typeNameFive,typeNameSix};

	private static String rollDice = "";

	private int inactivePlayers  = 0; //Variable to check amount of inactive player. It starts with 0, because they all start out active

	int trow = 0;

	public void game(){

		int turn = 0; //Variable used to determine which players turn it is.
		//variables created for storing the users names for the game in an array
		//With only a Max amount of 6 players, the len of the array is only 6
		String playerNames[] = {"","","","","",""};


		//The choice of amount of players
		String[] amount = {"3", "4","5","6"};//Lowest amount of players will be 3
		//Selection box in which amount of players is chosen
		String players = (String) JOptionPane.showInputDialog(null, "Vælg antal spillere:",
				"Livets største beslutning", JOptionPane.QUESTION_MESSAGE, null,
				amount, 
				amount[0]); //Default choice is 3 players
		int NumberOfPlayers = Integer.parseInt(players);//Turns the choice into an integer


		//Game Window initialization
		//		GUI.create("fieldstext-cdio3.txt");
		Game.setRollDice("Kast terninger");

		//User names are prompted from the users, and store in previous variables
		int n = 0; //Variable used to run through the array
		while (n<=NumberOfPlayers-1){
			playerNames[n] = GUI.getUserString(" Indtast navn for spiller "+(n+1));
			if (playerNames[n].equals("")){
				playerNames[n] = "Spiller "+(n+1);//Add 1 to n, because we wont start with Spiller0
			}
			playerTurn[n].setName(playerNames[n]);
			n++;//increment n in order to perform the next iteration
		}

		//variable used to store the button pressed value
		String buttonPressed = "";

		//Dices to be rolled are created.
		Terning dieOne = new Terning();



		n = 0; //Resest the variable used to run through the array

		/*
		 * Color1-3 is the value to the six color made with RGB color-model
		 * To set the color of the six players cars.
		 */
		int[] color1 = { 255,0,18,255,0,230};
		int[] color2 = { 255,0,247,56,145,0};
		int[] color3 = { 255,0,56,26,255,255};
		//adds player cars to the game
		while (n<=NumberOfPlayers-1){
			GUI.addPlayer(playerNames[n],playerTurn[n].getAccount().getBalance(),color1[n],color2[n],color3[n]);
			n++;
		}


		n = 0; //Resest the variable used to run through the array
		//Maximum amount of players that can be inactive
		int MaxInactive = NumberOfPlayers - 1;
		while(game) {

			//Updates the balance of all players at the start of each turn
			for(int check = 0; check < NumberOfPlayers; check++){
				GUI.setBalance(playerNames[check], playerTurn[check].getAccount().getBalance());
			}

			//Checks if the players have already lost. If so, next players turn
			if (activePlayers[turn]!=true){
				turn++;
				if (turn>NumberOfPlayers-1){
					turn=0;
				}
				continue;
			}
			//Terminates the game if all except one have lost
			if (inactivePlayers==MaxInactive){
				Object[] option = {"Slut spil!",};         		
				int endButtonPressed = JOptionPane.showOptionDialog(null,playerNames[turn]+" er vinderen! " + " Tak fordi I spillede med! ", playerNames[turn]+ " vandt! ",
						JOptionPane.WARNING_MESSAGE,
						JOptionPane.QUESTION_MESSAGE,
						null,
						option,
						option[0]);
				if (endButtonPressed == 0){
					System.exit(0);
				}
			}

			//Prints out which players turn it is
			System.out.println(playerNames[turn]+"s tur.");

			//user prompted button, when pressed the value of rollDice is stored in i.
			buttonPressed = GUI.getUserButtonPressed(null, rollDice+" ("+playerTurn[turn].getName()+")");

			if(buttonPressed.equals(rollDice+" ("+playerTurn[turn].getName()+")")){
				//int trow=dieOne.rollDie();
				//int trow = 0;
				trow=dieOne.rollDie();
				GUI.setDice(dieOne.getFaceValue1(), dieOne.getFaceValue2());
				if(activePlayers[turn]) {
					if(playerTurn[turn].getPrisonCount()==4){
						playerTurn[turn].resetPrisonCount();
						if(dieOne.getFaceValue1()!=dieOne.getFaceValue2())
						{
							playerTurn[turn].getAccount().withdraw(1000);
							System.out.println(playerNames[turn]+" har været i fængslet i 3 runder og betaler 1000 for at komme ud");	
						}
						else
						{
							System.out.println(playerNames[turn]+" er ude af fænglset pga par på slag");
						}
					}
					if(playerTurn[turn].getPrisonCount()>0){
						if(dieOne.getFaceValue1()==dieOne.getFaceValue2())
						{
							playerTurn[turn].resetPrisonCount();
							System.out.println(playerNames[turn]+" er ude af fænglset pga par på slag");
						}
						else
						{
							playerTurn[turn].incrementPrisonCount();
							trow=0;
							System.out.println(playerNames[turn]+" forbliver i fænglset");
						}				
					}
					GUI.removeAllCars(playerNames[turn]);//Removes the player from the board.
					playerTurn[turn].updateCurrentPos(trow);//Updates the current position by adding with trow

					//sets car at field corresponding to the value of the players position
					GUI.setCar(playerTurn[turn].getCurrentPos()+1, playerNames[turn]);
					System.out.println(playerNames[turn]+" fik en "+trow+"'er.");

					currentBoard.fields[playerTurn[turn].getCurrentPos()].landOnField(playerTurn[turn]);

					//Fields.field(playerTurn[turn], trow, i);
					GUI.setBalance(playerNames[turn], playerTurn[turn].getAccount().getBalance());

					//Sets the player to lose in case of 0 points
					checkForLoserAndExecute(playerNames, turn);	 

					//Next players turn
					turn++;
					//If turn is out of bounds. It is reset to 0
					if (turn>NumberOfPlayers-1){
						turn=0;
					}

					if(playerTurn[turn].checkForHouseColours()>0){
						if(playerTurn[turn].listHousesToBuy(currentBoard)[0]!= null){
							GUI.getUserSelection("Vælg gade(r) du vil købe huse på", playerTurn[turn].listHousesToBuy(currentBoard));
						}
					}
				}
			}
		}
	}

	//Checks if the players have lost all points
	private void checkForLoserAndExecute(String[] playerNames, int turn) {
		if(playerTurn[turn].getAccount().getBalance()==0){
			activePlayers[turn] = false;//Sets the player to false (inactive), when the player have lost
			inactivePlayers++;//increment amount of inactive players
			GUI.removeAllCars(playerNames[turn]); //Player is removed from board

			//removes bankrupt player as owner of his fields

			for(int is = 0; is < currentBoard.ownables.length; is++){
				if(currentBoard.ownables[is].getOwner() == playerTurn[turn]) {
					currentBoard.ownables[is].setOwner(null);
				}	
			}
		}	
	}



	//	String StreetsWithHousesToBuy[];
	//	
	//	public String[] listHousesToBuy(Spiller spiller) {
	//		StreetsWithHousesToBuy = new String[currentBoard.gader.length];
	//		int index = 0;
	//		for (Gade gade : currentBoard.gader) {
	//			if(spiller.getOwnsAllColour()[gade.getColourIndex()] == true){
	//				StreetsWithHousesToBuy[index++] = gade.getFieldName();				
	//			}
	//		}
	//		return StreetsWithHousesToBuy;
	//	}


	//Language Strings getters and setters
	public static void setTypeNameOne(String typeNameOne) {
		Game.typeNameOne = typeNameOne;
	}
	public static void setTypeNameTwo(String typeNameTwo) {
		Game.typeNameTwo = typeNameTwo;
	}
	public static String getRollDice() {
		return rollDice;
	}
	public static void setRollDice(String rollDice) {
		Game.rollDice = rollDice;
	}

}


