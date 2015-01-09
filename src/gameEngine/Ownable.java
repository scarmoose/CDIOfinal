package gameEngine;

public abstract class Ownable extends Felt {
	
	private String name;
	private Spiller owner;
	private int price;
	private int pawnPrice;
	private boolean isPawned;
	
	
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
	
	public int getPawnPrice() {
		return pawnPrice; 
	}
	
	public boolean isPawned() {
		return isPawned;
	}
	
	/**
	 * Pawns property and returns half the buy price to the owners account.
	 */
	
	public void pawnProperty() {
		isPawned = true; 
		owner.getAccount().deposit(pawnPrice);
	}
	
	public boolean isBuyable() {
		return owner == null;
	}
	
	public abstract int getRent();
}
