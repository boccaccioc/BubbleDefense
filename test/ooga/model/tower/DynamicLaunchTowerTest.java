package ooga.model.tower;
import ooga.model.enemy.Enemy;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class DynamicLaunchTowerTest {


    @Test
    void DLTTest(){
        DynamicLaunchTower dlt = new Goldfish(300, 300);
        List<Point2D> endPoints = new ArrayList<>();
        List<Point2D> directions = new ArrayList<>();

        List<Enemy> enemies = new ArrayList<>();
        //DestroyableObject b = new DestroyableObject(200,200, );
    }
}
