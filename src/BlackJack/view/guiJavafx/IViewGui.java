package BlackJack.view.guiJavafx;

import BlackJack.model.Game;
import BlackJack.model.rules.abstractFactoryFinishedRules.RulesFactory;
import javafx.scene.Scene;

public interface IViewGui {
	void DisplayWelcomeMessage(RulesFactory v_rulesFactory);

	void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);

	void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);

	void DisplayGameOver(boolean a_dealerIsWinner);
	
	String getValue();

	enum choice {
		NewGame, Hit, Stand;
		choice value;
		
		choice getValue(){
			return value;
		}
		 void setValue(choice value2){
			value = value2;
		}
	}

	Scene createScene(Game g);;


}