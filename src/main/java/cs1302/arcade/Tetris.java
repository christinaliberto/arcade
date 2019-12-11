package cs1302.arcade;


import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.event.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.text.FontWeight;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Region;
import cs1302.arcade.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Tetris {

    private Timeline tl = new Timeline();
    private int score = 0;
    private int level = 1;
    private int lines = 0;
    private GridPane grid = new GridPane();
    private Square sq;
    private boolean gameOver = false;
    
    public Tetris() {
        Stage tetris = new Stage();
        tetris.initModality(Modality.APPLICATION_MODAL);
        HBox main = new HBox();
        main.setPadding(new Insets(15, 12, 15, 12));
        main.setSpacing(20);
        Image rainbow = new Image("http://hd-wallpapers.download/free/blocks_rainbow_3d_graphics_background_76559_6000x4000-3000x2000.jpg", 500, 620, false, false);
        BackgroundImage back = new BackgroundImage(rainbow, BackgroundRepeat.NO_REPEAT,
                                                   BackgroundRepeat.NO_REPEAT,
						   BackgroundPosition.DEFAULT,
						   BackgroundSize.DEFAULT);
        Background background = new Background(back);
        main.setBackground(background);
        VBox left = new VBox();
        VBox right = new VBox();
        HBox next = new HBox();
        HBox rule = new HBox();
        left.setSpacing(40);
        next.setAlignment(Pos.CENTER);
        next.setBackground(new Background(new BackgroundFill(Color.BLACK,
                                                             CornerRadii.EMPTY, Insets.EMPTY)));
        next.setStyle("-fx-padding: 0;" + "-fx-border-style: solid outside;"
                      + "-fx-border-width: 5;" + "-fx-border-insets: 5;"
                      + "-fx-border-radius: 5;" + "-fx-border-color: red;");
        rule.setBackground(new Background(new BackgroundFill(Color.BLACK,
                                                             CornerRadii.EMPTY, Insets.EMPTY)));
        rule.setStyle("-fx-padding: 0;" + "-fx-border-style: solid outside;"
                      + "-fx-border-width: 5;" + "-fx-border-insets: 5;"
                      + "-fx-border-radius: 5;" + "-fx-border-color: red;");
        Text info = new Text();
        info.setText("SCORE:\n" + score + "\n" + "LEVEL :\n" + level + "\n" + "LINES :\n" + lines);
        info.setFill(Color.RED);
        info.setFont(Font.font("Futura", FontWeight.BOLD, 16));
        Text rules = new Text();
        rules.setText("CONTROLS \n\n" + "⇨ to move right \n\n"
                      + "⇦ to move left \n\n" + "⇧ to rotate \n\n" + "⇩ to move down \n");
        rules.setFill(Color.RED);
        rules.setFont(Font.font("Futura", FontWeight.BOLD, 16));
        next.getChildren().add(info);
        rule.getChildren().add(rules);
        ImageView logo = new ImageView(new Image("https://www2.instantticketcontest.com/TX/Tetris/images/logo-game@2x.png", 150, 150, false, false));
        left.getChildren().addAll(logo, next, rule);
        right.getChildren().addAll(makeGrid());
        sq = new Square(grid);
        setTimeline(level);
        tl.play();
        main.getChildren().addAll(left, right);
        Scene scene = new Scene(main);
        scene.setOnKeyPressed(keyHandler());
        tetris.setTitle("Tetris");
        tetris.setWidth(500);
        tetris.setHeight(620);
        tetris.setScene(scene);
        tetris.show();
    } //runTetris

    public GridPane makeGrid() {
        // creates grid
        grid.setPrefSize(300, 600);
        grid.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        for (int i = 0; i < 10; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100.0 / 10);
            grid.getColumnConstraints().add(col);
        } //for
        for (int i = 0; i < 20; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / 20);
            grid.getRowConstraints().add(row);
        } //for
        grid.setGridLinesVisible(true);
        grid.setBackground(new Background(new BackgroundFill(Color.BLACK,
                                                             CornerRadii.EMPTY, Insets.EMPTY)));
        return grid;
    } //makeGrid

    public EventHandler<? super KeyEvent> keyHandler() {
        return e -> {
            if (e.getCode() == KeyCode.RIGHT) {
                sq.move("right");
            } else if (e.getCode() == KeyCode.LEFT) {
                sq.move("left");
            } else if (e.getCode() == KeyCode.DOWN) {
                sq.move("down");
            } else if (e.getCode() == KeyCode.UP) {
                sq.move("up");
            }
        }; //return
    } //KeyHandler

    private void setTimeline(int Level) {
        tl.stop();
        EventHandler<ActionEvent> handler = e -> {
            if(sq.down() == false) {
                clearLines();
                checkGameOver();
                if(gameOver == false) {
                  sq = new Square(grid);
		  score+=10;
                } //if
            } //if    
        };        
        KeyFrame k;
        switch (level) {
        case 1:
            k = new KeyFrame(Duration.millis(800), handler);
            break;
        case 2:
            k = new KeyFrame(Duration.millis(500), handler);
            break;
        case 3:
            k = new KeyFrame(Duration.millis(200), handler);
            break;
        default:
            k = new KeyFrame(Duration.millis(1000), handler);
        }
        tl.getKeyFrames().clear();
        tl.getKeyFrames().add(k);
        tl.setCycleCount(Timeline.INDEFINITE);
    } //setTimeline

	private void clearLines() {
        int rowsCleared = 0;
        for(int y = 0; y < 20; y++) {
            boolean isFull = true;
            for (int x = 0; x < 10; x++) {
                if(sq.getFromGrid(x, y) == null) {
                    isFull = false;
                } //if
            } //for
            if(isFull) {
		score+= 250;
                for (int x = 0; x < 10; x++) {
                    Rectangle rect = sq.getFromGrid(x, y);
                    grid.getChildren().remove(rect);
                    for (int k = y; k > 0; k--) {
                        Rectangle top = sq.getFromGrid(x, k - 1);
                        if(top != null) {
                            GridPane.setRowIndex(top, k);
                        }
                    }
                }
            }
        }
        
    }
	
     private void checkGameOver() {
        for(int col = 0; col < 10; col++) {
            if(sq.getFromGrid(col, 0) != null) {
                tl.stop();
                gameOver = true;
                Alert alert = new Alert(AlertType.INFORMATION,
                                        "GAME OVER!\n"  +
                                        "Final score: " + score);
                
            }
        }
    }
    
} //tetris class 
