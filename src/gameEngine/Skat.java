package gameEngine;

//import javax.swing.JOptionPane; 

public class Skat extends Felt {
	
	
	private int baseTax;
	private double percentTax;  
	
	/**
	 * Constructs a field of type Tax
	 * @param fieldName name of field
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
		if(playerWhoLanded.getAccount().getBalance() >= 10*baseTax) {
			playerWhoLanded.getAccount().withdraw(baseTax);
		}
		else playerWhoLanded.getAccount().withdraw((int) ((percentTax/100.0) * playerWhoLanded.getAccount().getBalance()));
	}

}
