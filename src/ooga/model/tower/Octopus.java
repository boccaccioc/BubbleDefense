package ooga.model.tower;

import java.awt.geom.Point2D;
import java.util.*;
import ooga.model.Model;

public class Octopus extends FixedLaunchTower {

  public Octopus(double x, double y) {
    super(x, y, 300,160);
    firingSpeed = 3;
    projectilesPerShot = 5;
    projectileType = "Spike";
  }

  @Override
  protected List<Point2D> getLaunchDirections(Model model) {
    return new ArrayList<>(
        Arrays.asList(normalize(0, 1),
            normalize(0.95, 0.31),
            normalize(0.59, -0.81),
            normalize(-0.59, -0.81),
            normalize(-0.95, 0.31))
    );
  }
}