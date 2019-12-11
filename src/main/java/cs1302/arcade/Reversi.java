
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

public class Reversi extends Application {

    public static final int BOARDWIDTH = 8;
    public static final int BOARDHEIGHT = 8;
    public static final int SIZEOFTILES = 50;
    

    Player player1, player2, turn;
    
    public Text scoresTurn;

    Circle gamePiece, player11, player12, player21, player22; 

    Shape[][] gameBoard = new Shape[BOARDWIDTH][BOARDHEIGHT]; 

    GameSpace space;

    int click1, click2; 
        
    Group gameSpaces;
    
    public HBox playerScores;
    
    Board reversiBoard = new Board();

    public void initializePlayers() {


        player1 = new Player('c');
        player2 = new Player('w');

        turn = player1;  
        //reversiBoard.initializeGameBoard(); 
    }

	player1 = new Player('c');
	player2 = new Player('w');
	turn = player1;  
 }

    
    public void createScores() {
        
        playerScores = new HBox();
        BackgroundFill fill = new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY);

        Background scoreBack = new Background(fill);
        playerScores.setBackground(scoreBack);
        
        scoresTurn = new Text("                    It's Player 1's turn!\n" + "\n                         Player 1: " + reversiBoard.getPlayer1Score() + "\n                         Player 2: " + reversiBoard.getPlayer2Score());
        scoresTurn.setFill(Color.RED);
        scoresTurn.setFont(Font.font("Futura", FontWeight.BOLD, 16));
        
        playerScores.getChildren().add(scoresTurn);

	Background scoreBack = new Background(fill);
	playerScores.setBackground(scoreBack);
	
	scoresTurn = new Text("                    It's Player 1's turn!\n"  + "\n                         Player 1: " + reversiBoard.getPlayer1Score() + "\n                         Player 2: " + reversiBoard.getPlayer2Score()); 
	scoresTurn.setFill(Color.RED);
	scoresTurn.setFont(Font.font("Futura", FontWeight.BOLD, 16));
	
	playerScores.getChildren().add(scoresTurn);

    }

    public void updateScores() {


        if (turn  == player1) {
            scoresTurn.setText("                    It's player 2's turn!\n" + "\n                         Player 1: " + reversiBoard.getPlayer1Score() + "\n                         Player 2: " + reversiBoard.getPlayer2Score());
        } else {
            scoresTurn.setText("                    It's player 1's turn!\n" + "\n                         Player 1: " + reversiBoard.getPlayer1Score() + "\n                         Player 2: " + reversiBoard.getPlayer2Score());
        }

	if (turn  == player2) {
	    scoresTurn.setText("                    It's Player 2's turn!\n" + "\n                         Player 1: " + reversiBoard.getPlayer1Score() + "\n                         Player 2: " + reversiBoard.getPlayer2Score());
	} else {
	    scoresTurn.setText("                    It's Player 1's turn!\n" + "\n                         Player 1: " + reversiBoard.getPlayer1Score() + "\n                         Player 2: " + reversiBoard.getPlayer2Score());
	}

    }


    public Circle createGamePiece(char color, int xPos, int yPos) {

        Paint colorFill = null; 

        if (color == 'c') {
            colorFill = Color.CYAN;
        }
        else if (color == 'w') {
            colorFill = Color.WHITE;
        }
        gamePiece = new Circle(xPos * SIZEOFTILES, yPos * SIZEOFTILES, 20, colorFill);
        gamePiece.setTranslateX((SIZEOFTILES - SIZEOFTILES * .5 * 2)/ 2 + SIZEOFTILES*.5);
        gamePiece.setTranslateY((SIZEOFTILES - SIZEOFTILES * .5 * 2) / 2 + SIZEOFTILES * .5);

    return gamePiece;
}

public void initialPieces() {

    player11 = createGamePiece('c', 3, 3);
    player12 = createGamePiece('c', 4, 4);
    player21 = createGamePiece('w', 3, 4);
    player22 = createGamePiece('w', 4, 3);
    gameSpaces.getChildren().addAll(player11, player12, player21, player22);
    
}

