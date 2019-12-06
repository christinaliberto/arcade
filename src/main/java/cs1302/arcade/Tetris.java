
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

	VBox vbox = new VBox(scoreLevel, grid);
	scene = new Scene(vbox);
	grid.requestFocus();
	grid.setLinesVisible(true); 
	return scene;
    }
	
    
}
