package gameEngine;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import desktop_resources.GUI;


public class Gade extends Ownable {
	
	private int rent; 
	private int housesOnField = 0; 
	private final int MAX_HOUSES_ON_FIELD = 5; //4 houses + 1 hotel
	private int[] houseRent = new int[5];
	private int housePrice;	
	private String colour;
	
	public String getColour() {
		return colour;
	}
	
	public int getHousePrice() {
		return housePrice;
	}
	
	/**
	 * will return the index of the colour in form of its position position on the game board. blue = 0, pink = 1, etc.
	 * @return the colour index
	 */
	public int getColourIndex() {
		if(colour.equals("blue")) {
			return 0;
		}else if(colour.equals("pink")) {
			return 1;
		}else if(colour.equals("green")) {
			return 2;
		}else if(colour.equals("grey")) {
			return 3; 
		}else if(colour.equals("red")) {
			return 4;
		}else if(colour.equals("white")) {
			return 5;
		}else if(colour.equals("yellow")) {
			return 6;
		}else if(colour.equals("purple")) {
			return 7;
		}else return 0;
	}
	public void setColour(String colour) {		
		this.colour = colour;
	}

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
	
	public Gade(String fieldName, int price, int rent, String colour, int housePrice) {
		super(fieldName, price);
		this.rent = rent;
		this.colour = colour;
		this.housePrice = housePrice;
	}
	
	public int getHousesOnField() {
		return housesOnField;
	}
	
	public int getMAX_HOUSES_ON_FIELD() {
		return MAX_HOUSES_ON_FIELD;
	}
	
	/**
	 * if there is room on the chosen field, this will build the selected number of houses on the property.
	 * if the player can't afford it, no houses will be bought.
	 * if number of houses on a field is 5, a hotel will be set instead.
	 * @param lander the player who wants to buy houses
	 * @param houseCount the number of houses the player wants to buy
	 * @param fieldNumber the field number of the field the player wants to buy houses on
	 */
	
	public void buyHouse(Spiller lander, int houseCount, int fieldNumber) {
		System.out.println(this.fieldName);
		if(housesOnField < MAX_HOUSES_ON_FIELD) {
//			System.out.println("Xasda"+getOwner());
			if(super.getOwner().getAccount().getBalance()>housePrice){
				housesOnField = housesOnField + houseCount;	
				lander.getAccount().withdraw(houseCount * housePrice);
				if(housesOnField<=4){
					System.out.println("qwerty "+fieldNumber+ " "+houseCount);
					System.out.println(super.getOwnerName() +" har købt "+houseCount+" hus(e) på "+super.getFieldName());
					GUI.showMessage(super.getOwnerName() +" har købt "+houseCount+" hus(e) på "+super.getFieldName());
					System.out.println(super.getOwnerName() + " ejer nu " + getHousesOnField() + " huse på " + super.getFieldName());
					GUI.setHouses(fieldNumber+1, housesOnField);					
				}else if(housesOnField>4){
					GUI.setHotel(fieldNumber+1, true);
					System.out.println(super.getOwnerName()+" har købt et hotel på "+super.getFieldName());					
				}
			
			}
			else{
				System.out.println(super.getOwnerName()+" kan ikke bygge flere huse eller hoteller på "+super.getFieldName());
				GUI.showMessage(super.getOwnerName()+" kan ikke bygge flere huse eller hoteller på "+super.getFieldName());
			}
		}
	}
	
	/**
	 * Prompts the player if he wants to buy a not-owned fleet,
	 * if players account balance is more than the price of the property.
	 * If the property is bought, the players corresponding colour count will increment
	 * @param lander player who landed on the field
	 */
	
	public void buyProperty(Spiller lander){
//		System.out.println("BuyProperty" + lander.getName());
		if(lander.getAccount().getBalance()<super.getPrice()){
			final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "Du har ikke penge nok", "Service meddelelse",
			JOptionPane.WARNING_MESSAGE);
			return;
		}
		else{
		super.setOwner(lander);
		super.setOwnerName(lander.getName());
		lander.getAccount().withdraw(getPrice());
		System.out.println(lander.getName()+" købte "+fieldName+" for "+getPrice());
		GUI.setOwner(lander.getCurrentPos()+1, lander.getName());
			//Switch only works in 1.7 or newer version, so we went with this instead
			if(colour.equals("blue")){
				lander.incrementBlueOwned();
			}
			else if(colour.equals("pink")){
				lander.incrementPinkOwned();
			}
			else if(colour.equals("green")){
				lander.incrementGreenOwned();
			}
			else if(colour.equals("grey")){
				lander.incrementGreyOwned();
			}
			else if(colour.equals("red")){
				lander.incrementRedOwned();
			}
			else if(colour.equals("white")){
				lander.incrementWhiteOwned();
			}
			else if(colour.equals("yellow")){
				lander.incrementYellowOwned();
			}
			else if(colour.equals("purple")){
				lander.incrementPurpleOwned();
			}
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
			if(housesOnField>0){
				lander.getAccount().withdraw(houseRent[housesOnField-1]);
				super.getOwner().getAccount().deposit(houseRent[housesOnField-1]);
			}
			else{
			lander.getAccount().withdraw(rent);
			super.getOwner().getAccount().deposit(rent);
			System.out.println(lander.getName()+" betalte "+rent+" til "+getOwnerName());
			}
			}
		else{				
			Object[] options = {
					"Køb nu!",
                    "Nej, ellers tak!",};
			int buttonPressed = JOptionPane.showOptionDialog(null,
					"Ønsker du ("+lander.getName()+") at eje "+ super.getFieldName()+"? Pris: "+ super.getPrice(),
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



