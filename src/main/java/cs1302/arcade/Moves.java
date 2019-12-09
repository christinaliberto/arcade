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
    Rectangle[] shape;
    GridPane grids;
    int xint;
    int yint;
    
    public Moves(Rectangle[] x, GridPane grid, int k, int l, String type, Rectangle a, Rectangle b, Rectangle c, Rectangle d){
	s1= a;
	s2 = b;
	s3 = c;
	s4 = d;
	shape = x;
	grids = grid;
	xint = k;
	yint = l;
        if (type.equals("down")) {
            //moveDown(shape);                                                                                                                                                    
        } else if (type.equals("right")) {
            moveRight();
        } else if (type.equals("left")) {
            moveLeft();
        }
    }

    
    public void moveLeft() {
	for ( Rectangle s : shape ) {
	    grids.getChildren().remove(s);
	    //grids.add(s,(xint-1),yint);
	    xint--;
	}
    } //moveleft

    public void moveRight() {
        valid = true;
        for (int i = 0; i < 4; i++) {
	    col = GridPane.getColumnIndex(shape[i]);
	    row = GridPane.getRowIndex(shape[i]);
	    if(col == 9) {	
		valid = false;
	    } else {
		Rectangle pane = getPane(col + 1, row);
		if(pane != null && isPiece(pane) == false ) {
		    valid = false;
		}
	    }
        }
        if (valid) {
            for( int i = 0; i < 4; i++) {
                GridPane.setColumnIndex(shape[i], GridPane.getColumnIndex(shape[i]) + 1);
	    }
            xint++;
        }
	
	
    } // move right

    public Rectangle getPane(int col, int row) {
	for (Node node : grids.getChildren()) {
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
