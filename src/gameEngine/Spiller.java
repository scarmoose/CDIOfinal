package gameEngine;

public class Spiller {

	private String name;
	private int fleetsOwned = 0;
	private int breweriesOwned = 0;
	private int currentPos = 0;
	private Konto playerAcc = new Konto(); 
	private int PrisonCount = 0;

	public int getPrisonCount() {
		return PrisonCount;
	}

	public void incrementPrisonCount() {
		this.PrisonCount = this.PrisonCount + 1;
	}
	
	public void resetPrisonCount() {
		PrisonCount = 0;
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
		if(currentPos == 21)
		{
			currentPos = 11;
		}
		if(currentPos > 39){
			currentPos = currentPos - 40;
			this.getAccount().deposit(4000); //4000 when START is passed
			System.out.println(name+ " fik 4000 for at passere START");
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

}
