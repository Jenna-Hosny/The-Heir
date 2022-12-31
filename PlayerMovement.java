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

public class PlayerMovement {

    CollisionDetection CollisionDetection = new CollisionDetection();

    private boolean wPressed = false;
    private boolean aPressed = false;
    private boolean sPressed = false;
    private boolean dPressed = false;

    public double playerVelocityY;
    public double playerVelocityX;

  public void updatePlayerVelocity(ImageView player, AnchorPane gamePane) {
    
    String collisionDirection = CollisionDetection.getCollisionDirection(player, gamePane);

    boolean canMoveUp = !collisionDirection.contains("above");
    boolean canMoveDown = !collisionDirection.contains("below");
    boolean canMoveLeft = !collisionDirection.contains("left");
    boolean canMoveRight = !collisionDirection.contains("right");
    
    if(CollisionDetection.isColliding(player, gamePane)){
      if (wPressed && canMoveUp) {
          playerVelocityY = -5;
      } else if (sPressed && canMoveDown) {
          playerVelocityY = 5;
      } else if (aPressed && canMoveLeft) {
          playerVelocityX = -5;
      } else if (dPressed && canMoveRight) {
          playerVelocityX = 5;
      }
    } else {
               
      if (wPressed) {
          playerVelocityY = -5;
      } else if (aPressed) {
            playerVelocityX = -5;
      } else if (sPressed) {
            playerVelocityY = 5;
      } else if (dPressed) {
            playerVelocityX = 5;
      }
    }
  }

  public void inputSetup(AnchorPane scene) {
      scene.requestFocus();
      scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
        switch (event.getCode()) {
        case W:
              wPressed = true;
              break;
        case A:
              aPressed = true;
              break;
        case S:
              sPressed = true;
              break;
        case D:
              dPressed = true;
              break;
        }
    });
      scene.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
        switch (event.getCode()) {
        case W:
              wPressed = false;
              break;
        case A:
              aPressed = false;
              break;
        case S:
              sPressed = false;
              break;
        case D:
              dPressed = false;
              break;
        }
    });
  }

  private boolean isKeyPressed(KeyCode key) {
    if (key == KeyCode.W) {
          return wPressed;
    } if (key == KeyCode.A) {
          return aPressed;
    } if (key == KeyCode.S) {
          return sPressed;
    } if (key == KeyCode.D) {
          return dPressed;
    }  return false;
  }
  
}