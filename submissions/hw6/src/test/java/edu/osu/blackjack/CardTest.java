
package edu.osu.blackjack;


import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import java.util.ArrayList;


public class CardTest {
    @Test
	public void testToString(){

	Card c1 = new Card(Card.Face.TWO, Card.Suit.HEART);
	String card1 = c1.toString();
		assertEquals(card1,"TWOHEART");
	}
		
	public void testNewDeck(){
		ArrayList<Card>d = Card.newDeck();
	int size = d.size();
		assertEquals(size, 52);

	}

	public void testVisible(){
		
	Card c1 = new Card(Card.Face.TWO, Card.Suit.HEART);
	c1.setVisible(true);
		assertEquals(c1.isVisible(), true);

	
	c1.setVisible(false);
		assertEquals(c1.isVisible(), false);
	}
}
