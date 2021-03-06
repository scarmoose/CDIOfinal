package gameEngine;

import desktop_resources.GUI;


public class Fængsel extends Felt{

	
	private int PrisonPos = 11;
	
	public Fængsel(String fieldName){
		super(fieldName);
	}
	/**
	 * The play who landed on the field gets put in prison
	 */
	@Override
	public void landOnField(Spiller playerWhoLandedOnField) {
		GUI.showMessage("Du rykkes til fængsel feltet");
		System.out.println(playerWhoLandedOnField.getName()+" ryger i fængsel");
		GUI.removeAllCars(playerWhoLandedOnField.getName());//Removes the player from the board.
		//sets car at field corresponding to the value of the players position
		GUI.setCar(PrisonPos, playerWhoLandedOnField.getName());
		playerWhoLandedOnField.updateCurrentPos(-20);;
		playerWhoLandedOnField.incrementPrisonCount();
	}
	
}
