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

public class Scenes {

  static GameLoop GameLoop = new GameLoop();
  //MovementController movementController = new MovementController();
  
  //Border Edge Boxes
    static VBox vbox1;
      static HBox hbox1;
      static HBox hbox2;
        static HBox hbox4;
        static VBox vbox2;
        static HBox hbox5;
      static HBox hbox3;
  
    static ImageView MainPlayButton;
    static ImageView MainLoadButton;
    static ImageView MainTutorialButton;
    static ImageView MainExitButton;
    static Scene scene;
    static AnchorPane menupane;
  
  public static void borderSetup() {
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
  
  public static void Prologue() {
    
    Image img;
    AnchorPane prologuePane = new AnchorPane();
    ImageView player;
    Rectangle rect;

    prologuePane.setMinHeight(675);
    prologuePane.setMinWidth(1200);
    prologuePane.setMaxHeight(675);
    prologuePane.setMaxWidth(1200);

    img = new Image("Assets/sprite.jpg");
    player = new ImageView(img);
    player.setPreserveRatio(true);
    player.setFitHeight(100);
    player.setFitWidth(100);

    rect = new Rectangle(200, 200, 50, 50);

    prologuePane.getChildren().addAll(player, rect);
    vbox2.getChildren().clear();
    vbox2.getChildren().add(prologuePane);
    vbox2.setVgrow(prologuePane, Priority.ALWAYS);
    GameLoop.switchScene(player, prologuePane, scene);
  }
}