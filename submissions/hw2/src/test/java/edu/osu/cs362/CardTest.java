package edu.osu.cs362;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class CardTest  {
   
    @Test
    public void testCardConstructor() {

        Card c = new Card(Card.Face.ACE, Card.Suit.SPADE);
	
	String val = c.toString();

	assertEquals("ACESPADE",val);

	    } 
    
    @Test
    public void testCardProtoDeck() {
     ArrayList<Card>d = Card.newDeck();
		
     int size = d.size();

	assertEquals(52,size);
	
	
    }

    @Test
    public void testCardVisability(){
       
	Card c = new Card(Card.Face.ACE, Card.Suit.SPADE);
		       
	c.setVisible(true);
       	boolean result = c.isVisible();
	assertEquals(true,result);
	

	c.setVisible(false);
	boolean result1 = c.isVisible();
	assertEquals(false,result1);
	
	
    }

 
}
