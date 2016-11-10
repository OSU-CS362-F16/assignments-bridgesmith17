package edu.osu.blackjack;


import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import static org.mockito.Mockito.*;
import java.util.*;

public class SimpleBlackjackRandomTest {
    @Test
   public void testRandomBasicFunctionality(){
		Random rand = new Random();
		

		PlayerAction pa = mock(PlayerAction.class);
			





	int runs = 100;

	for(int i = 0; i <runs; i ++){	
	
		int p = rand.nextInt(4) + 1;	
		Dealer dealer = new Dealer();
		Player[] players = new Player[p];	
		
		dealer.shuffleDeck();
			
		List<Card> newDeck = new ArrayList<Card>(dealer.getHand());
	
		int action = rand.nextInt(3);

		if(action == 0)
		{
			  
		when(pa.getAction()).thenReturn(PlayerAction.ActionType.HIT)
					.thenReturn(PlayerAction.ActionType.STAND);
		} else if (action == 1)

		{
		
		when(pa.getAction()).thenReturn(PlayerAction.ActionType.DOUBLE)
					.thenReturn(PlayerAction.ActionType.STAND);
		}
		else
			
		when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND);
		
		for(int j=0; j < p; j++){

			players[j] = new Player();
		}	
		SimpleBlackjack bj = new SimpleBlackjack(dealer,players);
		bj.playRound();
	// was trying to figure out how to test deal car to dealer but unsuccessful..	
	//	List<Card> dHand = new ArrayList<Card>(dealer.getDealerHand());
	
//		assertEquals(newDeck.get(2),dHand.get(0));
//		assertEquals(newDeck.get(1),dHand.get(1)); 
		// tests if appropriate cards are dealt to each player 
		int nextCard = 2;
		for(int j= 0; j < p; j++) {
			List<Card> pHand = new ArrayList<Card>(players[0].getHand());
			
		assertEquals(newDeck.get(nextCard),pHand.get(0));
		nextCard = nextCard +1;
		assertEquals(newDeck.get(nextCard),pHand.get(1));
	
		nextCard = nextCard + 1;
		}
		//randomly checks if additional cards are dealt to player based on random selection of hit, double or stand. 
		for(int j=0; j< p; j++) {
		
		if(action < 2)
		{
						
			List<Card> phand = players[j].getHand();
			
		assertEquals(newDeck.get(nextCard),phand.get(2));
		nextCard = nextCard +1;
		}
		
		
		}	
	    }
	}
	
}
