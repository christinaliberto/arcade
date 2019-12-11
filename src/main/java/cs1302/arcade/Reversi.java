package cs1302.arcade;

import javafx.scene.layout.HBox; 
import javafx.scene.paint.Paint; 
import javafx.scene.layout.VBox; 
import javafx.scene.text.*; 
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color; 
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Background;
import javafx.scene.input.MouseEvent; 
import javafx.geometry.Pos; 

/**
 * A class that represents that graphical portion of the 
 * Reversi game. The gameboard is composed 64 rectangles 
 * and the game pieces are circles which are placed on the 
 * game board. The GUI indicates which players' turn it is
 * as well as the valid moves of the player and the winner 
 * once the game has concluded. When the user reopens the 
 * GUI, a new game will begin. 
 */
public class Reversi extends Application {
    // declare and initialize variables 
    public static final int BOARDWIDTH = 8;
    public static final int BOARDHEIGHT = 8;
    public static final int SIZEOFTILES = 50;
    
    Player player1; 
    Player player2;
    Player turn;
    
    public Text scoresTurn;

    Circle gamePiece;
    Circle player11;
    Circle player12;
    Circle player21;
    Circle player22;
    
    Shape[][] gameBoard = new Shape[BOARDWIDTH][BOARDHEIGHT]; 
    
    GameSpace space;
    
    int click1;  
    int click2;
    
    Group gameSpaces;
    
    public HBox playerScores;
    
    Board reversiBoard = new Board();
    
    /**
     * A method that initializes the players for the game. 
     * Player one's pieces are cyan blue, and player 2's pieces
     * are white. Turn is initialzed to be player one. 
     */
    public void initializePlayers() {
        
        
        player1 = new Player('c'); // set player 1 to cyan
        player2 = new Player('w'); // set player 2 to white
        
        turn = player1;  // set turn to player 1
        
    }
    
