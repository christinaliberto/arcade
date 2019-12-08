package cs1302.arcade;

import javafx.scene.Node;
import cs1302.arcade.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;

public class Moves {

    public int row;
    public int col;
    public boolean valid;
    Rectangle s1;
    Rectangle s2;
    Rectangle s3;
    Rectangle s4;

    public Moves(Rectangle[] x, GridPane grid, int k, String type, Rectangle a, Rectangle b, Rectangle c, Rectangle d){
	
        if (type.equals("down")) {
            //moveDown(shape);                                                                                                                                                    
        } else if (type.equals("right")) {
            moveRight(x,grid,k);
        } else if (type.equals("left")) {
            moveLeft(x,grid,k);
        }
    }

    
    public void moveLeft(Rectangle[] x, GridPane grid, int k) {
        valid = true;
        for (int i = 0; i < 4; i++) {
	    col = GridPane.getColumnIndex(x[i]);
	    row = GridPane.getRowIndex(x[i]);
	    if(col == 0) { 
		valid = false;
	    } else {
	       Rectangle pane = getPane(grid, col - 1, row);
		if(pane != null && isPiece(pane) == false) {
		    valid = false;
		}
	    }
        }
        if (valid) {
            for( int i = 0; i < 4; i++) {
		GridPane.setColumnIndex(x[i], GridPane.getColumnIndex(x[i]) - 1);
	    }
            k--;
        }
    } //moveleft

    public void moveRight(Rectangle[] x, GridPane grid, int k) {
        valid = true;
        for (int i = 0; i < 4; i++) {
	    col = GridPane.getColumnIndex(x[i]);
	    row = GridPane.getRowIndex(x[i]);
	    if(col == 9) {	
		valid = false;
	    } else {
		Rectangle pane = getPane(grid, col + 1, row);
		if(pane != null && isPiece(pane) == false ) {
		    valid = false;
		}
	    }
        }
        if (valid) {
            for( int i = 0; i < 4; i++) {
                GridPane.setColumnIndex(x[i], GridPane.getColumnIndex(x[i]) + 1);
	    }
            k++;
        }
	
	
    } // move right

    public Rectangle getPane(GridPane gridPane, int col, int row) {
	for (Node node : gridPane.getChildren()) {
	    if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
		return (Rectangle)node;
	    }
	}
	return null;
    }

    public boolean isPiece(Rectangle x) {
        if (x == s1 || x == s2 || x == s3 || x == s4) {
            return true;
        } else {
            return false;
        } //if                                                                                                                                                                      
    } //is piece
    
} //moves
