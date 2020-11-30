package ooga.model.projectile;

public class SeaShell extends Projectile {

  /** Creates a seashell projectile
   * @param startX x position this projectile is being created
   * @param startY y position this projectile is being created
   * @param xDirection x direction this projectile will move in
   * @param yDirection y direction this projectile will move in
   * @param speed that this projectile will move at
   */
  public SeaShell(double startX, double startY, double xDirection, double yDirection, double speed) {
    super(startX, startY, xDirection, yDirection, speed);
    damage = 2;
    myID = "SeaShellProjectile";
    sceneImg.setId(myID);
  }
}
