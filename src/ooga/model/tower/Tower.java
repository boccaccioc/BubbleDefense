package ooga.model.tower;

import java.awt.geom.Point2D;
import java.util.List;
import ooga.model.Model;
import ooga.model.projectile.Projectile;
import ooga.model.enemy.Enemy;

/**
 * All towers have a location on the board, a price, and a range (which could cover the entire board
 * in certain cases).<br> Has control of objects in its range, and does not have control over
 * objects outside its range.<br> Only becomes active when a bubble enters its range.<br>
 */
public abstract class Tower implements TowerInterface {

  public static final int DEFAULT_RADIUS = 200;
  public static final int DEFAULT_PRICE = 200;
  public static final int INCREASE_SPEED_FACTOR = 2;
  public static final double DEFAULT_PROJECTILE_SPEED = 50;

  protected double x;
  protected double y;
  protected Point2D location;
  protected int price;
  protected int rangeRadius;
  protected int firingSpeed;
  protected double projectileSpeed;

  public Tower(double x, double y, int price, int rangeRadius) {
    if(price < 0) { price = 0; }
    if(rangeRadius < 0) { rangeRadius = 0; }
    this.price = price;
    this.x = x;
    this.y = y;
    this.location = new Point2D.Double(x, y);
    this.rangeRadius = rangeRadius;
    firingSpeed = 1;
    projectileSpeed = DEFAULT_PROJECTILE_SPEED;
  }

  public Tower(double x, double y, int price) {
    this(x, y, price, DEFAULT_RADIUS);
  }

  public Tower(double x, double y) {
    this(x, y, DEFAULT_PRICE, DEFAULT_RADIUS);
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    if (price > 0) {
      this.price = price;
    }
  }

  public int getRangeRadius() {
    return rangeRadius;
  }

  public void setRangeRadius(int newRadius) {
    if(newRadius >= 0) {
      rangeRadius = newRadius;
    }
  }

  public void setFiringSpeed(int firingSpeed) {
    this.firingSpeed = firingSpeed;
  }

  public int getFiringSpeed() {
    return firingSpeed;
  }

  public void setProjectileSpeed(int projectileSpeed) {
    this.projectileSpeed = projectileSpeed;
  }

  public double getProjectileSpeed() {
    return projectileSpeed;
  }

  public void increaseProjectileSpeed() {
    projectileSpeed *= INCREASE_SPEED_FACTOR;
  }

  public boolean shouldActivate(List<Enemy> enemies) {
    for (Enemy enemy : enemies) {
      if (enemyInRange(enemy)) {
        return true;
      }
    }
    return false;
  }

  public abstract List<Projectile> activate(Model model);

  public boolean enemyInRange(Enemy enemy) {
    if (enemy != null) {
      double bubbleX = enemy.getXPos();
      double bubbleY = enemy.getYPos();
      double bRadius = enemy.getRadius();
      return (bubbleY < y+rangeRadius && bubbleY > y-rangeRadius) &&
              (bubbleX+bRadius < x+rangeRadius && bubbleX+bRadius > x-rangeRadius);
    }
    return false;
  }

  private static double calculateDistanceFrom(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }
}
