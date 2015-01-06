package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FleetTest {

	Player playerTest1;
	Player playerTest2;
	Fleet fl1;
	Fleet fl2;
	
	@Before
	public void setUp() throws Exception {
		playerTest1 = new Player("playerTest1");
		playerTest2 = new Player("playerTest2");
		fl1 = new Fleet("Fleet", 5, 4000);
		fl2 = new Fleet("Fleet2", 6, 4000);

	}

	@Test
	public void testGetRent() {
		fl1.setOwner(playerTest1);
		playerTest1.incrementFleetsOwned();
		playerTest1.incrementFleetsOwned();
		assertEquals(fl1.getRent(),1000);
		playerTest1.incrementFleetsOwned();
		assertEquals(2000, fl1.getRent());
		playerTest1.incrementFleetsOwned();
		assertEquals(4000, fl1.getRent());
		

	}
	
	@Test
	public void testDipositAndWithdraw(){
		playerTest1.getAccount().deposit(1000);
		playerTest2.getAccount().withdraw(1000);
		assertEquals(playerTest1.getAccount().getBalance(),31000);
		assertEquals(playerTest2.getAccount().getBalance(),29000);
	}
	
	@Test
	public void testBuyProportyAndLandOnField(){
		fl1.buyProperty(playerTest1);
		assertEquals(26000, playerTest1.getAccount().getBalance());
		fl1.landOnField(playerTest2);
		assertEquals(29500, playerTest2.getAccount().getBalance());
		fl2.buyProperty(playerTest1);
		fl1.landOnField(playerTest2);
		assertEquals(28500, playerTest2.getAccount().getBalance());
	}
	
	
}
