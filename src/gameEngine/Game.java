
package gameEngine;

import javax.swing.JOptionPane;

import desktop_resources.GUI;
import gameEngine.GameBoard;

public class Game {

	//All players are created
	Spiller player1 = new Spiller("PlayerOne");
	Spiller player2 = new Spiller("PlayerTwo");
	Spiller player3 = new Spiller("PlayerThree");
	Spiller player4 = new Spiller("PlayerFour");
	Spiller player5 = new Spiller("PlayerFive");
	Spiller player6 = new Spiller("PlayerSix");
	Spiller playerTurn[] = {player1,player2,player3,player4,player5,player6}; 

	GameBoard currentBoard = new GameBoard();
	boolean buyCheck = true;

	//All players are set to true. True means they are active
	private boolean playerOne = true;
	private boolean playerTwo = true;
	private boolean playerThree = true;
	private boolean playerFour = true;
	private boolean playerFive = true;
	private boolean playerSix = true;
	private boolean activePlayers[]={playerOne,playerTwo,playerThree,playerFour,playerFive,playerSix};

	private boolean game = true;
	private static String rollDice = "";

	private int inactivePlayers  = 0; //Variable to check amount of inactive player. It starts with 0, because they all start out active

	int trow = 0;

	public void game(){

		int turn = 0; //Variable used to determine which players turn it is.
		//variables created for storing the users names for the game in an array
		//With only a Max amount of 6 players, the len of the array is only 6
		String playerNames[] = {"","","","","",""};

		//The choice of amount of players
		String[] amount = {"2","3", "4","5","6"};//Lowest amount of players will be 3
		//Selection box in which amount of players is chosen
		String players = (String) JOptionPane.showInputDialog(null, "Vælg antal spillere:",
				"Livets største beslutning", JOptionPane.QUESTION_MESSAGE, null,
				amount, 
				amount[0]); //Default choice is 3 players
		int NumberOfPlayers = Integer.parseInt(players);//Turns the choice into an integer
	
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

		n = 0; //Resets the variable used to run through the array		

		while (n<=NumberOfPlayers-1){

			GUI.addPlayer(playerNames[n],playerTurn[n].getAccount().getBalance(),playerTurn[n].playerCar);
			n++;
		}

		n = 0; //Resets the variable used to run through the array
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
				trow = 1;				
//				trow=dieOne.rollDie();
				if(activePlayers[turn]) {
					prisonCheck(turn, playerNames, dieOne);					
					GUI.setDice(dieOne.getFaceValue1(), dieOne.getFaceValue2());
					GUI.removeAllCars(playerNames[turn]);//Removes the player from the board.
					playerTurn[turn].updateCurrentPos(trow);//Updates the current position by adding with trow

					//sets car at field corresponding to the value of the players position
					GUI.setCar(playerTurn[turn].getCurrentPos()+1, playerNames[turn]);
					System.out.println(playerNames[turn]+" fik en "+trow+"'er.");
					currentBoard.fields[playerTurn[turn].getCurrentPos()].landOnField(playerTurn[turn]);
					GUI.setBalance(playerNames[turn], playerTurn[turn].getAccount().getBalance());

					//Sets the player to lose in case of 0 points
					checkForLoserAndExecute(playerNames, turn);	 

					if(playerTurn[turn].checkForHouseColours()>0){
						if(playerTurn[turn].listHousesToBuy(currentBoard)[0]!= null){
							Object[] options = {
									"Køb hus(e) nu!",
									"Giv turen videre.",};
							int buttonPressed2 = JOptionPane.showOptionDialog(null,
									"Du ejer en eller flere serier af gader!",
									"BESLUT DIG NU!",
									JOptionPane.WARNING_MESSAGE,
									JOptionPane.QUESTION_MESSAGE,
									null,
									options, 
									options[0]);
							if(buttonPressed2 == 0){
								while (buyCheck)
								{
									getHouses(turn);
								}
								buyCheck=true;
							}							
						}
					}
					turn++;
					if (turn>NumberOfPlayers-1){
						turn=0;
					}
				}
			}
		}
	}

	private void prisonCheck(int turn, String[] playerNames, Terning dieOne) {
		if(playerTurn[turn].getPrisonCount()==4){
			System.out.println(playerNames[turn]+" har været i fængslet i 3 runder og kommer nu ud");
			playerTurn[turn].resetPrisonCount();
		}
		if(playerTurn[turn].getPrisonCount()>0){
			Object[] Prisonoptions = {
					"Betal for at komme ud",
		            "Prøv at slå par for at komme ud",};
			int buttonPrison = JOptionPane.showOptionDialog(null,
					"Ønsker du at betale for at komme ud af fængslet?",
					"BESLUT DIG NU!",
					JOptionPane.WARNING_MESSAGE,
					JOptionPane.QUESTION_MESSAGE,
					null,
					Prisonoptions, 
					Prisonoptions[0]);
			
			if(buttonPrison == 0){
				playerTurn[turn].getAccount().withdraw(1000);
				playerTurn[turn].resetPrisonCount();
			}	
			else if(buttonPrison == 1){
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
		}
	}
	
	/**
	 * method responsible for listing the properties available to buy houses on. 
	 * And buy the houses if the player wishes
	 * @param turn the player turn. NOT the player
	 */
	private void getHouses(int turn) {
		String buttonPressed3 = GUI.getUserSelection("Vælg gade(r) du vil købe huse på",
				playerTurn[turn].listHousesToBuy(currentBoard));
		for(int i =0;i<currentBoard.gader.length;i++){
			if(buttonPressed3.equals(currentBoard.gader[i].getFieldName()) 
					&& currentBoard.gader[i].getHousesOnField()<currentBoard.gader[i].getMAX_HOUSES_ON_FIELD()){
				int houseCount = GUI.getUserInteger("Hvor mange huse vil du købe? (5 huse = 1 hotel) 1 hus koster "+currentBoard.gader[i].getHousePrice(),
						1, 5-currentBoard.gader[i].getHousesOnField());
				for(int j = 0; j < currentBoard.fields.length; j++){	
					Felt f = currentBoard.fields[j];
					if(!(f instanceof Gade)){
						continue;
					}
					Gade g = (Gade) f;
					if(buttonPressed3.equals(g.getFieldName())){
						currentBoard.gader[i].buyHouse(playerTurn[turn],houseCount,j);											
					}
				}
			}
		}
		Object[] checkoptions = {
				"Køb flere huse!",
				"Giv turen videre.",};
		int buttonCheck = JOptionPane.showOptionDialog(null,
				"Køb flere huse eller giv turen videre",
				"BESLUT DIG NU!",
				JOptionPane.WARNING_MESSAGE,
				JOptionPane.QUESTION_MESSAGE,
				null,
				checkoptions, 
				checkoptions[0]);
		if(buttonCheck == 0){
			return;
		}
		else if(buttonCheck == 1){
			buyCheck=false;
		}
	}

	/**
	 * Checks to see if the current player lost
	 * @param playerNames array of the player names
	 * @param turn the player turn. NOT the player
	 */
	
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

	public static String getRollDice() {
		return rollDice;
	}
	public static void setRollDice(String rollDice) {
		Game.rollDice = rollDice;
	}

}


