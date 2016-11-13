package BlackJack.view.guiJavafx;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CardWithText extends StackPane {
	
	public CardWithText(String str, String str2){

		Text text1 = new Text(str);
		text1.setFont(new Font(30));
		Text text2 = new Text("of");
		text2.setFont(new Font(20));
		Text text3 = new Text(str2);
		text3.setFont(new Font(30));
		
		VBox vbox = new VBox();
		vbox.getChildren().add(text1);
		vbox.getChildren().add(text2);
		vbox.getChildren().add(text3);
		vbox.setAlignment(Pos.CENTER);
	getChildren().addAll(new Card(), vbox);
	}
}
