package BlackJack.view.guiJavafx;

import BlackJack.controller.PlayGame;
import BlackJack.model.Game;
import BlackJack.model.rules.abstractFactoryFinishedRules.RulesFactory;

import BlackJack.view.guiJavafx.IViewGui;
import BlackJack.view.RuleTypeVisitor;
import BlackJack.view.Visitor;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BlackJackGui implements IViewGui {
	
	public String choiceValue = "Quit";
	
	Text text1;
	Text text2;
	Text text3;
	Text text4;
	Text text5;
	Text text6;
	
	private Group root;
	private Scene myscene;
	
	FlowPane flowPanePlayer;
	FlowPane flowPaneDealer;
	
	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;
	
	PlayGame ctrl;

	public BlackJackGui(Game g) {
		
	    
		
		//rectangle panes
		Rectangle rect1 = new Rectangle(1250, 250);
		Rectangle rect2 = new Rectangle(1250, 250);
		Rectangle rect3 = new Rectangle(1250, 200);
		Rectangle rect5 = new Rectangle(1250, 900);

		//rectangle color and stroke
		rect1.setFill(Color.GREEN);
		rect2.setFill(Color.GREEN);
		rect3.setFill(Color.GREEN);
		rect5.setFill(Color.GREEN);
		
		rect1.setStroke(Color.BLACK);
		rect2.setStroke(Color.BLACK);
		rect3.setStroke(Color.BLACK);
		rect5.setStroke(Color.BLACK);
		//texts
		Label error = new Label();
		text1 = new Text("Dealer");
		text1.setFont(new Font(50));
		text2 = new Text("Player");
		text2.setFont(new Font(50));
		text3 = new Text("Score:");
		text3.setFont(new Font(50));
		text4 = new Text("Score:");
		text4.setFont(new Font(50));
		text5 = new Text("");
		text5.setFont(new Font(50));
		text6 = new Text("");
		text6.setFont(new Font(20));

	
		
		//buttons
		btn1 = new Button();
		btn2 = new Button();
		btn3 = new Button();
		btn4 = new Button();
		//styling everthing
	    btn1.setText("Play Game");
	    btn2.setText("Hit");
	    btn3.setText("Stand");
	    btn4.setText("Quit");

	    btn1.setStyle("-fx-font-size: 20pt;");
	    btn2.setStyle("-fx-font-size: 20pt;");
	    btn3.setStyle("-fx-font-size: 20pt;");
	    btn4.setStyle("-fx-font-size: 20pt;");
	    HBox hbox = new HBox();
	    hbox.getChildren().addAll(btn1,btn2,btn3,btn4);
	    hbox.setAlignment(Pos.CENTER);
	    hbox.setSpacing(50);
	    hbox.setLayoutX(100);
	    hbox.setLayoutY(750);
	    hbox.setPrefWidth(1230);
	    hbox.setPrefHeight(180);
	    
		
	    error.setLayoutX(105);
	    error.setLayoutY(120);
	    error.setStyle("-fx-border-color: white; -fx-font-size: 20pt;");
	    
		text1.setLayoutX(150);
	    text1.setLayoutY(380);
	    text2.setLayoutX(150);
	    text2.setLayoutY(630);
	    text3.setLayoutX(1100);
	    text3.setLayoutY(380);
	    text4.setLayoutX(1100);
	    text4.setLayoutY(630);
	    text5.setLayoutX(150);
	    text5.setLayoutY(100);
	    text6.setLayoutX(150);
		text6.setLayoutY(150);
	    
	    rect1.setLayoutX(100);
	    rect1.setLayoutY(250);
	    rect2.setLayoutX(100);
	    rect2.setLayoutY(500);
	    rect3.setLayoutX(100);
	    rect3.setLayoutY(750);
	    rect5.setLayoutX(100);
	    rect5.setLayoutY(50);
	    
		//card panes
		flowPanePlayer = new FlowPane();
		flowPaneDealer = new FlowPane();
	    
	    flowPanePlayer.setLayoutX(90);
	    flowPanePlayer.setLayoutY(500);
	    flowPaneDealer.setLayoutX(90);
	    flowPaneDealer.setLayoutY(250);
	    
	    flowPanePlayer.setAlignment(Pos.CENTER);
	    flowPaneDealer.setAlignment(Pos.CENTER);
	    flowPanePlayer.setPrefSize(1250, 250);
		flowPaneDealer.setPrefSize(1250, 250);

		ctrl = new PlayGame(g, this);
		root = new Group();
		root.getChildren().addAll(rect5,rect3,rect2,rect1,text1,text2,text3,text4,text5,text6,hbox,flowPanePlayer, flowPaneDealer);

	}
	
	public Scene createScene(Game g){
	
		myscene = new Scene(root, 1400, 1000);

		eventHandler(g);
		return myscene;
	}
	
	private void eventHandler(Game g){
		
		    btn1.setOnAction(new EventHandler<ActionEvent>() {

		        @Override
		        public void handle(ActionEvent event) {

		        	setValue(choice.NewGame);
		        	ctrl.Play(g);
		        	
		        }
		    });
		 
		    btn2.setOnAction(new EventHandler<ActionEvent>() {

		        @Override
		        public void handle(ActionEvent event) {
		        	
		        	setValue(choice.Hit);
		        	ctrl.Play(g);
		        }
		    });
		 
		    btn3.setOnAction(new EventHandler<ActionEvent>() {

		        @Override
		        public void handle(ActionEvent event) {
		        	
		        	setValue(choice.Stand);
		        	ctrl.Play(g);
		        }
		    });
		   
		    btn4.setOnAction(new EventHandler<ActionEvent>() {

		        @Override
		        public void handle(ActionEvent event) {
		        	
		        	Platform.exit();
		        }
		    });
		
		
	}
	
	public void DisplayWelcomeMessage(RulesFactory v_rulesFactory) {
		//clearing and displaying
		Visitor visitor = new RuleTypeVisitor();
		text5.setText("Hello Black Jack World");
		text6.setText("Rules: " + v_rulesFactory.accept(visitor));

	}

	@Override
	public String getValue() {
		return choiceValue;
	}

	private void setValue(IViewGui.choice value) {

		choiceValue = value.toString();
	}

	public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
		DisplayHand("Player", a_hand, a_score);
	}

	public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
		DisplayHand("Dealer", a_hand, a_score);
	}

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
        	
        	 if(a_name.equals("Player")){

        		 flowPanePlayer.getChildren().clear();
                 text4.setText("Score: " + a_score);
                 }else if(a_name.equals("Dealer")){
                	 flowPaneDealer.getChildren().clear();
                 text3.setText("Score: " + a_score);
                 }
                 text2.setText("Player");
                 text1.setText("Dealer");
                 
           
            for(BlackJack.model.Card c : a_hand)
            {
            	if(a_name.equals("Player")){
            	flowPanePlayer.getChildren().add(new CardWithText(c.GetValue().toString(), c.GetColor().toString()));
            	}
            	flowPaneDealer.getChildren().add(new CardWithText(c.GetValue().toString(), c.GetColor().toString()));
            
            }
            
           
        }

        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
        	
    		flowPanePlayer.getChildren().clear();
    		flowPaneDealer.getChildren().clear();
            
            if (a_dealerIsWinner)
            {
            	text1.setText("GameOver: Dealer Won!");
            }
            else
            {
            	text2.setText("GameOver: You Won!");
            }
            
        }
	
}