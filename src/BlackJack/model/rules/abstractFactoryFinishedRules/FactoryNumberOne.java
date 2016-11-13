package BlackJack.model.rules.abstractFactoryFinishedRules;

public class FactoryNumberOne extends AbstractFinishedRuleFactory {

	public void setRuleFactory(RulesFactory factory){
		
		setFactory(factory);
	}
	
	@Override
	public void setRules() {
		
		setM_newGameRule(getFactory().GetNewGameRule());
		setM_hitRule(getFactory().GetHitRule());
		setM_winnerRule(getFactory().GetWinnerRule());
		
	}

}
