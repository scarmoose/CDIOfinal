package gameEngine;

import boundaryToMatador.GUI;

public class Metro extends Felt{
	
	
		
		private int metroFine = 750; //Set fine to 750
		private int metroBonus = 500;
		private int rejsekortFine = 150;
		
		public Metro(String fieldName){
			super(fieldName);
		}
		public int getmetroFine() {
			return metroFine;
		}
		
		@Override
		public void landOnField(Spiller playerWhoLanded) {
			int result = (int)((Math.random()*8)+1);
			
	
				switch (result){
				case 1:
					playerWhoLanded.getAccount().withdraw(metroFine); //withdraw to the players account
					System.out.println("Du har fået en bøde, for at køre uden billet. Betal " + metroFine +",-");
					GUI.showMessage("Du har fået en bøde, for at køre uden billet. Betal " + metroFine +",-");
					break;
				case 2:
					playerWhoLanded.getAccount().deposit(metroBonus); //Deposit Bonus to the  players account
					System.out.println("Du retuner en tegnebog til retmæssige ejer. Du får en findeløn " + metroBonus +",-");
					GUI.showMessage("Du retuner en tegnebog til retmæssige ejer. Du får en findeløn " + metroBonus +",-");
					break;
				case 3:
					System.out.println("Du har taget Metroen den forkerte vej. Du rykkes tilbage til forrige Station");
					GUI.showMessage("Du har taget Metroen den forkerte vej. Du rykkes tilbage til forrige Station");
					break;
				case 4:
					System.out.println("Du har husket rejsekortet idag. Ryk frem til Næste Station");
					GUI.showMessage("Du har husket rejsekortet idag. Ryk frem til Næste Station");
					break;
				case 5:
					playerWhoLanded.getAccount().withdraw(rejsekortFine); //withdraw to the players account
					System.out.println("Du har ikke tjekket ud med Rejsekortet. Du får en bøde på." + rejsekortFine + ",-");
					GUI.showMessage("Du har ikke tjekket ud med Rejsekortet. Du får en bøde på." + rejsekortFine + ",-");
					break;
				case 6:
					System.out.println("Du tog Metroen den forkerte vej. Du rykkes tilbage til forrige Station");
					GUI.showMessage("Du tog Metroen den forkerte vej. Du rykkes tilbage til forrige Station");
					break;
				case 7:
					System.out.println("Du har husket Ungdomskortet idag. Ryk frem til næste Station");
					GUI.showMessage("Du har husket Ungdomskortet idag. Ryk frem til næste Station");
					break;
				case 8:
					System.out.println("Du faldt i søvn i Metroen. Du rykkes 2 Stationer frem. Ingen Bonus ved passering ved start");
					GUI.showMessage("Du faldt i søvn i Metroen. Du rykkes 2 Stationer frem. Ingen Bonus ved passering ved start");
					break;
					
				}
				}
				
		
}
