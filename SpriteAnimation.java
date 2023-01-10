import javafx.animation.*;
import javafx.scene.image.*;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class SpriteAnimation {

  SpriteSheetProcessor Sheet = new SpriteSheetProcessor();

  Timeline playerUpAnimation;
  Timeline playerLeftAnimation;
  Timeline playerDownAnimation;
  Timeline playerRightAnimation;

  boolean isPlayerMovingUp;
  boolean isPlayerMovingLeft;
  boolean isPlayerMovingDown;
  boolean isPlayerMovingRight;

  Image Up1, Up2, Up3, Up4, Up5, Up6, Up7, Up8, Up9;
  Image Left1, Left2, Left3, Left4, Left5, Left6, Left7, Left8, Left9;
  Image Down1, Down2, Down3, Down4, Down5, Down6, Down7, Down8, Down9;
  Image Right1, Right2, Right3, Right4, Right5, Right6, Right7, Right8, Right9;

  private boolean lastAnimationWasUp = false;
  private boolean lastAnimationWasLeft = false;
  private boolean lastAnimationWasDown = false;
  private boolean lastAnimationWasRight = false;


  public void animatePlayer(ImageView playerImageView, double playerVelocityX, double playerVelocityY) {

    playerUpAnimation(playerImageView);
    playerLeftAnimation(playerImageView);
    playerDownAnimation(playerImageView);
    playerRightAnimation(playerImageView);
    
    /*if (playerVelocityY == 5) {
        isPlayerMovingDown = true;
    } else {
        isPlayerMovingDown = false;
    }

    if (playerVelocityY == -5) {
        isPlayerMovingUp = true;
    } else {
        isPlayerMovingUp = false;
    }

    if (playerVelocityX == 5) {
        isPlayerMovingRight = true;
    } else {
        isPlayerMovingRight = false;
    }

    if (playerVelocityX == -5) {
        isPlayerMovingLeft = true;
    } else {
        isPlayerMovingLeft = false;
    } */

    
    if (isPlayerMovingDown) {
        playerDownAnimation.play();
        lastAnimationWasDown = true;
        lastAnimationWasUp = false;
        lastAnimationWasLeft = false;
        lastAnimationWasRight = false;
    } else {
        playerDownAnimation.stop();
        if (lastAnimationWasDown) {
            playerImageView.setImage(Down1);
            lastAnimationWasDown = false;
        }
      }

    if (isPlayerMovingUp) {
        playerUpAnimation.play();
        lastAnimationWasUp = true;
        lastAnimationWasDown = false;
        lastAnimationWasLeft = false;
        lastAnimationWasRight = false;
    } else {
        playerUpAnimation.stop();
        if (lastAnimationWasUp) {
            playerImageView.setImage(Up1);
            lastAnimationWasUp = false;
        }
      }

    if (isPlayerMovingRight) {
        playerRightAnimation.play();
        lastAnimationWasRight = true;
        lastAnimationWasUp = false;
        lastAnimationWasDown = false;
        lastAnimationWasLeft = false;
    } else {
        playerLeftAnimation.stop();
        if (lastAnimationWasRight) {
            playerImageView.setImage(Left1);
            lastAnimationWasRight = false;
        }
      }

      if (isPlayerMovingLeft) {
          playerLeftAnimation.play();
          lastAnimationWasLeft = true;
          lastAnimationWasUp = false;
          lastAnimationWasDown = false;
          lastAnimationWasRight = false;
      } else {
          playerLeftAnimation.stop();
          if (lastAnimationWasLeft) {
              playerImageView.setImage(Left1);
              lastAnimationWasLeft = false;
          }
      }
  }

  public void updateAnimation(double velX, double velY) {
    
    if (velY == 0 && playerUpAnimation != null && playerDownAnimation != null) {
        playerUpAnimation.stop();
        playerDownAnimation.stop();
    }

    if (velY == 0 && playerLeftAnimation != null && playerRightAnimation != null) {
        playerLeftAnimation.stop();
        playerRightAnimation.stop();
    }
  }
  

  public void playerUpAnimation(ImageView playerImageView) {

    Image spriteSheet = new Image("Assets/MainCharacterAnim/SpriteSheet.png");

    List<Image> walkingSprites = Sheet.processSpriteSheet(spriteSheet);
    
      
      // Load the images to be used in the animation
      Up1 = new Image("Assets/MainCharacterAnim/UP/Up1.png");
      Up2 = new Image("Assets/MainCharacterAnim/UP/Up2.png");
      Up3 = new Image("Assets/MainCharacterAnim/UP/Up3.png");
      Up4 = new Image("Assets/MainCharacterAnim/UP/Up4.png");
      Up5 = new Image("Assets/MainCharacterAnim/UP/Up5.png");
      Up6 = new Image("Assets/MainCharacterAnim/UP/Up6.png");
      Up7 = new Image("Assets/MainCharacterAnim/UP/Up7.png");
      Up8 = new Image("Assets/MainCharacterAnim/UP/Up8.png");
      Up9 = new Image("Assets/MainCharacterAnim/UP/Up9.png");

      // Create a Timeline to switch through the images at regular intervals
      playerUpAnimation = new Timeline(
      new KeyFrame(Duration.millis(111), e -> playerImageView.setImage(Up2)),
      new KeyFrame(Duration.millis(222), e -> playerImageView.setImage(Up3)),
      new KeyFrame(Duration.millis(333), e -> playerImageView.setImage(Up4)),
      new KeyFrame(Duration.millis(444), e -> playerImageView.setImage(Up5)),
      new KeyFrame(Duration.millis(555), e -> playerImageView.setImage(Up6)),
      new KeyFrame(Duration.millis(666), e -> playerImageView.setImage(Up7)),
      new KeyFrame(Duration.millis(777), e -> playerImageView.setImage(Up8)),
      new KeyFrame(Duration.millis(888), e -> playerImageView.setImage(Up9))
      );
      playerUpAnimation.setCycleCount(Animation.INDEFINITE);

      // Create a boolean flag to track whether the animation is currently playing
        isPlayerMovingUp = false;
  }

  public void playerLeftAnimation(ImageView playerImageView) {

    Image spriteSheet = new Image("Assets/MainCharacterAnim/SpriteSheet.png");

    List<Image> walkingSprites = Sheet.processSpriteSheet(spriteSheet);
    
      // Load the images to be used in the animation
      Left1 = new Image("Assets/MainCharacterAnim/LEFT/Left1.png");
      Left2 = new Image("Assets/MainCharacterAnim/LEFT/Left2.png");
      Left3 = new Image("Assets/MainCharacterAnim/LEFT/Left3.png");
      Left4 = new Image("Assets/MainCharacterAnim/LEFT/Left4.png");
      Left5 = new Image("Assets/MainCharacterAnim/LEFT/Left5.png");
      Left6 = new Image("Assets/MainCharacterAnim/LEFT/Left6.png");
      Left7 = new Image("Assets/MainCharacterAnim/LEFT/Left7.png");
      Left8 = new Image("Assets/MainCharacterAnim/LEFT/Left8.png");
      Left9 = new Image("Assets/MainCharacterAnim/LEFT/Left9.png");


      // Create a Timeline to switch through the images at regular intervals
      playerLeftAnimation = new Timeline(
      new KeyFrame(Duration.millis(111), e -> playerImageView.setImage(Left2)),
      new KeyFrame(Duration.millis(222), e -> playerImageView.setImage(Left3)),
      new KeyFrame(Duration.millis(333), e -> playerImageView.setImage(Left4)),
      new KeyFrame(Duration.millis(444), e -> playerImageView.setImage(Left5)),
      new KeyFrame(Duration.millis(555), e -> playerImageView.setImage(Left6)),
      new KeyFrame(Duration.millis(666), e -> playerImageView.setImage(Left7)),
      new KeyFrame(Duration.millis(777), e -> playerImageView.setImage(Left8)),
      new KeyFrame(Duration.millis(888), e -> playerImageView.setImage(Left9))
      );
      playerLeftAnimation.setCycleCount(Animation.INDEFINITE);

      // Create a boolean flag to track whether the animation is currently playing
        isPlayerMovingLeft = false;
    
  }

  public void playerDownAnimation(ImageView playerImageView) {

    Image spriteSheet = new Image("Assets/MainCharacterAnim/SpriteSheet.png");

    List<Image> walkingSprites = Sheet.processSpriteSheet(spriteSheet);
      
      // Load the images to be used in the animation
      Down1 = new Image("Assets/MainCharacterAnim/DOWN/Down1.png");
      Down2 = new Image("Assets/MainCharacterAnim/DOWN/Down2.png");
      Down3 = new Image("Assets/MainCharacterAnim/DOWN/Down3.png");
      Down4 = new Image("Assets/MainCharacterAnim/DOWN/Down4.png");
      Down5 = new Image("Assets/MainCharacterAnim/DOWN/Down5.png");
      Down6 = new Image("Assets/MainCharacterAnim/DOWN/Down6.png");
      Down7 = new Image("Assets/MainCharacterAnim/DOWN/Down7.png");
      Down8 = new Image("Assets/MainCharacterAnim/DOWN/Down8.png");
      Down9 = new Image("Assets/MainCharacterAnim/DOWN/Down9.png");


      // Create a Timeline to switch through the images at regular intervals
      playerDownAnimation = new Timeline(
      new KeyFrame(Duration.millis(111), e -> playerImageView.setImage(Down2)),
      new KeyFrame(Duration.millis(222), e -> playerImageView.setImage(Down3)),
      new KeyFrame(Duration.millis(333), e -> playerImageView.setImage(Down4)),
      new KeyFrame(Duration.millis(444), e -> playerImageView.setImage(Down5)),
      new KeyFrame(Duration.millis(555), e -> playerImageView.setImage(Down6)),
      new KeyFrame(Duration.millis(666), e -> playerImageView.setImage(Down7)),
      new KeyFrame(Duration.millis(777), e -> playerImageView.setImage(Down8)),
      new KeyFrame(Duration.millis(888), e -> playerImageView.setImage(Down9))
      );
      playerDownAnimation.setCycleCount(Animation.INDEFINITE);

      // Create a boolean flag to track whether the animation is currently playing
        isPlayerMovingDown = false;
    
  }

  public void playerRightAnimation(ImageView playerImageView) {

    Image spriteSheet = new Image("Assets/MainCharacterAnim/SpriteSheet.png");

    List<Image> walkingSprites = Sheet.processSpriteSheet(spriteSheet);
      
      // Load the images to be used in the animation
      Right1 = new Image("Assets/MainCharacterAnim/RIGHT/Right1.png");
      Right2 = new Image("Assets/MainCharacterAnim/RIGHT/Right2.png");
      Right3 = new Image("Assets/MainCharacterAnim/RIGHT/Right3.png");
      Right4 = new Image("Assets/MainCharacterAnim/RIGHT/Right4.png");
      Right5 = new Image("Assets/MainCharacterAnim/RIGHT/Right5.png");
      Right6 = new Image("Assets/MainCharacterAnim/RIGHT/Right6.png");
      Right7 = new Image("Assets/MainCharacterAnim/RIGHT/Right7.png");
      Right8 = new Image("Assets/MainCharacterAnim/RIGHT/Right8.png");
      Right9 = new Image("Assets/MainCharacterAnim/RIGHT/Right9.png");


      // Create a Timeline to switch through the images at regular intervals
      playerRightAnimation = new Timeline(
      new KeyFrame(Duration.millis(111), e -> playerImageView.setImage(Right2)),
      new KeyFrame(Duration.millis(222), e -> playerImageView.setImage(Right3)),
      new KeyFrame(Duration.millis(333), e -> playerImageView.setImage(Right4)),
      new KeyFrame(Duration.millis(444), e -> playerImageView.setImage(Right5)),
      new KeyFrame(Duration.millis(555), e -> playerImageView.setImage(Right6)),
      new KeyFrame(Duration.millis(666), e -> playerImageView.setImage(Right7)),
      new KeyFrame(Duration.millis(777), e -> playerImageView.setImage(Right8)),
      new KeyFrame(Duration.millis(888), e -> playerImageView.setImage(Right9))
      );
      playerRightAnimation.setCycleCount(Animation.INDEFINITE);

      // Create a boolean flag to track whether the animation is currently playing
        isPlayerMovingRight = false;
    
  }
}