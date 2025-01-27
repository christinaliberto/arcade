package cs1302.arcade;

import cs1302.arcade.Tetris;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.event.ActionEvent; 
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background; 
import javafx.scene.layout.BackgroundImage;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize; 
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.effect.InnerShadow;
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Font;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.shape.Circle;
import javafx.scene.layout.*; 
import javafx.scene.effect.Reflection;

/**
 * Application subclass for {@code ArcadeApp}.
 * @version 2019.fa
 */

public class ArcadeApp extends Application {

    // declare and initialize variables
    Reversi reversiGame = new Reversi();
    
    Group group = new Group();           // main container
    Random rng = new Random();           // random number generator
    Rectangle r = new Rectangle(20, 20); // some rectangle
 
    /** click event for reversi.
     * @return EventHandler
     */
    
    private EventHandler<? super MouseEvent> clickReversi() {
        return e -> {
            playReversi();
        };
    }

    /** click event for tetris.
     * @return EventHandler
     */
    
    private EventHandler<? super MouseEvent> clickTetris() {
        return e -> {
            playTetris();
        };
    }

    /** {@inheritDoc} */
    @Override
    public void start(Stage stage) {

        
        
        Scene scene = new Scene(createMenu(), 500, 500);
        stage.setTitle("cs1302-arcade!");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        group.requestFocus();

    } // start

    /** starts reversi app. */
    
    public void playReversi() {
        
        Stage playGame = new Stage();
        playGame.initModality(Modality.APPLICATION_MODAL);
        reversiGame.start(playGame); 
    }

    /**starts tetris app. */
    
    public void playTetris() {
        Tetris tetris = new Tetris();
    }

    /** creates menu.
     * @return VBox
     */
        
    public VBox createMenu() {
        
        VBox vbox = new VBox();
        vbox.setSpacing(120);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        Text welcome = new Text();
        welcome.setX(10);
        welcome.setY(70);
        welcome.setCache(true);
        welcome.setText("Welcome to the 530 Coding Queens Arcade!\n\n"
                        + "        Click the game you want to play!");
        welcome.setFill(Color.HOTPINK);
        welcome.setFont(Font.font("Futura", FontWeight.BOLD, 20));
        Reflection r = new Reflection();
        r.setFraction(0.4f);
        welcome.setEffect(r); 
        vbox.setBackground(createBackground());
        vbox.getChildren().addAll(welcome, games()); 
        return vbox; 
    }

    /** makes background.
     * @return Background
     */
    
    public Background createBackground() {

        Image gameBackground = new Image("file:resources/b984750467f7b4b000f03977cc1d2ca4.jpg",
                                         500, 500, false, false);
        BackgroundImage bg = new BackgroundImage(gameBackground, BackgroundRepeat.NO_REPEAT,
                                                 BackgroundRepeat.NO_REPEAT,
                                                 BackgroundPosition.DEFAULT,
                                                 BackgroundSize.DEFAULT);
        Background mainBackground = new Background(bg);

        return mainBackground;
    }
    
    /** makes game buttons.
     * @return HBox
     */
    
    public HBox games() {
        HBox hbox = new HBox();
        hbox.setSpacing(66);
        hbox.setPadding(new Insets(15, 66, 15, 66));
        ImageView reversiPic = new ImageView(new
                                             Image("file:resources/ReversiTeaser.jpg", 150,
                                                   150, false, false));
        ImageView tetrisPic = new ImageView(new
                                            Image("file:resources/tetris-h.jpg", 150,
                                                  150, false, false));
        reversiPic.setOnMouseClicked(clickReversi());
        tetrisPic.setOnMouseClicked(clickTetris()); 
        hbox.getChildren().addAll(reversiPic, tetrisPic);

        return hbox;
    }   

} // ArcadeApp
