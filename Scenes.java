import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.scene.image.*;

public class Scenes {
  public void menu(Stage primaryStage) {
  
    Main Main = new Main();
    Prologue Prologue = new Prologue();
    
    Label label;
    Button MainPlay;
    Button MainLoad;
    Button MainExit;
    VBox vbox1;
    VBox vbox2;
    Scene scene;
    HBox hbox;
    Group gp;

    label = new Label("Welcome!");
    MainPlay = new Button(/*"New Game"*/);
    MainLoad = new Button("Load Game");
    MainExit = new Button("Exit");
    
    Image img = new Image("Assets/pnn.png");
    ImageView view = new ImageView(img);
    view.setFitHeight(20);
    view.setFitWidth(40);
    view.setPreserveRatio(true);
    MainPlay.setGraphic(view);
    

    MainPlay.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        //System.out.println("Play");
        Prologue(primaryStage);
      }
    });
    MainLoad.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        System.out.println("Load a Game");
      }
    });
    MainExit.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        System.out.println("Exit");
      }
    });

    vbox1 = new VBox(MainPlay, MainLoad, MainExit);
    vbox1.setSpacing(30);
    vbox1.setMargin(MainPlay, new Insets(50, 10, 0, 20));  
    vbox1.setMargin(MainLoad, new Insets(0, 10, 0, 20)); 
    vbox1.setMargin(MainExit, new Insets(0, 10, 0, 20));

    vbox2 = new VBox(label, vbox1);
    label.setAlignment(Pos.CENTER);

    gp = new Group();
    gp.getChildren().add(vbox1);
    gp.getChildren().add(vbox2);
    

    scene = new Scene(gp, 900, 600);
    primaryStage.setTitle("A Simple Scene!");
    primaryStage.setScene(scene);
    primaryStage.show();
    primaryStage.setFullScreen(true);
  }
  public static void Prologue(Stage primaryStage) {

  MovementController movementController = new MovementController();
  Main Main = new Main();

  Image img;
  ImageView view;
  Scene prologueScene;

  MenuPage MenuPage = new MenuPage();

  AnchorPane prologuePane = new AnchorPane();

    img = new Image("Assets/sprite.jpg");
    view = new ImageView(img);
    view.setPreserveRatio(true);
    view.setFitHeight(100);
    view.setFitWidth(100);

    prologuePane.getChildren().add(view);
    prologueScene = new Scene(prologuePane);
    prologueScene.getRoot().requestFocus();
    movementController.makeMovable(view, prologuePane);
    primaryStage.setScene(prologueScene);
    primaryStage.show();
    primaryStage.setFullScreen(true);
}
}