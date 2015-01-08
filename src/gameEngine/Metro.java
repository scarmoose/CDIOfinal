package gameEngine;

import javax.swing.JOptionPane; 

public class Metro extends Felt{
	
	
		
		private int metroFine;
		
		public Metro(String fieldName, int metroFine){
			super(fieldName);
			this.metroFine = metroFine;
		}
		public int getmetroFine() {
			return metroFine;
		}
		
		@Override
		public void landOnField(Spiller playerWhoLanded) {
			int result = (int)(Math.random()*100);
			if(result >= 20 && result <=20){
				playerWhoLanded.getAccount().withdraw(metroFine);
				System.out.println("Du har fået en bøde, for at køre uden billet.");
			}
			}
}
