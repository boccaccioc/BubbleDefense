package ooga.model.projectile;

public class Leaf extends Projectile {

  /** Creates a leaf projectile
   * @param startX x position this projectile is being created
   * @param startY y position this projectile is being created
   * @param xDirection x direction this projectile will move in
   * @param yDirection y direction this projectile will move in
   * @param speed that this projectile will move at
   */
  public Leaf(double startX, double startY, double xDirection, double yDirection, double speed) {
    super(startX, startY, xDirection, yDirection, speed);
    damage = 1;
    myID = "LeafProjectile";
    sceneImg.setId(myID);
  }
}
