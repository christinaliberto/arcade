package cs1302.arcade;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/** 
 * A class representing one square in the game board for the
 * Reversi game. A square is a rectangle, and it's height and 
 * width is set to 50. The xLoc and yLoc are references to the array
 * that represents the board, so a square is relocated to that value 
 * multiplied by 50 for proper representation. The square's color is set 
 * to pink, with a white boarder. 
 */
public class GameSpace extends Rectangle {

    /** 
     * A constructor for a square in the game board.
     *
     * @param xLoc an integer used as a reference to the array that
     * stores the board's information
     *
     * @param yLoc an integer used as a reference to the array that 
     * stores the board's information
     */
    public GameSpace(int xLoc, int yLoc) {
        setWidth(50); // set width to 50
        setHeight(50); // set height to 50
        relocate(xLoc * 50, yLoc * 50); // relocate to specified location
        setFill(Color.HOTPINK); // set color to hot pink
        setStroke(Color.WHITE); // set outline to white
    }
}
