package edu.osu.blackjack;


import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import static org.mockito.Mockito.*;

public class MockExampleTest {
    @Test
    public void testMock(){
	// Does it run without errors for a simple case?
	DealerAction dt = mock(DealerAction.class);
	PlayerAction pa = mock(PlayerAction.class);

	//  This player is feeling charitiable....
	when(pa.getAction()).thenReturn(PlayerAction.ActionType.HIT)
                            .thenReturn(PlayerAction.ActionType.HIT)
                            .thenReturn(PlayerAction.ActionType.HIT)
                            .thenReturn(PlayerAction.ActionType.HIT)
                            .thenReturn(PlayerAction.ActionType.HIT)
                            .thenReturn(PlayerAction.ActionType.HIT)	
	                    .thenReturn(PlayerAction.ActionType.HIT)	   
	                    .thenReturn(PlayerAction.ActionType.STAND);	                          
	SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
	j.playRound();
	verify(dt, times(9)).dealCard(pa);
    }
	

	//testing rule that doubledown can only happen for first turn after player has been dealt first two cards
	@Test 
		public void testDoubleLimit1(){


	DealerAction dt = mock(DealerAction.class);
	PlayerAction pa = mock(PlayerAction.class);
	
	

	when(pa.getAction()).thenReturn(PlayerAction.ActionType.HIT)
				.thenReturn(PlayerAction.ActionType.DOUBLE);

	SimpleBlackjack j = new SimpleBlackjack(dt, new PlayerAction[] {pa});
	j.playRound();

	verify(pa, times(0)).doubleDownBet();
	}

   @Test
	public void testDoubleLimit2(){

	DealerAction dt = mock(DealerAction.class);
	PlayerAction pa = mock(PlayerAction.class);



	when(pa.getAction()).thenReturn(PlayerAction.ActionType.DOUBLE)
				.thenReturn(PlayerAction.ActionType.HIT);

	SimpleBlackjack j = new SimpleBlackjack(dt, new PlayerAction[] {pa});
	j.playRound();

	verify(dt, times(4)).dealCard(pa);
	}
	
		
	
	@Test 
		public void testDealerHand(){



	DealerAction dt = mock(DealerAction.class);
	PlayerAction pa = mock(PlayerAction.class);
	

	when(pa.getAction()).thenReturn(PlayerAction.ActionType.HIT)
				.thenReturn(PlayerAction.ActionType.STAND);

	SimpleBlackjack j = new SimpleBlackjack(dt, new PlayerAction[] {pa});
	j.playRound();

	verify(dt, times(2)).dealCard(dt);
	}

	@Test
	public void testStand(){

	DealerAction dt = mock(DealerAction.class);
	PlayerAction pa = mock(PlayerAction.class);

	//stand should cause the loop to break.
	when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND)
				.thenReturn(PlayerAction.ActionType.HIT);

	SimpleBlackjack j = new SimpleBlackjack(dt, new PlayerAction[]{pa});	

	j.playRound();	
	verify(dt, times(3)).dealCard(pa);

	}

	@Test
	public void testBlackJackIntiial(){


	DealerAction dt = mock(DealerAction.class);
	PlayerAction pa = mock(PlayerAction.class);



	when(pa.getAction()).thenReturn(PlayerAction.ActionType.STAND);



	SimpleBlackjack j = new SimpleBlackjack(dt, new PlayerAction[] {pa});
	j.playRound();
	
	verify(dt, times(2)).dealCard(pa);
	


}	
	
}
