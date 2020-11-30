package ooga.model.tower;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import ooga.model.Model;
import ooga.model.enemy.Enemy;

public abstract class DynamicLaunchTower extends LaunchTower {

  private Point2D directionVector; //unit vector

  public DynamicLaunchTower(double x, double y, int price, int rangeRadius) {
    super(x, y, price, rangeRadius);
  }

  public DynamicLaunchTower(double x, double y, int price) {
    super(x, y, price);
  }

  public DynamicLaunchTower(double x, double y) {
    super(x, y);
  }

  @Override
  protected List<Point2D> getLaunchDirections(Model model) {
    List<Point2D> endPoints = new ArrayList<>();
    List<Point2D> directions = new ArrayList<>();
    List<Enemy> enemies = model.getEnemies();

    for (Enemy enemy : enemies) {
      if(enemyInRange(enemy)) {
        endPoints.add(new Point2D.Double(enemy.getXPos(), enemy.getYPos()));
        break;
      }
    }

    if(endPoints.size() != 0) {
      for(Point2D endPoint: endPoints) {
        directions.add(findDirectionVector(endPoint));
      }
    }
    directionVector = directions.get(0);
    return directions;
  }

  public Point2D getDirectionVector(){
    return directionVector;
  }
}
