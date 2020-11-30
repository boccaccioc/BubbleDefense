package ooga.model.projectile;

import java.awt.geom.Point2D;
import javafx.scene.Node;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import ooga.model.Model;
import ooga.model.enemy.Enemy;

public abstract class Projectile implements ProjectileInterface {

  public static final int MAX_X = 850;
  public static final int MAX_Y = 850;

  protected int width = 10;
  protected int height = 10;

  protected double radius = 10;
  protected Point2D directionVector; //unit vector
  double xInitial;
  double yInitial;
  double x;
  double y;
  double speed;
  int damage = 1;
  private boolean shouldBeDestroyed;
  protected String myID;
  protected Shape sceneImg;

  /**Creates a base projectile
   * @param startX x position this projectile is being created
   * @param startY y position this projectile is being created
   * @param xDirection x direction this projectile will move in
   * @param yDirection y direction this projectile will move in
   * @param speed that this projectile will move at
   */
  public Projectile(double startX, double startY, double xDirection, double yDirection,
      double speed) {
    xInitial = startX;
    yInitial = startY;
    x = startX;
    y = startY;
    this.speed = speed;
    directionVector = new Point2D.Double(xDirection, yDirection);
    shouldBeDestroyed = false;
    //sceneImg = new Circle(x, y, radius);
    sceneImg = new Polygon();
  }

  public String getID(){
    return myID;
  }

  public int getDamage(){
    return damage;
  }

  public double getCurrentX() {
    return x;
  }

  public double getCurrentY() {
    return y;
  }

  public double getSpeed() {
    return speed;
  }

  public Shape getSceneImg() { return sceneImg; }

  public Node getCollisionImg() {
    return null;
  }

  public void update(Model model) {
    move();
    checkBubbleCollisions(model);
    checkOutOfBounds();
  }

  public void move() {
    x += 0.025 * speed * directionVector.getX();
    y += -0.025 * speed * directionVector.getY();
    moveImage();
  }

  protected void moveImage() {
    sceneImg = new Polygon();
    if(directionVector.getX() == 0) {
      sceneImg = new Polygon(x, y - directionVector.getY()*height,
          x + width, y,
          x - width,y);
    } else if(directionVector.getY() == 0) {
      sceneImg = new Polygon(x + directionVector.getX()*height, y,
          x, y - width,
          x, y + width);
    } else {
      sceneImg = new Polygon(x + directionVector.getX()*height, y + directionVector.getY()*height,
          x + directionVector.getX()*width, y - directionVector.getY()*width,
          x - directionVector.getX()*width, y - directionVector.getY()*width);
    }
    sceneImg.setId(myID);
  }

  protected void checkOutOfBounds() {
    if(x > MAX_X || x < 0 || y > MAX_Y || y < 0) {
      destroy();
    }
  }

  public boolean didCollideWith(Enemy enemy) {
    return withinRange(enemy, x, y, radius);
  }

  protected boolean withinRange(Enemy enemy, double x1, double y1, double radius) {
    double x2 = enemy.getXPos();
    double y2 = enemy.getYPos();
    return enemy.getRadius() + radius > Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
  }

  protected void checkBubbleCollisions(Model model) {
    for(Enemy enemy : model.getEnemies()) {
      if(didCollideWith(enemy)) {
        collidedWith(enemy, model);
        //break;
      }
    }
  }

  protected void collidedWith(Enemy enemy, Model model) {
    enemy.enemyCollision(this, model);
    destroy();
  }

  protected void destroy() {
    shouldBeDestroyed = true;
  }

  public boolean shouldBeDestroyed() {
    return shouldBeDestroyed;
  }
}