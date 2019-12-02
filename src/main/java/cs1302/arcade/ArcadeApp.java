package cs1302.arcade;

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
/**
 * Application subclass for {@code ArcadeApp}.
 * @version 2019.fa
 */

public class ArcadeApp extends Application {

    Group group = new Group();           // main container
    Random rng = new Random();           // random number generator
    Rectangle r = new Rectangle(20, 20); // some rectangle

    /**
     * Return a mouse event handler that moves to the rectangle to a random
     * position any time a mouse event is generated by the associated node.
     * @return the mouse event handler
     */

    /**
     * Return a key event handler that moves to the rectangle to the left
     * or the right depending on what key event is generated by the associated
     * node.
     * @return the key event handler
     */
    private EventHandler<? super KeyEvent> createKeyHandler() {
        return event -> {
            System.out.println(event);
            switch (event.getCode()) {
            case LEFT:  // KeyCode.LEFT
                r.setX(r.getX() - 10.0);
                break;
            case RIGHT: // KeyCode.RIGHT
                r.setX(r.getX() + 10.0);
                break;
            default:
                // do nothing
            } // switch
             // TODO bounds checking
        };
    } // createKeyHandler

    private EventHandler<? super MouseEvent> clickMancala() {
	return e -> {
	    playMancala();
		};
    }

    private EventHandler<? super MouseEvent> clickTetris() {
	return e -> {
	    playTetris();
		};
    }
    /** {@inheritDoc} */
    @Override
    public void start(Stage stage) {

        /* You are allowed to rewrite this start method, add other methods,
         * files, classes, etc., as needed. This currently contains some
         * simple sample code for mouse and keyboard interactions with a node
         * (rectangle) in a group.
         */

        r.setX(50);                                // 50px in the x direction (right)
        r.setY(50);                                // 50ps in the y direction (down)
        group.getChildren().add(r);                // add to main container
        //r.setOnMouseClicked(createMouseHandler()); // clicks on the rectangle move it randomly
        group.setOnKeyPressed(createKeyHandler()); // left-right key presses move the rectangle

        
        
      	Scene scene = new Scene(createMenu(), 500, 500);
	stage.setTitle("cs1302-arcade!");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

        // the group must request input focus to receive key events
        // @see https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html#requestFocus--
        group.requestFocus();

    } // start

    public void playMancala() {

	Stage mancala = new Stage();

	mancala.initModality(Modality.APPLICATION_MODAL);


	Image woodenBoard = new Image("file:resources/wood_background_hd_picture_5_169810.jpg", 552, 368, false, false);
	BackgroundImage wooden = new BackgroundImage(woodenBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	Background mancalaBackground = new Background(wooden);

	VBox vbox = new VBox();

	vbox.setBackground(mancalaBackground);

     	Scene scene = new Scene(vbox, 552, 368);
	  
	mancala.setTitle("Mancala");
	mancala.setWidth(552);
	mancala.setHeight(368);
	mancala.setScene(scene);
	 
	mancala.show();
    }

    public void playTetris() {

	Stage tetris = new Stage();
	tetris.initModality(Modality.APPLICATION_MODAL);
	HBox main = new HBox();
	Image rainbow = new Image("http://hd-wallpapers.download/free/blocks_rainbow_3d_graphics_background_76559_6000x4000-3000x2000.jpg", 500, 580, false, false);
        BackgroundImage back = new BackgroundImage(rainbow, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	Background background = new Background(back);
	main.setBackground(background);
	VBox left = new VBox();
	VBox right = new VBox();
	HBox next = new HBox();

	next.setBackground(new Background(new BackgroundFill(Color.HOTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
	next.setStyle("-fx-padding: 30;" + "-fx-border-style: solid inside;"
        + "-fx-border-width: 4;" + "-fx-border-insets: 10;"
        + "-fx-border-radius: 10;" + "-fx-border-color: red;");
	HBox stats = new HBox();
	ImageView logo = new ImageView(new Image("https://www2.instantticketcontest.com/TX/Tetris/images/logo-game@2x.png", 150, 150, false, false));
	ImageView codegame = new ImageView(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7c/Emacs_Tetris_vector_based_detail.svg/2000px-Emacs_Tetris_vector_based_detail.svg.png", 300, 570, false, false));
	left.getChildren().addAll(logo, next, stats);
	right.getChildren().addAll(codegame);
	main.getChildren().addAll(left, right);
	Scene scene = new Scene(main);
	tetris.setTitle("Tetris");
	tetris.setWidth(500);
	tetris.setHeight(580);
	tetris.setScene(scene);
	tetris.show();
    }

    public VBox createMenu() {

	VBox vbox = new VBox();
	vbox.setSpacing(120);
	vbox.setPadding(new Insets(10, 10, 10, 10));
	Text welcome = new Text();
	welcome.setX(10);
	welcome.setY(70);
	welcome.setCache(true);
	welcome.setText("Welcome to the 530 Coding Queens Aracde!\n" + "        Click the game you want to play");
	welcome.setFill(Color.HOTPINK);
	welcome.setFont(Font.font("Futura", FontWeight.BOLD, 20));
	vbox.setBackground(createBackground());
	vbox.getChildren().addAll(welcome, games()); 
	return vbox; 
    }

    public Background createBackground() {

	Image crownImage = new Image("https://i.pinimg.com/originals/b9/84/75/b984750467f7b4b000f03977cc1d2ca4.jpg", 500, 500, false, false);
	BackgroundImage crowns = new BackgroundImage(crownImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	Background mainBackground = new Background(crowns);

	return mainBackground;
    }

    public HBox games() {
	HBox hbox = new HBox();
	hbox.setSpacing(66);
	hbox.setPadding(new Insets(15, 66, 15, 66));
	ImageView mancalaPic = new ImageView(new Image("http://iomega-europe.com/wp-content/uploads/2018/01/logo-mancala.png", 150, 150, false, false));
	ImageView tetrisPic = new ImageView(new Image("https://i-cdn.phonearena.com/images/articles/309604-thumb/tetris-h.jpg", 150, 150, false, false));
	//	mancalaPic.translateX(300);
	//mancalaPic.translateY(250);
	//tetrisPic.translateY(250);
	mancalaPic.setOnMouseClicked(clickMancala());
	tetrisPic.setOnMouseClicked(clickTetris()); 
	hbox.getChildren().addAll(mancalaPic, tetrisPic);

	return hbox;
    }
   
	
      
	

} // ArcadeApp
