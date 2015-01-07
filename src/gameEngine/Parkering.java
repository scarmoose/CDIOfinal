package gameEngine;

public class Parkering extends Felt{

	
	private int bonus;
	/**
	 * Construct for the class Refugee 
	 * 
	 * @param fieldName Name of the field
	 * @param fieldNumber number of the field
	 * @param bonus the value of the bonus a player should recieve when he lands on the field
	 */
	
	public Parkering(String fieldName, int bonus){
		super(fieldName);
		this.bonus = bonus;
	}
	/**
	 * The play who landed on the field recieves a set bonus.
	 */
	@Override
	public void landOnField(Spiller playerWhoLandedOnField) {
		playerWhoLandedOnField.getAccount().deposit(bonus);
		System.out.println(playerWhoLandedOnField.getName()+" recieved "+bonus);
	}
	
}
