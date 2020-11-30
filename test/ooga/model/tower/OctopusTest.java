package ooga.model.tower;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OctopusTest {
    @Test
    void octopusTest(){
        Octopus o = new Octopus(300,300);
        int firingSpeed = 3;
        Assertions.assertTrue(o.getFiringSpeed() == firingSpeed);
        Assertions.assertTrue(o.getProjectileSpeed() == 50);
        Assertions.assertTrue(o.getRangeRadius() == 200);
        Assertions.assertTrue(o.getProjectileType() == "Spike");
    }
}