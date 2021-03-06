package gameEngine;

public abstract class Felt {
	

	
	String fieldName;
	
	
	/**
	 * Constructs a field with a name and a number
	 * @param fieldName Name of field
	 * @param fieldNumber Number of field
	 */
	
	public Felt(String fieldName) {
		this.fieldName = fieldName; 
	}
	/**
	 * This is used to have an effect on a given player depending on the field which 
	 * it landed on.
	 * 
	 * @param player the player who have landed on the current field
	 */
	public abstract void landOnField(Spiller player);
	

}






