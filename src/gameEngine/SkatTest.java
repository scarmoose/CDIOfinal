package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SkatTest {

	Spiller playerTestLand;
	Skat indkomstskat;
	Skat ekstraordinærstatsskat;
	
	@Before
	public void setUp() throws Exception {
		playerTestLand = new Spiller("test1");
		indkomstskat = new Skat("Indkomstskat", 4000, 10);
		ekstraordinærstatsskat = new Skat("Ekstraordinærstatsskat", 2000, 0);
	}
	
	@Test
	public void test10percentLandOnField() {
		playerTestLand.getAccount().setBalance(30000);
		indkomstskat.landOnField(playerTestLand);
		System.out.println(playerTestLand.getAccount().getBalance());
		assertEquals(playerTestLand.getAccount().getBalance(),27000);
	} 
	
	@Test
	public void test4000LandOnField() {
		playerTestLand.getAccount().setBalance(50000);
		indkomstskat.landOnField(playerTestLand);
		System.out.println(playerTestLand.getAccount().getBalance());
		assertEquals(playerTestLand.getAccount().getBalance(),46000);
	}
 
}
