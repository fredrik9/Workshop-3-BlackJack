package BlackJack.model.rules.abstractFactoryFinishedRules;

import BlackJack.model.rules.*;

public abstract class AbstractFinishedRuleFactory {

	private RulesFactory factory;
	
	private INewGameStrategy m_newGameRule;
	private IHitStrategy m_hitRule;
	private IWinnerStrategy m_winnerRule;
	
	public abstract void setRuleFactory(RulesFactory factory);
	
	public abstract void setRules();

	public INewGameStrategy getM_newGameRule() {
		return m_newGameRule;
	}

	public void setM_newGameRule(INewGameStrategy m_newGameRule) {
		this.m_newGameRule = m_newGameRule;
	}

	public IWinnerStrategy getM_winnerRule() {
		return m_winnerRule;
	}

	public void setM_winnerRule(IWinnerStrategy m_winnerRule) {
		this.m_winnerRule = m_winnerRule;
	}

	public IHitStrategy getM_hitRule() {
		return m_hitRule;
	}

	public void setM_hitRule(IHitStrategy m_hitRule) {
		this.m_hitRule = m_hitRule;
	}

	public RulesFactory getFactory() {
		return factory;
	}

	public void setFactory(RulesFactory factory) {
		this.factory = factory;
	}
}
