package ooga.model.projectile;

import java.util.List;
import javafx.scene.image.ImageView;
import ooga.model.Model;
import ooga.model.enemy.Enemy;
import ooga.view.animation.ExplosionSprite;

public class Torpedo extends Projectile {

  private static final String IMAGE_PATH = "data/images/torpedoCollision";
  private static final String EXTENSION = ".gif";
  double explodingRadius = 150;

  /** Creates a torpedo projectile
   * @param startX x position this projectile is being created
   * @param startY y position this projectile is being created
   * @param xDirection x direction this projectile will move in
   * @param yDirection y direction this projectile will move in
   * @param speed that this projectile will move at
   */
  public Torpedo(double startX, double startY, double xDirection, double yDirection, double speed) {
    super(startX, startY, xDirection, yDirection, speed);
    damage = 100;
    myID = "TorpedoProjectile";
    sceneImg.setId(myID);
  }

  @Override
  protected void collidedWith(Enemy enemy, Model model) {
    List<Enemy> enemies = model.getEnemies();
    // find other enemies that are in explodingRadius & destroy those
    for(Enemy e: enemies) {
      if(withinRange(e, enemy.getXPos(), enemy.getYPos(), explodingRadius)) {
        e.enemyCollision(this, model);
      }
    }
    super.collidedWith(enemy, model);
  }

  @Override
  public ImageView getCollisionImg() {
    ExplosionSprite sprite = new ExplosionSprite();
    return sprite.getSprite();
  }
}
