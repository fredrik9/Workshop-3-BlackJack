package BlackJack.view;

import BlackJack.model.rules.abstractFactoryFinishedRules.*;

public interface Visitor {

	String visitRuleSet(RulesFactory1 v_rulesFactory);
	String visitRuleSet(RulesFactory2 v_rulesFactory);
	String visitRuleSet(RulesFactory3 v_rulesFactory);
	String visitRuleSet(RulesFactory4 v_rulesFactory);
	
}
