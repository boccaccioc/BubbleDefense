package ooga.model.tower;

public class Submarine extends DynamicLaunchTower {

  public Submarine(double x, double y) {
    super(x, y, 900, 160);
    firingSpeed = 2;
    projectilesPerShot = 1;
    projectileType = "Torpedo";
  }

}
