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
    public Rectangle s1 = new Rectangle(30,30);
    public Rectangle s2 = new Rectangle(30,30);
    public Rectangle s3 = new Rectangle(30,30);
    public Rectangle s4 = new Rectangle(30,30);
    public Rectangle[] shape = { s1, s2, s3, s4 };
    public String identity = "";
    public int rotations = 0;

    /** construct a random tetromino. 
     * @param grid the grid
     */
    
    public Square(GridPane grid) {
        String[] tetromino = {"sq","I","J","L","T","S","Z"}; //all possible tetrominos
	int r = 1;
	//int r = (int)(Math.random() * 7); //to choose random tetromino
        if (tetromino[r].equals("sq")) {
            sq(grid);
            identity = "sq";
            rotations = 0;
        } else if (tetromino[r].equals("I")) {
            i(grid);
            identity = "I";
            rotations = 0;
        } else if (tetromino[r].equals("J")) {
            j(grid);
            identity = "J";
            rotations = 0;
        } else if (tetromino[r].equals("L")) {
            l(grid);
            identity = "L";
            rotations = 0;
        } else if (tetromino[r].equals("T")) {
            t(grid);
            identity = "T";
            rotations = 0;
        } else if (tetromino[r].equals("S")) {
            s(grid);
            identity = "S";
            rotations = 0;
        } else if (tetromino[r].equals("Z")) {
            z(grid);
            identity = "Z";
            rotations = 0;
        } //if
    } //square

    /** creates a square tetromino.
     * @param grid the grid                                                                    
     */
    
    public void sq(GridPane grid) {
        s1 = new Rectangle(30,30); //bricks
        s2 = new Rectangle(30,30);
        s3 = new Rectangle(30,30);
        s4 = new Rectangle(30,30);
        s1.setFill(Color.YELLOW); //color
        s2.setFill(Color.YELLOW);
        s3.setFill(Color.YELLOW);
        s4.setFill(Color.YELLOW);
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
        s1.setFill(Color.TURQUOISE); //color
        s2.setFill(Color.TURQUOISE);
        s3.setFill(Color.TURQUOISE);
        s4.setFill(Color.TURQUOISE);
        y = 5;
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
        s1.setFill(Color.BLUE); //color
        s2.setFill(Color.BLUE);
        s3.setFill(Color.BLUE);
        s4.setFill(Color.BLUE);
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
        s1.setFill(Color.ORANGE); //color
        s2.setFill(Color.ORANGE);
        s3.setFill(Color.ORANGE);
        s4.setFill(Color.ORANGE);
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
        s1.setFill(Color.LIMEGREEN); //color
        s2.setFill(Color.LIMEGREEN);
        s3.setFill(Color.LIMEGREEN);
        s4.setFill(Color.LIMEGREEN);
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
        s1.setFill(Color.RED); //color
        s2.setFill(Color.RED);
        s3.setFill(Color.RED);
        s4.setFill(Color.RED);
        y = 1;
        grid.add(s1, x, y);
        grid.add(s2, x, y - 1);
        grid.add(s3, x - 1, y - 1);
        grid.add(s4, x + 1 , y); //add to grid

    }

    /** calls move class for movement.  
     * @param grid the grid
     * @param type the type
     */
    
    public void move(String type, GridPane grid) {
        Moves move = new Moves(shape, grid, x, y, type, rotations, identity);
    } //move 


} //square
