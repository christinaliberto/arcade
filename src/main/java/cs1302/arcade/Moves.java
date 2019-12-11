package cs1302.arcade;

import javafx.scene.paint.Color;
import javafx.scene.Node;
import cs1302.arcade.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;

/** applies the moves and rotations to the tetris game. */

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
    Rectangle[] shape = new Rectangle[4] ;
    GridPane grids;
    int xint;
    int yint;
    int rotations = 0;
    String id;
    Color current;

    /** constructor for move values. 
     *@param x the shape
     *@param grid the grid
     *@param k the x value
     *@param l the y value
     *@param ident the identity
     *@param co the color
     *@param a one rectangle
     *@param b second rectangle
     *@param c thrid rectangle
     *@param d fourth rectangle
     */
    
    public Moves(Rectangle[] x, GridPane grid, int k, int l, String ident, Color co,
                 Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        s1 = a;
        s2 = b;
        s3 = c;
        s4 = d;
	shape[0] = s1;
	shape[1] = s2;
	shape[2] = s3;
	shape[3] = s4;
        grids = grid;
        xint = k;
        yint = l;
        id = ident;
        current = co;
    }

    /** calls the proper method to match the key clicked.
     * @param type the key pressed
     */
    
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

    /** adds a new rectangle to the grid.
     * @param row the row
     * @param col the column
     * @return Rectangle    
     */
    
    public Rectangle addNewRect(int row, int col) {
        Rectangle s = new Rectangle(30, 30);
        s.setFill(current);
        grids.add(s, row, col);
        return s;
    }

    /**  moves the tetrimino down one row. */
    
    public void moveDown() {
	int col, row;
        boolean canMove = true;
	for(Rectangle r : shape) {
            if(r != null) {
		col = GridPane.getColumnIndex(r);
                row = GridPane.getRowIndex(r);
                if(row == 19) { 
                    canMove = false;
                } else { 
                    Rectangle next = getPane(col, row + 1);
                    if(next != null && isPiece(next) == false) {
                        canMove = false;
                    }
		    
                }
            }
        }

	if(canMove) {
	    yint++;
	    for(Rectangle r : shape) {
		if(r != null) {
		    row = GridPane.getRowIndex(r);
		    GridPane.setRowIndex(r, row + 1);
		    
		}
	    }
	}
    }
        

    /**  moves the tetrimino  left one column. */
    
    public void moveLeft() {
	 int col, row;
        boolean canMove = true;
        for(Rectangle r : shape) {
            if(r != null) {
		col = GridPane.getColumnIndex(r);
                row = GridPane.getRowIndex(r);
                if(row == 19) {
                    canMove = false;
                } else {
                    Rectangle next = getPane(col - 1, row);
                    if(next != null && isPiece(next) == false) {
                        canMove = false;
                    }

		}
            }
        }

        if(canMove) {
            yint++;
            for(Rectangle r : shape) {
                if(r != null) {
                    col = GridPane.getColumnIndex(r);
                    GridPane.setColumnIndex(r, col - 1);

                }
            }
        }

    } //moveleft

    /**  moves the tetrimino  right one column. */

    public void moveRight() {
	 int col, row;
        boolean canMove = true;
        for(Rectangle r : shape) {
            if(r != null) {
		col = GridPane.getColumnIndex(r);
                row = GridPane.getRowIndex(r);
                if(row == 19) {
                    canMove = false;
                } else {
                    Rectangle next = getPane(col + 1, row);
                    if(next != null && isPiece(next) == false) {
                        canMove = false;
                    }

		}
            }
        }

        if(canMove) {
            yint++;
            for(Rectangle r : shape) {
                if(r != null) {
                    col = GridPane.getColumnIndex(r);
                    GridPane.setColumnIndex(r, col + 1);

                }
            }
        }

    } // move right

    /** returns the value of a pane on the grid.
     *@param row the row
     *@param col the column
     *@return Rectangle
     */
    
    public Rectangle getPane(int col, int row) {
        for (Node node : grids.getChildren()) {
            if (node != null && GridPane.getColumnIndex(node) != null
                && GridPane.getRowIndex(node) != null) {
                if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                    return (Rectangle)node;
                }
            }
        }
        return null;
    }

    /** deternines if a rectangle is a piece of the tetrimino.  
     * @param x the rectangle
     * @return boolean
     */
    
    public boolean isPiece(Rectangle x) {
        if (x == s1 || x == s2 || x == s3 || x == s4) {
            return true;
        } else {
            return false;
        } //if            
    } //is piece

    /** uses the type to determine which rotate method to use. */
    
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
    
    /** uses the location of the tetrimino to determine the proper rotate method. */
    
    public void sqLoc() {

    } //location

    /** uses the location of the tetrimino to determine the proper rotate method. */
    
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

    /** uses the location of the tetrimino to determine the proper rotate method. */
    
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

    /** uses the location of the tetrimino to determine the proper rotate method. */
    
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

    /** uses the location of the tetrimino to determine the proper rotate method. */
    
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

    /** uses the location of the tetrimino to determine the proper rotate method. */
    
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

    /** uses the location of the tetrimino to determine the proper rotate method. */
    
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

    /** removes rectangles for rotation process. */

    public void remove() {
        grids.getChildren().remove(s2);
        grids.getChildren().remove(s3);
        grids.getChildren().remove(s4);
    } //remove

    /** rotates tetromino to desired position. */
    
    public void i1() {
        try {
            Rectangle next2 = getPane(xint, yint + 1);
            Rectangle next3 = getPane(xint, yint + 2);
            Rectangle next4 = getPane(xint, yint + 3);
            if (next2 == null && next3 == null && next4 == null) {
                remove();
                s2 = addNewRect(xint, yint + 1);
                s3 = addNewRect(xint, yint + 2);
                s4 = addNewRect(xint, yint + 3);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block
        }
    } //rotations

    /** rotates tetromino to desired position. */
    
    public void i2() {
        try {
            Rectangle next2 = getPane(xint - 1, yint);
            Rectangle next3 = getPane(xint - 2, yint);
            Rectangle next4 = getPane(xint - 3, yint);
            if (next2 == null && next3 == null && next4 == null) {
                remove();
                s2 = addNewRect(xint - 1, yint);
                s3 = addNewRect(xint - 2, yint);
                s4 = addNewRect(xint - 3, yint);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0;
        }
    } //rotations

    /** rotates tetromino to desired position. */
    
    public void i3() {
        try {
            Rectangle next2 = getPane(xint, yint - 1);
            Rectangle next3 = getPane(xint, yint - 2);
            Rectangle next4 = getPane(xint, yint - 3);
            if (next2 == null && next3 == null && next4 == null) {
                remove();
                s2 = addNewRect(xint, yint - 1);
                s3 = addNewRect(xint, yint - 2);
                s4 = addNewRect(xint, yint - 3);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block    
        }
    } //rotations

    /** rotates tetromino to desired position. */
    
    public void i4() {
        try {
            Rectangle next2 = getPane(xint + 1, yint);
            Rectangle next3 = getPane(xint + 2, yint);
            Rectangle next4 = getPane(xint + 3, yint);
            if (next2 == null && next3 == null && next4 == null) {
                remove();
                s2 = addNewRect(xint + 1, yint);
                s3 = addNewRect(xint + 2, yint);
                s4 = addNewRect(xint + 3, yint);
                rotations = 0;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block    
        }
    } //rotations

    /** rotates tetromino to desired position. */
    
    public void j1() {
        try {
            Rectangle next2 = getPane(xint, yint + 1);
            Rectangle next3 = getPane(xint, yint - 1);
            Rectangle next4 = getPane(xint + 1, yint - 1);
            if (next2 == null && next3 == null && next4 == null) {
                remove();
                s2 = addNewRect(xint, yint + 1);
                s3 = addNewRect(xint, yint - 1);
                s4 = addNewRect(xint + 1, yint - 1);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block
        }
    } //rotations

    /** rotates tetromino to desired position. */
    
    public void j2() {
        try {
            Rectangle next2 = getPane(xint - 1, yint);
            Rectangle next3 = getPane(xint + 1, yint);
            Rectangle next4 = getPane(xint + 1, yint + 1);
            if (next2 == null && next3 == null && next4 == null) {
                remove();
                s2 = addNewRect(xint - 1, yint);
                s3 = addNewRect(xint + 1, yint);
                s4 = addNewRect(xint + 1, yint + 1);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block
        }
    } //rotations

    /** rotates tetromino to desired position. */
    
    public void j3() {
        try {
            Rectangle next2 = getPane(xint, yint - 1);
            Rectangle next3 = getPane(xint, yint + 1);
            Rectangle next4 = getPane(xint - 1, yint + 1);
            if (next2 == null && next3 == null && next4 == null) {
                remove();
                s2 = addNewRect(xint, yint - 1);
                s3 = addNewRect(xint, yint + 1);
                s4 = addNewRect(xint - 1, yint + 1);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block    
        }
    } //rotations

    /** rotates tetromino to desired position. */
    
    public void j4() {
        try {
            Rectangle next2 = getPane(xint + 1, yint);
            Rectangle next3 = getPane(xint - 1, yint);
            Rectangle next4 = getPane(xint - 1, yint - 1);
            if (next2 == null && next3 == null && next4 == null) {
                remove();
                s2 = addNewRect(xint + 1, yint);
                s3 = addNewRect(xint - 1, yint);
                s4 = addNewRect(xint - 1, yint - 1);
                rotations = 0;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block
        }
    } //rotations

    /** rotates tetromino to desired position. */
    
    public void l1() {
        try {
            Rectangle next2 = getPane(xint, yint - 1);
            Rectangle next3 = getPane(xint, yint + 1);
            Rectangle next4 = getPane(xint + 1, yint + 1);
            if (next2 == null && next3 == null && next4 == null) {
                remove();
                s2 = addNewRect(xint, yint - 1);
                s3 = addNewRect(xint, yint + 1);
                s4 = addNewRect(xint + 1, yint + 1);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block
        }
    } //rotations

    /** rotates tetromino to desired position. */
    
    public void l2() {
        try {
            Rectangle next2 = getPane(xint + 1, yint);
            Rectangle next3 = getPane(xint - 1, yint);
            Rectangle next4 = getPane(xint - 1, yint + 1);
            if (next2 == null && next3 == null && next4 == null) {
                remove();
                s2 = addNewRect(xint + 1, yint);
                s3 = addNewRect(xint - 1, yint);
                s4 = addNewRect(xint - 1, yint + 1);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block    
        }
    } //rotations

    /** rotates tetromino to desired position. */
    
    public void l3() {
        try {
            Rectangle next2 = getPane(xint, yint + 1);
            Rectangle next3 = getPane(xint, yint - 1);
            Rectangle next4 = getPane(xint - 1, yint - 1);
            if (next2 == null && next3 == null && next4 == null) {
                remove();
                s2 = addNewRect(xint, yint + 1);
                s3 = addNewRect(xint, yint - 1);
                s4 = addNewRect(xint - 1, yint - 1);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block    
        }
    } //rotations

    /** rotates tetromino to desired position. */
    
    public void l4() {
        try {
            Rectangle next2 = getPane(xint - 1, yint);
            Rectangle next3 = getPane(xint + 1, yint);
            Rectangle next4 = getPane(xint + 1, yint - 1);
            if (next2 == null && next3 == null && next4 == null) {
                remove();
                s2 = addNewRect(xint - 1, yint);
                s3 = addNewRect(xint + 1, yint);
                s4 = addNewRect(xint + 1, yint - 1);
                rotations = 0;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block    
        }
    } //rotations

    /** rotates tetromino to desired position. */
    
    public void s1() {
        try {
            if (getPane(xint + 1, yint + 1) == null && getPane(xint + 1, yint) == null) {
                remove();
                s2 = addNewRect(xint, yint);
                s3 = addNewRect(xint + 1, yint);
                s4 = addNewRect(xint + 1, yint + 1);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block   
        }
    } //rotations

    /** rotates tetromino to desired position. */
    
    public void s2() {
        try {
            if (getPane(xint - 1, yint + 1) == null && getPane(xint, yint + 1) == null) {
                remove();
                s2 = addNewRect(xint, yint + 1);
                s3 = addNewRect(xint, yint);
                s4 = addNewRect(xint - 1, yint + 1);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block   
        }
    } //rotations

    /** rotates tetromino to desired position. */
    
    public void s3() {
        try {
            if (getPane(xint - 1, yint - 1) == null && getPane(xint - 1, yint) == null) {
                remove();
                s2 = addNewRect(xint, yint);
                s3 = addNewRect(xint - 1, yint - 1);
                s4 = addNewRect(xint - 1, yint);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block   
        }
    } //rotations

    /** rotates tetromino to desired position. */
    
    public void s4() {
        try {
            if (getPane(xint, yint - 1) == null && getPane(xint + 1, yint - 1) == null) {
                remove();
                s2 = addNewRect(xint, yint - 1);
                s3 = addNewRect(xint + 1, yint - 1);
                s4 = addNewRect(xint, yint);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block
        }
    } //rotations
    
    /** rotates tetromino to desired position. */
    
    public void t1() {
        try {
            Rectangle next2 = getPane(xint, yint);
            Rectangle next3 = getPane(xint, yint);
            Rectangle next4 = getPane(xint, yint);
            if (next2 == null && next3 == null && next4 == null) {
                remove();
                s2 = addNewRect(xint, yint);
                s3 = addNewRect(xint, yint);
                s4 = addNewRect(xint, yint);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block
        }
    } //rotations
    
    /** rotates tetromino to desired position. */
    
    public void t2() {
        try {
            Rectangle next2 = getPane(xint, yint + 1);
            Rectangle next3 = getPane(xint, yint + 2);
            Rectangle next4 = getPane(xint, yint + 3);
            if (next2 == null && next3 == null && next4 == null) {
                remove();
                s2 = addNewRect(xint, yint + 1);
                s3 = addNewRect(xint, yint + 2);
                s4 = addNewRect(xint, yint + 3);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block
        }
    } //rotations
    
    /** rotates tetromino to desired position. */
    
    public void t3() {
        try {
            Rectangle next2 = getPane(xint, yint + 1);
            Rectangle next3 = getPane(xint, yint + 2);
            Rectangle next4 = getPane(xint, yint + 3);
            if (next2 == null && next3 == null && next4 == null) {
                remove();
                s2 = addNewRect(xint, yint + 1);
                s3 = addNewRect(xint, yint + 2);
                s4 = addNewRect(xint, yint + 3);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block
        }
    } //rotations
    
    /** rotates tetromino to desired position. */
    
    public void t4() {
        try {
            Rectangle next2 = getPane(xint, yint + 1);
            Rectangle next3 = getPane(xint, yint + 2);
            Rectangle next4 = getPane(xint, yint + 3);
            if (next2 == null && next3 == null && next4 == null) {
                remove();
                s2 = addNewRect(xint, yint + 1);
                s3 = addNewRect(xint, yint + 2);
                s4 = addNewRect(xint, yint + 3);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block
        }
    } //rotations

    /** rotates tetromino to desired position. */
    
    public void z1() {
        try {
            if (getPane(xint, yint + 1) == null && getPane(xint + 1, yint - 1) == null) {
                remove();
                s2 = addNewRect(xint, yint + 1);
                s3 = addNewRect(xint + 1, yint - 1);
                s4 = addNewRect(xint, yint);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block
        }
    } //rotations
    
    /** rotates tetromino to desired position. */
    
    public void z2() {
        try {
            if (getPane(xint - 1, yint) == null && getPane(xint + 1, yint + 1) == null) {
                remove();
                s2 = addNewRect(xint, yint);
                s3 = addNewRect(xint + 1, yint + 1);
                s4 = addNewRect(xint - 1, yint);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block
        }
    } //rotations
    
    /** rotates tetromino to desired position. */
    
    public void z3() {
        try {
            if (getPane(xint, yint - 1) == null && getPane(xint - 1, yint + 1) == null) {
                remove();
                s2 = addNewRect(xint, yint - 1);
                s3 = addNewRect(xint - 1, yint + 1);
                s4 = addNewRect(xint, yint);
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block
        }
    } //rotations
    
    /** rotates tetromino to desired position. */
    
    public void z4() {
        try {
            if (getPane(xint + 1, yint) == null && getPane(xint - 1, yint - 1) == null) {
                remove();
                s2 = addNewRect(xint, yint);
                s3 = addNewRect(xint - 1, yint - 1);
                s4 = addNewRect(xint + 1, yint );
                rotations++;
            }
        } catch (IndexOutOfBoundsException e) {
            int nothing = 0; //for checkstyle no empty block
        }
    } //rotations
    
} //moves
