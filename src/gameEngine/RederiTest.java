package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RederiTest {

	Spiller playerTest1;
	Spiller playerTest2;
	Rederi fl1;
	Rederi fl2;
	
	@Before
	public void setUp() throws Exception {
		playerTest1 = new Spiller("playerTest1");
		playerTest2 = new Spiller("playerTest2");
		fl1 = new Rederi("Fleet", 5, 4000);
		fl2 = new Rederi("Fleet2", 6, 4000);

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
