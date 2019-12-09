package cs1302.arcade;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.shape.*;


public class Reversi extends Application {

    public static final int BOARDWIDTH = 8;
    public static final int BOARDHEIGHT = 8;
    public static final int SIZEOFTILES = 50;
    
    public int turn = 1;

    Player player1, player2;
    
    public Text scoresTurn;

    Circle gamePiece, player11, player12, player21, player22; 

    Group gameSpaces;
    
    public VBox playerScores;

    Board reversiBoard = new Board();
    
    public void createScores() {
	
	playerScores = new VBox();
	
	scoresTurn = new Text("It's Player 1's turn!\n" + "\nPlayer 1: " + reversiBoard.getPlayer1Score() + "\nPlayer 2: " + reversiBoard.getPlayer2Score());
	scoresTurn.setFill(Color.RED);
	scoresTurn.setFont(Font.font("Futura", FontWeight.BOLD, 16));
	
	playerScores.getChildren().add(scoresTurn);
    }

    public void updateScores() {

	if (turn == 1) {
	    scoresTurn.setText("It's player 2's turn!\n" + "\nPlayer 1: " + reversiBoard.getPlayer1Score() + "\nPlayer 2: " + reversiBoard.getPlayer2Score());
	} else {
	    scoresTurn.setText("It's player 1's turn!\n" + "\nPlayer 1: " + reversiBoard.getPlayer1Score() + "\nPlayer 2: " + reversiBoard.getPlayer2Score());
	}
    }


    public Circle createGamePiece(char color, int xPos, int yPos) {

	Paint color = null; 

	if (color == 'c') {
	    color = Color.CYAN;
	}
	else if (color == 'w') {
	    color = color.WHITE;
	}
	gamePiece = new Circle(x * SIZEOFTILES, y * SIZEOFTILES, 20, color);
	gamePiece.setTranslateX((SIZEOFTILES - SIZEOFTILES * .5 * 2)/ 2 + SIZEOFTILES*.5);
	gamePiece.setTranslateY(SIZEOFTILES - SIZEOFTILES * .5 * 2) / 2 + SIZEOFTILES * .5);

    return gamePiece;
}

public void initialPieces() {

    player11 = createGamePiece('w', 3, 4);
    player12 = createGamePiece('w', 4, 3);
    player21 = createGamePiece('c', 3, 3);
    player22 = createGamePiece('c', 4, 4);
    gameSpaces.getChilren().addAll(player11, player12, player21, player22);
    
}

public void start (Stage stage) {
    
    gameSpaces = new Group();
}









	
		
		
			       
	    
	  
    
	
	
	
