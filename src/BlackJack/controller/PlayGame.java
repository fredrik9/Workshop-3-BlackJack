package BlackJack.controller;

import BlackJack.model.Card.Value;
import BlackJack.model.IObserver;
import BlackJack.view.guiJavafx.IViewGui;

public class PlayGame implements IObserver{
	
	IViewGui a_view;
	
	public PlayGame(BlackJack.model.Game a_game, BlackJack.view.guiJavafx.IViewGui a_views){
		
		a_view = a_views;
		a_game.addSubscriber(this);
		a_view.DisplayWelcomeMessage(a_game.getRulesFactory());
	}

	public void Play(BlackJack.model.Game a_game) {
		
		if (a_view.getValue() == "NewGame") {
			a_game.NewGame();
		} else if (a_view.getValue() == "Hit") {
			a_game.Hit();
		} else if (a_view.getValue() == "Stand") {
			a_game.Stand();
		}
		
		if (a_game.IsGameOver()) {
			a_view.DisplayGameOver(a_game.IsDealerWinner());
		}

	}

	@Override
	public void dealtCard(Value value, BlackJack.model.Game a_game) {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
		a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
	
	}
}