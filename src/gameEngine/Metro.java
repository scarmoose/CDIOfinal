package gameEngine;

import desktop_resources.GUI;


public class Metro extends Felt{



	private int metroFine = 750; //Set fine to 750
	private int metroBonus = 500; //bonus for finding the wallet
	private int rejsekortFine = 150;//fine for not having the travelcard at check
	private int fieldNumber[]={2,7,17,22,33,36}; // array over the metro fields
	private int updateOneSpaceAhead[]={6,11,6,12,4,7}; // array over the positive amount that there are add to the felt position to get to the next metro fields
	private int updateOneSpaceBack[]={35,-4,-9,-4,-10,-2};//array over the negative amount that there are add to the felt position to get to the next metro fields
	private int updateTwoSpaceAhead[]={16,16,17,15,10,12};//array over the double positive amount that there are add to the felt position to get to the next metro fields
	private int i = 0;

	public Metro(String fieldName){
		super(fieldName);
	}
	public int getMetroFine() {
		return metroFine;
	}

	@Override
	public void landOnField(Spiller playerWhoLanded) {

		int result = (int)((Math.random()*8)+1); // 8 random Places for the Switch statsment. And +1 for make it go from 1-8 insted of 0-7.

		while(playerWhoLanded.getCurrentPos() !=fieldNumber[i]){
			i++;
		}

		switch (result){
		case 1:
			playerWhoLanded.getAccount().withdraw(metroFine); //withdraw to the players account
			System.out.println("Du har fået en bøde for at køre uden billet. Betal " + metroFine +",-");
			GUI.showMessage("Du har fået en bøde for at køre uden billet. Betal " + metroFine +",-");
			GUI.removeAllCars(playerWhoLanded.getName()); //remove the car so it can be placed at the new position
			playerWhoLanded.updateCurrentPos(updateOneSpaceAhead [i]-1);//update the position to the new by adding the amount of the number in the array
			GUI.setCar(playerWhoLanded.getCurrentPos()+1, playerWhoLanded.getName());
			break;

		case 2:
			System.out.println("Du har husket dit rejsekortet i dag. Ryk frem til næste metro felt");
			GUI.showMessage("Du har husket dit rejsekortet i dag. Ryk frem til næste metro felt");
			GUI.removeAllCars(playerWhoLanded.getName());
			playerWhoLanded.updateCurrentPos(updateOneSpaceAhead [i]-1);
			GUI.setCar(playerWhoLanded.getCurrentPos()+1, playerWhoLanded.getName());
			break;

		case 3:

			playerWhoLanded.getAccount().deposit(metroBonus); //Deposit Bonus to the  players account
			System.out.println("Du finder en tegnebog, og retuner den til den retmæssige. For din gode gerning får du en findeløn. " + metroBonus +",-");
			GUI.showMessage("Du finder en tegnebog, og retuner den til den retmæssige. For din gerning får du en findeløn. " + metroBonus +",-");
			GUI.removeAllCars(playerWhoLanded.getName());
			playerWhoLanded.updateCurrentPos(updateOneSpaceAhead [i]-1);
			GUI.setCar(playerWhoLanded.getCurrentPos()+1, playerWhoLanded.getName());
			break;

		case 4:
			System.out.println("Du har husket dit rejsekortet i dag. Ryk frem til næste metro felt");
			GUI.showMessage("Du har husket dit rejsekortet i dag. Ryk frem til næste metro felt");
			GUI.removeAllCars(playerWhoLanded.getName());
			playerWhoLanded.updateCurrentPos(updateOneSpaceAhead [i]-1);
			GUI.setCar(playerWhoLanded.getCurrentPos()+1, playerWhoLanded.getName());
			break;

		case 5:
			playerWhoLanded.getAccount().withdraw(rejsekortFine); //withdraw to the players account
			System.out.println("Du har glemt at tjekke ud med dit rejsekort. Du modtager derfor en bøde på. " + rejsekortFine + ",-");
			GUI.showMessage("Du har glemt at tjekke ud med dit rejsekort. Du modtager derfor en bøde på. " + rejsekortFine + ",-");
			GUI.removeAllCars(playerWhoLanded.getName());
			playerWhoLanded.updateCurrentPos(updateOneSpaceAhead [i]-1);
			GUI.setCar(playerWhoLanded.getCurrentPos()+1, playerWhoLanded.getName());
			break;

		case 6:

			System.out.println("Du tog metroen den forkerte vej. Ryk tilbage til forrige metro felt");
			GUI.showMessage("Du tog metroen den forkerte vej. Ryk tilbage til forrige metro felt");
			GUI.removeAllCars(playerWhoLanded.getName());
			playerWhoLanded.updateCurrentPos(updateOneSpaceBack [i]-1);
			GUI.setCar(playerWhoLanded.getCurrentPos()+1, playerWhoLanded.getName());
			break;

		case 7:
			System.out.println("Du har husket dit rejsekort i dag. Ryk frem til næste metro felt");
			GUI.showMessage("Du har husket dit rejsekort i dag. Ryk frem til næste metro felt");
			GUI.removeAllCars(playerWhoLanded.getName());
			playerWhoLanded.updateCurrentPos(updateOneSpaceAhead [i]-1);
			GUI.setCar(playerWhoLanded.getCurrentPos()+1, playerWhoLanded.getName());
			break;

		case 8:
			System.out.println("Du faldt i søvn i metroen. Ryk 2 metro felter frem. Du modtager ikke 4000,-. hvis du passerer start feltet");
			GUI.showMessage("Du faldt i søvn i metroen. Ryk 2 metro felter frem. Du modtager ikke 4000,-. hvis du passerer start feltet");

			//withdraw 4000 from the account of the player so there dont get the bonus when the landed on field nr. 33
			if(playerWhoLanded.getCurrentPos() == 33 ){
				playerWhoLanded.getAccount().withdraw(4000);
				System.out.println("Trækker 4000 fra for at passer start");
			}
			else if(playerWhoLanded.getCurrentPos() == 36 ){
				playerWhoLanded.getAccount().withdraw(4000);
				System.out.println("Trækker 4000 fra for at passer start");
			}
			GUI.removeAllCars(playerWhoLanded.getName());
			playerWhoLanded.updateCurrentPos(updateTwoSpaceAhead [i]-1);
			GUI.setCar(playerWhoLanded.getCurrentPos()+1, playerWhoLanded.getName());
			break;

		}


	}
	public void landOnFieldTest(Spiller playerWhoLanded,int result) {	

		//int result = (int)((Math.random()*8)+1); // 8 random Places for the Switch statsment. And +1 for make it go from 1-8 insted of 0-7.
//
//		while(playerWhoLanded.getCurrentPos() !=fieldNumber[i]){
//			i++;
//		}

		switch (result){
		case 1:
			playerWhoLanded.getAccount().withdraw(metroFine); //withdraw to the players account
			System.out.println("Du har fået en bøde for at køre uden billet. Betal " + metroFine +",-");
			GUI.showMessage("Du har fået en bøde for at køre uden billet. Betal " + metroFine +",-");
			GUI.removeAllCars(playerWhoLanded.getName()); //remove the car so it can be placed at the new position
			playerWhoLanded.updateCurrentPos(updateOneSpaceAhead [i]-1);//update the position to the new by adding the amount of the number in the array
			GUI.setCar(playerWhoLanded.getCurrentPos()+1, playerWhoLanded.getName());
			break;

		case 2:
			System.out.println("Du har husket dit rejsekortet i dag. Ryk frem til næste metro felt");
			GUI.showMessage("Du har husket dit rejsekortet i dag. Ryk frem til næste metro felt");
			GUI.removeAllCars(playerWhoLanded.getName());
			playerWhoLanded.updateCurrentPos(updateOneSpaceAhead [i]-1);
			GUI.setCar(playerWhoLanded.getCurrentPos()+1, playerWhoLanded.getName());
			break;

		case 3:

			playerWhoLanded.getAccount().deposit(metroBonus); //Deposit Bonus to the  players account
			System.out.println("Du finder en tegnebog, og retuner den til den retmæssige. For din gode gerning får du en findeløn. " + metroBonus +",-");
			GUI.showMessage("Du finder en tegnebog, og retuner den til den retmæssige. For din gerning får du en findeløn. " + metroBonus +",-");
			GUI.removeAllCars(playerWhoLanded.getName());
			playerWhoLanded.updateCurrentPos(updateOneSpaceAhead [i]-1);
			GUI.setCar(playerWhoLanded.getCurrentPos()+1, playerWhoLanded.getName());
			break;

		case 4:
			System.out.println("Du har husket dit rejsekortet i dag. Ryk frem til næste metro felt");
			GUI.showMessage("Du har husket dit rejsekortet i dag. Ryk frem til næste metro felt");
			GUI.removeAllCars(playerWhoLanded.getName());
			playerWhoLanded.updateCurrentPos(updateOneSpaceAhead [i]-1);
			GUI.setCar(playerWhoLanded.getCurrentPos()+1, playerWhoLanded.getName());
			break;

		case 5:
			playerWhoLanded.getAccount().withdraw(rejsekortFine); //withdraw to the players account
			System.out.println("Du har glemt at tjekke ud med dit rejsekort. Du modtager derfor en bøde på. " + rejsekortFine + ",-");
			GUI.showMessage("Du har glemt at tjekke ud med dit rejsekort. Du modtager derfor en bøde på. " + rejsekortFine + ",-");
			GUI.removeAllCars(playerWhoLanded.getName());
			playerWhoLanded.updateCurrentPos(updateOneSpaceAhead [i]-1);
			GUI.setCar(playerWhoLanded.getCurrentPos()+1, playerWhoLanded.getName());
			break;

		case 6:

			System.out.println("Du tog metroen den forkerte vej. Ryk tilbage til forrige metro felt");
			GUI.showMessage("Du tog metroen den forkerte vej. Ryk tilbage til forrige metro felt");
			GUI.removeAllCars(playerWhoLanded.getName());
			playerWhoLanded.updateCurrentPos(updateOneSpaceBack [i]-1);
			GUI.setCar(playerWhoLanded.getCurrentPos()+1, playerWhoLanded.getName());
			break;

		case 7:
			System.out.println("Du har husket dit rejsekort i dag. Ryk frem til næste metro felt");
			GUI.showMessage("Du har husket dit rejsekort i dag. Ryk frem til næste metro felt");
			GUI.removeAllCars(playerWhoLanded.getName());
			playerWhoLanded.updateCurrentPos(updateOneSpaceAhead [i]-1);
			GUI.setCar(playerWhoLanded.getCurrentPos()+1, playerWhoLanded.getName());
			break;

		case 8:
			System.out.println("Du faldt i søvn i metroen. Ryk 2 metro felter frem. Du modtager ikke 4000,-. hvis du passerer start feltet");
			GUI.showMessage("Du faldt i søvn i metroen. Ryk 2 metro felter frem. Du modtager ikke 4000,-. hvis du passerer start feltet");

			//withdraw 4000 from the account of the player so there dont get the bonus when the landed on field nr. 33
			if(playerWhoLanded.getCurrentPos() == 33 ){
				playerWhoLanded.getAccount().withdraw(4000);
				System.out.println("Trækker 4000 fra for at passer start");
			}
			else if(playerWhoLanded.getCurrentPos() == 36 ){
				playerWhoLanded.getAccount().withdraw(4000);
				System.out.println("Trækker 4000 fra for at passer start");
			}
			GUI.removeAllCars(playerWhoLanded.getName());
			playerWhoLanded.updateCurrentPos(updateTwoSpaceAhead [i]-1);
			GUI.setCar(playerWhoLanded.getCurrentPos()+1, playerWhoLanded.getName());
			break;

		}
	}
}
