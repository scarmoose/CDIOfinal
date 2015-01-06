package gameEngine;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LaborCamp extends Ownable {
	
	private int baseRent = 100;
	
	/**
	 * Constructs a Labor Camp
	 * @param fieldName Name of field
	 * @param fieldNumber Number of field
	 * @param price Price of field
	 */
	
	public LaborCamp(String fieldName, int fieldNumber, int price){ 
		super(fieldName, fieldNumber, price);
	}

	public int getRent() {
		return baseRent * Die.getLastRoll();
	}
	
	/**
	 * Prompts the player if he wants to buy a not-owned fleet if players account balance > price
	 * @param playerWhoLandedOnField player who landed on the field
	 */
	
	public void buyProperty(Player playerWhoLandedOnField){
		if(playerWhoLandedOnField.getAccount().getBalance()<super.getPrice()){
			final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "Insufficient funds", "Service message",
			JOptionPane.WARNING_MESSAGE);
			return;
		}
		else{
		super.setOwner(playerWhoLandedOnField);
		super.setOwnerName(playerWhoLandedOnField.getName());
		playerWhoLandedOnField.getAccount().withdraw(getPrice());
		System.out.println(playerWhoLandedOnField.getName()+" bought "+fieldName+" for "+getPrice());
		}
	}
	
	/**
	 * Updates balances of the owner and the player who landed.
	 * If the field is not owned, the player who landed on there can choose to buy it.
	 * @param playerWhoLandedOnField player who landed on the field
	 */

	public void landOnField(Player playerWhoLandedOnField) { 
		if(super.getOwner() != null){
			playerWhoLandedOnField.getAccount().withdraw(getRent());
			super.getOwner().getAccount().deposit(getRent());
			System.out.println(playerWhoLandedOnField.getName()+" paid "+getRent()+" in rent to "+getOwnerName());
		}
		else{
			Object[] options = {
					"Buy it now!",
                    "No, thank you",};
			int buttonPressed = JOptionPane.showOptionDialog(null,
					"Do you wish to own this property? (LaborCamp-property)",
					"DECIDE NOW!",
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
