package edu.osu.blackjack;



public class SimpleBlackjack {
	public enum ActionType {HIT , DOUBLE, STAND};
	private int numPlayers;
	
	DealerAction dealer;
	PlayerAction[] players ;

	
	public SimpleBlackjack(DealerAction d, PlayerAction[] ip){
		this.dealer = d;
		this.players = ip;
	}
	
	public void playRound(){
		//comented out shuffle deck ; will shuffle deck outside of function for testing 
		//dealer.shuffleDeck();
		
		for(PlayerAction p: players ){
			p.makeBet();
		}
		
			dealer.dealDealerCard();
			dealer.dealDealerCard();
		
		for(PlayerAction p: players ){
			dealer.dealCard(p);
			dealer.dealCard(p);
		}
	
		if(dealer.isInsuranceAvailable()){
			for(PlayerAction p: players ){
				p.makeInsuranceBet();
			}
		}

		for(PlayerAction p: players ){
			boolean turnOver = false;
			int turn = 1;
			while(!turnOver){
				PlayerAction.ActionType a = p.getAction();	
	
				switch(a){
					case HIT:
						dealer.dealCard(p);		
						turn = 2;
						break;
					case DOUBLE:
						switch(turn){
							case 1:
		
								p.doubleDownBet();
								dealer.dealCard(p);
								turnOver = true;
								break;
							default:
								turn = 2;
								break;
								}	
				default: // stand
						turnOver = true;
						break;
				}
		
			}
		}

		for(PlayerAction p: players){
			dealer.compareHandAndSettle(p);
		}
	}
}
