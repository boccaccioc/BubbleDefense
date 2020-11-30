package ooga.model.tower;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PufferfishTest {
    /*
    @Test
    void shootProjectileTest(){
        Path p = new Path();
        p.getElements().add(new MoveTo(300.0f, 300.0f));
        ArcTo arcTo = new ArcTo();
        arcTo.setX(500.0f);
        arcTo.setY(500.0f);
        arcTo.setRadiusX(100.0f);
        arcTo.setRadiusY(100.0f);
        p.getElements().add(arcTo);
        Bubble b = new BasicBubble(300,300, new ArrayList<String>(), 5,30, p);
        Bubble b2 = new BasicBubble(100,100, new ArrayList<String>(),5, 30, p);
        Pufferfish puff = new Pufferfish(400,400);
        Assertions.assertEquals(puff.shootProjectile(b).size(), 8);
    }
*/
     /*@Test
    void shootProjectile() throws InterruptedException {
        ArrayList<Bubble> bubbles = new ArrayList<>();
        List<String> NoResistance = new ArrayList<String>();
        NoResistance.add("None");
        Bubble bIn = new Bubble(150, 150, NoResistance, 1, 10);
        Bubble bOut = new Bubble(350, 350, NoResistance, 1, 10);
        bubbles.add(bIn);
        bubbles.add(bOut);
        Pufferfish p = new Pufferfish(100, 100);
        assertTrue(p.calculateDistanceFrom(p.getXPos(), p.getYPos(), bIn.getXPos(), bIn.getYPos()) <= p.getRangeRadius());
        assertFalse(p.calculateDistanceFrom(p.getXPos(), p.getYPos(), bOut.getXPos(), bOut.getYPos()) <= p.getRangeRadius());
        p.shootProjectile(bubbles);
    }
        //p.shootProjectile(bubbles);
    }*/
    @Test
    void pufferfishTest(){
        Pufferfish p = new Pufferfish(300,300);
        int firingSpeed = 3;
        Assertions.assertTrue(p.getFiringSpeed() == firingSpeed);
        Assertions.assertTrue(p.getProjectileSpeed() == 50);
        Assertions.assertTrue(p.getRangeRadius() == 150);
        Assertions.assertTrue(p.getProjectileType() == "Spike");
    }
}






    /*@Test
    void shootProjectile() throws InterruptedException {
        ArrayList<Bubble> bubbles = new ArrayList<>();
        List<String> NoResistance = new ArrayList<String>();
        NoResistance.add("None");
        Bubble bIn = new Bubble(150, 150, NoResistance, 1, 10);
        Bubble bOut = new Bubble(350, 350, NoResistance, 1, 10);
        bubbles.add(bIn);
        bubbles.add(bOut);
        Pufferfish p = new Pufferfish(100, 100);
        assertTrue(p.calculateDistanceFrom(p.getXPos(), p.getYPos(), bIn.getXPos(), bIn.getYPos()) <= p.getRangeRadius());
        assertFalse(p.calculateDistanceFrom(p.getXPos(), p.getYPos(), bOut.getXPos(), bOut.getYPos()) <= p.getRangeRadius());
        p.shootProjectile(bubbles);
    }
        //p.shootProjectile(bubbles);
    }*/

