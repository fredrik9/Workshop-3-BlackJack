package BlackJack.model.rules.abstractFactoryFinishedRules;

import BlackJack.model.rules.*;
import BlackJack.view.Visitor;

public class RulesFactory4 implements RulesFactory, Visitable {

  public IHitStrategy GetHitRule() {
    return new BasicHitStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new InternationalNewGameStrategy();
  }
  
  public IWinnerStrategy GetWinnerRule(){
	  return new EqualScorePlayerWinnerStrategy();
  }

@Override
public String accept(Visitor visitor) {
	return visitor.visitRuleSet(this);
}
  
}