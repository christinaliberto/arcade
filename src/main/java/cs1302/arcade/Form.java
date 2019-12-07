package cs1302.arcade;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;

public abstract class Form {

    public int rotate;
    public int moveX;
    public int moveY;
    public Color formFill;
    public GridPane grid;
    public Rectangle part1;
    public Rectangle part2;
    public Rectangle part3;
    public Rectangle part4;
    public Rectangle [] parts = new Rectangle[4];


    public Form(Color formFill, GridPane grid, int moveY) {
	rotate = 0; 
	this.formFill = formFill;
	this.grid = grid;
	this.moveY = moveY;
    }

    public Rectangle getRectangle(int column, int row) {

	if (column > 9 || column < 0) {
	    throw new IndexOutOfBoundsException();
	}
	if (row > 9 || row < 0)  {
	    throw new IndexOutOfBoundsException();
	}

	for (Node rectangleAtLocation : grid.getChildren()) {
	    if (rectangleAtLocation != null) {
		if (GridPane.getColumnIndex(rectangleAtLocation) != null) {
		    if (GridPane.getRowIndex(rectangleAtLocation) != null) {
			if (GridPane.getColumnIndex(rectangleAtLocation) == column) {
			    if (GridPane.getRowIndex(rectangleAtLocation) == row) {
				return (Rectangle)rectangleAtLocation;
			    }
			}
		    }
		}
	    }
	}
	    return null;
    }

    public void fillParts() {
	parts[0] = part1;
	parts[1] = part2;
	parts[2] = part3;
	parts[3] = part4;
    }

    public boolean notForm(Rectangle r) {
	if (r != part1) {
	    if (r != part2) {
		if (r != part3) {
		    if (r != part4) {
			return true;
		    }
		}
	    }
	}
	return false;
    }

    public boolean down() {
	int column;
	int row;
	boolean canGo = true;

	for (int i = 0; i < parts.length; i++) {
	    if (parts[i] != null) {
		column = GridPane.getColumnIndex(parts[i]);
		row = GridPane.getRowIndex(parts[i]);
		if (row == 19) {
		    canGo = false;
		} else {
		    Rectangle next = getRectangle(column, row + 1);
		    if (next != null) {
			if (notForm(next)) {
			    canGo = false;
			}
		    }
		}
	    }
	}

	if (canGo) {
	    for (int i = 0; i < parts.length; i++) {
		GridPane.setRowIndex(parts[i], GridPane.getRowIndex(parts[i]) + 1);
	    }
	    moveY++;
	}

	return canGo;
    }

    public void right() {

	int column;
	int row;
	boolean canGo = true;

	for (int i = 0; i < parts.length; i++) {
	    if (parts[i] != null) {
		column = GridPane.getColumnIndex(parts[i]);
		row = GridPane.getRowIndex(parts[i]);
		if (column == 9) {
		    canGo = false;
		} else {
		    Rectangle next = getRectangle(column + 1, row);
		    if (next != null) {
			if (notForm(next)) {
			    canGo = false;
			}
		    }
		}
	    }
	}
	if (canGo) {
	    for (int i = 0; i < parts.length; i++) {
		GridPane.setColumnIndex(parts[i], GridPane.getColumnIndex(parts[i]) + 1);
	    }
	    moveX++;
	}
    }

    

    public void left() {
	int column;
	int row;
	boolean canGo = true;

	for (int i = 0; i < parts.length; i++) {
	    if (parts[i] != null) {
		column = GridPane.getColumnIndex(parts[i]);
		row = GridPane.getRowIndex(parts[i]);
		if (column == 0) {
		    canGo = false;
		} else {
		    Rectangle next = getRectangle(column - 1, row);
		    if (next != null) {
			if (notForm(next)) {
			    canGo = false;
			}
		    }
		}
	    }
	}
	if (canGo) {
	    for (int i = 0; i < parts.length; i++) {
		GridPane.setColumnIndex(parts[i], GridPane.getColumnIndex(parts[i]) - 1);
	    }
	    moveX --;
	}
    }


    public Rectangle addToGrid(int column, int row) {
	Rectangle rectangle = new Rectangle(30, 30);
	rectangle.setFill(formFill);
	grid.add(rectangle, column, row);
	return rectangle;
    }

    public void remove(Rectangle rectangle) {
	grid.getChildren().remove(rectangle);
    }

    public void rotateForm() {
	if (rotate == 0) {
	    rotate90();
	}
	if (rotate== 90) {
	    rotate180();
	}
	if (rotate == 180) {
	    rotate270();
	}
	if (rotate == 270) {
	    rotate0();
	}
    }

        public void rotate0() {}                                                                                                                                                       
    public void rotate90() {}                                                                                                                                                     
    public void rotate180() {}                                                                                                                                                     
    public void rotate270() {}
}


	       
	    
	

    
		     
		    
    

    
							
		       
	
    
    

    
    
       
