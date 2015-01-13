package gameEngine;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Rederi extends Ownable {
	
	/**
	 * Constructs a field of the type Rederi
	 * @param fieldName The name of the field.
	 * @param fieldNumber Number of the field. 
	 * @param price the price of the field.
	 */
	
	public Rederi(String fieldName, int price) {
		super(fieldName, price);
	}
	
	/*
	 * The rent of the fleet corresponding to owner.getFleetsOwned()
	 */
	
	final int RENT_1 = 500;
	final int RENT_2 = 1000;
	final int RENT_3 = 2000;
	final int RENT_4 = 4000;

	/*
	 * (non-Javadoc) A switch made over the value of RENT_1 to RENT_4.
	 * @see gameEngine.Ownable#getRent() 
	 */
	
	@Override
	public int getRent(){
		switch (super.getOwner().getFleetsOwned()){
	
		case 1: 
			return RENT_1;
		case 2:
			return RENT_2;
		case 3:
			return RENT_3;
		case 4:
			return RENT_4;
		default:
			return 0;
				
		}
	}
	
	/**
	 * Prompts the player if he wants to buy a not-owned fleet if players account balance > price
	 * @param player player who landed on the field
	 */
	
	public void buyProperty(Spiller player){
		if (player.getAccount().getBalance()<super.getPrice()){
			final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "Du har ikke penge nok!", "Service meddelelse",
			JOptionPane.WARNING_MESSAGE);
			return;
		}
		else{
			super.setOwner(player);
			super.setOwnerName(player.getName());
			player.getAccount().withdraw(getPrice());
			super.getOwner().incrementFleetsOwned();
			System.out.println(player.getName()+" købte "+fieldName+" for "+getPrice());
		}
	}
	
	/**
	 * Updates balances of the owner and the player who landed.
	 * If the field is not owned, the player who landed on there can choose to buy it.
	 * @param player player who landed on the field
	 */
	
	@Override
	public void landOnField(Spiller player) {
		if (super.getOwner() != null){
			super.getOwner().getAccount().deposit(getRent());
			player.getAccount().withdraw(getRent());
			System.out.println(player.getName()+" betalte "+getRent()+" til "+getOwnerName());
		}
		else {
			//prompts the player to buy the field
			Object[] options = {
					"Køb nu!",
                    "Nej, ellers tak.",};
			int buttonPressed = JOptionPane.showOptionDialog(null,
					"Ønsker du ("+player.getName()+") at eje "+ super.getFieldName()+"? Pris: "+ super.getPrice(),
					"BESLUT DIG NU!",
					JOptionPane.WARNING_MESSAGE,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options, 
					options[0]);
			
			if(buttonPressed == 0){
				buyProperty(player);
			}	
			else if(buttonPressed == 1){
				return;
			}
		}
	}
}
