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

/**
 * Application subclass for {@code ArcadeApp}.
 * @version 2019.fa
 */

public class ArcadeApp extends Application {

    Group group = new Group();           // main container
    Random rng = new Random();           // random number generator
    Rectangle r = new Rectangle(20, 20); // some rectangle


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


	Image woodenBoard = new Image("file:resources/wood_background_hd_picture_5_169810.jpg", 800, 800, false, false);
	BackgroundImage wooden = new BackgroundImage(woodenBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	Background mancalaBackground = new Background(wooden);

	VBox vbox = new VBox();

	vbox.setBackground(mancalaBackground);
	


	Scene scene = new Scene(vbox, 800, 368);
	  
	mancala.setTitle("Mancala");
	mancala.setWidth(800);
	mancala.setHeight(368);
	mancala.setScene(scene);
	 
	mancala.show();
    }

    public void playTetris() {
<<<<<<< HEAD

	Stage tetris = new Stage();
        tetris.initModality(Modality.APPLICATION_MODAL);
        HBox main = new HBox();
	GridPane grid = new GridPane();
        main.setPadding(new Insets(15, 12, 15, 12));
        main.setSpacing(20);
	Image rainbow = new Image("http://hd-wallpapers.download/free/blocks_rainbow_3d_graphics_background_76559_6000x4000-3000x2000.jpg", 500, 600, false, false);
        BackgroundImage back = new BackgroundImage(rainbow, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(back);
        main.setBackground(background);
        VBox left = new VBox();
        VBox right = new VBox();
        HBox next = new HBox();
        left.setSpacing(20);
        next.setAlignment(Pos.CENTER);
        next.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        next.setStyle("-fx-padding: 5;" + "-fx-border-style: solid outside;"
		      + "-fx-border-width: 5;" + "-fx-border-insets: 5;"
		      + "-fx-border-radius: 5;" + "-fx-border-color: red;");
        Text info = new Text();
        info.setText("SCORE:\n" + " 0\n" + "LEVEL :\n" + " 1\n" + "LINES :\n" + " 0");
        info.setFill(Color.RED);
        info.setFont(Font.font("Futura", FontWeight.BOLD, 16));
        next.getChildren().add(info);
        HBox stats = new HBox();
        ImageView logo = new ImageView(new Image("https://www2.instantticketcontest.com/TX/Tetris/images/logo-game@2x.png", 150, 150, false, false));
        grid.setPrefSize(300, 600);
        grid.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE); 

	//adds cols and rows to grid
        final int numCols = 10;
	final int numRows = 20;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);  
            grid.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            grid.getRowConstraints().add(rowConst);         
        }
        grid.setGridLinesVisible(true);
	grid.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        left.getChildren().addAll(logo, next, stats);
        right.getChildren().addAll(grid);
        main.getChildren().addAll(left, right);

	Scene scene = new Scene(main);
	tetris.setTitle("Tetris");
	tetris.setWidth(500);
	tetris.setHeight(560);
	tetris.setScene(scene);
        tetris.show();
=======
	Tetris tetris = new Tetris();
>>>>>>> 6515fb09926dfe24dfc0014591d1ba601df26432
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
        mancalaPic.setOnMouseClicked(clickMancala());
	tetrisPic.setOnMouseClicked(clickTetris()); 
	hbox.getChildren().addAll(mancalaPic, tetrisPic);

	return hbox;
    }
   
	
      
	

} // ArcadeApp
