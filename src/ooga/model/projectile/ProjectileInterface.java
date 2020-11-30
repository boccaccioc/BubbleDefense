package ooga.model.projectile;

import javafx.scene.shape.Shape;
import ooga.model.Model;
import ooga.model.enemy.Enemy;

public interface ProjectileInterface {

  String getID();

  int getDamage();

  double getCurrentX();

  double getCurrentY();

  double getSpeed();

  Shape getSceneImg();

  void update(Model model);

  void move();

  boolean didCollideWith(Enemy enemy);

  boolean shouldBeDestroyed();
}
