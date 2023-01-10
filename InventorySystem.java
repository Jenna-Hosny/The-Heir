import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.input.*;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import gameItems.*;
import javafx.scene.paint.Color;

public class InventorySystem {

  Pane inventoryPane;
  Rectangle dimmingScreen;

  public void inputSetup(AnchorPane scene) {
    scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
        switch (event.getCode()) {
        case I:
            if (inventoryPane.isVisible()) {
                inventoryPane.setVisible(false);
                dimmingScreen.setVisible(false);
            } else {
                inventoryPane.setVisible(true);
                dimmingScreen.setVisible(true);
            }
        }
    });
  }
  
  public void createInventory(AnchorPane scene) {
    inventoryPane = new Pane();
    //inventoryPane.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-background-radius: 10;");

    /*inventoryPane.setMinWidth(119);
    inventoryPane.setMaxWidth(119);
    inventoryPane.setMinHeight(171);
    inventoryPane.setMaxHeight(171);*/
    //inventoryPane.setLayoutX(150);
    //inventoryPane.setLayoutY(600);

    inventoryPane.setLayoutX(462.5);
    inventoryPane.setLayoutY(80);

    dimmingScreen = new Rectangle(0, 0, 1375, 695);
    dimmingScreen.setFill(Color.BLACK);
    dimmingScreen.setOpacity(0.8);


    scene.getChildren().addAll(dimmingScreen, inventoryPane);

    Image img = new Image("basicInventory.png");
    ImageView invBack = new ImageView(img);
    invBack.setPreserveRatio(true);
    invBack.setFitWidth(450);
    inventoryPane.getChildren().add(invBack);
    
  }
  
}