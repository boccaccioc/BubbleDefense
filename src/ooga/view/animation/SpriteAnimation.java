package ooga.view.animation;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation extends Transition {

  private ImageView imageView;
  private int count;
  private int columns;
  private int offsetX;
  private int offsetY;
  private int width;
  private int height;
  private int lastIndex;

  public SpriteAnimation(ImageView imageView, Duration duration, int count, int columns,
      int offsetX, int offsetY, int width, int height) {
    this.imageView = imageView;
    this.count = count;
    this.columns = columns;
    this.offsetX = offsetX;
    this.offsetY = offsetY;
    this.width = width;
    this.height = height;
    setCycleDuration(duration);
    setInterpolator(Interpolator.LINEAR);
  }

  protected void interpolate(double i) {
    final int index = Math.min((int) Math.floor(i * count), count - 1);
    if (index != lastIndex) {
      int x = (index % columns) * width + offsetX;
      int y = (index / columns) * height + offsetY;
      imageView.setViewport(new Rectangle2D(x, y, width, height));
      lastIndex = index;
    }
  }
}
