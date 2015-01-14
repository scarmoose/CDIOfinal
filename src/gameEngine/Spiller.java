package gameEngine;

import boundaryToMatador.GUI;

public class Spiller {

	private String name;
	private int fleetsOwned = 0;
	private int breweriesOwned = 0;
	private int currentPos = 0;
	private Konto playerAcc = new Konto(); 
	private int prisonCount = 0;
	
//	private boolean ownsAllBlue = false; 
//	private boolean ownsAllPink = false; 
//	private boolean ownsAllGreen = false; 
//	private boolean ownsAllGrey = false;
//	private boolean ownsAllRed = false; 
//	private boolean ownsAllWhite = false; 
//	private boolean ownsAllYellow = false;
//	private boolean ownsAllPurple = false;
	
	private boolean ownsAllColour[] = {false, false, false, false, false, false, false, false};
	
	//counters for each colour category
//	private int colourCount[] = {0,0,0,0,0,0,0,0};
//	private int blueCount = 0;
//	private int pinkCount = 0;
//	private int greenCount = 0;
//	private int greyCount = 0;
//	private int redCount = 0;
//	private int whiteCount = 0;
//	private int yellowCount = 0;
//	private int purpleCount = 0;
	
	public int colourCount[] = new int[8]; //= {blueCount, pinkCount, greenCount, greyCount, redCount,whiteCount, yellowCount, purpleCount};
	
//	private final int MAXCOUNT[] = {2,3,3,3,3,3,3,3,2};
	private final int BLUE_COUNT_MAX = 2; 
	private final int PINK_COUNT_MAX = 3; 
	private final int GREEN_COUNT_MAX = 3;
	private final int GREY_COUNT_MAX = 3; 
	private final int RED_COUNT_MAX = 3; 
	private final int WHITE_COUNT_MAX = 3;
	private final int YELLOW_COUNT_MAX = 3; 
	private final int PURPLE_COUNT_MAX = 2; 
	
	int MAX_COLOUR[] = {BLUE_COUNT_MAX, PINK_COUNT_MAX, GREEN_COUNT_MAX,
			GREY_COUNT_MAX, RED_COUNT_MAX, WHITE_COUNT_MAX, YELLOW_COUNT_MAX, PURPLE_COUNT_MAX};
	
	

	public int getPrisonCount() {
		return prisonCount;
	}

	public void incrementPrisonCount() {
		this.prisonCount++;
	}
	
	public void resetPrisonCount() {
		prisonCount = 0;
	}

	/**
	 * 
	 * returns an integer with the players current position. 
	 * If the players position is more than 39 (the 39 fields + START at 0)
	 * 39 is subtracted when the currentPos i needed
	 * 
	 * @return the current position of the player in the game.
	 */
	public int getCurrentPos() {
		if(currentPos > 39){
			currentPos = currentPos - 40;
			this.getAccount().deposit(4000); //4000 when START is passed
			System.out.println(name+ " fik 4000 for at passere START");
			GUI.showMessage(name+ " fik 4000 for at passere START");
		}		
		return currentPos;
	}

	public void setCurrentPos(int currentPos) {
		this.currentPos = currentPos - 1;
	}

	/**
	 * 
	 * @param throwValue is the value of the dice roll, this is added to the position of the player
	 */
	public void updateCurrentPos(int throwValue) {
		this.currentPos = currentPos + throwValue;
	}

	/**
	 * Construct for a new player
	 * @param name name of the player
	 */
	public Spiller(String name) {
		this.name = name; 
	}

	/**
	 * Name change method
	 * @param name name you would like the given player to be called instead.
	 */
	public void setName(String name) {
		this.name = name; 
	}
	/**
	 * 
	 * @return the name of the player
	 */
	public String getName() {
		return name; 
	}
	/**
	 * Converts the players name and account values to a string and returns it
	 */
	public String toString() {
		return name + "'s " + playerAcc.toString();
	}
	/**
	 * 
	 * @return returns the players account for further use.
	 */
	public Konto getAccount() {
		return playerAcc;
	}
	
	/**
	 * 
	 * @return the amount of fleets that a player owns
	 */
	public int getFleetsOwned(){
		return fleetsOwned;
	}
	/**
	 * adds 1 to the amount of fleets a player owns.
	 * 
	 */
	public void incrementFleetsOwned(){
		this.fleetsOwned = this.fleetsOwned + 1;
	}
	
	public int getBreweriesOwned(){
		return breweriesOwned;
	}
	
	public void incrementBreweriesOwned(){
		this.breweriesOwned++;
	}
	
	/*
	 * Colour getters and setters
	 */
	public void incrementBlueOwned(){
		this.colourCount[0]++;
	}
	public void incrementPinkOwned(){
		this.colourCount[1]++;
	}
	public void incrementGreenOwned(){
		this.colourCount[2]++;
	}
	public void incrementGreyOwned(){
		this.colourCount[3]++;
	}
	public void incrementRedOwned(){
		this.colourCount[4]++;
	}
	public void incrementWhiteOwned(){
		this.colourCount[5]++;
	}
	public void incrementYellowOwned(){
		this.colourCount[6]++;
	}
	public void incrementPurpleOwned(){
		this.colourCount[7]++;
	}
	
	public int getBlueCount() {
		return colourCount[0];
	}
	
	public void setBlueCount(int blueCount) {
		colourCount[0] = blueCount; 
	}
	
