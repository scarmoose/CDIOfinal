package gameEngine;

public abstract class Fields {
	

	
	String fieldName;
	int fieldNumber;
	
	/**
	 * Constructs a field with a name and a number
	 * @param fieldName Name of field
	 * @param fieldNumber Number of field
	 */
	
	public Fields(String fieldName, int fieldNumber) {
		this.fieldName = fieldName; 
		this.fieldNumber = fieldNumber; 
	}
	/**
	 * This is used to have an effect on a given player depending on the field which 
	 * it landed on.
	 * 
	 * @param player the player who have landed on the current field
	 */
	public abstract void landOnField(Player player);
	

}






