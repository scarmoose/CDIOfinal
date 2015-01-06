package gameEngine;

public class Account {
	
	private int balance;
	/**
	 * 
	 * @param balance the balance of the player.
	 */
	public Account(int balance) {
		this.balance = balance;
	}
	
	public Account() {
		balance = 30000;
	}
	
	/**
	 * 
	 * @param amount is the points you wish deposited to the players account
	 * @return a string that states if the method succeded or failed.
	 */
	public String deposit(int amount) {
		if(amount >= 0) {  
			balance += amount;
			return "Deposit succesful";
		} else return "Deposit unsuccesful. Please deposit positive amount";
	}
	/**
	 * 
	 * @param amount is the points wish to remove from a given players account
	 * @return a string that states if the method succeded or failed.
	 */
	public String withdraw(int amount) {
		if(amount<=balance) {
			balance -= amount;
			return "Withdrawal succesful";
		} else if(amount>balance){
			balance = 0;
			return "Withdrawal unsuccesful. Cannot withdraw amount larger than balance ";
		}
		return "";
	}
	/**
	 * 
	 * @return the balance from the players account
	 */
	public int getBalance() {
		return balance;
	}
	/**
	 * 
	 * @param balance sets the balance of a given player
	 */
	
	public void setBalance(int balance) {
		if(balance >= 0) {
			this.balance = balance;
		} 
	}
	
	/**
	 * returns the balance as balance: + balance.
	 */
	public String toString() {
		return "balance: " + balance;
	}

}
