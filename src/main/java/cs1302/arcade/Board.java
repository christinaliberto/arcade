package cs1302.arcade;

/**
 * A class representing the game board in a game of Reversi. It is a character
 * array so that the color representation of a player can be stored. The board
 * contains the methods that allow for the game pieces to be flipped, as well
 * as for the hints, or valid spaces where a player can move, to be shown. 
 */
public class Board {
    
    // initialize and declare variables     
    public final int rows = 8;
    public final int columns = 8;
    
    public char[][] board;
    
    public int player1Score = 2;
    public int player2Score = 2;
    public int remainingTiles;
    
    /**
     * A constructor for the board class. The board is initialized
     * to the specified rows and columns, in this case 8, for a classic
     * game of Reversi.
     */
    public Board() {
        // initialize board to row by column size
        board = new char[rows][columns];
        
    }
    
    
    /**
     * A method that resets the players' scores to 2, so that the game 
     * can reset following the end of a previous play. 
     */
    public void resetScore() {
        // set both players' scores to 2
        player1Score = 2;
        player2Score = 2;
    }
    
    /** 
     * A getter method, which returns the score of player 1. 
     *
     * @return player 1's score
     */
    public int getPlayer1Score() {
        return player1Score; // return player 1 score
    }
    
    /**
     * A getter method, which returns the score of player 2. 
     *
     * @return player 2's score
     */
    public int getPlayer2Score() {
        return player2Score; // return player 2 score
    }

    /**
     * A method which initializes the board to hold the character - in all
     * empty spaces, and places the players' pieces in their default 
     * configuration for the start of a game of Reversi.
     */
    public void initializeGameBoard() {
        // for every element in the game board
        for (int i = 0; i < rows; i++) {
            for (int x = 0; x < columns; x++) {
                board[i][x] = '-'; // set to -
            }
        }
        // initialize pieces to default configuration
        board[3][3] = 'c';
        board[4][4] = 'c';
        board[4][3] = 'w';
        board[3][4] = 'w';
    }

    /**
     * A method which returns the spaces on the board which do not contain 
     * either players' game piece. 
     *
     * @return the number of empty spaces on the game board
     */
    public int returnRemaining() {
        // return the remaining empty tiles
        return remainingTiles;
    }
    
    /**
     * A method which returns true or false depending on whether or not the 
     * game is over. The game is over when there are no more valid moves for
     * either player to place a game piece at, or when all spaces in the 
     * game board contain either players' game piece. 
     *
     * @return true or false depending on if the game has ended
     */
    public boolean endGame() {
        // create new boolean
        boolean valid = false; 
        for (int i = 0; i < rows; i++) {
            for (int x = 0; x < columns; x++) {
                if (board[i][x] == '*') { // if there is a valid space
                    valid = true; // set valid to true
                }
            }
        }
        // if valid is false, or there are no more remaining spaces
        if (valid == false || returnRemaining() == 0) {
            return true; // return true
        } else {
            return false; // else return false
        }
        
        
    }
    
    /**
     * A method that calculates the scores of the players based on 
     * how many of their pieces are present on the game board. This method 
     * also calculates how many empty spaces there are on the game board. 
     */
    public void scores() {

        // initialize the scores to 0
        remainingTiles = 0;
        player1Score = 0;
        player2Score = 0;

        // for every element in the board array
        for (int i = 0; i < 8; i++) {
            for (int x = 0; x < 8; x++) {
                if (board[i][x] == 'c') { // if the board = c
                    player1Score++; // increase player 1's score
                } else if (board[i][x] == 'w') { // if the board = 2
                    player2Score++; // increase player 2's score
                } else { // else 
                    remainingTiles++; // increase remaining tiles
                }
            }
        }
    }
    
    /**
     * A method that determines if a space on the game board is a valid 
     * location for a player to move. If there is an asterisk at that location 
     * on the board, then that space is valid, else that space is invalid. 
     *
     * @param xLoc x location
     * @param yLoc y location
     * @return true or false if the space on the board is a valid play or not
     */
    public boolean valid(int xLoc, int yLoc) {
        // if board at the location = asterisk
        if (board[xLoc][yLoc] == '*') { 
            return true; // return true
        }
        return false; // return false if not
    }
    
