package BlackJack.model.rules.abstractFactoryFinishedRules;

import BlackJack.model.rules.*;

public interface RulesFactory extends Visitable  {

  public IHitStrategy GetHitRule(); 

  public INewGameStrategy GetNewGameRule(); 
  
  public IWinnerStrategy GetWinnerRule();
  
}