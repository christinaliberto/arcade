package cs1302.arcade;

import javafx.scene.Node;
import cs1302.arcade.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;

public class Moves {



    public boolean valid;
    Rectangle s1;
    Rectangle s2;
    Rectangle s3;
    Rectangle s4;
    Rectangle[] shape;
    GridPane grids;
    int xint;
    int yint;
    int rotations;
    String id;
    
    public Moves(Rectangle[] x, GridPane grid, int k, int l, String type, int r, String ident){
	s1 = x[0];
	s2 = x[1];
	s3 = x[2];
	s4 = x[3];
	shape = x;
	grids = grid;
	xint = k;
	yint = l;
	rotations = r;
	id = ident;
        if (type.equals("down")) {
            moveDown();                                                                                                                                                    
        } else if (type.equals("right")) {
            moveRight();
        } else if (type.equals("left")) {
            moveLeft();
        } else if (type.equals("up")) {
	    rotate();
	}
    }

    public void moveDown() {

    }

    public void moveLeft() {
	//try {
	    
                grids.getChildren().remove(s1);
		grids.getChildren().remove(s2);
		grids.getChildren().remove(s3);
		grids.getChildren().remove(s4);
                
	
		//} catch (IndexOutOfBoundsException e) {}
	
    
	
    } //moveleft

    public void moveRight() {
        valid = true;
        for (int i = 0; i < 4; i++) {
	    if(xint == 9) {	
		valid = false;
	    } else {
		Rectangle pane = getPane(xint + 1, yint);
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

    public void rotate() {
	if (id.equals("sq")) {
            sqLoc();
        } else if (id.equals("I")) {
            iLoc();
        } else if (id.equals("J")) {
            jLoc();
        } else if (id.equals("L")) {
            lLoc();
        } else if (id.equals("T")) {
            tLoc();
        } else if (id.equals("S")) {
            sLoc();
        } else if (id.equals("Z")) {
	    zLoc();
        } //if 
    } // rotate

    public void sqLoc() {

    } //location

    public void iLoc() {
	if ( rotations == 0 ) {
	    i1();
	} else if (rotations == 1) {
	    i4();
	} else if (rotations == 2) {
	    i3();
	} else if (rotations == 3) {
	    i4();
	}
    } //location
    
    public void jLoc() {
	if ( rotations == 0 ) {
	    j1();
	} else if (rotations == 1) {
	    j2();
	} else if (rotations == 2) {
	    j3();
	} else if (rotations == 3) {
	    j4();
	}
    } //location
    
    public void lLoc() {
	if ( rotations == 0 ) {
	    l1();
	} else if (rotations == 1) {
	    l2();
	} else if (rotations == 2) {
	    l3();
	} else if (rotations == 3) {
	    l4();
	}
    } //location
    
    public void tLoc() {
	if ( rotations == 0 ) {
	    t1();
	} else if (rotations == 1) {
	    t2();
	} else if (rotations == 2) {
	    t3();
	} else if (rotations == 3) {
	    t4();
	}
    } //location
    
    public void sLoc() {
	if ( rotations == 0 ) {
	    s1();
	} else if (rotations == 1) {
	    s2();
	} else if (rotations == 2) {
	    s3();
	} else if (rotations == 3) {
	    s4();
	}
    } //location
    
    public void zLoc() {
	if ( rotations == 0 ) {
	    z1();
	} else if (rotations == 1) {
	    z2();
	} else if (rotations == 2) {
	    z3();
	} else if (rotations == 3) {
	    z4();
	}
    } //location
    
    public void i1() {
	try {
            //Rectangle nextR2 = getFromGrid(pivotX, pivotY + 1);
            //Rectangle nextR3 = getFromGrid(pivotX, pivotY + 2);
            //Rectangle nextR4 = getFromGrid(pivotX, pivotY + 3);
            //if(nextR2 == null && nextR3 == null && nextR4 == null) {
		grids.getChildren().remove(s2);
                grids.getChildren().remove(s3);
                grids.getChildren().remove(s4);
		grids.add(s2, xint, yint + 1);
		grids.add(s2, xint, yint + 1);
		grids.add(s2, xint, yint + 1);
		rotations++;
		    //}
        } catch (IndexOutOfBoundsException e) {}
    } //rotations

    public void i2() {

    } //rotations

    public void i3() {

    } //rotations

    public void i4() {

    } //rotations
    
    public void j1() {} //rotations
    public void j2() {} //rotations
    public void j3() {} //rotations
    public void j4() {} //rotations
    public void l1() {} //rotations
    public void l2() {} //rotations
    public void l3() {} //rotations
    public void l4() {} //rotations
    public void s1() {} //rotations
    public void s2() {} //rotations
    public void s3() {} //rotations
    public void s4() {} //rotations
    public void t1() {} //rotations
    public void t2() {} //rotations
    public void t3() {} //rotations
    public void t4() {} //rotations
    public void z1() {} //rotations
    public void z2() {} //rotations
    public void z3() {} //rotations
    public void z4() {} //rotations
} //moves
