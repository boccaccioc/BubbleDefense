package ooga.model.tower;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import ooga.model.Model;
import ooga.model.projectile.Projectile;
import ooga.model.projectile.ProjectileFactory;

// launch direction is predefined (always shoots in 8 directions)
// launch direction depends on something (launch at first balloon)
// --- this includes projectiles that follow balloons (bc it would just
// --- fire that type of projectile)
public abstract class LaunchTower extends Tower {

  protected int projectilesPerShot;
  protected String projectileType;
  protected ProjectileFactory projectileFactory;

  public LaunchTower(double x, double y, int price, int rangeRadius) {
    super(x, y, price, rangeRadius);
    projectileSpeed = DEFAULT_PROJECTILE_SPEED;
    projectilesPerShot = 1;
    projectileType = "";
    projectileFactory = new ProjectileFactory();
  }

  public LaunchTower(double x, double y, int price) {
    super(x, y, price);
  }

  public LaunchTower(double x, double y) {
    super(x, y);
  }

  public String getProjectileType() {
    return projectileType;
  }

  @Override
  public List<Projectile> activate(Model model) {
    List<Projectile> newProjectiles = launchProjectiles(model);
    model.addProjectiles(newProjectiles);
    return newProjectiles;
  }

  private List<Projectile> launchProjectiles(Model model) {
    List<Projectile> newProjectiles = new ArrayList<>();
    List<Point2D> launchDirections = getLaunchDirections(model);

    for (Point2D directionVector : launchDirections) {
      Optional<Projectile> projectile = projectileFactory
          .getProjectile(projectileType, x, y, directionVector.getX(), directionVector.getY(), projectileSpeed);

      projectile.ifPresent(newProjectiles::add);
    }
    return newProjectiles;
  }

  protected abstract List<Point2D> getLaunchDirections(Model model);

  protected Point2D findDirectionVector(Point2D endPoint) {
    double dx = endPoint.getX() - x;
    double dy = y - endPoint.getY();

    double magnitude = Math.sqrt(dx*dx + dy*dy);
    return new Point2D.Double(dx/magnitude, dy/magnitude);
  }

  public Point2D normalize(double x, double y) {
    double magnitude = Math.sqrt(x*x + y*y);
    return new Point2D.Double(x/magnitude, y/magnitude);
  }

}
