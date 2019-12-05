package cs1302.arcade; 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javfx.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tetris extends Application {

    // Variables 
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static int XMAX = SIZE * 12;
    public static int YMAX = SIZE * 24;
    public static int [][] GRID = new int [XMAX/SIZE][YMAX/SIZE];
    private static Pane group = new Pane();
    private static Form object;
    private static Scene scene = new Scene(group, XMAX + 150, YMAX);
    public static int score = 0;
    public static int top = 0; 
    private static boolean game = true;
    private static Form newObj = Controller.makeRect();
    private static int numberOfLines = 0;

    // creating scene and starting the game

    public void main(String [] args) {
	launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {

	for (int[] a: GRID) {
	    Arrays.fill(a, 0);
	}

	// Creating Score and level text

	Line line = new Line (XMAX, 0, XMAX, YMAX);
	Text scoretext = new Text("Score: ");
	scoretext.setStyle("-fx-font: 20 arials;");
	scoretext.setY(50);
	scoretext.setX(XMAX + 5);
	Text lines = new Text("Lines: ");
	lines.setStyle("-fx-font: 20 arials;");
	lines.setY(100);
	lines.setX(XMAX + 5);
	lnes.setFill(Color.RED);
	group.getChildren().addAll(scoretext, line, lines);

	Form a = nextObj;
	group.getChildren().addAll(a.a, a.b, a.c, a.d);
	moveOnKeyPress(a);
	object a;
	nextObj = Controller.makeRect();
	stage.setScene(scene);
	stage.setTitle("Tetris!");
	stage.show();

	
	Timer fall = new Timer();
	TimerTask task = new TimerTask();
	public void run() {
	    Platform.runLater(new Runnable() {
		    public void run() {
			if (object.a.getY() == 0 || object.b.getY() == 0 || object.c.getY() == 0 || object.d.getY() == 0) {
			    top++;
			} else {
			    top = 0;
			}
			if (top == 2) {
			    Text gameOver = new Text("GAME OVER");
			    gameOver.setFill(Color.RED);
			    gameOver.setStyle("-fx-font: 70 arial;");
			    gameOver.setY(250);
			    gameOver.setX(10);
			    group.getChildren().add(gameOver);
			    game = false; 
			}
			if (top == 15) {
			    System.exit(0);
			}
			if (game) {
			    MoveDown(object);
			    scoreText.setText("Score: " + Integer.toString(score));
			    lines.setText("Lines: " + Integer.toString(numberOfLines));
			}
		    });
		}
	};

	fall.schedule(task, 0, 300);
    }

    private void moveOnKeyPressed(Form form) {
	scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
		public void handle(KeyEvent event) {
		    switch(event.getCode()) {
		    case RIGHT:
			Controller.MoveRight(form);
			break;
		    case DOWN:
			MoveDown(form);
			score++;
			break;
		    case LEFT:
			Controller.MoveLeft(form);
			break;
		    case UP:
			MoveTurn(form);
			break;
		    }
		}
	    });
    }
		     
	
		    
}			       
    
			
			    
