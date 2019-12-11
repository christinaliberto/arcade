package cs1302.arcade;

import cs1302.arcade.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import java.util.Random;


/** creates all the tetrominoes for the tetris game. */

public class Square {

    public int x = 4;
    public int y;
    public Rectangle s1 = new Rectangle(30,30); //the four rectangles for all tetriminoes
    public Rectangle s2 = new Rectangle(30,30);
    public Rectangle s3 = new Rectangle(30,30);
    public Rectangle s4 = new Rectangle(30,30);
    public Rectangle[] shape = { s1, s2, s3, s4 }; // array to keep them together
    public String identity = "";
    public int rotations = 0;
    public Color current;
    public Moves move;

    /** construct a random tetromino. 
     * @param grid the grid
     */
    
    public Square(GridPane grid) {
        String[] tetromino = {"sq","I","J","L","T","S","Z"}; //all possible tetrominos
        int r = (int)(Math.random() * 7); //to choose random tetromnio
        if (tetromino[r].equals("sq")) {
            sq(grid);
            identity = "sq";
        } else if (tetromino[r].equals("I")) {
            i(grid);
            identity = "I";
        } else if (tetromino[r].equals("J")) {
            j(grid);
            identity = "J";
        } else if (tetromino[r].equals("L")) {
            l(grid);
            identity = "L";
        } else if (tetromino[r].equals("T")) {
            t(grid);
            identity = "T";
        } else if (tetromino[r].equals("S")) {
            s(grid);
            identity = "S";
        } else if (tetromino[r].equals("Z")) {
            z(grid);
            identity = "Z";
        } //if
        move = new Moves(shape, grid, x, y, identity, current, s1, s2, s3, s4);
    } //square

    /** creates a square tetromino.
     * @param grid the grid                                                                    
     */
    
    public void sq(GridPane grid) {
        s1 = new Rectangle(30,30); //bricks
        s2 = new Rectangle(30,30);
        s3 = new Rectangle(30,30);
        s4 = new Rectangle(30,30);
        current = Color.YELLOW;
        s1.setFill(current); //color
        s2.setFill(current);
        s3.setFill(current);
        s4.setFill(current);
        y = 0;
        grid.add(s1,x,y);
        grid.add(s2,x + 1,y);
        grid.add(s3,x,y + 1);
        grid.add(s4,x + 1 ,y + 1); //add to grid positions
        
    } //sq

    /** creates the I tetromino.                                                                   
     * @param grid the grid   
     */
    
    public void i(GridPane grid) {
        s1 = new Rectangle(30,30); //blocks
        s2 = new Rectangle(30,30);
        s3 = new Rectangle(30,30);
        s4 = new Rectangle(30,30);
        current = Color.TURQUOISE;
        s1.setFill(current); //color
        s2.setFill(current);
        s3.setFill(current);
        s4.setFill(current);
        y = 0;
        grid.add(s1,x,y);
        grid.add(s2,x + 1,y);
        grid.add(s3,x + 2,y);
        grid.add(s4,x + 3 ,y); //add to grid
        
    } //i

    /** creates the T tetromino.    
     * @param grid the grid      
     */
    
    public void t(GridPane grid) {
        s1 = new Rectangle(30,30); //blocks
        s2 = new Rectangle(30,30);
        s3 = new Rectangle(30,30);
        s4 = new Rectangle(30,30);
        current = Color.HOTPINK;
        s1.setFill(Color.HOTPINK); //color
        s2.setFill(Color.HOTPINK);
        s3.setFill(Color.HOTPINK);
        s4.setFill(Color.HOTPINK);
        y = 1;
        grid.add(s1,x,y);
        grid.add(s2,x,y - 1);
        grid.add(s3,x + 1,y);
        grid.add(s4,x - 1,y); //add to grid
        
    } //t
    
    /** creates the J tetromino.                                                 
     * @param grid the grid     
     */
    
    public void j(GridPane grid) {
        s1 = new Rectangle(30,30); //blocks
        s2 = new Rectangle(30,30);
        s3 = new Rectangle(30,30);
        s4 = new Rectangle(30,30);
        current = Color.BLUE;
        s1.setFill(current); //color
        s2.setFill(current);
        s3.setFill(current);
        s4.setFill(current);
        y = 1;
        grid.add(s1,x,y);
        grid.add(s2,x - 1,y);
        grid.add(s3,x - 1,y - 1);
        grid.add(s4,x + 1 ,y); //add to grid
        
    }

    /** creates the L tetromino. 
     * @param grid the grid                    
     */
    
    public void l(GridPane grid) {
        s1 = new Rectangle(30,30); //blocks
        s2 = new Rectangle(30,30);
        s3 = new Rectangle(30,30);
        s4 = new Rectangle(30,30);
        current = Color.ORANGE;
        s1.setFill(current); //color
        s2.setFill(current);
        s3.setFill(current);
        s4.setFill(current);
        y = 1;
        grid.add(s1, x, y);
        grid.add(s2, x + 1, y);
        grid.add(s3, x + 1, y - 1);
        grid.add(s4, x - 1 , y); //add to grid
        
    }

    /** creates the S tetromino.
     * @param grid the grid                 
     */
    
    public void s(GridPane grid) {
        s1 = new Rectangle(30,30); //blocks
        s2 = new Rectangle(30,30);
        s3 = new Rectangle(30,30);
        s4 = new Rectangle(30,30);
        current = Color.LIMEGREEN;
        s1.setFill(current); //color
        s2.setFill(current);
        s3.setFill(current);
        s4.setFill(current);
        y = 1;
        grid.add(s1, x, y);
        grid.add(s2, x, y - 1);
        grid.add(s3, x + 1, y - 1);
        grid.add(s4, x - 1, y ); //add to grid

    }

    /** creates the Z tetromino.
     * @param grid the grid                                                   
     */
    
    public void z(GridPane grid) {
        s1 = new Rectangle(30,30); //blocks
        s2 = new Rectangle(30,30); 
        s3 = new Rectangle(30,30);
        s4 = new Rectangle(30,30);
        current = Color.RED;
        s1.setFill(current); //color
        s2.setFill(current);
        s3.setFill(current);
        s4.setFill(current);
        y = 1;
        grid.add(s1, x, y);
        grid.add(s2, x, y - 1);
        grid.add(s3, x - 1, y - 1);
        grid.add(s4, x + 1 , y); //add to grid

    }

    //the following methods make the move class
    //available to the main tetris class
    
    /** calls move class for movement.  
     * @param type the type
     */
    
    public void move(String type) {
        move.direction(type);
    } //move 
    
    /** calls move class for timeline. 
     * @return boolean
     */

    public boolean down() {
        if (move.moveDown() == false) {
            return false;
        } else {
            return true;
        }
    }
    
    /** calls move class for tetris class access. 
     * @param col the column
     * @param row the row
     * @return Rectangle
     */
    
    public Rectangle getFromGrid( int col, int row) {
        return move.getPane( col, row);
    }
    
} //square
