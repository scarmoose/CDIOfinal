package gameEngine;

public class Die {
	
	private final int MAX = 6; //max value of die
	private int faceValue1; //shows current value of roll 1
	private int faceValue2; //Shows current value of roll 2
	private static int lastRoll;
	
	/**
	 * Rolls two dices, saves these in faceValue1 and faceValue2
	 * Saves the combined value of faceValue1 and faceValue2 in lastRoll.
	 * @return returns the total roll of both dices
	 */
	public int rollDie(){
		
		faceValue1 = (int) (Math.random() * MAX) + 1;
		faceValue2 = (int) (Math.random() * MAX) + 1;	
		lastRoll = faceValue1+faceValue2;		
		return lastRoll;
		
	}
	/**
	 * 
	 * @return faceValue1, one of the dice rolls.
	 */
	public int getFaceValue1() {
		return faceValue1;
	}
	/**
	 * 
	 * @return faceValue2, one of the dice rolls.
	 */
	public int getFaceValue2(){
		return faceValue2;
	
	}
	/**
	 * 
	 * @param faceValue sets the faceValue1 to the given parameter
	 */
	public void setFaceValue1(int faceValue) {
		this.faceValue1 = faceValue;
	}
	/**
	 * 
	 * @param faceValue sets the faceValue2 to the given parameter
	 */
	public void setFaceValue2(int faceValue) {
		this.faceValue2 = faceValue;
	}
	/**
	 * 
	 * @param roll sets the value of the last
	 */
	public void setLastRoll(int roll){
		lastRoll = roll;
	}
	/**
	 * 
	 * @return the current value of lastRoll
	 */
	public static int getLastRoll(){
		return lastRoll;
	}
}


