package ooga.model.enemy;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.PathTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import ooga.model.Model;
import ooga.model.projectile.Projectile;

public class Enemy {

    //We likely will remove the xpos and ypos for path and imageview
    private double xPosition;
    private double yPosition;
    private List<String> myResistances;
    private int lives;
    //private ImageView image;
    private Circle myCircle;
    private Path myPath;
    private PathTransition myTransition;
    private static int delayNum = 0;
    private static int delayTime = 400;
    private boolean shouldBeDestroyed;
    private double bias = 100; //bias caused by how path transition was layed out
    private double durationTime = 5;

    /**
     * Creates a enemy with the attributes in the parameters
     * @param xPos x location enemy will be created at
     * @param yPos y location enemy will be created at
     * @param numOfLives number of lives for this enemy
     * @param collisionRadius of this enemy
     * @param path that this enemy will follow
     * @param ID for the javafx circle related to this object
     */
    public Enemy(double xPos, double yPos, int numOfLives, double collisionRadius, Path path, String ID) {
        this(xPos, yPos, new ArrayList<>(), numOfLives, collisionRadius, path, ID);
    }

    /**
     * Creates a enemy with the attributes in the parameters
     * @param xPos x location enemy will be created at
     * @param yPos y location enemy will be created at
     * @param resistances that this enemy will have
     * @param numOfLives number of lives for this enemy
     * @param collisionRadius of this enemy
     * @param path that this enemy will follow
     * @param ID for the javafx circle related to this object
     */
    public Enemy(double xPos, double yPos, List<String> resistances, int numOfLives, double collisionRadius, Path path, String ID) {
        xPosition = xPos;
        yPosition = yPos;
        lives = numOfLives;
        myResistances = new ArrayList<>(resistances);
        myCircle = new Circle(xPosition, yPosition, collisionRadius, Color.RED);
        myCircle.setId(ID);
        myPath = path;
        makeTransition();
        shouldBeDestroyed = false;
    }

    public double getXPos(){
        return myCircle.getTranslateX()-bias;

    }

    public double getYPos(){
        return myCircle.getTranslateY()-bias; //bias due to other methods in model
    }

    public int getLivesLeft() { return lives; }

    public static void resetDelay(){
        delayNum = 0;
    }

    public PathTransition getTransition(){
        return myTransition;
    }

    public Circle getMyCircle(){
        return myCircle;
    }

    public boolean shouldBeDestroyed() {
        return shouldBeDestroyed;
    }

    public double getRadius() {
        return myCircle.getRadius();
    }

    /**
     * moves this enemy to the front in the view
     */
    public void toFront(){
        myCircle.toFront();
    }

    /**
     * creates the path transition for this enemy using the path
     */
    private void makeTransition(){
        addDelay();
        myTransition = new PathTransition();
        myTransition.setNode(myCircle);
        myTransition.setDuration(Duration.seconds(durationTime));
        myTransition.setDelay(Duration.millis(delayNum*delayTime));
        myTransition.setPath(myPath);
    }

    /**Checks for collision with the projectile passed as a parameter
     * @param projectile projectile colision is being tested on
     * @param model model for this instance of the game
     */
    public void enemyCollision(Projectile projectile, Model model) {
        model.hitBubble();
        lives -= projectile.getDamage();
        if(lives <= 0) {
            pop();
            return;
        }
        if(myCircle.getId().indexOf("_") == -1){
            myCircle.setId(myCircle.getId()+"_damaged");
        }
    }

    //This is the method for when the bubble collided with a projectile that causes it to pop
    private void pop() {
        shouldBeDestroyed = true;
    }

    /**
     * adds delay before this enemy starts moving through its path
     */
    public static void addDelay(){
        delayNum++;
    }

}
