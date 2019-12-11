package cs1302.arcade;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameSpace extends Rectangle {

    public GameSpace(int xLoc, int yLoc) {

        setWidth(Reversi.SIZEOFTILES);
        setHeight(Reversi.SIZEOFTILES);

        relocate(xLoc * Reversi.SIZEOFTILES, yLoc * Reversi.SIZEOFTILES);

        setFill(Color.HOTPINK);
        setStroke(Color.WHITE); 
    }
}


