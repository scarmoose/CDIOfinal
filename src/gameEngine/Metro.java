package gameEngine;

import boundaryToMatador.GUI;

public class Metro extends Felt{
	
	
		
		private int metroFine = 750; //Set fine to 750
		private int metroBonus = 500;
		private int rejsekortFine = 150;
		private int plads[]={2,7,17,22,33,36};
		private int update[]={6,11,6,11,4,7};
		private int i = 0;
		
		public Metro(String fieldName){
			super(fieldName);
		}
		public int getmetroFine() {
			return metroFine;
		}
		
		@Override
		public void landOnField(Spiller playerWhoLanded) {
			int result = (int)(1);//(int)(Math.random()*1)+ // 8 random Places for the Switch statsment. And +1 for make go from 1-8 and not 0-7.
			
			while(playerWhoLanded.getCurrentPos() !=plads[i]){
				i++;
			}
	
				switch (result){
				case 1:
					playerWhoLanded.getAccount().withdraw(metroFine); //withdraw to the players account
					System.out.println("Du har fået en bøde, for at køre uden billet. Betal " + metroFine +",-");
					GUI.showMessage("Du har fået en bøde, for at køre uden billet. Betal " + metroFine +",-");
					GUI.removeAllCars(playerWhoLanded.getName());
					GUI.removeAllCars(playerWhoLanded.getName());
					playerWhoLanded.updateCurrentPos(update [i]);
					GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					
					
//					
//					if (playerWhoLanded.getCurrentPos() == i){
//						GUI.removeAllCars(playerWhoLanded.getName());
//						playerWhoLanded.updateCurrentPos(6);
//						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
//					}
//					else if(playerWhoLanded.getCurrentPos() == 7){
//						GUI.removeAllCars(playerWhoLanded.getName());
//						playerWhoLanded.updateCurrentPos(11);
//						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
//					}
//					else if(playerWhoLanded.getCurrentPos() == 17){
//						GUI.removeAllCars(playerWhoLanded.getName());
//						playerWhoLanded.updateCurrentPos(6);
//						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
//					}
//					else if(playerWhoLanded.getCurrentPos() == 22){
//						GUI.removeAllCars(playerWhoLanded.getName());
//						playerWhoLanded.updateCurrentPos(11);
//						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
//					}
//					else if(playerWhoLanded.getCurrentPos() == 33){
//						GUI.removeAllCars(playerWhoLanded.getName());
//						playerWhoLanded.updateCurrentPos(4);
//						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
//					}
//					else if(playerWhoLanded.getCurrentPos() == 36){
//						GUI.removeAllCars(playerWhoLanded.getName());
//						playerWhoLanded.updateCurrentPos(7);
//						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
//					}
					break;
				case 2:
					playerWhoLanded.getAccount().deposit(metroBonus); //Deposit Bonus to the  players account
					System.out.println("Du retuner en tegnebog til retmæssige ejer. Du får en findeløn " + metroBonus +",-");
					GUI.showMessage("Du retuner en tegnebog til retmæssige ejer. Du får en findeløn " + metroBonus +",-");
					if (playerWhoLanded.getCurrentPos() == 2){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(6);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 7){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(11);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 17){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(6);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 22){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(11);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 33){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(4);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 36){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(7);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					break;
				case 3:
					System.out.println("Du har taget Metroen den forkerte vej. Rykkes tilbage til Forige Station");
					GUI.showMessage("Du har taget Metroen den forkerte vej. Rykkes tilbage til Forige Station");
					if (playerWhoLanded.getCurrentPos() == 2){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(35);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 7){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(-4);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 17){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(-9);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 22){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(-4);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 33){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(-10);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 36){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(-2);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					break;
				case 4:
					System.out.println("Du har huske Rejsekortet idag. Ryk frem til Næste Station");
					GUI.showMessage("Du har huske Rejsekortet idag. Ryk frem til Næste Station");
					if (playerWhoLanded.getCurrentPos() == 2){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(6);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 7){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(11);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 17){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(6);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 22){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(11);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 33){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(4);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 36){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(7);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					break;
				case 5:
					playerWhoLanded.getAccount().withdraw(rejsekortFine); //withdraw to the players account
					System.out.println("Du har ikke tjekket ud med Rejsekortet. Du få en bøde på." + rejsekortFine + ",-");
					GUI.showMessage("Du har ikke tjekket ud med Rejsekortet. Du få en bøde på." + rejsekortFine + ",-");
					if (playerWhoLanded.getCurrentPos() == 2){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(6);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 7){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(11);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 17){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(6);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 22){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(11);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 33){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(4);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 36){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(7);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					break;
				case 6:
					System.out.println("Du tog Metroen den forkerte vej. Rykkes tilbage til Forige Station");
					GUI.showMessage("Du tog Metroen den forkerte vej. Rykkes tilbage til Forige Station");
					if (playerWhoLanded.getCurrentPos() == 2){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(6);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 7){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(11);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 17){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(6);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 22){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(11);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 33){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(4);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 36){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(7);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					break;
				case 7:
					System.out.println("Du huske Ungdomskortet idag. Ryk frem til Næste Station");
					GUI.showMessage("Du huske Ungdomskortet idag. Ryk frem til Næste Station");
					if (playerWhoLanded.getCurrentPos() == 2){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(6);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 7){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(11);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 17){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(6);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 22){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(11);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 33){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(4);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 36){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(7);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					break;
				case 8:
					System.out.println("Du faldt i søvn i Metron. Du rykkes 2 Stationer frem. Ingen Bonus ved passering ved start");
					GUI.showMessage("Du faldt i søvn i Metron. Du rykkes 2 Stationer frem. Ingen Bonus ved passering ved start");
					if (playerWhoLanded.getCurrentPos() == 2){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(16);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 7){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(16);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 17){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(16);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 22){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(15);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
					}
					else if(playerWhoLanded.getCurrentPos() == 33){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(10);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
						playerWhoLanded.getAccount().withdraw(-4000);
					}
					else if(playerWhoLanded.getCurrentPos() == 36){
						GUI.removeAllCars(playerWhoLanded.getName());
						playerWhoLanded.updateCurrentPos(12);
						GUI.setCar(playerWhoLanded.getCurrentPos(), playerWhoLanded.getName());
						playerWhoLanded.getAccount().withdraw(-4000);
					}
					break;
					
				}
				
					
				
				
				}
				
		
}
