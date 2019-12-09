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

public class Reversi extends Application {

    public static final int BOARDWIDTH = 8;
    public static final int BOARDHEIGHT = 8;
    public static final int SIZEOFTILES = 50;
    
    public int turn = 1;

    Player player1, player2;
    
    public Text scoresTurn;

    Circle gamePiece, player11, player12, player21, player22; 

    Shape[][] gameBoard = new Shape[BOARDWIDTH][BOARDHEIGHT]; 

    GameSpace space; 
	
    Group gameSpaces;
    
    public HBox playerScores;

    Board reversiBoard = new Board();

    public void initializePlayers() {
	player1 = new Player('c');
	player2 = new Player('w');
    }
    
    public void createScores() {
	
	playerScores = new HBox();
        BackgroundFill fill = new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY);
    Background scoreBack = new Background(fill);
    playerScores.setBackground(scoreBack);
    
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

    player11 = createGamePiece('w', 3, 4);
    player12 = createGamePiece('w', 4, 3);
    player21 = createGamePiece('c', 3, 3);
    player22 = createGamePiece('c', 4, 4);
    gameSpaces.getChildren().addAll(player11, player12, player21, player22);
    
}

public void validMoves() {
    for (int i = 0; i < 8; i++) {
	for (int x = 0; x < 8; x++) {
	    if (reversiBoard.valid(i, x)) {
		gameBoard[i][x].setFill(Color.YELLOW);
	    }
	    else {
		gameBoard[i][x].setFill(Color.HOTPINK);
	    }
	}
    }
}

public void setPiece(char c) {
    for (int i = 0; i < 8; i++) {
	for (int x = 0; x < 8; x++) {
	    if (reversiBoard.board[i][x] == c) {
		gameSpaces.getChildren().add(createGamePiece(c, i, x));
	    }
	}
    }
}
    
   

			  

public void start (Stage stage) {

    VBox reversiV = new VBox();

    reversiV.setPrefSize(BOARDWIDTH * SIZEOFTILES, BOARDHEIGHT * SIZEOFTILES);
    
    gameSpaces = new Group();

    for (int i = 0; i < BOARDHEIGHT; i++) {
	for(int x = 0; x < BOARDWIDTH; x++) {
	    space = new GameSpace(i, x);
	    gameBoard[i][x] = space;
	    gameSpaces.getChildren().add(space);
	}
    }
    initialPieces();
    reversiV.getChildren().addAll(gameSpaces);
    createScores();
    reversiV.getChildren().add(playerScores);

    Scene scene = new Scene(reversiV, 410, 600);

    stage.setTitle("Reversi");

    stage.setScene(scene);
    stage.sizeToScene(); 
    stage.show();

    reversiBoard.initializeGameBoard();
    initializePlayers();
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






	
		
		
			       
	    
	  
    
	
	
	
