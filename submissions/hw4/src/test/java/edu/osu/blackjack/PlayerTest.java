package edu.osu.blackjack;


import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;

public class PlayerTest {
    @Test
	public void testAcceptCard(){
	
	Player p = new Player();
	p.acceptCard(new Card(Card.Face.ACE, Card.Suit.HEART));
	 
	List<Card> cards = p.getHand();

	assertEquals(cards.get(0),"ACEHEART");

	}
	@Test
	public void testMakeBet(){
	Player p = new Player();

	int bet = p.makeBet();
	int cbet = p.getCurrentBet();
	

	assertEquals(bet, cbet);

	p.doubleDownBet();

	int dbet=p.getCurrentBet();

	assertEquals(dbet, (2 *cbet));


	}
	
	@Test
	public void testInsurance(){

	Player p = new Player();

	p.moveMoneyToInsurance(100);

	int insure = p.makeInsuranceBet();
	assertEquals(insure, 100);

	}

@Test
	public void testAcceptMoney(){
	Player p = new Player();

	int i = 500;
	p.moveMoneyToBet(i);

	assertEquals(p.getCurrentBet(), i);

}	
		
	
}
