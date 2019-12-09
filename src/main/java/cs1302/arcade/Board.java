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
	boolean end = false;

	for (int i = 0; i < 8; i++) {
	    for (int x = 0; x < 8; x++) {
		if (gameBoard[i][x] == '*') {
		    canMove = true;
		}
	    }
	}
	if (canMove == false) {
	    end = true;
	}
	if (returnRemaining() == 0) {
	    end = true;
	}

	return end;
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
	 
    
    
    

	

    
			
