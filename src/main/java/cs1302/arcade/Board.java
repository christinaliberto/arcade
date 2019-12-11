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

    public void resetScore() {

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
	boolean valid = false; 
	for (int i = 0; i < rows; i++) {
	    for (int x = 0; x < columns; x++) {
		if (board[i][x] == '*') {
		    valid = true;
		}
	    }
	}
	if (valid == false || returnRemaining() == 0) {
	    return true;
	} else {
	    return false;
	}
        
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

    public void flip(int x, int y, Player player) {

	board[x][y] = player.color;

	flip1(x, y, player);
	flip2(x, y, player);
	flip3(x, y, player);
	flip4(x, y, player);
	flip5(x, y, player);
	flip6(x, y, player);
	flip7(x, y, player);
	flip8(x, y, player);
    }


    public void flip1(int x, int y, Player player) {
	
	char opp = '?';

	if (player.color == 'c') {
	    opp = 'w';
	} else {
	    opp = 'c';
	}

	int X = x;
	int Y = y;

	if (x - 1 >= 0 && y - 1 >= 0 && board[x - 1][y - 1] == opp) {
	    x = x - 1;
	    y = y - 1;
	    while (x > 0 && y > 0 && board[x][y] == opp) {
		x--;
		y--;
	    }
	    if (x >= 0 && y >= 0 && board[x][y] == player.color) {
		while (x != X - 1 && y != Y - 1) {
		    board[++x][++y] = player.color;
		}
	    }
	}
    }

    public void flip2(int x, int y, Player player) {

	char opp = '?';
	if (player.color == 'c') {
	    opp = 'w';
	} else {
	    opp = 'c';
	}
	
	int X = x;
	int Y = y;
	
	if (x - 1 >= 0 && board[x - 1][y] == opp) {
	    x = x - 1;
	    while (x > 0 && board[x][y] == opp) {
		x--;
	    }
	    if (x >= 0 && board[x][y] == player.color) {
		while (x != X - 1) {
		    board[++x][y] = player.color;
		}
	    }
	}
    }

    public void flip3(int x, int y, Player player) {

	char opp = '?';

	if (player.color == 'c') {
	    opp = 'w';
	} else {
	    opp = 'c';
	}

	int X = x;
	int Y = y; 
	
	if (x - 1 >= 0 && y + 1 < columns && board[x - 1][y + 1] == opp) {
	    x = x - 1;
	    y = y + 1;
	    while (x > 0 && y < columns - 1 && board[x][y] == opp) {
		x--;
		y++;
	    }
	    if (x >= 0 && y < columns && board[x][y] == player.color) {
		while (x != X - 1 && y != Y + 1) {
		    board[++x][--y] = player.color;
		}
	    }
	}
    }


    public void flip4(int x, int y, Player player){
	
	char opp = '?';
	
	if (player.color == 'c') {
		opp = 'w';
	} else {
	    opp = 'c';
	}
	
	int X = x;
	    int Y = y; 
	    
	    if (y - 1 >= 0 && board[x][y - 1] == opp) {
		y = y - 1;
		while (y > 0 && board[x][y] == opp)  {
		    y--;
		}
		if (y >= 0 && board[x][y] == player.color)  {
		    while (y != Y - 1) {
			board[x][++y] = player.color;
		    }
		}
	    }
    }
    
    public void flip5(int x, int y, Player player) {
	
	char opp = '?';
	if (player.color == 'c') {
	    opp = 'w';
	} else {
	    opp = 'c';
	}
	    
	int X = x;
	int Y = y; 
	
	if (y + 1 < columns && board[x][y + 1] == opp) {
	    y = y + 1;
	    while (y < columns - 1 && board[x][y] == opp) {
		y++;
	    }
	    if (y < columns && board[x][y] == player.color) {
		while (y != Y + 1) {
		    board[x][--y] = player.color;
		}
	    }
	    }
    }
    
    public void flip6(int x, int y, Player player) {
	
	char opp = '?';
	if (player.color == 'c') {
	    opp = 'w';
	} else {
		opp = 'c';
	}
	
	int X = x;
	int Y = y; 
	
	if (x + 1 < rows && y - 1 >= 0 && board[x + 1][y - 1] == opp) {
	    x = x + 1;
	    y = y - 1;
	    while (x < rows - 1 && y > 0 && board[x][y] == opp) {
		x++;
		y--;
	    }
	    if (x < rows && y >= 0 && board[x][y] == player.color) {
		while (x != X + 1 && y != Y - 1) {
		    board[--x][++y] = player.color;
		}
	    }
	}
    }
    
    public void flip7(int x, int y, Player player) {
	
	char opp = '?';
	if (player.color == 'c') {
	    opp = 'w';
	} else {
	    opp = 'c';
	}
	
	int X = x;
	int Y = y;
	
	if (x + 1 < rows && board[x + 1][y] == opp) {
	    x = x + 1;
	    while (x < rows - 1 && board[x][y] == opp)  {
		x++;
	    }
	    if (x < rows && board[x][y] == player.color) {
		while (x != X + 1)  {
		    board[--x][y] = player.color;
		}
	    }
	}
    }
    
    public void flip8(int x, int y, Player player) {
	
	char opp = '?';
	if (player.color == 'c') {
	    opp = 'w';
	} else {
	    opp = 'c';
	}
	
	int X = x;
	int Y = y;
	
	if (x + 1 < rows && y + 1 < columns && board[x + 1][y + 1] == opp) {
	    x = x + 1;
	    y = y + 1;
	    while ( x < rows - 1 && y < columns - 1 && board[x][y] == opp) {
		x++;
		y++;
	    }
	    if (x < rows && y < columns && board[x][y] == player.color) {
		while (x != X + 1 && y != Y + 1) {
		    board[--x][--y] = player.color;
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

    public boolean isInBounds(int row, int col) {
        return (row < 8 && row >= 0 && col >=0 && col < 8);
    }

    
}               
                          
                                
                        
                                
                                                        
                                  
                                                                    

                
                                   
                                             
        
        
           
        
        
    

    
     
         
    
    
    

        

    
                        
