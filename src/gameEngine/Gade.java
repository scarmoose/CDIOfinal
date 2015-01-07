package gameEngine;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gade extends Ownable {
	
	private int rent; 
	private int housesOnField = 0; 
	private final int MAX_HOUSES_ON_FIELD = 4;
	
	/**
	 * Constructs a Territory field
	 * @param fieldName name of the field
	 * @param price price of the field
	 * @param rent rent of the field 
	 */
	
	public Gade(String fieldName, int price, int rent) {
		super(fieldName, price);
		this.rent = rent;
	}
	
	public int getHousesOnField() {
		return housesOnField;
	}
	
	public void buyHouse() {
		if(housesOnField < MAX_HOUSES_ON_FIELD) {
			housesOnField++;			
		}
	}
	
	/**
	 * Prompts the player if he wants to buy a not-owned fleet if players account balance > price
	 * @param lander player who landed on the field
	 */
	
	public void buyProperty(Spiller lander){
		if(lander.getAccount().getBalance()<super.getPrice()){
			final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "Insufficient funds", "Service message",
			JOptionPane.WARNING_MESSAGE);
			return;
		}
		else{
		super.setOwner(lander);
		super.setOwnerName(lander.getName());
		lander.getAccount().withdraw(getPrice());
		System.out.println(lander.getName()+" bought "+fieldName+" for "+getPrice());
		}
	}
	
	/**
	 * Updates balances of the owner and the player who landed.
	 * If the field is not owned, the player who landed on there can choose to buy it.
	 * @param player player who landed on the field
	 */

	@Override
	public void landOnField( Spiller lander){
		if (super.getOwner() != null){
			lander.getAccount().withdraw(rent);
			super.getOwner().getAccount().deposit(rent);
			System.out.println(lander.getName()+" paid "+rent+" in rent to "+getOwnerName());
		}
		else{				
			Object[] options = {
					"Buy it now!",
                    "No, thank you",};
			int buttonPressed = JOptionPane.showOptionDialog(null,
					"Do you wish to own this property? (Territory-property)",
					"DECIDE NOW!",
					JOptionPane.WARNING_MESSAGE,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options, 
					options[0]);
			
			if(buttonPressed == 0){
				buyProperty(lander);
			}	
			else if(buttonPressed == 1){
				return;
			}
			
		}
		
	}
	@Override
	public int getRent() {
		return rent;
	}
		
	
}



