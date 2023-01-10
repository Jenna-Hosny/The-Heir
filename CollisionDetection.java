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
import javafx.collections.FXCollections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollisionDetection {
  
    public static boolean isColliding(Rectangle solidArea, AnchorPane anchorpane) {
      
        boolean isColliding = false;

        // get the bounds of the image view
        Bounds imageBounds = solidArea.getBoundsInParent();

        // get all nodes in the anchor pane with "collision" in their name
        List<Node> collisionNodes = anchorpane.getChildren().stream()
    .filter(node -> node.getId() != null && node.getId().contains("collision"))
    .collect(Collectors.toList());

        // check if any of the collision nodes are intersecting with the image view
        for (Node node : collisionNodes) {
            if (node instanceof Shape) {
                Shape shape = (Shape) node;
                isColliding = shape.getBoundsInParent().intersects(imageBounds);
              
                double imageViewTop = imageBounds.getMinY();
                double imageViewBottom = imageBounds.getMaxY();
                double imageViewLeft = imageBounds.getMinX();
                double imageViewRight = imageBounds.getMaxX();
                double shapeTop = shape.getBoundsInParent().getMinY();
                double shapeBottom = shape.getBoundsInParent().getMaxY();
                double shapeLeft = shape.getBoundsInParent().getMinX();
                double shapeRight = shape.getBoundsInParent().getMaxX();

                //System.out.println(imageViewTop);
                //System.out.println(imageViewBottom);
                //System.out.println(imageViewLeft);
                //System.out.println(imageViewRight);
                //System.out.println(shapeTop);
                //System.out.println(shapeBottom);
                //System.out.println(shapeLeft);
                //System.out.println(shapeRight);
            }
            if (isColliding) {
                break;
            }
        }

        return isColliding;
    }
  
    public static String getCollisionDirection(Rectangle solidArea, AnchorPane anchorpane) {
        String collisionDirections = new String();
        // Get the bounds of the image view
        Bounds imageViewBounds = solidArea.getBoundsInParent();

      List<Node> collisionNodes = anchorpane.getChildren().stream().filter(node -> node.getId() != null && node.getId().contains("collision")).collect(Collectors.toList());

        // Check for collisions with each shape in the anchor pane
        for (Node node : collisionNodes) {
            if (node instanceof Shape) {
                Shape shape = (Shape) node;
                  //System.out.println("Collision test");
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

                    if (imageViewTop <= shapeBottom && imageViewTop > shapeBottom - 5) {
                        // Collision from above
                        collisionDirections = "above";
                        //System.out.println("Above");
                    }if (imageViewBottom >= shapeTop && imageViewBottom < shapeTop + 5) {
                        // Collision from below
                        collisionDirections = "below";
                        //System.out.println("Below");
                    }if (imageViewRight >= shapeLeft && imageViewRight < shapeLeft + 5) {
                        // Collision from the right
                        collisionDirections = "right";
                        //System.out.println("Right");
                    }if (imageViewLeft <= shapeRight && imageViewLeft > shapeRight - 5) {
                        // Collision from the left
                        collisionDirections = "left";
                        //System.out.println("Left");
                  }
            }
    }
        return collisionDirections;
}
  
}