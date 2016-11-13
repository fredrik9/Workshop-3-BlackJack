package BlackJack.view;

import BlackJack.model.rules.abstractFactoryFinishedRules.RulesFactory;

public class SwedishView implements IView 
    {
        public void DisplayWelcomeMessage(RulesFactory v_rulesFactory)
        {
        	Visitor visitor = new RuleTypeVisitor();
            System.out.println("Hej Black Jack Världen");
            System.out.println("----------------------");
            System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
            System.out.println("Regler:");
            System.out.println(v_rulesFactory.accept(visitor));
            GetInput();
        }
        
        
        public String choiceValue = "Quit";

    	@Override
    	public String getValue() {
    		return choiceValue;
    	}

    	private void setValue(IView.choice value) {

    		choiceValue = value.toString();
    	}

    	public void GetInput() {
    		try {
    			int c = System.in.read();
    			while (c == '\r' || c == '\n') {
    				c = System.in.read();
    			}

    			if (c == 'p') {
    				setValue(choice.NewGame);
    			} else if (c == 'h') {
    				setValue(choice.Hit);
    			} else if (c == 's') {
    				setValue(choice.Stand);
    			}else if (c == 'q') {
    				setValue(choice.Quit);
    			}

    		} catch (java.io.IOException e) {
    			System.out.println("" + e);
    		}
    	}
        
        public void DisplayCard(BlackJack.model.Card a_card)
        {
            if (a_card.GetColor() == BlackJack.model.Card.Color.Hidden)
            {
                System.out.println("Dolt Kort");
            }
            else
            {
                String colors[] = 
                    { "Hjärter", "Spader", "Ruter", "Klöver" };
                String values[] =  
                    { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess" };
                System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
            }
        }
        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Spelare", a_hand, a_score);
            GetInput();
        }
        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Croupier", a_hand, a_score);
        }
        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("Slut: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Croupiern Vann!");
            }
            else
            {
                System.out.println("Du vann!");
            }
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Har: " + a_score);
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Poäng: " + a_score);
            System.out.println("");
        }

    }
