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
    SpriteAnimation SpriteAnimation = new SpriteAnimation();
    Scenes Scenes = new Scenes();

    private boolean wPressed = false;
    private boolean aPressed = false;
    private boolean sPressed = false;
    private boolean dPressed = false;

    public double playerVelocityY;
    public double playerVelocityX;

    boolean lastAnimationWasDown = false;
    boolean lastAnimationWasUp = false;
    boolean lastAnimationWasLeft = false;
    boolean lastAnimationWasRight = false;

    double previousTime = System.nanoTime();
  
  public void updatePlayerVelocity(ImageView player, Rectangle solidArea, AnchorPane gamePane) {

    double elapsedTime = 0;
    long now = System.nanoTime();

    elapsedTime = (now - previousTime) / 1_000_000_000.0;
    previousTime = now;
    
    String collisionDirection = CollisionDetection.getCollisionDirection(solidArea, gamePane);

    boolean canMoveUp = !collisionDirection.contains("above");
    boolean canMoveDown = !collisionDirection.contains("below");
    boolean canMoveLeft = !collisionDirection.contains("left");
    boolean canMoveRight = !collisionDirection.contains("right");
    
    if(CollisionDetection.isColliding(solidArea, gamePane)){
      playerVelocityY = 0;
      playerVelocityX = 0;
      if (wPressed && canMoveUp) {
          playerVelocityY = -80 * elapsedTime;
          SpriteAnimation.playerUpAnimation.play();
          lastAnimationWasDown = false;
          lastAnimationWasUp = true;
          lastAnimationWasLeft = false;
          lastAnimationWasRight = false;
      } else if (sPressed && canMoveDown) {
          playerVelocityY = 80 * elapsedTime;
          SpriteAnimation.playerDownAnimation.play();
          lastAnimationWasDown = true;
          lastAnimationWasUp = false;
          lastAnimationWasLeft = false;
          lastAnimationWasRight = false;
      } else if (aPressed && canMoveLeft) {
          playerVelocityX = -80 * elapsedTime;
          SpriteAnimation.playerLeftAnimation.play();
          lastAnimationWasDown = false;
          lastAnimationWasUp = false;
          lastAnimationWasLeft = true;
          lastAnimationWasRight = false;
      } else if (dPressed && canMoveRight) {
          playerVelocityX = 80 * elapsedTime;
          SpriteAnimation.playerRightAnimation.play();
          lastAnimationWasDown = false;
          lastAnimationWasUp = false;
          lastAnimationWasLeft = false;
          lastAnimationWasRight = true;
      }
    } else {
               
      if (wPressed) {
          playerVelocityY = -80 * elapsedTime;
          SpriteAnimation.playerUpAnimation.play();
          lastAnimationWasDown = false;
          lastAnimationWasUp = true;
          lastAnimationWasLeft = false;
          lastAnimationWasRight = false;
      } else if (aPressed) {
          playerVelocityX = -80 * elapsedTime;
          SpriteAnimation.playerLeftAnimation.play();
          lastAnimationWasDown = false;
          lastAnimationWasUp = false;
          lastAnimationWasLeft = true;
          lastAnimationWasRight = false;
      } else if (sPressed) {
          playerVelocityY = 80 * elapsedTime;
          SpriteAnimation.playerDownAnimation.play();
          lastAnimationWasDown = true;
          lastAnimationWasUp = false;
          lastAnimationWasLeft = false;
          lastAnimationWasRight = false;
      } else if (dPressed) {
          playerVelocityX = 80 * elapsedTime;
          SpriteAnimation.playerRightAnimation.play();
          lastAnimationWasDown = false;
          lastAnimationWasUp = false;
          lastAnimationWasLeft = false;
          lastAnimationWasRight = true;
      }
    }
  }

  public void inputSetup(ImageView playerImageView, AnchorPane scene) {
      SpriteAnimation.playerUpAnimation(playerImageView);
      SpriteAnimation.playerLeftAnimation(playerImageView);
      SpriteAnimation.playerDownAnimation(playerImageView);
      SpriteAnimation.playerRightAnimation(playerImageView);
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
              SpriteAnimation.playerUpAnimation.stop();
              if (lastAnimationWasUp) {
                  playerImageView.setImage(SpriteAnimation.Up1);
                  lastAnimationWasUp = false;
              }
              wPressed = false;
              break;
        case A:
              SpriteAnimation.playerLeftAnimation.stop();
              if (lastAnimationWasLeft) {
                  playerImageView.setImage(SpriteAnimation.Left1);
                  lastAnimationWasLeft = false;
              }
              aPressed = false;
              break;
        case S:
              SpriteAnimation.playerDownAnimation.stop();
              if (lastAnimationWasDown) {
                  playerImageView.setImage(SpriteAnimation.Down1);
                  lastAnimationWasDown = false;
              }
              sPressed = false;
              break;
        case D:
              SpriteAnimation.playerRightAnimation.stop();
              if (lastAnimationWasRight) {
                  playerImageView.setImage(SpriteAnimation.Right1);
                  lastAnimationWasRight = false;
              }
              dPressed = false;
              break;
        }
    });
  }
}