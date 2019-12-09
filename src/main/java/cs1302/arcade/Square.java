package cs1302.arcade;

import cs1302.arcade.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import java.util.Random;

public class Square {

    public int x = 4;
    public int y;
    public Rectangle s1 = new Rectangle(30,30);
    public Rectangle s2 = new Rectangle(30,30);
    public Rectangle s3 = new Rectangle(30,30);
    public Rectangle s4 = new Rectangle(30,30);
    public Rectangle[] shape = { s1, s2, s3, s4 };
    public String identity = "";
    public int rotations = 0;
    
    public Square(GridPane grid) {
	String[] tetromino = {"sq","I","J","L","T","S","Z"};
	int r = (int)(Math.random() * 7);
	if (tetromino[r].equals("sq")) {
	    sq(grid);
	    identity = "sq";
	    rotations =	0;
	} else if (tetromino[r].equals("I")) {
	    I(grid);
	     identity = "I";
	     rotations = 0;
	} else if (tetromino[r].equals("J")) {
	    J(grid);
	    identity = "J";
	    rotations =	0;
	} else if (tetromino[r].equals("L")) {
	    L(grid);
	     identity = "L";
	     rotations = 0;
	} else if (tetromino[r].equals("T")) {
	    T(grid);
	    identity = "T";
	    rotations =	0;
	} else if (tetromino[r].equals("S")) {
	    S(grid);
	    identity = "S";
	    rotations =	0;
	} else if (tetromino[r].equals("Z")) {
	    Z(grid);
	    identity = "Z";
	    rotations =	0;
	}
    }

    public void sq(GridPane grid) {
        s1 = new Rectangle(30,30);
        s2 = new Rectangle(30,30);
        s3 = new Rectangle(30,30);
        s4 = new Rectangle(30,30);
	s1.setFill(Color.YELLOW);
	s2.setFill(Color.YELLOW);
	s3.setFill(Color.YELLOW);
	s4.setFill(Color.YELLOW);
	y = 0;
	grid.add(s1,x,y);
	grid.add(s2,x + 1,y);
	grid.add(s3,x,y + 1);
	grid.add(s4,x + 1 ,y + 1);
	
    }

    public void I(GridPane grid) {
        s1 = new Rectangle(30,30);
        s2 = new Rectangle(30,30);
        s3 = new Rectangle(30,30);
        s4 = new Rectangle(30,30);
	s1.setFill(Color.TURQUOISE);
	s2.setFill(Color.TURQUOISE);
	s3.setFill(Color.TURQUOISE);
	s4.setFill(Color.TURQUOISE);
	y = 0;
	grid.add(s1,x,y);
	grid.add(s2,x + 1,y);
	grid.add(s3,x + 2,y);
	grid.add(s4,x + 3 ,y);
	
    }

    public void T(GridPane grid) {
        s1 = new Rectangle(30,30);
        s2 = new Rectangle(30,30);
        s3 = new Rectangle(30,30);
	s4 = new Rectangle(30,30);
	s1.setFill(Color.HOTPINK);
	s2.setFill(Color.HOTPINK);
	s3.setFill(Color.HOTPINK);
	s4.setFill(Color.HOTPINK);
	y = 1;
	grid.add(s1,x,y);
	grid.add(s2,x,y - 1);
	grid.add(s3,x + 1,y);
	grid.add(s4,x - 1,y);
	
    }

    public void J(GridPane grid) {
      s1 = new Rectangle(30,30);
      s2 = new Rectangle(30,30);
      s3 = new Rectangle(30,30);
      s4 = new Rectangle(30,30);
      s1.setFill(Color.BLUE);
      s2.setFill(Color.BLUE);
      s3.setFill(Color.BLUE);
      s4.setFill(Color.BLUE);
      y = 1;
      grid.add(s1,x,y);
      grid.add(s2,x - 1,y);
      grid.add(s3,x - 1,y - 1);
      grid.add(s4,x + 1 ,y);
	
    }

    public void L(GridPane grid) {
        s1 = new Rectangle(30,30);
        s2 = new Rectangle(30,30);
        s3 = new Rectangle(30,30);
	s4 = new Rectangle(30,30);
	s1.setFill(Color.ORANGE);
	s2.setFill(Color.ORANGE);
	s3.setFill(Color.ORANGE);
	s4.setFill(Color.ORANGE);
	y = 1;
	grid.add(s1, x, y);
	grid.add(s2, x + 1, y);
	grid.add(s3, x + 1, y - 1);
	grid.add(s4, x - 1 , y);
	
    }

    public void S(GridPane grid) {
        s1 = new Rectangle(30,30);
        s2 = new Rectangle(30,30);
        s3 = new Rectangle(30,30);
        s4 = new Rectangle(30,30);
        s1.setFill(Color.LIMEGREEN);
        s2.setFill(Color.LIMEGREEN);
        s3.setFill(Color.LIMEGREEN);
        s4.setFill(Color.LIMEGREEN);
	y = 1;
	grid.add(s1, x, y);
        grid.add(s2, x, y - 1);
        grid.add(s3, x + 1, y - 1);
        grid.add(s4, x - 1, y );

    }

     public void Z(GridPane grid) {
        s1 = new Rectangle(30,30);
        s2 = new Rectangle(30,30);
        s3 = new Rectangle(30,30);
        s4 = new Rectangle(30,30);
        s1.setFill(Color.RED);
        s2.setFill(Color.RED);
        s3.setFill(Color.RED);
        s4.setFill(Color.RED);
	y = 1;
        grid.add(s1, x, y);
        grid.add(s2, x, y - 1);
        grid.add(s3, x - 1, y - 1);
        grid.add(s4, x + 1 , y);

    }

    public void move(String type, GridPane grid){
	Moves move = new Moves(shape, grid, x, y, type, s1, s2, s3, s4);
    }

    public void rotate(){
	if (identity.equals("sq")) {
            if ( rotations == 0 ) {
		
	    } else if (rotations == 1) {
		
	    } else if (rotations == 2) {
		
	    } else if (rotations == 3) {

	    } else if (rotations == 4) {

	    }
        } else if (identity.equals("I")) {
            if ( rotations == 0 ) {
		
            } else if (rotations == 1) {
		
            } else if (rotations == 2) {
		
            } else if (rotations == 3) {

            } else if (rotations == 4) {

            }
        } else if (identity.equals("J")) {
	    if ( rotations == 0 ) {
		
            } else if (rotations == 1) {
		
            } else if (rotations == 2) {
		
            } else if (rotations == 3) {

            } else if (rotations == 4) {

            }
        } else if (identity.equals("L")) {
	    if ( rotations == 0 ) {
		
            } else if (rotations == 1) {
		
            } else if (rotations == 2) {
		
            } else if (rotations == 3) {

            } else if (rotations == 4) {

            }
        } else if (identity.equals("T")) {
            if ( rotations == 0 ) {
		
            } else if (rotations == 1) {
		
            } else if (rotations == 2) {
		
            } else if (rotations == 3) {

            } else if (rotations == 4) {

            }
        } else if (identity.equals("S")) {
            if ( rotations == 0 ) {
		
            } else if (rotations == 1) {
		
            } else if (rotations == 2) {
		
            } else if (rotations == 3) {

            } else if (rotations == 4) {

            }
        } else if (identity.equals("Z")) {
            if ( rotations == 0 ) {
		
            } else if (rotations == 1) {
		
            } else if (rotations == 2) {
		
            } else if (rotations == 3) {

            } else if (rotations == 4) {

            } //if
        } //if
    } //rotations



}
