package gameEngine;

import boundaryToMatador.GUI;

public class Metro extends Felt{
	
	
		
		private int metroFine = 750; //Set fine to 750
		
		public Metro(String fieldName){
			super(fieldName);
		}
		public int getmetroFine() {
			return metroFine;
		}
		
		@Override
		public void landOnField(Spiller playerWhoLanded) {
			int result = (int)(Math.random()*100);
			if(result >= 1 && result <=100){ // Make i a 1 out of 5 chance to get a fine
				playerWhoLanded.getAccount().withdraw(metroFine); //withdraw to the players account
				System.out.println("Du har fået en bøde, for at køre uden billet. Betal " + metroFine +",-");
				GUI.showMessage("Du har fået en bøde, for at køre uden billet. Betal " + metroFine +",-");
			}
			
			}
		
}
