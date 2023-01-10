import javafx.application.Application;
import javafx.application.Application.*;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Scenes {

  static GameLoop GameLoop = new GameLoop();
  SpriteSheetProcessor Sheet = new SpriteSheetProcessor();
  
  //Border Edge Boxes
   VBox vbox1;
     HBox hbox1;
     HBox hbox2;
       HBox hbox4;
       VBox vbox2;
       HBox hbox5;
     HBox hbox3;
  
   ImageView MainPlayButton;
   ImageView MainLoadButton;
   ImageView MainTutorialButton;
   ImageView MainExitButton;
   Scene scene;
   AnchorPane menupane;
   ImageView player;
   AnchorPane prologuePane;

  ImageView Image1;
  ImageView Image2;
  ImageView Image3;
  ImageView Image4;
  ImageView Image5;
  ImageView Image6;
  ImageView Image7;
  ImageView Image8;
  ImageView Image9;

  Rectangle playerSolidArea;
  
  public void borderSetup() {
    vbox1 = new VBox();
      hbox1 = new HBox();
      hbox2 = new HBox();
        hbox4 = new HBox();
        vbox2 = new VBox();
        hbox5 = new HBox();
      hbox3 = new HBox();

    vbox1.getChildren().addAll(hbox1, hbox2, hbox3);
    vbox1.setVgrow(hbox1, Priority.ALWAYS);
    vbox1.setVgrow(hbox2, Priority.ALWAYS);
    vbox1.setVgrow(hbox3, Priority.ALWAYS);
    hbox2.getChildren().addAll(hbox4, vbox2, hbox5);
    hbox2.setHgrow(hbox4, Priority.ALWAYS);
    hbox2.setHgrow(vbox2, Priority.ALWAYS);
    hbox2.setHgrow(hbox5, Priority.ALWAYS);

    hbox1.setStyle("-fx-background-color: #000000;");
    hbox3.setStyle("-fx-background-color: #000000;");
    hbox4.setStyle("-fx-background-color: #000000;");
    hbox5.setStyle("-fx-background-color: #000000;");

    scene = new Scene(vbox1);
  }
  
  public void Mainmenu(Stage primaryStage) {

    borderSetup();
    
    Image play = new Image("Assets/MainMenu/NewGame.png");
    Image play1 = new Image("Assets/MainMenu/NewGameHighlight.png");
    MainPlayButton = new ImageView(play);
    Image load = new Image("Assets/MainMenu/LoadGame.png");
    Image load1 = new Image("Assets/MainMenu/LoadGameHighlight.png");
    MainLoadButton = new ImageView(load);
    Image tutorial = new Image("Assets/MainMenu/Tutorial.png");
    Image tutorial1 = new Image("Assets/MainMenu/TutorialHighlight.png");
    MainTutorialButton = new ImageView(tutorial);
    Image exit = new Image("Assets/MainMenu/Exit.png");
    Image exit1 = new Image("Assets/MainMenu/ExitHighlight.png");
    MainExitButton = new ImageView(exit);
    MainPlayButton.setPreserveRatio(true);
    MainPlayButton.setFitHeight(150);
    MainLoadButton.setPreserveRatio(true);
    MainLoadButton.setFitHeight(150);
    MainTutorialButton.setPreserveRatio(true);
    MainTutorialButton.setFitHeight(150);
    MainExitButton.setPreserveRatio(true);
    MainExitButton.setFitHeight(150);

    MainPlayButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent e) {
        Prologue();
      }
    });
    MainPlayButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent e) {
        MainPlayButton.setImage(play1);
      }
    });
    MainPlayButton.setOnMouseExited(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent e) {
        MainPlayButton.setImage(play);
      }
    });
    MainLoadButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent e) {
        System.out.println("Load a Game");
      }
    });
    MainLoadButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent e) {
        MainLoadButton.setImage(load1);
      }
    });
    MainLoadButton.setOnMouseExited(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent e) {
        MainLoadButton.setImage(load);
      }
    });
    MainTutorialButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent e) {
        //System.out.println("Play");
        System.out.println("Tutorial");
      }
    });
    MainTutorialButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent e) {
        MainTutorialButton.setImage(tutorial1);
      }
    });
    MainTutorialButton.setOnMouseExited(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent e) {
        MainTutorialButton.setImage(tutorial);
      }
    });
    MainExitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent e) {
        System.out.println("Exit");
      }
    });
    MainExitButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent e) {
        MainExitButton.setImage(exit1);
      }
    });
    MainExitButton.setOnMouseExited(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent e) {
        MainExitButton.setImage(exit);
      }
    });

    Image backgroundImage = new Image("Assets/MainMenu/test3.png");
    ImageView MenuBackground = new ImageView(backgroundImage);
    //MenuBackground.setPreserveRatio(true);
    //MenuBackground.setFitHeight(694);
    //MenuBackground.setFitWidth(1374);

    /*BackgroundImage bgImg = new BackgroundImage(MenuBackground, 
    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
    BackgroundPosition.DEFAULT, 
    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, false));*/

    menupane = new AnchorPane();

    menupane.setMinHeight(675);
    menupane.setMinWidth(1200);
    menupane.setMaxHeight(675);
    menupane.setMaxWidth(1200);
    menupane.setPrefHeight(675);
    menupane.setPrefWidth(1200);

    vbox2.getChildren().add(menupane);
    vbox2.setVgrow(menupane, Priority.ALWAYS);

    menupane.setTopAnchor(MenuBackground, 0.0);
    menupane.setLeftAnchor(MenuBackground, 0.0);
    menupane.setTopAnchor(MainPlayButton, 113.75);
    menupane.setLeftAnchor(MainPlayButton, 100.0);
    menupane.setTopAnchor(MainLoadButton, 212.5);
    menupane.setLeftAnchor(MainLoadButton, 100.0);
    menupane.setTopAnchor(MainTutorialButton, 311.25);
    menupane.setLeftAnchor(MainTutorialButton, 100.0);
    menupane.setTopAnchor(MainExitButton, 410.0);
    menupane.setLeftAnchor(MainExitButton, 100.0);
    menupane.getChildren().addAll(MenuBackground, MainPlayButton, MainLoadButton, MainTutorialButton, MainExitButton);
    /*Background back = new Background(bgImg);
    menupane.setBackground(back);*/
    
    primaryStage.setTitle("Untitled Game");
    primaryStage.setScene(scene);
    primaryStage.setFullScreenExitHint("");
    primaryStage.setResizable(false);
    primaryStage.show();
    primaryStage.setFullScreen(true);
  }
  
  public void Prologue() {

    Image spriteSheet = new Image("Assets/MainCharacterAnim/SpriteSheet.png");

    List<Image> walkingSprites = Sheet.processSpriteSheet(spriteSheet);
    
    Image img;
    prologuePane = new AnchorPane();
    Rectangle collisiontest;

    prologuePane.setMinHeight(675);
    prologuePane.setMinWidth(1200);
    prologuePane.setMaxHeight(675);
    prologuePane.setMaxWidth(1200);

    img = new Image("Assets/MainCharacterAnim/DOWN/Down1.png");
    player = new ImageView(img);
    player.setPreserveRatio(true);
    player.setFitHeight(75);
    //player.setFitWidth(100);

    collisiontest = new Rectangle(200, 200, 50, 50);
    collisiontest.setId("collisiontest");
    
    playerSolidArea = new Rectangle();
    playerSolidArea.setX(21.5);
    playerSolidArea.setY(36);
    playerSolidArea.setWidth(32);
    playerSolidArea.setHeight(30);
    playerSolidArea.setFill(Color.TRANSPARENT);
    //playerSolidArea.xProperty().bind(player.xProperty());
    //playerSolidArea.yProperty().bind(player.yProperty());
    //player.getChildren().add(playerSolidArea);

    prologuePane.getChildren().addAll(collisiontest, playerSolidArea, player);
  
    vbox2.getChildren().clear();
    vbox2.getChildren().add(prologuePane);
    vbox2.setVgrow(prologuePane, Priority.ALWAYS);
    GameLoop.switchScene(player, playerSolidArea, prologuePane, scene);
  }
}