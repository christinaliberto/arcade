package cs1302.arcade;

import cs1302.arcade.Form; 
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;

public class Square extends Form {

    public Square(GridPane grid) {
	super(Color.YELLOW, grid, 0);
	moveX = (int)(Math.random() * 9);

	part1 = addToGrid(moveX, moveY);
	part2 = addToGrid(moveX + 1, moveY);
	part3 = addToGrid(moveX, moveY + 1);
	part4 = addToGrid(moveX + 1, moveY + 1);

	
	fillParts();
    }

    public void rotate0() {}
    public void rotate90() {}
    public void rotate180() {}
    public void rotate270() {}

}
