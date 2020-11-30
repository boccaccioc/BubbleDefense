package ooga.model.projectile;

import java.lang.reflect.Constructor;
import java.util.Optional;

public class ProjectileFactory {

  /** Creates a projectile of a given type
   * @param type of the projectile that you want to create
   * @param x x position this projectile is being created
   * @param y y position this projectile is being created
   * @param xDirection x direction this projectile will move in
   * @param yDirection y direction this projectile will move in
   * @param speed that this projectile will move at
   */
  public Optional<Projectile> getProjectile(String type, double x, double y, double xDirection, double yDirection, double speed) {

    try {
      Class<?> projectileClass = Class.forName("ooga.model.projectile." + type);
      Constructor<?> constructor = projectileClass.getConstructors()[0];
      return Optional.of((Projectile) constructor.newInstance(x, y, xDirection, yDirection, speed));
    } catch (Exception e) {
      //error stuff here
    }
    return Optional.empty();
  }
}
