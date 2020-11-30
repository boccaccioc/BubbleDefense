package ooga.model.tower;

public abstract class FixedLaunchTower extends LaunchTower {

  public FixedLaunchTower(double x, double y, int price, int rangeRadius) {
    super(x, y, price, rangeRadius);
  }

  public FixedLaunchTower(double x, double y, int price) {
    super(x, y, price);
  }

  public FixedLaunchTower(double x, double y) {
    super(x, y);
  }

}
