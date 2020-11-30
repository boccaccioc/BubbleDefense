package ooga.view.animation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class ExplosionSprite {

  private static final String SPRITE_PATH = "data/sprites/explosion/torpedoCollision.png";
  private static final int ANIMATION_DURATION = 1000; //2500
  private static final int COLUMNS = 9; // 9 x 9
  private static final int COUNT = 24;
  private static final int OFFSET_X = 128; //18
  private static final int OFFSET_Y = 24; //25
  private static final int WIDTH = 132;
  private static final int HEIGHT = 136;

  private Image image;

  public ExplosionSprite() {
    try {
      image = new Image(new FileInputStream(SPRITE_PATH));
    } catch (FileNotFoundException e) {
      image = null;
    }
  }

  public ImageView getSprite() {
    ImageView imageView = new ImageView(image);
    imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

    Animation animation = new SpriteAnimation(imageView, Duration.millis(ANIMATION_DURATION), COUNT,
        COLUMNS, OFFSET_X, OFFSET_Y, WIDTH, HEIGHT);

    animation.setCycleCount(Animation.INDEFINITE);
    animation.play();

    return imageView;
  }
}
