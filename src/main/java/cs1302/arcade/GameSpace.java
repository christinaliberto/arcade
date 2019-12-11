package cs1302.arcade;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameSpace extends Rectangle {

    public GameSpace(int xLoc, int yLoc) {
	setWidth(50);
	setHeight(50);
	relocate(xLoc * 50, yLoc * 50);
	setFill(Color.HOTPINK);
	setStroke(Color.WHITE);
    }
}
