import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.util.Duration;

public class GameLoop {

    PlayerMovement PlayerMovement = new PlayerMovement();
    Scenes Scenes = new Scenes();
    InventorySystem InventorySystem = new InventorySystem();

    private double playerX = 0;
    private double playerY = 0;

    boolean isPlayerMovingDown;
    boolean isPlayerMovingUp;
    boolean isPlayerMovingRight;
    boolean isPlayerMovingLeft;

    SpriteAnimation Animation = new SpriteAnimation();

    private boolean isPlayerMoving = false;
    
    public void switchScene(ImageView player, Rectangle solidArea, AnchorPane currentPane, Scene scene) {
        // Create player and game pane
        InventorySystem.createInventory(currentPane);
        PlayerMovement.inputSetup(player, currentPane);
        InventorySystem.inputSetup(currentPane);

        // Set up the game loop
        new AnimationTimer() {
          @Override
          public void handle(long now) {
            // Update player velocity based on user input
            PlayerMovement.playerVelocityX = 0;
            PlayerMovement.playerVelocityY = 0;
            PlayerMovement.updatePlayerVelocity(player, solidArea, currentPane);

            //Animation.updateAnimation(player, PlayerMovement.playerVelocityX, PlayerMovement.playerVelocityY);

            // Update player position based on velocity
            playerX += PlayerMovement.playerVelocityX;
            playerY += PlayerMovement.playerVelocityY;
            player.setTranslateX(playerX);
            player.setTranslateY(playerY);
            solidArea.setTranslateX(playerX);
            solidArea.setTranslateY(playerY);

            /*if (!isPlayerMoving) {
              Animation.animatePlayer(player, PlayerMovement.playerVelocityX, PlayerMovement.playerVelocityY);
              isPlayerMoving = true;
            }*/
          }
        }.start();
    }
}