package gameEngine;

public abstract class Ownable extends Felt {
	
	private String name;
	private Spiller owner;
	private int price;
	private int pawnPrice;
	
	
	/**
	 * Creates ownable field without owner
	 * @param fieldName name of field
	 * @param fieldNumber number of field on the game board
	 * @param price price of the field
	 */
	
	public Ownable(String fieldName, int price) {
		super(fieldName); 
		this.price = price;
		this.pawnPrice = (int) (price/2);
		this.owner = null;
	}
	
	public String getFieldName() {
		return fieldName; 
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
