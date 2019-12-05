package application;

import javafx.scene.shape.*;

public class Controller {

    public static final int MOVE = Tetris.MOVE;
    public static final int SIZE = Tetris.SIZE;
    public static int XMAX = Tetris.XMAX;
    public static int YMAX = Tetris.YMAX;
    public static int [][] GRID = Tetris.GRID;

    public static void MoveRight(Form form) {
	if (form.a.getX() + MOVE <= XMAX - SIZE && form.b.getX() + MOVE <= XMAX - SIZE && form.c.getX() + MOVE <= XMAX - SIZE && form.d.getX() + MOVE <= XMAX - SIZE) {
	    int movea = GRID[((int) form.a.getX() / SIZE) + 1][((int) form.a.getY() / SIZE)];
	    int	moveb =	GRID[((int) form.b.getX() / SIZE) + 1][((int) form.b.getY() / SIZE)];
	    int	movec =	GRID[((int) form.c.getX() / SIZE) + 1][((int) form.c.getY() / SIZE)];
	    int	moved =	GRID[((int) form.d.getX() / SIZE) + 1][((int) form.d.getY() / SIZE)];
	    if (movea == 0 && movea == moveb && moveb == movec && movec == moved ) {
		form.a.setX(form.a.getX() + MOVE);
		form.b.setX(form.b.getX() + MOVE);
		form.c.setX(form.c.getX() + MOVE);
		form.d.setX(form.d.getX() + MOVE);
	    } //if
	} //if
    } //MoveRight

    public static void MoveLeft(Form form) {
        if (form.a.getX() - MOVE >= 0 && form.b.getX() - MOVE >= 0 && form.c.getX() - MOVE >= 0 && form.d.getX() - MOVE >= 0) {
            int	movea =	GRID[((int) form.a.getX() / SIZE) - 1][((int) form.a.getY() / SIZE)];
            int moveb = GRID[((int) form.b.getX() / SIZE) - 1][((int) form.b.getY() / SIZE)];
            int movec = GRID[((int) form.c.getX() / SIZE) - 1][((int) form.c.getY() / SIZE)];
            int moved = GRID[((int) form.d.getX() / SIZE) - 1][((int) form.d.getY() / SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved ) {
		form.a.setX(form.a.getX() - MOVE);
                form.b.setX(form.b.getX() - MOVE);
                form.c.setX(form.c.getX() - MOVE);
                form.d.setX(form.d.getX() - MOVE);
            } //if
	} //if                                                                                                                                                    
    } //MoveLeft
    
    
} //Controller
