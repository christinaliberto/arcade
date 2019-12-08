package cs1302.arcade;

import javafx.geometry.Insets; 
import javafx.scene.layout.*; 
import javafx.stage.Modality; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.shape.Circle;
import javafx.animation.TranslateTransition;
import javafx.animation.ParallelTransition;
import javafx.util.Duration;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Mancala {

    public int numberOfPits = 12;
    public int numberOfStones = 4;
    public int [] board = new int[14];

    public static boolean game = true;

    public Image pits = new Image("file:resources/circle-png-circle-png-hd-1600.png", 90, 90, false, false);
    public Image stores = new Image("file:resources/d238146fc3a2b6b70c792b5c55d91584-rectangle-shape-stroke-by-vexels.png", 125, 125, false, false);
    public Image mancalaBall = new Image("file:resources/48-484326_free-vector-nlyl-blue-circle-clip-art-small.png", 25, 25, false, false); 

    public ImageView storeImage1 = new ImageView();
    public ImageView storeImage2 = new ImageView(); 
    public ImageView [] pitsImage = new ImageView [12];
    public ImageView [] ballImageView = new ImageView[48];
    
    public Pane northPane = new Pane();
    public Pane southPane = new Pane();

     
    public GridPane pitsPane = new GridPane(); 
    public GridPane stonesInPit = new GridPane();
    public StackPane stonesAndPits = new StackPane();
    
    public Mancala() {

	Stage mancalaStage = new Stage();
	mancalaStage.initModality(Modality.APPLICATION_MODAL);
	Scene scene = new Scene(makeBoard(), 800, 368);
	mancalaStage.setScene(scene);
	mancalaStage.setWidth(800);
	mancalaStage.setHeight(368); 
	mancalaStage.setTitle("Mancala"); 
	mancalaStage.show(); 
	
    }
    

    public Pane makeBoard() {

	Pane pane  = new Pane(); 
	Image woodenBoard = new Image("file:resources/wood_background_hd_picture_5_169810.jpg", 800, 800, false, false);
	BackgroundImage wooden = new BackgroundImage(woodenBoard, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	Background mancalaBackground = new Background(wooden);
	pane.setBackground(mancalaBackground);
        pane.getChildren().add(setUpMancala()); 
	return pane; 
    }

    public Pane  setUpMancala() {

	double gap = (800 - 2 * (30 + stores.getWidth()) - pits.getWidth() * 6) / (6 + 1);

	storeImage1.setImage(stores);
	storeImage1.setRotate(90);
	storeImage1.setLayoutX(30);
	storeImage1.setLayoutY((368 - stores.getHeight()) / 2);

	northPane.setPrefSize(118 + gap / 2, 328);
	northPane.getChildren().add(storeImage1);

	storeImage2.setImage(stores);
	storeImage2.setRotate(90);
	storeImage2.setLayoutX(gap / 2);
	storeImage2.setLayoutY((368 - stores.getHeight()) / 2);

	southPane.setPrefSize(118 + gap / 2, 328);
	southPane.relocate(800 - 118 - gap / 2, 0);
	southPane.getChildren().add(storeImage2);

	for (int i = 0; i < pitsImage.length; i++) {
	    pitsImage[i] = new ImageView();
	    pitsImage[i].setImage(pits);
	    pitsImage[i].setOnMouseClicked(this); 
	}

	for (int i = 0; i < 6; i++) {
	    pitsPane.add(pitsImage[i], i , 0, 1, 1);
	}
	for (int i = 6; i < pitsImage.length; i++) {
	    pitsPane.add(pitsImage[i], i - 6, 1, 1, 1);
	}
	pitsPane.setPadding(new Insets(100, 100, 10, 140)); 

	for (int i = 0; i < ballImageView.length; i++) {
	    ballImageView[i] = new ImageView();
	    ballImageView[i].setImage(mancalaBall);
	}

	for (int i = 0; i < 6; i++) {
	    stonesInPit.add(ballImageView[i], i, 0, 1, 1);
	}
	
	stonesInPit.setPadding(new Insets(100, 100, 10, 140)); 

	stonesAndPits.getChildren().addAll(pitsPane, stonesInPit); 
	
	Pane gamePane = new Pane();

       
						 
	gamePane.getChildren().add(northPane);
	gamePane.getChildren().add(southPane);
	gamePane.getChildren().addAll(stonesAndPits);
	
	return gamePane; 
   }

	
        

    

    
}
 
