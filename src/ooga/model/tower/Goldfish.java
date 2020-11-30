package ooga.model.tower;

public class Goldfish extends DynamicLaunchTower {

  public Goldfish(double x, double y) {
    super(x, y, 100, 150);
    firingSpeed = 2;
    projectilesPerShot = 1;
    projectileType = "Leaf";
  }

}