    /**
     * A method that creates the score board for the game
     * which includes which player's turn it is, as well as 
     * each player's score. 
     */
    public void createScores() {
        
        playerScores = new HBox(); // create new HBox
        BackgroundFill fill = new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY);
        // set the background fill to light pink
        Background scoreBack = new Background(fill); // set background to fill
        playerScores.setBackground(scoreBack); // add the background to HBox
        // set text
        scoresTurn = new Text("                    It's Player 1's turn!\n" +
                              "\n                         Player 1: "
                              + reversiBoard.getPlayer1Score() +
                              "\n                         Player 2: "
                              + reversiBoard.getPlayer2Score());
        scoresTurn.setFill(Color.RED); // set text fill to red
        scoresTurn.setFont(Font.font("Futura", FontWeight.BOLD, 16));
        // set font, weight, and size
        playerScores.getChildren().add(scoresTurn);
        // add text to HBox
        
    }

    /** 
     * A method that updates the scores of the players so that 
     * it can be accurately represented in the GUI.
     */
    public void updateScores() {
        
        // if turn is player 2 update text to player 2 
        if (turn  == player2) {
            scoresTurn.setText("                    It's Player 2's turn!\n" +
                               "\n                         Player 1: "
                               + reversiBoard.getPlayer1Score() +
                               "\n                         Player 2: "
                               + reversiBoard.getPlayer2Score());
        } else { // else
            // update text to player 1
            scoresTurn.setText("                    It's Player 1's turn!\n" +
                               "\n                         Player 1: "
                               + reversiBoard.getPlayer1Score() +
                               "\n                         Player 2: "
                               + reversiBoard.getPlayer2Score());
        }
        
    }
    
    /**
     * A method that creates a player's game piece in the correct location
     * on the game board. A game piece is represented by a circle of the 
     * specified color for each player. 
     *
     * @param color the color of the game piece
     * @param xPos the x location where the piece is placed
     * @param yPos the y location where the piece is placed
     * @return the circle game piece
     */
    public Circle createGamePiece(char color, int xPos, int yPos) {
        
        Paint colorFill = null; // initialize paint to null
        
        if (color == 'c') { // if color is c
            colorFill = Color.CYAN; // fill to cyan
        } else if (color == 'w') { // if color is w
            colorFill = Color.WHITE; // fill to white
        }
        // create a new game piece and set its location on the game board
        gamePiece = new Circle(xPos * SIZEOFTILES, yPos * SIZEOFTILES, 20, colorFill);
        gamePiece.setTranslateX((SIZEOFTILES - SIZEOFTILES * .5 * 2) / 2 + SIZEOFTILES * .5);
        gamePiece.setTranslateY((SIZEOFTILES - SIZEOFTILES * .5 * 2) / 2 + SIZEOFTILES * .5);
        
        return gamePiece; // return the game piece
    }

    /**
     * A method that places each player's game pieces
     * in their starting configuration, and adds them to the 
     * game board. 
     */
    public void initialPieces() {
        // set each player's piece to their starting configuration
        player11 = createGamePiece('c', 3, 3);
        player12 = createGamePiece('c', 4, 4);
        player21 = createGamePiece('w', 3, 4);
        player22 = createGamePiece('w', 4, 3);
        // add the pieces to the group (gameSpaces)
        gameSpaces.getChildren().addAll(player11, player12, player21, player22);
        
    }

    /**
     * A method that colors the game board yellow if the move is valid
     * for the specified player. 
     */
    public void validMoves() {
        // for every element in the char game board
        for (int i = 0; i < 8; i++) {
            for (int x = 0; x < 8; x++) {
                if (reversiBoard.valid(i, x)) { // if valid
                    // set the fill to yellow
                    gameBoard[i][x].setFill(Color.LIGHTGOLDENRODYELLOW);
                    // set the outline to black
                    gameBoard[i][x].setStroke(Color.BLACK); 
                } else { // else
                    // set the fill to hot pink
                    gameBoard[i][x].setFill(Color.HOTPINK);
                    /// set the outline to white
                    gameBoard[i][x].setStroke(Color.WHITE); 
                }
                
            }
        }
    }
    
    
    /**
     * A method that places the game piece of the specified 
     * color at the correct location on the game board. 
     * 
     * @param c the color that the game piece will be filled
     */
    public void setPiece(char c) {
        // for every element in the char board representation
        for (int i = 0; i < BOARDHEIGHT; i++) {
            for (int x = 0; x < BOARDWIDTH; x++) {
                if (reversiBoard.board[i][x] == c) { // if the board at that location equls c
                    // add a new game piece to the group at that location with that color
                    gameSpaces.getChildren().add(createGamePiece(c, i, x));
                }
            }
        }
        
    }

    /** 
     * A method that switches which player's turn it is
     * after each move.
     */
    public void playerSwitch() {
        if (turn == player1) { // if turn is player 1
            turn = player2; // set to player 2
        } else { // else
            turn = player1; // set to player 1
        }
    }

    /**
     * A method that displays text in the GUI based on 
     * which player won the game i.e. which player had the 
     * highest score, or if the players tied. 
     */
    public void createGameOver()  {
        
        // if player 1 has highest score, set text to player 1 wins
        if (reversiBoard.getPlayer1Score() > reversiBoard.getPlayer2Score()) {
            scoresTurn.setText("                           GAME OVER!\n\n\n" +
                               "                          Player 1 Wins!");
            // else if player 2 has highest score, set text to player 2 wins
        } else if (reversiBoard.getPlayer2Score() > reversiBoard.getPlayer1Score()) { 
            scoresTurn.setText("                           GAME OVER!\n\n\n" +
                               "                          Player 2 Wins!");
            // else set text to tie
        } else {
            scoresTurn.setText("                           GAME OVER!\n\n\n" +
                               "                           It's a Tie!");
        }
        
        
    }

    /**
     * A method that calls the basic methods used
     * to play the game of Reversi i.e. setting the 
     * players' game pieces, switching turns, 
     * calling the hint method, updating the scores, 
     * and showing the valid moves. 
     */
    public void recurseReversi() {
        
        setPiece(turn.color); // call setPiece on turn color
        reversiBoard.resetBoard(); // reset the board
        playerSwitch(); // switch players
        reversiBoard.hint(turn); // show hints
        reversiBoard.scores(); // score the board
        validMoves(); // show valid moves
        updateScores(); // update the scores
    }

    /**
     * {@inheritDoc} 
     */
    
    @Override
    public void start (Stage stage) {
        turn = player1; // set turn to player 1
        VBox reversiV = new VBox(); // create new vbox
        // set the size to the size of tiles * width by board height * size of tiles
        reversiV.setPrefSize(BOARDWIDTH * SIZEOFTILES, BOARDHEIGHT * SIZEOFTILES);
        
        gameSpaces = new Group(); // create new group

        // for every element in the reversi board
        for (int i = 0; i < 8; i++) {
            for (int x = 0; x < 8; x++) {
                
                space = new GameSpace(i, x); // create a new game space
                gameBoard[i][x] = space; // set the board at that array to the space
                gameSpaces.getChildren().add(gameBoard[i][x]); // add to the group
                
                // when game space is clicked at that location
                gameBoard[i][x].setOnMouseClicked(e -> { 

                    // calculate location on the char representation
                    click1 = (int)(e.getSceneY() / SIZEOFTILES);
                    click2 = (int)(e.getSceneX() / SIZEOFTILES);
                    // if the click is valid
                    if (reversiBoard.valid(click2, click1)) {
                        // call the flip method
                        reversiBoard.flip(click2, click1, turn);
                        // call the recurseReversi method
                        recurseReversi(); 
                        // if the game is over
                        if (reversiBoard.endGame()) {
                            createGameOver(); // call createGameOver
                            reversiBoard.resetScore(); // reset the players' scores
                            
                        }
                    }
                });
            }
        }
        
        initialPieces(); // initialize the game pieces
        reversiV.getChildren().addAll(gameSpaces); // add them to the vbox
        reversiBoard.resetScore();  // reset the scores
        createScores(); // create the score vbox 
        reversiV.getChildren().add(playerScores); // add the scores to the vbox
        Scene scene = new Scene(reversiV, 400, 475); // create a new scene
        stage.setTitle("Reversi"); // set the title to reversi
        stage.setScene(scene); // set the stage to the scene
        stage.sizeToScene();  // size the stage to the scene
        stage.show(); // show the stage
        // initialize the game board and players
        reversiBoard.initializeGameBoard();
        initializePlayers();
        // show player 1's valid moves
        reversiBoard.hint(player1); 
        validMoves(); 
        // request focus on the group
        gameSpaces.requestFocus(); 
    }
    
    /**
     * Launches the reversi application. 
     *
     * @param args the command-line arguments
     */
    public static void main(String [] args) {
        // try launching the application
        try {
            Application.launch(args);
        } catch (Exception e) { // catch exception
            System.out.println("error");
        }
    }
            
    

    
}






        
                
                
                               
            
          
    
        
        
        
