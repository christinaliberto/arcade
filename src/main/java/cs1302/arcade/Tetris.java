
package cs1302.arcade;

import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.animation.Timeline; 
import javafx.scene.text.*;
import javafx.scene.control.Button;
import java.util.Arrays;
import javafx.stage.Stage;
import javafx.application.Application;

<<<<<<< HEAD
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
    private static Form nextObj = Controller.makeRect();
    private static int numberOfLines = 0;

    // creating scene and starting the game

    public void main(String [] args) {
        launch(args);
    }

    @Override
    public void run() throws Exception {
        
        Timer fall = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						if (object.a.getY() == 0 || object.b.getY() == 0 || object.c.getY() == 0
								|| object.d.getY() == 0)
							top++;
						else
							top = 0;
						
						if (top == 2) {
						    // GAME OVER
						    Text over = new Text("GAME OVER");
						    over.setFill(Color.RED);
						    over.setStyle("-fx-font: 70 arial;");
						    over.setY(250);
						    over.setX(10);
						    group.getChildren().add(over);
						    game = false;
						}
						// Exit
						if (top == 15) {
						    System.exit(0);
						}
						
						if (game) {
						    MoveDown(object);
						    scoretext.setText("Score: " + Integer.toString(score));
						    lines.setText("Lines: " + Integer.toString(numberOfLines));
						}
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
=======
public class Tetris {

    private GridPane grid = new GridPane();
    private Scene scene;
    private Stage stage;
    private Text score;
    private Text level;
    private Timeline dropping;
    private boolean endGame = false;

    public Scene setTetrisScene() {

	score = new Text();
	level = new Text();

	HBox scoreLevel = new HBox(score, level);
	scoreLevel.setSpacing(35);
>>>>>>> bc70b8be6bef5441a1aaa3e11ec6e432b966b892

	VBox vbox = new VBox(scoreLevel, grid);
	scene = new Scene(vbox);
	grid.requestFocus();
	grid.setLinesVisible(true); 
	return scene;
    }
	
    
}
