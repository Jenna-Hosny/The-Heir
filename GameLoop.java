import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.image.*;

public class GameLoop {

    PlayerMovement PlayerMovement = new PlayerMovement();
    Scenes Scenes = new Scenes();

    private double playerX = 0;
    private double playerY = 0;
    //public double playerVelocityX;
    //public double playerVelocityY;
  
    public void switchScene(ImageView player, AnchorPane currentPane, Scene scene) {
        // Create player and game pane
        PlayerMovement.inputSetup(currentPane);

        // Set up the game loop
        new AnimationTimer() {
          @Override
          public void handle(long now) {
            // Update player velocity based on user input
            PlayerMovement.playerVelocityX = 0;
            PlayerMovement.playerVelocityY = 0;
            PlayerMovement.updatePlayerVelocity(player, currentPane);

            // Update player position based on velocity
            playerX += PlayerMovement.playerVelocityX;
            playerY += PlayerMovement.playerVelocityY;
            player.setTranslateX(playerX);
            player.setTranslateY(playerY);
          }
        }.start();
    }
}