public void validMoves() {

    for (int i = 0; i < 8; i++) {
        for (int x = 0; x < 8; x++) {
            if (reversiBoard.valid(i, x)) {
                gameBoard[i][x].setFill(Color.LIGHTGOLDENRODYELLOW);
                gameBoard[i][x].setStroke(Color.BLACK); 
            }
            
            else {
                gameBoard[i][x].setFill(Color.HOTPINK);
                gameBoard[i][x].setStroke(Color.BLACK); 
            }
            
        }
    }
}

    

    public void setPiece(char c) {

        for (int i = 0; i <BOARDHEIGHT; i++) {
            for (int x = 0; x < BOARDWIDTH; x++) {
                if (reversiBoard.board[i][x] == c) {
                    gameSpaces.getChildren().add(createGamePiece(c, i, x));
                }
            }
        }
        
    }

    public void playerSwitch() {
        if (turn == player1) {
            turn = player2;
        } else
            turn = player1; 
    }

    public void createGameOver()  {


        if (reversiBoard.getPlayer1Score() > reversiBoard.getPlayer2Score()) {
            scoresTurn.setText("                    GAME OVER!\n                          Player 1 Wins!");
        } else if (reversiBoard.getPlayer2Score() > reversiBoard.getPlayer1Score()) {
            scoresTurn.setText("                    GAME OVER!\n                          Player 2 Wins!");
        } else {
            scoresTurn.setText("                    GAME OVER!\n                            It's a Tie!");
        }

	if (reversiBoard.getPlayer1Score() > reversiBoard.getPlayer2Score()) {
	    scoresTurn.setText("                           GAME OVER!\n" + "\n                          Player 1 Wins!\n\n");
	} else if (reversiBoard.getPlayer2Score() > reversiBoard.getPlayer1Score()) {
	    scoresTurn.setText("                           GAME OVER!\n" + "\n                          Player 2 Wins!\n\n");
	} else {
	    scoresTurn.setText("                           GAME OVER!\n" + "\n                          It's a Tie!\n\n");
	}
 

    }

    public void recurseReversi() {

	setPiece(turn.color);
	reversiBoard.resetBoard();
	playerSwitch();
	reversiBoard.hint(turn);
	reversiBoard.scores();
	validMoves();
	updateScores();
    }
   

                          

public void start (Stage stage) {

    turn = player1;
    
    VBox reversiV = new VBox();
    
    reversiV.setPrefSize(BOARDWIDTH * SIZEOFTILES, BOARDHEIGHT * SIZEOFTILES);

    gameSpaces = new Group();

    for (int i = 0; i < 8; i++) {

        for(int x = 0; x < 8; x++) {
            space = new GameSpace(i, x);
            gameBoard[i][x] = space;
            gameSpaces.getChildren().add(gameBoard[i][x]);
            
            gameBoard[i][x].setOnMouseClicked(e -> {
                    // System.out.println(e);

                    click1 = (int)(e.getSceneY()/SIZEOFTILES);
                    click2 = (int)(e.getSceneX()/SIZEOFTILES);

                    if (reversiBoard.valid(click2, click1)) {

                        reversiBoard.flip(click2, click1, turn);
                        
                        setPiece(turn.color);

                        reversiBoard.resetBoard();
                        playerSwitch();
                        reversiBoard.hint(turn);
                        reversiBoard.scores();
                        validMoves();
                        updateScores();
                    } else if (reversiBoard.endGame()) {
                        createGameOver();
                        reversiBoard.resetScore();
                        reversiBoard.initializeGameBoard();
                        initializePlayers();
                        reversiBoard.hint(player1);
                        validMoves(); 
                    }
                });
        }

	for(int x = 0; x < 8; x++) {
	    space = new GameSpace(i, x);
	    gameBoard[i][x] = space;
	    gameSpaces.getChildren().add(gameBoard[i][x]);
	    
	    gameBoard[i][x].setOnMouseClicked(e -> {

		    click1 = (int)(e.getSceneY()/SIZEOFTILES);
		    click2 = (int)(e.getSceneX()/SIZEOFTILES);

		    if (reversiBoard.valid(click2, click1)) {

			reversiBoard.flip(click2, click1, turn);
			recurseReversi(); 
			if (reversiBoard.endGame()) {
			    createGameOver();
			    reversiBoard.resetScore();
			     
			}
		    }
		});
	}

    }
    
    initialPieces();
    reversiV.getChildren().addAll(gameSpaces);
    reversiBoard.resetScore(); 
    createScores();
    
    reversiV.getChildren().add(playerScores);
    
    Scene scene = new Scene(reversiV, 400, 475);

    stage.setTitle("Reversi");

    stage.setScene(scene);
    stage.sizeToScene(); 
    stage.show();
    
    reversiBoard.initializeGameBoard();
    initializePlayers();
    
    reversiBoard.hint(player1); 
    validMoves(); 
    
    gameSpaces.requestFocus(); 
}
    public static void main(String [] args) {
        try {
            Application.launch(args);
        } catch(Exception e){
            System.out.println("error");
        }
    }
            
            


}






        
                
                
                               
            
          
    
        
        
        
