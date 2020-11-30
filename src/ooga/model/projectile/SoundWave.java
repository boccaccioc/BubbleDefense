package ooga.model.projectile;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import ooga.model.enemy.Enemy;

public class SoundWave extends Projectile {
  /** Creates a soundwave projectile
   * @param startX x position this projectile is being created
   * @param startY y position this projectile is being created
   * @param xDirection x direction this projectile will move in
   * @param yDirection y direction this projectile will move in
   * @param speed that this projectile will move at
   */
  public SoundWave(double startX, double startY, double xDirection, double yDirection, double speed) {
    super(startX, startY, xDirection, yDirection, speed);
    damage = 1;
    radius = 1;
    speed = 1;
    myID = "SoundWaveProjectile";
    sceneImg = new Circle(x, y, radius);
    sceneImg.setId(myID);
    sceneImg.setFill(Color.TRANSPARENT);
    sceneImg.setStroke(Color.YELLOWGREEN);
    sceneImg.setStrokeWidth(5);
  }

  @Override
  public void move() {
    radius += 0.0035 * speed;
    moveImage();
  }

  @Override
  protected void moveImage() {
    sceneImg = new Circle(x, y, radius);
    sceneImg.setId(myID);
    sceneImg.setFill(Color.TRANSPARENT);
    sceneImg.setStroke(Color.YELLOWGREEN);
    sceneImg.setStrokeWidth(5);
  }

  @Override
  protected void checkOutOfBounds() {
    if(radius >= MAX_X/2) {
      destroy();
    }
  }

  @Override
  public boolean didCollideWith(Enemy enemy) {
    double x1 = x;
    double y1 = y;
    double x2 = enemy.getXPos();
    double y2 = enemy.getYPos();
    return enemy.getRadius() + radius > Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
  }
}
