package edu.osu.cs362;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.*;

public class CardCollectionTest  {

    @Test
    public void testCardCollectionConstructor() {

        CardCollection hand = new CardCollection(new Card(Card.Face.ACE, Card.Suit.SPADE), new Card(Card.Face.KING, Card.Suit.HEART));
	
        Card c = hand.discardCard(0);
	
	String val = c.toString();

        assertEquals("ACESPADE",val);
      
    }
    @Test
    public void testCardCollectionRemove(){

	CardCollection hand = new CardCollection(new Card(Card.Face.FIVE, Card.Suit.SPADE), new Card(Card.Face.KING, Card.Suit.HEART));
	
	Card c = hand.discardCard(0);
	
	String val = c.toString();

	assertEquals("FIVESPADE",val);
       
	c = hand.discardCard(0);

	val = c.toString();

	assertEquals("KINGHEART", val);

       
    }

    @Test
    public void testCardCollectionAdd(){

        CardCollection hand = new CardCollection(new Card(Card.Face.FIVE, Card.Suit.SPADE), new Card(Card.Face.KING, Card.Suit.HEART));

        Card c = hand.discardCard(0);

        String val = c.toString();

        assertEquals("FIVESPADE",val);

	hand.add(new Card(Card.Face.NINE, Card.Suit.DIAMOND));
	
        c = hand.discardCard(0);
        
	val = c.toString();

        assertEquals("KINGHEART", val);
   
	c = hand.discardCard(0);

        val = c.toString();

	assertEquals("NINEDIAMOND", val);
    }

    @Test
    public void testCardCollectionAddAll(){

        CardCollection hand = new CardCollection(new Card(Card.Face.FIVE, Card.Suit.SPADE), new Card(Card.Face.KING, Card.Suit.HEART));

        Card c = hand.discardCard(0);

        String val = c.toString();

        assertEquals("FIVESPADE",val);

        List<Card> newHand = new ArrayList<Card>();

	newHand.add(new Card(Card.Face.NINE, Card.Suit.DIAMOND));

	newHand.add(new Card(Card.Face.ACE, Card.Suit.CLUB));
	
	hand.add(newHand);

	
        c = hand.discardCard(0);

        val = c.toString();
       
        assertEquals("KINGHEART", val);

        c = hand.discardCard(0);

        val = c.toString();

        assertEquals("NINEDIAMOND", val);


       c = hand.discardCard(0);
		 val = c.toString();

		 assertEquals("ACECLUB",val);
        }

    @Test
    public void testCardCollectionGet(){

        CardCollection hand = new CardCollection(new Card(Card.Face.FIVE, Card.Suit.SPADE), new Card(Card.Face.KING, Card.Suit.HEART));

	List<Card> c = hand.getCards();
	
	
	Card card1 = c.get(0);
	String val1 = card1.toString();

	assertEquals("FIVESPADE",val1);

	Card card2 = c.get(1);
	String val2 = card2.toString();
	
	assertEquals("KINGHEART",val2);
 }
}


