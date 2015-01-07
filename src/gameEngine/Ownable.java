package gameEngine;

public abstract class Ownable extends Felt {
	
	private String name;
	private Spiller owner;
	private int price;
	private int housesOnField = 0; 
	private final int MAX_HOUSES_ON_FIELD = 4;
	
	
	/**
	 * Creates ownable field without owner
	 * @param fieldName name of field
	 * @param fieldNumber number of field on the game board
	 * @param price price of the field
	 */
	
	public Ownable(String fieldName, int price) {
		super(fieldName); 
		this.price = price;
		this.owner = null;
	}
	
	public String getFieldName() {
		return fieldName; 
	}
	
	public int getHousesOnField() {
		return housesOnField;
	}
	
	public void buyHouse() {
		if(housesOnField < MAX_HOUSES_ON_FIELD) {
			housesOnField++;			
		}
	}
	
	public void setPrice(int price) {
		this.price = price; 
	}
	
	public int getPrice() {
		return price; 
	}
	
	public Spiller getOwner() {
		return owner; 
	}
	
	public void setOwner(Spiller owner) {
		this.owner = owner; 
	}
	public void setOwnerName(String name) { 
		this.name = name;
	}
	public String getOwnerName() {
		return name; 
	}
	
	public boolean isBuyable() {
		return owner == null;
	}
	
	public abstract int getRent();
}
