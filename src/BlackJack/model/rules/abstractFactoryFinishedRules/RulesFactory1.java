package BlackJack.model.rules.abstractFactoryFinishedRules;

import BlackJack.model.rules.*;
import BlackJack.view.Visitor;

public class RulesFactory1 implements RulesFactory, Visitable {

  public IHitStrategy GetHitRule() {
    return new Soft17();
  }

  public INewGameStrategy GetNewGameRule() {
    return new InternationalNewGameStrategy();
  }
  
  public IWinnerStrategy GetWinnerRule(){
	  return new EqualScoreDealerWinnerStrategy();
  }

@Override
public String accept(Visitor visitor) {
	
	return visitor.visitRuleSet(this);
}
  
}