    /**
     * A method that calls each hint method for all tentative moves for a 
     * specified player. Every space on the board is checked to determine 
     * whether or not the player can move at a space or not.
     *
     * @param player the current player 
     */ 
    public void hint(Player player) {
        // for every location in the board array 
        for (int row = 0; row < 8; row++) {
            
            for (int col = 0; col < 8; col++) {
                // call each individual hint method
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
    
    /**
     * A method that calls each flip method for all 8 possible locations 
     * surrounding a player's piece following their move. The game board
     * is also updated to hold that player's piece at the specified location.
     * A player's piece flips when there is an opponent's piece between the 
     * player's current move.
     *
     * @param x the x location on the game board where the player moved
     * @param y the y location on the game board where the player moved
     * @param player the current player 
     */ 
    
    public void flip(int x, int y, Player player) {
        // set the board at the location = to the player's color
        board[x][y] = player.color;

        // call each individual flip method
        flip1(x, y, player);
        flip2(x, y, player);
        flip3(x, y, player);
        flip4(x, y, player);
        flip5(x, y, player);
        flip6(x, y, player);
        flip7(x, y, player);
        flip8(x, y, player);
    }
    

    /**
     * A method that checks to the right and down for spaces 
     * that will change to the player's game piece color following
     * a move. All pieces will change if there is the opponent's piece
     * at that location and will continue until another piece of that 
     * player's color is found. 
     * 
     * @param x the x location on the game board where the player moved
     * @param y the y location on the game board where the player moved
     * @param player the current player 
     */
    public void flip1(int x, int y, Player player) {
        
        char opp = '?'; // initialize opp to ?
        // if player is c
        if (player.color == 'c') {
            opp = 'w'; // opp = w
        } else { // else
            opp = 'c'; // opp = c
        }
        // initialize holding variables to keep track of initial values
        int X = x;
        int Y = y;

        // x - 1 is in bounds and y - 1 is in bounds and the board at that location
        // is equal to opp
        if (x - 1 >= 0 && y - 1 >= 0 && board[x - 1][y - 1] == opp) {
            x = x - 1; // set x to x - 1
            y = y - 1; // set y to y - 1
            // while x > 0 and y > 0 and the board is equal to opp
            while (x > 0 && y > 0 && board[x][y] == opp) {
                x--; // decrement x
                y--; // decrement y
            }
            // if both variables are greater than 0 and the board at the location
            // is the player's color
            if (x >= 0 && y >= 0 && board[x][y] == player.color) {
                while (x != X - 1 && y != Y - 1) { // while not equal to initial location
                    board[++x][++y] = player.color;
                    // set board at all incrememnting values to player
                }
            }
        }
    }
    
    /**
     * A method that checks to the right of the current player's move
     * for spaces that will change to the player's game piece color following 
     * a move. All pieces will change if there is the opponent's piece at that 
     * location and will continue until another piece of that player's color is found.
     * 
     * @param x the x location on the game board where the player moved
     * @param y the y location on the game board where the player moved
     * @param player the current player
     */
    public void flip2(int x, int y, Player player) {
        // initialize the char variable based on
        // color value of player
        char opp = '?';
        if (player.color == 'c') {
            opp = 'w';
        } else {
            opp = 'c';
        }
        // initialize holding variables
        int X = x;
        int Y = y;
        // if x - 1 is in bounds of the board and the board
        // at that location is equal to opp
        if (x - 1 >= 0 && board[x - 1][y] == opp) {
            x = x - 1; // decrement x
            // while x is in bounds and the board = opp
            while (x > 0 && board[x][y] == opp) {
                x--; // decrement x
            }
            // if x is in bounds and the board = player
            if (x >= 0 && board[x][y] == player.color) {
                while (x != X - 1) { // while x is not equal to initial value
                    board[++x][y] = player.color; // set board to player color
                }
            }
        }
    }

    /**
     * A method that checks to the right and up of the current player's move
     * for spaces that will change to the player's game piece color following
     * a move. All pieces will change if there is the opponent's piece at that
     * location and will continue until another piece of that player's color 
     * is found. 
     * 
     * @param x the x location on the game board where the player moved
     * @param y the y location on the game board where the player moved
     * @param player the current player. 
     */
    public void flip3(int x, int y, Player player) {
        // initialize opp based on player color
        char opp = '?';

        if (player.color == 'c') {
            opp = 'w';
        } else {
            opp = 'c';
        }
        // initialize holding variables 
        int X = x;
        int Y = y; 
        // if x and y are in bounds and the board at that location is equal to opp
        if (x - 1 >= 0 && y + 1 < columns && board[x - 1][y + 1] == opp) {
            x = x - 1; // set x to x - 1
            y = y + 1; // set y to y + 1
            // while x and y are in bounds and the board is equal to opp
            while (x > 0 && y < columns - 1 && board[x][y] == opp) {
                x--; // decrement x
                y++; // increment y 
            }
            // if x and y are in bounds and the board is equal to the player's color
            if (x >= 0 && y < columns && board[x][y] == player.color) {
                while (x != X - 1 && y != Y + 1) { // while not equal to holders +- 1
                    board[++x][--y] = player.color; // set the board to player's color
                }
            }
        }
    }

    /**
     * A method that checks directly down of the current player's move
     * for spaces that will change to the player's game piece color following
     * a move. All pieces will change if there is the opponent's piece at that 
     * location and will continue until another piece of that player's color is found.
     *
     * @param x the x location on the game board where the player moved
     * @param y the y location on the game board where the player moved
     * @param player the current player
     */
    public void flip4(int x, int y, Player player) {

        // initialize opp based on player's color
        char opp = '?';
        
        if (player.color == 'c') {
            opp = 'w';
        } else {
            opp = 'c';
        }

        // initialize holding variables
        int X = x;
        int Y = y; 

        // if y - 1 is in bounds and the board is equal to opp
        if (y - 1 >= 0 && board[x][y - 1] == opp) {
            y = y - 1; // set y to y - 1
            // while y is in bounds and board is equal to opp
            while (y > 0 && board[x][y] == opp)  {
                y--; // decrement y
            }

            // if y is in bounds and the board is equal to the player's color
            if (y >= 0 && board[x][y] == player.color)  {
                while (y != Y - 1) { // while not equal to holder
                    board[x][++y] = player.color; // set to player's color
                }
            }
        }
    }
    
    /**
     * A method that checks directly up of the current player's move
     * for spaces that will change to the player's game piece color following 
     * a move. All pieces will change if theere is the opponent's piece at that
     * location and will continue until another piece of that player's color is found.
     *
     * @param x the x location on the game board where the player moved
     * @param y the y location on the game board where the player moved
     * @param player the current player
     */
    public void flip5(int x, int y, Player player) {
        // initialize opp based on player's color
        char opp = '?';
        if (player.color == 'c') {
            opp = 'w';
        } else {
            opp = 'c';
        }

        // initialize holding variables
        int X = x;
        int Y = y; 
        // if y + 1 is in bounds and the board is equal to opp
        if (y + 1 < columns && board[x][y + 1] == opp) {
            y = y + 1; // increase y
            // while y is in bounds and the board is equal to opp
            while (y < columns - 1 && board[x][y] == opp) {
                y++; // increment y
            }
            // if y is in bounds and board is equal to player color
            if (y < columns && board[x][y] == player.color) {
                while (y != Y + 1) { // while not equal to holder
                    board[x][--y] = player.color; // set to player color
                }
            }
        }
    }

    /**
     * A method that checks directly up and to the left of the current player's move
     * for spaces that will change to the player's game piece color following 
     * a move. All pieces will change if there is the opponent's piece at that
     * location and will continue until another piece of that player's color is found.
     * 
     * @param x the x location on the game board where the player moved
     * @param y the y location on the game board where the player moved
     * @param player the current player
     */
    public void flip6(int x, int y, Player player) {
        // initialize opp based on player color
        char opp = '?';
        if (player.color == 'c') {
            opp = 'w';
        } else {
            opp = 'c';
        }
        // initialize holding variables
        int X = x;
        int Y = y; 
        // if x + 1 and y - 1 are in bounds and board is equal to opp
        if (x + 1 < rows && y - 1 >= 0 && board[x + 1][y - 1] == opp) {
            x = x + 1; // increase x
            y = y - 1; // decrease y
            // while x and y are in bounds and board is equal to opp
            while (x < rows - 1 && y > 0 && board[x][y] == opp) {
                x++; // increment x
                y--; // decrememnt y
            }
            // if x and y are in bounds and board is equal to player's color
            if (x < rows && y >= 0 && board[x][y] == player.color) {
                // while not equal to holders
                while (x != X + 1 && y != Y - 1) {
                    board[--x][++y] = player.color; // set to player color
                }
            }
        }
    }
    
    /**
     * A method that checks directly to the right of the current player's move 
     * for spaces that will change to the player's game piece color following
     * a move. All pieces will change if there is the opponent's piece at that 
     * location and will continue until another piece of that player's color is found. 
     * 
     * @param x the x location on the game board where the player moved
     * @param y the y location on the game board where the player moved
     * @param player the current player
     */
    public void flip7(int x, int y, Player player) {
        // initialize opp based on player's color
        char opp = '?';
        if (player.color == 'c') {
            opp = 'w';
        } else {
            opp = 'c';
        }
        // initialize holdign variables
        int X = x;
        int Y = y;

        // if x + 1 is in bounds and the board is equal to opp
        if (x + 1 < rows && board[x + 1][y] == opp) {
            x = x + 1; // increase x
            // while x is in bounds and the board is equal to opp
            while (x < rows - 1 && board[x][y] == opp)  {
                x++; // increment x
            }
            // if x is in bounds and board is equal to player
            if (x < rows && board[x][y] == player.color) {
                while (x != X + 1)  { // while not equal to holder
                    board[--x][y] = player.color; // set board to player
                }
            }
        }
    }

    /**
     * A method that checks directly up and to the right of the current player's move
     * for spaces that will change to the player's game piece color following 
     * a move. All pieces will change if there is the opponent's piece at that 
     * location and will continue until another piece of that player's color is found. 
     * 
     * @param x the x location on the game board where the player moved
     * @param y the y location on the game board where the player moved
     * @param player the current player
     */
    public void flip8(int x, int y, Player player) {
        // initialize opp based on player color
        char opp = '?';
        if (player.color == 'c') {
            opp = 'w';
        } else {
            opp = 'c';
        }
        // initialize holding variables
        int X = x;
        int Y = y;
        // if x + 1 and y + 1 are in bounds and board is equal to opp
        if (x + 1 < rows && y + 1 < columns && board[x + 1][y + 1] == opp) {
            x = x + 1; // increase x 
            y = y + 1; // increase y
            // while x and y are in bounds and board is equal to opp
            while ( x < rows - 1 && y < columns - 1 && board[x][y] == opp) {
                x++; // increment x
                y++; // increment y
            }
            // if x and y are in bounds and board is equal to player
            if (x < rows && y < columns && board[x][y] == player.color) {
                while (x != X + 1 && y != Y + 1) { // while not equal to holder
                    board[--x][--y] = player.color; // set board to player
                }
            }
        }
        
    }
    
    
    /**
     * A method that removes all asterisk characters from the board
     * so that the hints can be reevaluated after each player's move. 
     */
    public void resetBoard() {
        // for every element in the board array
        for (int i = 0; i < rows; i++) {
            for (int x = 0; x < columns; x++) {
                if (board[i][x] == '*') { // if equal to asterisk
                    board[i][x] = '-'; // set back to dash
                }
            }
        }
    }
    
    
    
    /**
     * A method that checks directly up to find possible moves for the 
     * current player. A move is possible if there is an opponent's 
     * at the specified location - if there is an opponent's piece present, 
     * the space surrounding that location is valid if the board is empty 
     * at that location. 
     *
     * @param row the row to check on the board
     * @param col the col to check on the board
     * @param player the current player 
     */
    public void northHint(int row, int col, Player player) {
        // initialize opp variable based on player color
        char opp = '?';
        char p = '?';
        if (player.color == 'c') {
            p = 'c';
            opp = 'w';
        } else {
            p = 'w';
            opp = 'c';
        }
        // if row + 1 is in bounds and board at row col is opp and board at row + 1 is player
        if (isInBounds(row + 1, col) && board[row][col] == opp && board[row + 1][col] == p) {
            while (row < 8 && row >= 0) { // while less than 8 and greater than 0
                if (board[row][col] == opp) { // if board is equal to opp
                    row--; // decrement row
                    // else if board is empty
                } else if (board[row][col] == '-') {
                    board[row][col] = '*'; // set to asterisk
                    row = 8; // break loop
                } else {
                    row = 8; // break loop
                }
            }
        } else { // else 
            return; // return
        }
    }

    /**
     * A method that checks directly down to find possible moves for the 
     * current player. A move is possible if there is an opponent's
     * at the specified location - if there is an opponent's piece present, 
     * the space surrounding that location is valid if the board is empty 
     * at that location. 
     * 
     * @param row the row to check on the board
     * @param col the col to check on the board
     * @param player the current player
     */
    public void southHint(int row, int col, Player player) {
        // initialize opp based on player color
        char opp = '?';
        char p = '?';
        
        if (player.color == 'c') {
            p = 'c';
            opp = 'w';
        } else {
            p = 'w';
            opp = 'c';
        }

        // if is in bounds row -1 and board at row col is opp and board at row - 1 is player
        if (isInBounds(row - 1, col) && board[row][col] == opp && board[row - 1][col] == p) {
            while (row < 8) { // while less than 8
                if (board[row][col] == opp) { // if equal to opp
                    row++; // increment row
                    // else if emtpy
                } else if (board[row][col] == '-') {
                    board[row][col] = '*';// set to asterisk
                    row = 8; // break loop
                } else {
                    row = 8; // break loop
                }
            }
        } else { // else
            return; //return
        }
    }

    /**
     * A method that checks directly to the left to find possible moves for the 
     * current player. A move is possible if there is an opponent's
     * at the specified location - if there is an opponent's piece present, 
     * the space surrounding that location is valid if the board is empty 
     * at that location. 
     * 
     * @param row the row to check on the board
     * @param col the col to check on the board
     * @param player the current player
     */
    public void eastHint(int row, int col, Player player) {
        //iniitialize opp and p based on player color
        char p = '?';
        char opp = '?';

        if (player.color == 'c') {
            p = 'c';
            opp = 'w';
        } else {
            p = 'w';
            opp = 'c';
        }
        // if row and col - 1 are in bounds and board is equal to opp and board at col - 1 is player
        if (isInBounds(row, col - 1) && board[row][col] == opp && board[row][col - 1] == p) {
            while (col < 8 && col >= 0) { // while less than 8 greater than = to 0
                if (board[row][col] == opp) { // if board is opp
                    col++; // increment col
                    // else if board is emtpy
                } else if (board[row][col] == '-') {
                    board[row][col] = '*'; // set to asterisk
                    col = 8; // break loop
                } else {
                    col = 8; // break loop
                }
            }
        } else { // else
            return; // return
        }
    }

    /**
     * A method that checks to the right to find possible moves for the
     * current player. A move is possible if there is an opponent's 
     * at the specified location - if there is an opponent's piece present, 
     * the space surrounding that location is valid if the board is empty 
     * at that location. 
     * 
     * @param row the row to check on the board
     * @param col the col to check on the board
     * @param player the current player
     */
    public void westHint(int row, int col, Player player) {
        // initialize opp and p based on player color
        char p = '?';
        char opp = '?';
        
        if (player.color == 'c') {
            p = 'c';
            opp = 'w';
        } else {
            p = 'w';
            opp = 'c';
        }
        // if is in bounds row col + 1 and the board at row col is opp and the board
        // at col + 1 is player
        if (isInBounds(row, col + 1) && board[row][col] == opp && board[row][col + 1] == p) {
            while (col < 8 && col >= 0) { // while less than 8 and greater = to 0
                
                if (board[row][col] == opp) { // if equal to opp
                    col --; // decrement col
                    // else if emtpy
                } else if (board[row][col] == '-') {
                    board[row][col] = '*'; // set to asterisk
                    col = 8; // break loop
                } else {
                    col = 8; // break loop
                }
            }
        } else { // else 
            return; // return
        }
    }

    /**
     * A method that checks up and to the left to find possible moves for the 
     * current player. A move is possible if there is an opponent's
     * at the specified location - if there is an opponent's piece present, 
     * the space surrounding that location is valid if the board is empty
     * at that location. 
     * 
     * @param row the row to check on the board
     * @param col the col to check on the board
     * @param player the current player
     */
    public void northEastHint(int row, int col, Player player) {
        // initialize opp and p based on player color
        char p = '?';
        char opp = '?';
        
        if (player.color == 'c') {
            p = 'c';
            opp = 'w';
        } else {
            p = 'w';
            opp = 'c';
        }
        // if is in bounds row + 1 col -1
        if (isInBounds(row + 1, col - 1) &&
            // and board at row col is opp and board at row + 1 col - 1 is player
            board[row][col] == opp && board[row + 1][col - 1] == p) {
            while (col < 8 && row < 8 && row >= 0) { // while in bounds
                if (board[row][col] == opp) { // if equal to opp
                    col++; // increment col
                    row--; // decrement row
                    // if board is empty
                } else if (board[row][col] == '-') {
                    board[row][col] = '*'; // set to asterisk
                    col = 8; // break loop
                } else { // else
                    col = 8; // break loop
                }
            }
        } else { // else
            return; // return
        }
    }

    /** 
     * A method that checks up and to the right to find possible moves for the
     * current player. A move is possible if there is an opponent's
     * at the specified location - if there is an opponent's piece present, 
     * the space surrounding that location is valid if the board is empty
     * at that location. 
     * 
     * @param row the row to check on the board
     * @param col the col to check on the board
     * @param player the current player
     */
    public void northWestHint(int row, int col, Player player) {
        // initialize opp and p based on player color
        char p = '?';
        char opp = '?';
        if (player.color == 'c') {
            p = 'c';
            opp = 'w';
        } else {
            p = 'w';
            opp = 'c';
        }
        // if row + 1 and col + 1 are in bounds 
        if (isInBounds(row + 1, col + 1) &&
            // if board at row col is opp and board at + 1 + 1 is player
            board[row][col] == opp && board[row + 1][col + 1] == p) {
            // while less than 8 and greater than = to 0
            while (col < 8 && row < 8 && col >= 0 && row >= 0) {
                // if board is equal to opp
                if (board[row][col] == opp) {
                    row--; // decrement row
                    col--; // decrement col
                    // else if board is empty
                } else if (board[row][col] == '-') {
                    board[row][col] = '*'; // set to asterisk
                    col = 8; // break loop
                } else { // else
                    col = 8; // break loop
                }
            }
        } else { // else
            return; // return
        }
    }

    /**
     * A method that checks down and to the left to find possible moves for the 
     * current player. A move is posible if there is an opponent's 
     * at the specified location - if there is an opponent's piece present, 
     * the space surrounding that location is valid if the board is empty 
     * at that location. 
     *
     * @param row the row to check on the board
     * @param col the col to check on the board
     * @param player the current player
     */
    public void southEastHint(int row, int col, Player player) {
        // initialize opp and p based on player color
        char p = '?';
        char opp = '?';
        if (player.color == 'c') {
            p = 'c';
            opp = 'w';
        } else {
            p = 'w';
            opp = 'c';
        }
        // if row - 1 and col - 1 are in bounds
        if (isInBounds(row - 1, col - 1) &&
            // and board at row col is opp and board at - 1 - 1 is player
            board[row][col] == opp && board[row - 1][col - 1] == p) {
            while (col < 8 && row < 8) { // while row and col are < 8
                if (board[row][col] == opp) { // if equal to opp
                    col++; // increment col
                    row++; // increment row
                    // else if board is empty
                } else if (board[row][col] == '-') {
                    board[row][col] = '*'; // set to asterisk
                    col = 8; // break loop
                } else { // else 
                    col = 8; // break loop
                }
            }
        } else { // else
            return; // return
        }
    }

    /** 
     * A method that checks down and to the right to find posible moves for the 
     * current player. A move is possible if there is an opponent's 
     * at the specified location - if there is an opponent's piece present, 
     * the space surrounding that location is valid if the board is empty
     * at that location. 
     * 
     * @param row the row to check on the board
     * @param col the col to check on the board
     * @param player the current player
     */
    public void southWestHint(int row, int col, Player player) {
        // initialize opp and p based on player color
        char p = '?';
        char opp = '?';
        
        if (player.color == 'c') {
            p = 'c';
            opp = 'w';
        } else {
            p = 'w';
            opp = 'c';
        }
        // if is in bounds row - 1 col + 1
        if (isInBounds(row - 1, col + 1) &&
            // and board at row col is opp and board at -1 +1 is player
            board[row][col] == opp && board[row - 1][col + 1] == p) {
            while (col < 8 && col >= 0 && row < 8) { // while in bounds
                if (board[row][col] == opp) { // if board is opp
                    row++; // increment row
                    col--; // decrement col
                    // else if board is empty
                } else if (board[row][col] == '-') {
                    board[row][col] = '*'; // set to asterisk
                    col = 8; // break loop
                } else { // else
                    col = 8; // break loop
                }
            }
        } else { // else
            return; // return
        }
    }
    
    /**
     * A method that determines if a specified space is in the boundaries
     * of the board. 
     *
     * @param row the row to be checked
     * @param col the col to be checked 
     * @return true or false if the specified location is in bounds
     */
    public boolean isInBounds(int row, int col) {
        // returns if row and col are in bounds of the board
        return (row < 8 && row >= 0 && col >= 0 && col < 8);
    }
    
    
}               



                                
                                                        
                                  
                                                                    

                
                                   
                                             
        
        
           
        
        
    

    
     
         
    
    
    

        

    
                        
