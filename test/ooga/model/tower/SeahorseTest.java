package ooga.model.tower;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class SeahorseTest {
    @Test
    void seahorseTest(){
        Seahorse s = new Seahorse(300,300);
        int firingSpeed = 4;
        Assertions.assertTrue(s.getFiringSpeed() == firingSpeed);
        Assertions.assertTrue(s.getProjectileSpeed() == 50);
        Assertions.assertTrue(s.getRangeRadius() == 200);
        Assertions.assertTrue(s.getProjectileType() == "SeaShell");
    }
}