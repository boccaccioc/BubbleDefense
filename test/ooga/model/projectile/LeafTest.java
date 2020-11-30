package ooga.model.projectile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import javafx.scene.shape.Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeafTest {

  Projectile projectile;

  @BeforeEach
  void setupBank() {
    projectile = new Leaf(0, 0, 1, 0, 100);
  }

  @Test
  void getID(){
    Shape img = projectile.getSceneImg();
    assertEquals("LeafProjectile", projectile.getID());
    assertEquals(img.getId(), projectile.getID());
  }

  @Test
  void getDamage() {
    assertEquals(3, projectile.getCurrentY());
  }

  @Test
  void getCurrentX() {
    assertEquals(0, projectile.getCurrentX());
  }

  @Test
  void getCurrentY() {
    assertEquals(0, projectile.getCurrentY());
  }

  @Test
  void getSpeed() {
    assertEquals(100, projectile.getSpeed());
  }

  @Test
  void getSceneImg() {
    Shape img = projectile.getSceneImg();
    assertEquals("LeafProjectile", img.getId());
  }

  @Test
  void move() {
    assertEquals(0, projectile.getCurrentX());
    assertEquals(0, projectile.getCurrentY());
    projectile.move();
    assertEquals(2.5, projectile.getCurrentX());
    assertEquals(0, projectile.getCurrentY());
  }

  @Test
  void shouldBeDestroyed() {
    assertFalse(projectile.shouldBeDestroyed());
  }

}