import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.animation.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import javafx.scene.shape.*;
import javafx.scene.input.*;

public class MovementController {

    private BooleanProperty wPressed = new SimpleBooleanProperty();
    private BooleanProperty aPressed = new SimpleBooleanProperty();
    private BooleanProperty sPressed = new SimpleBooleanProperty();
    private BooleanProperty dPressed = new SimpleBooleanProperty();

    private BooleanBinding keyPressed = wPressed.or(aPressed).or(sPressed).or(dPressed);

    private int movementVariable = 3;

    private ImageView sprite;

    private AnchorPane scene;

    public void makeMovable(ImageView sprite, AnchorPane scene){
      this.sprite = sprite;
      this.scene = scene;

      movementSetup();

      keyPressed.addListener(((observableValue, aBoolean, t1) -> {
        if(!aBoolean){
          timer.start();
        } else {
          timer.stop();
        }
      }));
    }

    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long timestamp) {
        if(wPressed.get()) {
          if(sprite.getLayoutY() > 0) {
            sprite.setLayoutY(sprite.getLayoutY() - movementVariable);
          }
        }

        if(sPressed.get()){
          if(sprite.getLayoutY() < scene.getHeight()) {
            sprite.setLayoutY(sprite.getLayoutY() + movementVariable);
            System.out.println(scene.getHeight());
          }
        }

        if(aPressed.get()){
          if(sprite.getLayoutX() > 0) {
            sprite.setLayoutX(sprite.getLayoutX() - movementVariable);
            System.out.println(scene.getWidth());
          }
        }

        if(dPressed.get()){
          if(sprite.getLayoutX() < scene.getWidth()){
            sprite.setLayoutX(sprite.getLayoutX() + movementVariable);
          }
        }
      }
    };

    private void movementSetup(){
      scene.setOnKeyPressed(e -> {
        if(e.getCode() == KeyCode.W) {
            wPressed.set(true);
        }

        if(e.getCode() == KeyCode.A) {
            aPressed.set(true);
        }

        if(e.getCode() == KeyCode.S) {
            sPressed.set(true);
        }

        if(e.getCode() == KeyCode.D) {
            dPressed.set(true);
        }
    });

      scene.setOnKeyReleased(e ->{
        if(e.getCode() == KeyCode.W) {
             wPressed.set(false);
        }

        if(e.getCode() == KeyCode.A) {
              aPressed.set(false);
        }

        if(e.getCode() == KeyCode.S) {
              sPressed.set(false);
        }

        if(e.getCode() == KeyCode.D) {
              dPressed.set(false);
        }
    });
  }
}