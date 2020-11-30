package ooga.model.tower;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ooga.model.Model;

public class Pufferfish extends FixedLaunchTower {

  public Pufferfish(double x, double y) {
    super(x, y, 200, 150);
    firingSpeed = 3;
    projectilesPerShot = 8;
    projectileType = "Spike";
  }

  @Override
  protected List<Point2D> getLaunchDirections(Model model) {
    return new ArrayList<>(
        Arrays.asList(normalize(0,1),
            normalize(1,1),
            normalize(1,0),
            normalize(1,-1),
            normalize(0,-1),
            normalize(-1,-1),
            normalize(-1,0),
            normalize(-1,1))
    );
  }
}
