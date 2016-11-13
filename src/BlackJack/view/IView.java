package BlackJack.view;

import BlackJack.model.rules.abstractFactoryFinishedRules.RulesFactory;

public interface IView {
	void DisplayWelcomeMessage(RulesFactory v_rulesFactory);

	void DisplayCard(BlackJack.model.Card a_card);

	void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);

	void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);

	void DisplayGameOver(boolean a_dealerIsWinner);
	
	String getValue();

	enum choice {
		NewGame, Hit, Stand, Quit;
		choice value;
		
		choice getValue(){
			return value;
		}
		 void setValue(choice value2){
			value = value2;
		}
	};


}