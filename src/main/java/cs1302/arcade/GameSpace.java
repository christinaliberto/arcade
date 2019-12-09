package cs1302.arcade;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameSpace extends Rectangle {

    public static final int TILESIZE = 50; 

    public GameSpace(int xLoc, int yLoc) {

	setWidth(TILESIZE);
	setHeight(TILESIZE);
	setFill(Color.HOTPINK);
	setStroke(Color.BLACK);
	relocate(x * TILESIZE, y * TILESIZE);
    }
}


