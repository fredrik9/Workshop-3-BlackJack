package BlackJack.model.rules.abstractFactoryFinishedRules;

import BlackJack.view.Visitor;

public interface Visitable {
	
	public String accept(Visitor visitor);

}
