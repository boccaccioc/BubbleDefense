package ooga.model.tower;

import java.util.ArrayList;
import java.util.List;
import ooga.model.Model;
import ooga.model.projectile.Projectile;

public class Seahorse extends DynamicLaunchTower {

  List<Projectile> activeProjectiles = new ArrayList<>();

  public Seahorse(double x, double y) {
    super(x, y, 400, 160);
    firingSpeed = 4;
    projectilesPerShot = 1;
    //projectileType = "SeaShell";
    projectileType = "SoundWave";
  }

  @Override
  public List<Projectile> activate(Model model) {
    updateActiveProjectiles(model);
    // only activate new soundwaves if the old ones are all gone
    List<Projectile> newProjectiles = new ArrayList<>();
    if(activeProjectiles.size() == 0) {
      newProjectiles.addAll(super.activate(model));
      activeProjectiles.addAll(newProjectiles);
    }
    return newProjectiles;
  }

  private void updateActiveProjectiles(Model model) {
    // if anything in activeProjectiles is no longer in model.getProjectiles
    // then remove it from active
    List<Projectile> updatedProjectiles = new ArrayList<>();
    for (Projectile p : activeProjectiles) {
      if (model.getProjectiles().contains(p)) {
        updatedProjectiles.add(p);
      }
    }
    activeProjectiles = updatedProjectiles;
  }

}
