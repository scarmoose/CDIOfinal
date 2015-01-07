package gameEngine;

import javax.swing.JOptionPane; 

public class Skat extends Felt {
	
	
	private int baseTax;
	private double percentTax;  
	
	/**
	 * Constructs a field of type Tax
	 * @param fieldName name of field
	 * @param fieldNumber number of field on the game board
	 * @param baseTax Base tax
	 * @param percentTax Percent tax in whole numbers. i.e. 10% is 10.
	 */
	
	public Skat(String fieldName, int baseTax, int percentTax) {
		super(fieldName);
		this.baseTax = baseTax;
		this.percentTax = percentTax; 
	}
	/**
	 * 
	 * @return the set baseTax, this is a int
	 */
	public int getBaseTax() {
		return baseTax;
	}
	/**
	 * 
	 * @return the percentTax, this is a double.
	 */
	public double getPercentTax() {
		return percentTax;
	}
	
	/**
	 * Withdraws the amount corresponding to the Labor Camp field.
	 * There is two scenarios, the player is prompted whether he wants to pay 10% or 4000
	 * or if the percentTax is 0 then he is given no option to choose and pays the baseTax.
	 * @param playerWhoLanded The player who landed on the field
	 */
	@Override
	public void landOnField(Spiller playerWhoLanded) {
		if(playerWhoLanded.getAccount().getBalance() >= 40000) {
			playerWhoLanded.getAccount().withdraw(4000);
		}
		else playerWhoLanded.getAccount().withdraw((int) (0.1 * playerWhoLanded.getAccount().getBalance()));
	}

}
