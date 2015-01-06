package gameEngine;

import javax.swing.JOptionPane; 

public class Tax extends Fields {
	
	
	private int baseTax;
	private double percentTax;  
	
	/**
	 * Constructs a field of type Tax
	 * @param fieldName name of field
	 * @param fieldNumber number of field on the game board
	 * @param baseTax Base tax
	 * @param percentTax Percent tax in whole numbers. i.e. 10% is 10.
	 */
	
	public Tax(String fieldName, int fieldNumber, int baseTax, int percentTax) {
		super(fieldName, fieldNumber);
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
	public void landOnField(Player playerWhoLanded) {
		if(percentTax == 0) {
			playerWhoLanded.getAccount().withdraw(baseTax);
			System.out.println(playerWhoLanded.getName()+" landed on "+fieldName+" and paid "+baseTax);
		}
		else {
			Object[] options = {
					"10% of your fortune",
                    "4000 straight",};
			int buttonPressed = JOptionPane.showOptionDialog(null,
    "Do you want to pay 10% of your fortune or 4000?",
    "DECIDE NOW!",
    JOptionPane.WARNING_MESSAGE,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options, 
    options[0]);
			if(buttonPressed == 0){
				playerWhoLanded.getAccount().withdraw((int) ((percentTax/100.0) * playerWhoLanded
						.getAccount().getBalance()));
				System.out.println(playerWhoLanded.getName()+" landed on "+fieldName+" and paid "+(((10*playerWhoLanded
						.getAccount().getBalance())/9)-(playerWhoLanded
								.getAccount().getBalance())));
			}
			if(buttonPressed == 1) {
				playerWhoLanded.getAccount().withdraw(baseTax);
				System.out.println(playerWhoLanded.getName()+" landed on "+fieldName+" and paid "+baseTax);
			}
		}
	}

}
