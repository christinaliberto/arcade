package cs1302.arcade;


public class Board {

    
    public final int rows = 8;
    public final int columns = 8;
    public char board[][];
    public int player1Score = 0;
    public int player2Score = 0;
    public int remainingTiles;
    
    public Board() {
	board = new char[8][8];
	player1Score = 2;
	player2Score = 2;
    }

    public int getPlayer1Score() {
	return player1Score;
    }

    public int getPlayer2Score() {
	return player2Score;
    }

    public void initializeGameBoard() {
	for (int i = 0; i < board.length; i++) {
	    for (int x = 0; x < board[0].length; x++) {
		board[i][x] = '-';
	    }
	}
	board[3][3] = 'c';
	board[4][4] = 'c';
	board[4][3] = 'w';
	board[3][4] = 'w';
    }

    public int returnRemaining() {
	return remainingTiles;
    }

    public boolean endGame() {

	boolean canMove = false;

	for (int i = 0; i < 8; i++) {
	    for (int x = 0; x < 8; x++) {
		if (board[i][x] == '*') {
		    canMove = true;
		}
	    }
	}
	if (canMove == false) {
	    return true;
	}
	if (returnRemaining() == 0) {
	    return true;
	}

	return false;
    }

    public void scores() {

	remainingTiles = 0;
	player1Score = 0;
	player2Score = 0;

	for (int i = 0; i < 8; i++) {
	    for (int x = 0; x < 8; x++) {
		if (board[i][x] == 'c') {
		    player1Score++;
		} else if(board[i][x] == 'w') {
		    player2Score++;
		}
		else {
		    remainingTiles++;
		}
	    }
	}
    }

    public boolean valid(int xLoc, int yLoc) {

	if (board[xLoc][yLoc] == '*') {
	    return true;
	}
	return false;
    }

    public void move(Player player, int x, int y) {

	char other = ' ';
	if (player.getColor() == 'c') {
	    other = 'w';
	} else {
	    other = 'c';
	}

	board[x][y] = player.getColor();

	int x1 = x;
	int y1 = y;

	if (x - 1 >= 0 &&  y - 1 >= 0 && board[x - 1][y - 1] == other) {
	    x--;
	    y--;
	    while (x > 0 && y > 0 && board[x][y] == other) {
		x--;
		y--;
	    }
	    if (x >= 0 && y >= 0 && board[x][y] == player.getColor()) {
		while (x != x1 - 1 && y != y1 - 1) {
		    board[++x][++y] = player.getColor();
		}
	    }
	}

	x = x1;
	y = y1;

	if (x - 1 >= 0 && board[x-1][y] == other) {
	    x--;
	}
	if (x >= 0 && board[x][y] == player.getColor()) {
	    while (x != x1 - 1) {
		board[++x][y] = player.getColor();
	    }
	}

	x = x1;

	if (x - 1 >= 0 && y + 1 < columns && board[x - 1][y + 1] == other) {
	    x = x - 1;
	    y = y + 1;
	    while (x > 0 && y < columns - 1 && board[x][y] == other) {
		x--;
		y++;
	    }
	    if (x >= 0 && y < columns && board[x][y] == player.getColor()) {
		while (x != x1 - 1 && y != y1 + 1) {
		    board[x++][y--] = player.getColor();
		}
	    }
	}

	x = x1;
	y = y1;
	if (y - 1 >= 0 && board[x][y - 1] == other) {
	    y = y - 1;
	    while (y > 0 && board[x][y] == other) {
		y--;
	    }
	    if (y >= 0 && board[x][y] == player.getColor()) {
		while (y != y1 - 1) {
		    board[x][y++] = player.getColor();
		}
	    }
	}

	y = y1;
	if (y + 1 < columns && board[x][y + 1] == other) {
	    y = y + 1;
	    while (y < columns - 1 && board[x][y] == other) {
		y++;
	    }
	    if (y < columns && board[x][y] == player.getColor()) {
		while (y != y1 + 1) {
		    board[x][y--] = player.getColor();
		}
	    }
	}
	y = y1;
	if (x + 1 < rows && y - 1 >= 0 && board[x + 1][y - 1] == other) {
	    x++;
	    y--;
	    while (x < rows - 1 && y > 0 && board[x][y] == other) {
		x++;
		y--;
	    }
	    if (x < rows && y >= 0 && board[x][y] == player.getColor()) {
		while (x != x1 + 1 && y != y1 - 1) {
		    board[x--][y++] = player.getColor();
		}
	    }
	}

	x = x1;
	y = y1;

	if (x + 1 < rows && board[x + 1][y] == other) {
	    x++;
	    while (x < rows - 1 && board[x][y] == other) {
		x++;
	    }
	    if (x < rows && board[x][y] == player.getColor()) {
		while (x != x1 + 1) {
		    board[x--][y] = player.getColor();
		}
	    }
	}

	x = x1;
	if (x + 1 < rows && y + 1 < columns && board[x + 1][y + 1] == other) {
	    x++; y++;
	    while (x < rows - 1 && y < columns - 1 && board[x][y] == other) {
		x++; y++;
	    }
	    if (x < rows && y < columns && board[x][y] == player.getColor()){
		while (x != x1 + 1 && y != y1 + 1) {
		    board[x--][y--] = player.getColor();
		}
	    }
	}
    }

