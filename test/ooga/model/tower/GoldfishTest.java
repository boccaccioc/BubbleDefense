package ooga.model.tower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GoldfishTest {
    protected final double SPEED_SCALE_FACTOR = 10;
    /*
        @Test
        void shootProjectileTest() {
            List<Projectile> expectedList = new ArrayList<>();

            Path p = new Path();
            p.getElements().add(new MoveTo(300.0f, 300.0f));
            ArcTo arcTo = new ArcTo();
            arcTo.setX(500.0f);
            arcTo.setY(500.0f);
            arcTo.setRadiusX(100.0f);
            arcTo.setRadiusY(100.0f);
            p.getElements().add(arcTo);
            Bubble b = new Bubble(300,300, 5,p, "Bubble");
            Bubble b2 = new Bubble(100,100, new ArrayList<String>(),30, 5, p);
            Goldfish g = new Goldfish(400, 400);
            expectedList.add(new SeaShell(g.xPos, g.yPos, b.getXPos(), b.getYPos(), SPEED_SCALE_FACTOR,
                    SPEED_SCALE_FACTOR));
            Assertions.assertEquals(g.shootProjectile(b).get(0).getCurrentX(), expectedList.get(0).getCurrentX());
            Assertions.assertEquals(g.shootProjectile(b).get(0).getCurrentY(), expectedList.get(0).getCurrentY());
            Projectile leaf = g.shootProjectile(b).get(0);
            Assertions.assertEquals(leaf.getCurrentX(), expectedList.get(0).getCurrentX());
            Assertions.assertEquals(leaf.getCurrentY(), expectedList.get(0).getCurrentY());
            leaf.move();
            int newPos = 370;
            Assertions.assertEquals(leaf.getCurrentX(), newPos);
            Assertions.assertEquals(leaf.getCurrentY(), newPos);

        }*/
    @Test
    void goldfishTest() {
        Goldfish g = new Goldfish(300,300);
        int firingSpeed = 2;
        Assertions.assertTrue(g.getFiringSpeed() == firingSpeed);
        Assertions.assertTrue(g.getProjectileSpeed() == 50);
        Assertions.assertTrue(g.getRangeRadius() == 150);
        Assertions.assertTrue(g.getProjectileType() == "Leaf");
    }
}

