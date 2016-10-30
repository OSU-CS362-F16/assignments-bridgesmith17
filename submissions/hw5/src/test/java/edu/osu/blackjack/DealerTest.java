package edu.osu.blackjack;


import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;

public class DealerTest {
    @Test
	public void testAcceptCard(){
	
	Dealer dealer = new Dealer();
	dealer.acceptCard(new Card(Card.Face.ACE, Card.Suit.HEART));
	 
	List<Card> cards = dealer.getHand();

	assertEquals(cards.get(0),"ACEHEART");

	}
@Test		
	public void testDealCard(){
	
	Dealer p1 = new Dealer();
	Dealer p2 = new Dealer();

	
	p1.acceptCard(new Card(Card.Face.ACE, Card.Suit.HEART));
	
	p1.dealCard(p2);
	 
	List<Card> cards = p2.getHand();


	
	assertEquals(p1.getHand(),p2.getHand());
	
	}

@Test

	public void testShuffleDeck(){
	
	Dealer dealer = new Dealer();
	dealer.acceptCard(new Card(Card.Face.ACE, Card.Suit.HEART));

	dealer.acceptCard(new Card(Card.Face.THREE, Card.Suit.HEART));
	dealer.acceptCard(new Card(Card.Face.TWO, Card.Suit.HEART));

	dealer.shuffleDeck();

	
	List<Card> cards = dealer.getHand();

	assertFalse(cards.get(0).toString() == "ACEHEART");
	
	}
	
@Test

	public void testIsInsuranceAvailable(){



	Dealer dealer = new Dealer();
	dealer.acceptCard(new Card(Card.Face.ACE, Card.Suit.HEART));
	 
	List<Card> cards = dealer.getHand();

	cards.get(0).setVisible(true);

	boolean result = dealer.isInsuranceAvailable();

	assertEquals(result, true);

	Card c = cards.get(0);

	


 	int value = c.face.getValue();

	assertEquals(value, 11);
}
/*
	@Test 
/*	public void testHandScore() {

	
	Dealer dealer = new Dealer();
	dealer.acceptCard(new Card(Card.Face.ACE, Card.Suit.HEART));
	dealer.acceptCard(new Card(Card.Face.ACE, Card.Suit.SPADE));
	dealer.acceptCard(new Card(Card.Face.ACE, Card.Suit.CLUB));
 
	List<Card> cards = dealer.getHand();
	int score = dealer.handScore(cards);
	assertEquals(score, -1);
}



	public void testCompareHandAndSettle(){

	Dealer d1 = new Dealer();
	
	Player p1 = new Player();

	p1.acceptCard(new Card(Card.Face.KING, Card.Suit.SPADE));
	
	p1.makeBet();

	d1.acceptCard(new Card(Card.Face.NINE, Card.Suit.HEART));
	 
	List<Card> cards = d1.getHand();
	
	assertEquals(p1.currentWallet, 1020);



	}
*/
}
