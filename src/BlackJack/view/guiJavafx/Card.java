package BlackJack.view.guiJavafx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Card extends Rectangle {

	public Card(){
		
			setWidth(150);
	        setHeight(250);            
	        setFill(Color.WHITE.deriveColor(0, 1.2, 1, 0.6));
	        setStroke(Color.BLACK);
		
	}
	
}