	public int getPinkCount() {
		return colourCount[1];
	}
	
	public void setPinkCount(int pinkCount) {
		colourCount[1] = pinkCount;
	}
	
	public int getGreenCount() {
		return colourCount[2];
	}
	
	public void setGreenCount(int greenCount) {
		colourCount[2] = greenCount;
	}
	
	public int getGreyCount() {
		return colourCount[3];
	}
	
	public void setGreyCount(int greyCount) {
		colourCount[3] = greyCount;
	}
	
	public int getRedCount() {
		return colourCount[4];
	}
	
	public void setRedCount(int redCount) {
		colourCount[4] = redCount;
	}
	
	public int getWhiteCount() {
		return colourCount[5];
	}
	
	public void setWhiteCount(int whiteCount) {
		colourCount[5] = whiteCount;
	}
	
	public int getYellowCount() {
		return colourCount[6];
	}
	
	public void setYellowCount(int yellowCount) {
		colourCount[6] = yellowCount;
	}
	
	public int getPurpleCount() {
		return colourCount[7];
	}
	
	public void setPurpleCount(int purpleCount) {
		colourCount[7] = purpleCount; 
	}

	public int getBLUE_COUNT_MAX() {
		return BLUE_COUNT_MAX;
	}

	public int getPINK_COUNT_MAX() {
		return PINK_COUNT_MAX;
	}

	public int getGREEN_COUNT_MAX() {
		return GREEN_COUNT_MAX;
	}

	public int getGREY_COUNT_MAX() {
		return GREY_COUNT_MAX;
	}

	public int getRED_COUNT_MAX() {
		return RED_COUNT_MAX;
	}

	public int getWHITE_COUNT_MAX() {
		return WHITE_COUNT_MAX;
	}

	public int getYELLOW_COUNT_MAX() {
		return YELLOW_COUNT_MAX;
	}

	public int getPURPLE_COUNT_MAX() {
		return PURPLE_COUNT_MAX;
	}
	
	/*
	 * getters/setters ownsAll--- booleans
	 */
	
	public boolean isOwnsAllBlue() {
		return ownsAllColour[0];
	}

	public void setOwnsAllBlue(boolean ownsAllBlue) {
		ownsAllColour[0] = ownsAllBlue;
	}

	public boolean isOwnsAllPink() {
		return ownsAllColour[1];
	}

	public void setOwnsAllPink(boolean ownsAllPink) {
		ownsAllColour[1] = ownsAllPink;
	}

	public boolean isOwnsAllGreen() {
		return ownsAllColour[2];
	}

	public void setOwnsAllGreen(boolean ownsAllGreen) {
		ownsAllColour[2] = ownsAllGreen;
	}

	public boolean isOwnsAllGrey() {
		return ownsAllColour[3];
	}

	public void setOwnsAllGrey(boolean ownsAllGrey) {
		ownsAllColour[3] = ownsAllGrey;
	}

	public boolean isOwnsAllRed() {
		return ownsAllColour[4];
	}

	public void setOwnsAllRed(boolean ownsAllRed) {
		ownsAllColour[4] = ownsAllRed;
	}

	public boolean isOwnsAllWhite() {
		return ownsAllColour[5];
	}

	public void setOwnsAllWhite(boolean ownsAllWhite) {
		ownsAllColour[5] = ownsAllWhite;
	}

	public boolean isOwnsAllYellow() {
		return ownsAllColour[6];
	}

	public void setOwnsAllYellow(boolean ownsAllYellow) {
		ownsAllColour[6] = ownsAllYellow;
	}

	public boolean isOwnsAllPurple() {
		return ownsAllColour[7];
	}

	public void setOwnsAllPurple(boolean ownsAllPurple) {
		ownsAllColour[7] = ownsAllPurple;
	}

	public boolean[] getOwnsAllColour() {
		return ownsAllColour;
	}

	public void setOwnsAllColour(boolean[] ownsAllColour) {
		this.ownsAllColour = ownsAllColour;
	}

	public int[] getColourCount() {
		return colourCount;
	}

	public void setColourCount(int[] colourCount) {
		this.colourCount = colourCount;
	}
	
	String StreetsWithHousesToBuy[];
	
	public String[] listHousesToBuy(GameBoard gameBoard) {
		StreetsWithHousesToBuy = new String[gameBoard.gader.length];
		int index = 0;
		for (Gade gade : gameBoard.gader) {
			if(this.getOwnsAllColour()[gade.getColourIndex()] == true){
				StreetsWithHousesToBuy[index++] = gade.getFieldName();				
			}
		}
		return StreetsWithHousesToBuy;
	}
	
	private int numberOfColorsFullyOwned = 0; 

	public int checkForHouseColours() {
		for(int i = 0; i < this.getColourCount().length; i++) {
			if(this.getColourCount()[i] == this.MAX_COLOUR[i]	){
				this.getOwnsAllColour()[i] = true;	
				numberOfColorsFullyOwned++;
			}
		
		}
		return numberOfColorsFullyOwned;
	}
	
	public int getNumberOfColorsFullyOwned() {
		return numberOfColorsFullyOwned;
	}
	
	public void setNumberOfColorsFullyOwned(int numberOfColorsFullyOwned) {
		this.numberOfColorsFullyOwned = numberOfColorsFullyOwned;
	}
}

