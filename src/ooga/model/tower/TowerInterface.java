package ooga.model.tower;

import java.util.List;
import ooga.model.Model;
import ooga.model.projectile.Projectile;
import ooga.model.enemy.Enemy;

public interface TowerInterface {

    double getX();
    double getY();

    void setX(double x);
    void setY(double y);

    int getPrice();
    void setPrice(int price);

    int getRangeRadius();
    void setRangeRadius(int newRadius);

    boolean shouldActivate(List<Enemy> enemies);
    List<Projectile> activate(Model model);

    boolean enemyInRange(Enemy enemy);
}
