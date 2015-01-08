package gameEngine;

public class Spiller {

	private String name;
	private int fleetsOwned = 0;
	private int breweriesOwned = 0;
	private int currentPos = 0;
	private Konto playerAcc = new Konto(); 


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
			currentPos = currentPos - 39;
			this.getAccount().deposit(4000); //4000 when START is passed
			System.out.println(name+ " fik 4000 for at passere START");
		}		
		return currentPos;
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
