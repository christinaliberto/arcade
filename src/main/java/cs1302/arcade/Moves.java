package cs1302.arcade;

import javafx.scene.paint.Color;
import javafx.scene.Node;
import cs1302.arcade.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;

public class Moves {

    boolean valid;
    Rectangle s1;
    Rectangle s2;
    Rectangle s3;
    Rectangle s4;
    Rectangle s5;
    Rectangle s6;
    Rectangle s7;
    Rectangle s8;
    public Rectangle[] shape = { s1, s2, s3, s4 };
    GridPane grids;
    int xint;
    int yint;
    int rotations = 0;
    String id;
    Color current;
    
    public Moves(Rectangle[] x, GridPane grid, int k, int l, String ident, Color co, Rectangle a, Rectangle b, Rectangle c, Rectangle d){
	s1 = a;
	s2 = b;
	s3 = c;
	s4 = d;
	grids = grid;
	xint = k;
	yint = l;
	id = ident;
	current = co;
    }

    public void direction( String type) {
	
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

    public Rectangle addNewRect(int row, int col) {
        Rectangle s = new Rectangle(30, 30);
        s.setFill(current);
        grids.add(s, row, col);
        return s;
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
	    if(node != null && GridPane.getColumnIndex(node)!= null
               && GridPane.getRowIndex(node) != null) {
		if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
		    return (Rectangle)node;
		}
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
	    i2();
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
            Rectangle next2 = getPane(xint, yint + 1);
            Rectangle next3 = getPane(xint, yint + 2);
            Rectangle next4 = getPane(xint, yint + 3);
            if(next2 == null && next3 == null && next4 == null) {
		grids.getChildren().remove(s2);
                grids.getChildren().remove(s3);
                grids.getChildren().remove(s4);
	        s2 = addNewRect(xint, yint + 1);
	        s3 = addNewRect(xint, yint + 2);
                s4 = addNewRect(xint, yint + 3);
		rotations++;
	    }
        } catch (IndexOutOfBoundsException e) {}
    } //rotations

    public void i2() {
	try {
            Rectangle next2 = getPane(xint - 1, yint);
            Rectangle next3 = getPane(xint - 2, yint);
            Rectangle next4 = getPane(xint - 3, yint);
            if(next2 == null && next3 == null && next4 == null) {
                grids.getChildren().remove(s2);
                grids.getChildren().remove(s3);
                grids.getChildren().remove(s4);
                s2 = addNewRect(xint - 1, yint);
                s3 = addNewRect(xint - 2, yint);
	        s4 = addNewRect(xint - 3, yint);
                rotations++;
            }
	} catch (IndexOutOfBoundsException e) {}
    } //rotations

    public void i3() {
	try {
            Rectangle next2 = getPane(xint, yint - 1);
            Rectangle next3 = getPane(xint, yint - 2);
            Rectangle next4 = getPane(xint, yint - 3);
            if(next2 == null && next3 == null && next4 == null) {
                grids.getChildren().remove(s2);
                grids.getChildren().remove(s3);
                grids.getChildren().remove(s4);
                s2 = addNewRect(xint, yint - 1);
                s3 = addNewRect(xint, yint - 2);
	        s4 = addNewRect(xint, yint - 3);
                rotations++;
            }
	} catch (IndexOutOfBoundsException e) {}
    } //rotations

    public void i4() {
	try {
            Rectangle next2 = getPane(xint + 1, yint);
            Rectangle next3 = getPane(xint + 2, yint);
            Rectangle next4 = getPane(xint + 3, yint);
            if(next2 == null && next3 == null && next4 == null) {
                grids.getChildren().remove(s2);
                grids.getChildren().remove(s3);
                grids.getChildren().remove(s4);
                s2 = addNewRect(xint + 1, yint);
                s3 = addNewRect(xint + 2, yint);
	        s4 = addNewRect(xint + 3, yint);
                rotations = 0;
            }
	} catch (IndexOutOfBoundsException e) {}
    } //rotations
    
    public void j1() {
	try {
            Rectangle next2 = getPane(xint, yint + 1);
            Rectangle next3 = getPane(xint, yint - 1);
            Rectangle next4 = getPane(xint + 1, yint - 1);
            if(next2 == null && next3 == null && next4 == null) {
                grids.getChildren().remove(s2);
                grids.getChildren().remove(s3);
                grids.getChildren().remove(s4);
                s2 = addNewRect(xint, yint + 1);
                s3 = addNewRect(xint, yint - 1);
                s4 = addNewRect(xint + 1, yint - 1);
                rotations = 0;
            }
        } catch (IndexOutOfBoundsException e) {}
    } //rotations

    public void j2() {
	try {
            Rectangle next2 = getPane(xint - 1, yint);
            Rectangle next3 = getPane(xint + 1, yint);
            Rectangle next4 = getPane(xint + 1, yint + 1);
            if(next2 == null && next3 == null && next4 == null) {
                grids.getChildren().remove(s2);
                grids.getChildren().remove(s3);
                grids.getChildren().remove(s4);
                s2 = addNewRect(xint - 1, yint);
                s3 = addNewRect(xint + 1, yint);
                s4 = addNewRect(xint + 1, yint + 1);
                rotations = 0;
            }
        } catch (IndexOutOfBoundsException e) {}
    } //rotations

    public void j3() {
	try {
            Rectangle next2 = getPane(xint, yint - 1);
            Rectangle next3 = getPane(xint, yint + 1);
            Rectangle next4 = getPane(xint - 1, yint + 1);
            if(next2 == null && next3 == null && next4 == null) {
                grids.getChildren().remove(s2);
                grids.getChildren().remove(s3);
                grids.getChildren().remove(s4);
                s2 = addNewRect(xint, yint - 1);
                s3 = addNewRect(xint, yint + 1);
                s4 = addNewRect(xint - 1, yint + 1);
                rotations = 0;
            }
        } catch (IndexOutOfBoundsException e) {}
    } //rotations

    public void j4() {
	try {
            Rectangle next2 = getPane(xint + 1, yint);
            Rectangle next3 = getPane(xint - 1, yint);
            Rectangle next4 = getPane(xint - 1, yint - 1);
            if(next2 == null && next3 == null && next4 == null) {
                grids.getChildren().remove(s2);
                grids.getChildren().remove(s3);
                grids.getChildren().remove(s4);
                s2 = addNewRect(xint + 1, yint);
                s3 = addNewRect(xint - 1, yint);
                s4 = addNewRect(xint - 1, yint - 1);
                rotations = 0;
            }
        } catch (IndexOutOfBoundsException e) {}
    } //rotations

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
