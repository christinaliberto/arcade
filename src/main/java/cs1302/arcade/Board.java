package cs1302.arcade;


public class Board {

    
    public final int rows = 8;
    public final int columns = 8;

    public char board[][];

    public int player1Score = 2;
    public int player2Score = 2;
    public int remainingTiles;
    
    public Board() {

	board = new char[rows][columns];

    }
    

    public int getPlayer1Score() {
	return player1Score;
    }

    public int getPlayer2Score() {
	return player2Score;
    }

    public void initializeGameBoard() {
	for (int i = 0; i < rows; i++) {
	    for (int x = 0; x < columns; x++) {
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
	   board[x][y] = player.color; 
       }
    

    public void hint(Player player) {

	for (int row = 0; row < 8; row++) {
	    for (int col = 0; col < 8; col++) {
		northHint(row, col, player);
		northEastHint(row, col, player);
		eastHint(row, col, player);
		southEastHint(row, col, player);
		southHint(row, col, player);
		southWestHint(row, col, player);
		westHint(row, col, player);
		northWestHint(row, col, player);
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


   public void northHint(int row, int col, Player player) {
	char opp = '?';
	char p = '?';
	if (player.color == 'c') {
	    p = 'c';
	    opp = 'w';
	} else {
	    p = 'w';
	    opp = 'c';
	}

	if (isInBounds(row + 1, col) && board[row][col] == opp && board[row + 1][col] == p) {
	    while (row < 8 && row >= 0) {
		if (board[row][col] == opp) {
		    row--;
		} else if (board[row][col] == '-') {
		    board[row][col] = '*';
		    row = 8;
		} else {
		    row = 8;
		}
	    }
	} else {
	    return;
	}
    }

    public void southHint(int row, int col, Player player) {
	char opp = '?';
	char p = '?';

	if (player.color == 'c') {
	    p = 'c';
	    opp = 'w';
	} else {
	    p = 'w';
	    opp = 'c';
	}

	if (isInBounds(row - 1, col) && board[row][col] == opp && board[row - 1][col] == p) {
	    while (row < 8) {
		if (board[row][col] == opp) {
		    row++;
		} else if (board[row][col] == '-') {
		    board[row][col] = '*';
		    row = 8;
		} else {
		    row = 8;
		}
	    }
	} else {
	    return;
	}
    }

    public void eastHint(int row, int col, Player player) {
	char p = '?';
	char opp = '?';

	if (player.color == 'c') {
	    p = 'c';
	    opp = 'w';
	} else {
	    p = 'w';
	    opp = 'c';
	}

	if (isInBounds(row, col - 1) && board[row][col] == opp && board[row][col - 1] == p) {
	    while (col < 8 && col >= 0) {
		if (board[row][col] == opp) {
		    col++;
		} else if (board[row][col] == '-') {
		    board[row][col] = '*';
		    col = 8;
		} else {
		    col = 8;
		}
	    }
	} else {
	    return;
	}
    }

    public void westHint(int row, int col, Player player) {
	char p = '?';
	char opp = '?';

	if (player.color == 'c') {
	    p = 'c';
	    opp = 'w';
	} else {
	    p = 'w';
	    opp = 'c';
	}

	if (isInBounds(row, col + 1) && board[row][col] == opp && board[row][col + 1] == p) {
	    while (col < 8 && col >= 0) {
		
		if (board[row][col] == opp) {
		    col --;
		} else if (board[row][col] == '-') {
		    board[row][col] = '*';
		    col = 8; 
		} else {
		    col = 8;
		}
	    }
	} else {
	    return;
	}
    }

    public void northEastHint(int row, int col, Player player) {
	char p = '?';
	char opp = '?';

	if (player.color == 'c') {
	    p = 'c';
	    opp = 'w';
	} else {
	    p = 'w';
	    opp = 'c';
	}

	if (isInBounds(row + 1, col - 1) && board[row][col] == opp && board[row + 1][col - 1] == p) {
	    while (col < 8 && row < 8 && row >= 0) {
		if (board[row][col] == opp) {
		    col++;
		    row--;
		} else if (board[row][col] == '-') {
		    board[row][col] = '*';
		    col = 8;
		} else {
		    col = 8;
		}
	    }
	} else {
	    return;
	}
    }

    public void northWestHint(int row, int col, Player player) {
	char p = '?';
	char opp = '?';
	if (player.color == 'c') {
	    p = 'c';
	    opp = 'w';
	} else {
	    p = 'w';
	    opp = 'c';
	}

	if (isInBounds(row + 1, col + 1) && board[row][col] == opp && board[row + 1][col + 1] == p) {
	    while (col < 8 && row < 8 && col >= 0 && row >= 0) {
		if (board[row][col] == opp) {
		    row--;
		    col--;
		} else if (board[row][col] == '-') {
		    board[row][col] = '*';
		    col = 8;
		} else {
		    col = 8;
		}
	    }
	} else {
	    return;
	}
    }

    public void southEastHint(int row, int col, Player player) {
	char p = '?';
	char opp = '?';
	if (player.color == 'c') {
	    p = 'c';
	    opp = 'w';
	} else {
	    p = 'w';
	    opp = 'c';
	}

	if (isInBounds(row - 1, col - 1) && board[row][col] == opp && board[row - 1][col - 1] == p) {
	    while (col < 8 && row < 8) {
		if (board[row][col] == opp) {
		    col++;
		    row++;
		} else if (board[row][col] == '-') {
		    board[row][col] = '*';
		    col = 8;
		} else {
		    col = 8;
		}
	    }
	} else {
	    return;
	}
    }

    public void southWestHint(int row, int col, Player player) {
	char p = '?';
	char opp = '?';

	if (player.color == 'c') {
	    p = 'c';
	    opp = 'w';
	} else {
	    p = 'w';
	    opp = 'c';
	}

	if (isInBounds(row - 1, col + 1) && board[row][col] == opp && board[row - 1][col + 1] == p) {
	    while (col < 8 && col >= 0 && row < 8) {
		if (board[row][col] == opp) {
		    row++;
		    col--;
		} else if (board[row][col] == '-') {
		    board[row][col] = '*';
		    col = 8;
		} else {
		    col = 8;
		}
	    }
	} else {
	    return;
	}
    }

    // public void flip(int x, int y) {
    //}

    //public void flipNorth(int x, int y) {


    public boolean isInBounds(int row, int col) {
	return (row < 8 && row >= 0 && col >=0 && col < 8);
    }
    
}		
			  
				
			
				
			       				
				  
								    

		
				   
					     
	
	
	   
	
	
    

    
     
	 
    
    
    

	

    
			
