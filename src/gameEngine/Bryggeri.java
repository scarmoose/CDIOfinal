package gameEngine;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Bryggeri extends Ownable {
	
	private int baseRent = 100;
	
	private final int BreweriRENT_1 = baseRent*Terning.getLastRoll();
	private final int BreweriRENT_2 = 2*baseRent*Terning.getLastRoll();
	
	/**
	 * Constructs a Labor Camp
	 * @param fieldName Name of field
	 * @param fieldNumber Number of field
	 * @param price Price of field
	 */
	
	public Bryggeri(String fieldName, int price){ 
		super(fieldName, price);
	}

	public int getRent() {
		switch (super.getOwner().getBreweriesOwned()){
		
		case 1:
			return BreweriRENT_1;
		case 2:
			return BreweriRENT_2;
		default:
			return 0;
	}
	}
	
	/**
	 * Prompts the player if he wants to buy a not-owned fleet if players account balance > price
	 * @param playerWhoLandedOnField player who landed on the field
	 */
	
	public void buyProperty(Spiller playerWhoLandedOnField){
		if(playerWhoLandedOnField.getAccount().getBalance()<super.getPrice()){
			final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "Ikke penge nok.", "Service meddelelse",
			JOptionPane.WARNING_MESSAGE);
			return;
		}
		else{
		super.setOwner(playerWhoLandedOnField);
		super.setOwnerName(playerWhoLandedOnField.getName());
		playerWhoLandedOnField.getAccount().withdraw(getPrice());
		System.out.println(playerWhoLandedOnField.getName()+" købte "+fieldName+" for "+getPrice());
		}
	}
	
	/**
	 * Updates balances of the owner and the player who landed.
	 * If the field is not owned, the player who landed on there can choose to buy it.
	 * @param playerWhoLandedOnField player who landed on the field
	 */

	public void landOnField(Spiller playerWhoLandedOnField) { 
		if(super.getOwner() != null){
			playerWhoLandedOnField.getAccount().withdraw(getRent());
			super.getOwner().getAccount().deposit(getRent());
			System.out.println(playerWhoLandedOnField.getName()+" betalte "+getRent()+" til "+getOwnerName());
		}
		else{
			Object[] options = {
					"Køb nu!",
                    "Nej, ellers tak.",};
			int buttonPressed = JOptionPane.showOptionDialog(null,
					"Ønsker du ("+playerWhoLandedOnField.getName()+") at eje "+ super.getFieldName()+"? Pris: "+super.getPrice(),
					"BESLUT DIG NU!",
					JOptionPane.WARNING_MESSAGE,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options, 
					options[0]);
			
			if(buttonPressed == 0){
				buyProperty(playerWhoLandedOnField);
			}	
			else if(buttonPressed == 1){
				return;
			}	
		}
	}
}
