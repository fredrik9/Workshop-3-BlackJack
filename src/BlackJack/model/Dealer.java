package BlackJack.model;

import BlackJack.model.rules.abstractFactoryFinishedRules.AbstractFinishedRuleFactory;
import BlackJack.model.rules.abstractFactoryFinishedRules.FactoryNumberOne;
import BlackJack.model.rules.abstractFactoryFinishedRules.RulesFactory;

public class Dealer extends Player {

	private Deck m_deck;
	AbstractFinishedRuleFactory m_factory;

	public Dealer(RulesFactory a_rulesFactory) {

		m_factory = new FactoryNumberOne();
		m_factory.setRuleFactory(a_rulesFactory);
		m_factory.setRules();
	}

	public void doDealCard(boolean show, Player a_player) {
		Card card = m_deck.GetCard();
		card.Show(show);
		a_player.DealCard(card);
	}

	public boolean NewGame(Player a_player) {
		if (m_deck == null || IsGameOver()) {
			m_deck = new Deck();
			ClearHand();
			a_player.ClearHand();
			return m_factory.getM_newGameRule().NewGame(this, a_player);
		}
		return false;
	}

	public boolean Hit(Player a_player) {

		if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
			doDealCard(true, a_player);
			return true;
		}

		if (a_player.CalcScore() >= g_maxScore) {
			Stand();
		}

		return false;
	}

	public boolean IsDealerWinner(Player a_player) {

		return m_factory.getM_winnerRule().IsDealerWinner(a_player, this);
	}

	public boolean IsGameOver() {
		if (m_deck != null && m_factory.getM_hitRule().DoHit(this) != true) {
			return true;
		}
		return false;
	}

	public boolean Stand() {

		if (m_deck != null) {

			ShowHand();

			while (m_factory.getM_hitRule().DoHit(this)) {
				doDealCard(true, this);
			}
			return true;
		}
		return false;
	}

}