package ooga.model.tower;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubmarineTest {
    protected final double SPEED_SCALE_FACTOR = 10;
    @Test
    void submarineTest(){
        Submarine s = new Submarine(300,300);
        int firingSpeed = 2;
        Assertions.assertTrue(s.getFiringSpeed() == firingSpeed);
        Assertions.assertTrue(s.getProjectileSpeed() == 50);
        Assertions.assertTrue(s.getRangeRadius() == 250);
        Assertions.assertTrue(s.getProjectileType() == "Torpedo");
    }
}