    public void hint(Player player) {

	char other = ' ';
	char playerColor = player.getColor();
	
	if (player.getColor() == 'c') {
	    other = 'w';
	} else {
	    other = 'c';
	}

	for (int i = 0; i < 8; i++) {
	    for (int x = 0; x < 8; x++) {
		if (board[i][x] == other) {
		    int i1 = i;
		    int x1 = x;
		    if (i - 1 >= 0 && x - 1 >= 0 && board[i - 1][x - 1] == '-') {
			i = i++;
			x = x++;
			while (i < 7 && x < 7 && board[i][x] == other) {
			    i++;
			    x++;
			}
			if (i <= 7 && x <= 7 && board[i][x] == playerColor) {
			    board[i1 - 1][x1 - 1] = '*';
			}
		    }
		    i = i1; x = x1;
		    if (i - 1 >= 0 && board[i -1][x] == '-') {
			i++;
			while(i < 7 && board[i][x] == other) {
			    i++;
			}
			if (i <= 7 && board[i][x] == playerColor) {
			    board[i1 - 1][x1] = '*';
			}
		    }
		    i = i1;
		    if (i - 1 >= 0 && x + 1 <= 7 && board[i - 1][x + 1] == '-') {
			i++;
			x--;
			while(i < 7 && x > 0 && board[i][x] == other) {
			    i++; x++;
			}
			if (i <= 7 && x >= 0 && board[i][x] == playerColor) {
			    board[i1 - 1][x1 + 1] = '*';
			}
		    }
		    i = i1;
		    x = x1;

		    if (x - 1 >= 0 && board[i][x - 1] == '-') {
			x++;
			while (x < 7 && board[i][x] == other) {
			    x++;
			}
			if (x <= 7 && board[i][x] == playerColor) {
			    board[i1][x1 - 1] = '*';
			}
		    }
		    x = x1;
		    if (x + 1 <= 7 && board[i][x + 1] == '-') {
			x--;
			while (x > 0 && board[i][x] == other) {
			    x--;
			}
			if (x >= 0 && board[i][x] == playerColor) {
			    board[i1][x1 + 1] = '*';
			}
		    }
		    x = x1;
		    if (i + 1 <= 7 && x - 1 >= 0 && board[i + 1][x-1] == '-') {
			i--;
			x++;
			while (i > 0 && x < 7 && board[i][x] == other) {
			    i--; x++;
			}
			if (i >= 0 && x <= 7 && board[i][x] == playerColor) {
			    board[i1 + 1][x1 - 1] = '*';
			}
		    }
		    i = i1;
		    x = x1;
		    if (i + 1 <= 7 && board[i + 1][x] == '-') {
			i--;
			while (i > 0 && board[i][x] == other) {
			    i--;
			}
			if (i >= 0 && board[i][x] == playerColor) {
			    board[i1 + 1][x1] = '*';
			}
		    }
		    i = i1;
		    if (i + 1 <= 7 && x + 1 <= 7 && board[i + 1][x + 1] == '-') {
			i--; x--;
			while (i > 0 && x > 0 && board[i][x] == other) {
			    i--; x--;
			}
			if (i >= 0 && x >= 0 && board[i][x] == playerColor) {
			    board[i1 + 1][x1 + 1] = '*';
			}
		    }
		    i = i1;
		    x = x1;
		}
	    }
	}
    }

    public void resetBoard() {
	for (int i = 0; i < rows; i++) {
	    for (int x = 0; x < columns; x++) {
		if (board[i][x] == '*') {
		    board[i][x] = '-';
		}
	    }
	}
    }

}
			  
				
			
				
			       
				
				  
								    

		
				   
					     
	
	
	   
	
	
    

    
     
	 
    
    
    

	

    
			
