package gameEngine;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gade extends Ownable {
	
	private int rent; 
	private int housesOnField = 0; 
	private final int MAX_HOUSES_ON_FIELD = 5; //4 houses + 1 hotel
	private int[] houseRent = new int[5];
	
	/**
	 * Sets the rent of the field with houses and hotel
	 * @param rent1house rent of field with 1 house
	 * @param rent2houses rent of field with 2 houses
	 * @param rent3houses rent of field with 3 houses
	 * @param rent4houses rent of field with 4 houses
	 * @param renthotel rent of field with 1 hotel
	 */
	
	public void setHouseRent(int rent1house, int rent2houses, int rent3houses, int rent4houses, int renthotel) {
		houseRent[0] = rent1house; 
		houseRent[1] = rent2houses;
		houseRent[2] = rent3houses;
		houseRent[3] = rent4houses;
		houseRent[4] = renthotel;
	}
	
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
			JOptionPane.showMessageDialog(panel, "Ikke nok penge.", "Service meddelelse",
			JOptionPane.WARNING_MESSAGE);
			return;
		}
		else{
		super.setOwner(lander);
		super.setOwnerName(lander.getName());
		lander.getAccount().withdraw(getPrice());
		System.out.println(lander.getName()+" k�bte "+fieldName+" for "+getPrice());
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
			System.out.println(lander.getName()+" betalte "+rent+" til "+getOwnerName());
		}
		else{				
			Object[] options = {
					"K�b nu!!",
                    "Nej, ellers tak.",};
			int buttonPressed = JOptionPane.showOptionDialog(null,
					"�nsker du at eje denne gade?",
					"BESLUT DIG NU!",
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



