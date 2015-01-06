
package gameEngine;

import javax.swing.JOptionPane;


import boundaryToMatador.GUI;

import gameEngine.GameBoard;

public class Game {

	//All players are created
	Player player1 = new Player("PlayerOne");
	Player player2 = new Player("PlayerTwo");
	Player player3 = new Player("PlayerThree");
	Player player4 = new Player("PlayerFour");
	Player player5 = new Player("PlayerFive");
	Player player6 = new Player("PlayerSix");
	//All the players are placed in an array
	Player playerTurn[] = {player1,player2,player3,player4,player5,player6}; 

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

	public void game(){

		//variables created for storing the users names for the game in an array
		//With only a Max amount of 6 players, the len of the array is only 6
		String playerNames[] = {"","","","","",""};


		//The choice of amount of players
		String[] amount = { "2", "3", "4","5","6"};//Lowest amount of players will be 2
		//Selection box in which amount of players is chosen
		String players = (String) JOptionPane.showInputDialog(null, "Choose amount of players:",
				"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null,
				amount, 
				amount[0]); //Default choice is 2 players
		int NumberOfPlayers = Integer.parseInt(players);//Turns the choice into an integer


		//Game Window initialization
		GUI.create("fieldstext-cdio3.txt");
		Game.setTypeNameOne("Enter name for player 1");
		Game.setTypeNameTwo("Enter name for player 2");
		Game.setRollDice("Roll Dice");


		//User names are prompted from the users, and store in previous variables
		int n = 0; //Variable used to run through the array
		while (n<=NumberOfPlayers-1){
			playerNames[n] = GUI.getUserString(" Enter name for player "+(n+1));
			playerTurn[n].setName(playerNames[n]);
			if (playerNames[n].equals("")){
				playerNames[n] = "Player "+(n+1);//Add 1 to n, because we wont start with Spiller0
				playerTurn[n].setName(playerNames[n]);
			}
			n++;//increment n in order to perform the next iteration
		}

		//variable used to store the button pressed value
		String buttonPressed = "";

		//Dices to be rolled are created.
		Die dieOne = new Die();

		int turn = 0; //Variable used to determine which players turn it is.


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
				Object[] option = {"Exit game!",};         		
				int endButtonPressed = JOptionPane.showOptionDialog(null,playerNames[turn]+" is the winner! " + " Thanks for playing! ", playerNames[turn]+ " won!!! ",
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
			System.out.println(playerNames[turn]+"'s turn");
			
			//user prompted button, when pressed the value of rollDice is stored in i.
			buttonPressed = GUI.getUserButtonPressed(null, rollDice);

			if(buttonPressed.equals(rollDice)){
				int trow=dieOne.rollDie();
				GUI.setDice(dieOne.getFaceValue1(), dieOne.getFaceValue2());

				if(activePlayers[turn]) {
					GUI.removeAllCars(playerNames[turn]);//Removes the player from the board.
					playerTurn[turn].updateCurrentPos(trow);//Updates the current position by adding with trow
					
					//sets car at field corresponding to the value of the players position
					GUI.setCar(playerTurn[turn].getCurrentPos()+1, playerNames[turn]);
					System.out.println(playerNames[turn]+" threw a "+playerTurn[turn].getCurrentPos());

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


