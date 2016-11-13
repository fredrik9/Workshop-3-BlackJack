package BlackJack.view;

import BlackJack.model.rules.abstractFactoryFinishedRules.*;

public class RuleTypeVisitor implements Visitor {
	
	@Override
	public String visitRuleSet(RulesFactory1 v_rulesFactory) {
		System.out.println("hej");
		StringBuilder str = new StringBuilder();
		str.append("New game rule is: InternationalNewGameStrategy\n");
		str.append("Hit rule is: soft17\n");
		str.append("Winner rule is: EqualScoreDealerWinnerStrategy\n");
		return str.toString();
	}

	@Override
	public String visitRuleSet(RulesFactory2 v_rulesFactory) {
		StringBuilder str = new StringBuilder();
		str.append("New game rule is: AmericanNewGameStrategy\n");
		str.append("Hit rule is: soft17\n");
		str.append("Winner rule is: EqualScoreDealerWinnerStrategy\n");
		return str.toString();
		
	}

	@Override
	public String visitRuleSet(RulesFactory3 v_rulesFactory) {
		StringBuilder str = new StringBuilder();
		str.append("New game rule is: InternationalNewGameStrategy\n");
		str.append("Hit rule is: BasicHitStrategy\n");
		str.append("Winner rule is: EqualScoreDealerWinnerStrategy\n");
		return str.toString();
		
	}

	@Override
	public String visitRuleSet(RulesFactory4 v_rulesFactory) {
		StringBuilder str = new StringBuilder();
		str.append("New game rule is: InternationalNewGameStrategy\n");
		str.append("Hit rule is: BasicHitStrategy\n");
		str.append("Winner rule is: EqualScorePlayerWinnerStrategy\n");
		return str.toString();
		
	}

	
	
}
