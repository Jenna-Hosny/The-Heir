import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.scene.shape.Shape;

public class CollisionDetection {
  
    public boolean isColliding(ImageView imageView, AnchorPane anchorPane) {
    for (Node node : anchorPane.getChildren()) {
        if (node != imageView && node.getBoundsInParent().intersects(imageView.getBoundsInParent())) {
            return true;
        }
    }
    return false;
  }
  
    public static String getCollisionDirection(ImageView imageView, AnchorPane anchorpane) {
        String collisionDirections = new String();
        // Get the bounds of the image view
        Bounds imageViewBounds = imageView.getBoundsInParent();

        // Check for collisions with each shape in the anchor pane
        for (Node node : anchorpane.getChildren()) {
            if (node instanceof Shape) {
                Shape shape = (Shape) node;
                if (shape.getBoundsInParent().intersects(imageViewBounds)) {
                    // Collision detected! Now we need to determine the direction of the collision.
                    // We can do this by getting the center point of the image view and the shape, and comparing their positions.
                    double imageViewTop = imageViewBounds.getMinY();
                    double imageViewBottom = imageViewBounds.getMaxY();
                    double imageViewLeft = imageViewBounds.getMinX();
                    double imageViewRight = imageViewBounds.getMaxX();
                    double shapeTop = shape.getBoundsInParent().getMinY();
                    double shapeBottom = shape.getBoundsInParent().getMaxY();
                    double shapeLeft = shape.getBoundsInParent().getMinX();
                    double shapeRight = shape.getBoundsInParent().getMaxX();

                    if (imageViewTop == shapeBottom) {
                        // Collision from above
                        collisionDirections = "above";
                    }if (imageViewBottom == shapeTop) {
                        // Collision from below
                        collisionDirections = "below";
                    }if (imageViewRight == shapeLeft) {
                        // Collision from the right
                        collisionDirections = "right";
                    }if (imageViewLeft == shapeRight) {
                        // Collision from the left
                        collisionDirections = "left";
                  }
                }
            }
    }
        return collisionDirections;
}
  
}