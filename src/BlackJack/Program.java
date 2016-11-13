package BlackJack;

import BlackJack.model.Game;
import BlackJack.model.rules.abstractFactoryFinishedRules.*;
import BlackJack.view.guiJavafx.BlackJackGui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Program extends Application
{

  public static void main(String[] a_args)
  {
  
	  Application.launch(a_args);
    
  }

@Override
public void start(Stage primaryStage) throws Exception {
	  Game g = new Game(new RulesFactory4());
	    primaryStage.setTitle("BlackJack");

		BlackJackGui blackJack = new BlackJackGui(g);

		Scene scene = blackJack.createScene(g);

		primaryStage.setScene(scene);
		primaryStage.show();

}
}