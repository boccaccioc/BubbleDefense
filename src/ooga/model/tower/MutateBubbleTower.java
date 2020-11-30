package ooga.model.tower;

public abstract class MutateBubbleTower extends Tower {

  public MutateBubbleTower(double x, double y, int price, int rangeRadius) {
    super(x, y, price, rangeRadius);
  }

  public MutateBubbleTower(double x, double y, int price) {
    super(x, y, price);
  }

  public MutateBubbleTower(double x, double y) {
    super(x, y);
  }


}
