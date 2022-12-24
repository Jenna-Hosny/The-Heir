import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.scene.image.*;

  public class Main extends Application {
    static Scenes Scenes = new Scenes();
    
    public void start(Stage primaryStage) throws Exception {
      Scenes.menu(primaryStage);
    }
      public static void main(String[] args) {
        launch(args);
    } 
}