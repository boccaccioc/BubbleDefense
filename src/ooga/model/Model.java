package ooga.model;

import static ooga.model.enemy.Enemy.addDelay;
import static ooga.model.enemy.Enemy.resetDelay;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import ooga.controller.Properties.EnemyTypes.EnemyTypeProperties;
import ooga.controller.PropertiesReader;
import ooga.model.enemy.Enemy;
import ooga.model.tower.Tower;
import ooga.model.projectile.Projectile;

public class Model {

  private static final int STARTING_LIVES = 50;
  private static final int BURST_BUBBLE_POINTS = 5;
  private static final String DELAY_KEY = "p";
  private static final int END_COORDINATE_X = 100;
  private static final int END_COORDINATE_Y = 900;
  private static final int BUBBLE_STARTING_X = -100; // negative value so that you can not see them flash on screen before being added to path transition
  private static final int BUBBLE_STARTING_Y = -100;

  private static final String BASIC_BUBBLE = "BasicBubble";
  private static final String SOAPY_BUBBLE = "SoapyBubble";
  private static final String BARNACLE_BUBBLE = "BarnacleBubble";

  private List<Enemy> myEnemies;
  private List<Tower> myTowers;  //towers currently on the board
  private List<Projectile> myProjectiles;

  private int level;
  private Player player;
  private Path myPath = new Path();

  private PropertiesReader myPropReader;
  private int currentWave = 0;
  private int gameTime = 0;

  //Starts the model by reading the necessary property files needed to initialize bubbles, towers, etc
  public Model(PropertiesReader propReader) {
    myPropReader = propReader;

    player = new Player(propReader, STARTING_LIVES);
    level = 1;
    myEnemies = new ArrayList<>();
    myTowers = new ArrayList<>();
    myProjectiles = new ArrayList<>();
    createBubbles(currentWave);
  }

  public int getLevel() {
    return level;
  }

  public List<Enemy> getEnemies() {
    return myEnemies;
  }

  public void setBubbles(List<Enemy> enemies) {
    this.myEnemies = enemies;
  }

  public Path getPath() {
    return myPath;
  }

  public void setPath(Path path) {
    myPath = path;
  }

  public Player getPlayer() {
    return player;
  }

  public List<Projectile> getProjectiles() {
    return myProjectiles;
  }

  /**
   * adds projectiles to the list of projectiles
   * @param newProjectiles list of projectiles to be added
   */
  public void addProjectiles(List<Projectile> newProjectiles) {
    myProjectiles.addAll(newProjectiles);
  }

  /**
   * @param myPath path to be created
   * @param level of the path we will create
   */
  public void createPath(Path myPath, int level) {
    ArrayList<String[]> pathInfo = new ArrayList<>();
    if (level == 1) {
      pathInfo = myPropReader.getLevel1Properties().getPathPoints();
    } else if (level == 2) {
      pathInfo = myPropReader.getLevel2Properties().getPathPoints();
    } else if (level == 3) {
      pathInfo = myPropReader.getLevel3Properties().getPathPoints();
    }
    //ArrayList<String[]> pathInfo = myPropReader.getLevelProperties().getPathPoints();
    try {
      for (String[] coordinate : pathInfo) {
        double xCoordinate = Double.parseDouble(coordinate[0]);
        double yCoordinate = Double.parseDouble(coordinate[1]);
        if (coordinate.equals(pathInfo.get(0))) {
          myPath.getElements().add(new MoveTo(xCoordinate, yCoordinate));
        }
        myPath.getElements().add(new LineTo(xCoordinate, yCoordinate));
      }
    } catch (Exception e) {
      // TODO
    }

  }

  private void createBubbles(int wave) {
    String[] waveInfo = new String[0]; //does this break?
    if (level == 1) {
      waveInfo = myPropReader.getLevel1Properties().getBubbleWaves().get(wave);
    } else if (level == 2) {
      waveInfo = myPropReader.getLevel2Properties().getBubbleWaves().get(wave);
    } else if (level == 3) {
      waveInfo = myPropReader.getLevel3Properties().getBubbleWaves().get(wave);
    }
    //String[] waveInfo = myPropReader.getLevelProperties().getBubbleWaves().get(wave);
    EnemyTypeProperties thisBubbleTypeProps;
    for (String bubbleType : waveInfo) {
      if (bubbleType.equals(DELAY_KEY)) {
        addDelay();
      }
      try {
        switch (bubbleType + "Bubble") {
          case BASIC_BUBBLE -> thisBubbleTypeProps = myPropReader.getBubbleProperties()
              .getBasicBubbleProps();
          case SOAPY_BUBBLE -> thisBubbleTypeProps = myPropReader.getBubbleProperties()
              .getSoapyBubbleProps();
          case BARNACLE_BUBBLE -> thisBubbleTypeProps = myPropReader.getBubbleProperties()
              .getBarnacleBubbleProps();
          default -> throw new IllegalStateException("Unexpected value: " + bubbleType);
        }
        // The bubbles are off because of the constant starting x and y
        myEnemies.add(new Enemy(BUBBLE_STARTING_X, BUBBLE_STARTING_Y,
            thisBubbleTypeProps.getEnemyResistances(), thisBubbleTypeProps.getEnemyLives(),
            thisBubbleTypeProps.getCollisionRadius(), myPath, bubbleType + "Bubbles"));
      } catch (Exception e) {
        //error stuff here
      }
      addDelay();
    }
  }

  /**
   * starts the next wave of enemies
   */
  public void startNextWave() {
    level++;
    myEnemies.clear();
    myProjectiles.clear();
    resetDelay();
    currentWave++;
    createBubbles(currentWave);
    player.addEndOfRoundIncome();
  }

  /**
   * Purchases the tower passed in, meaning the Player's bank account is subtracted that money and
   * the tower is added.
   *
   * @param tower The tower that the player purchased
   * @return True if the player successfully bought the tower, false otherwise
   */
  public boolean buyTower(Tower tower) {
    if (player.canAffordTower(tower)) {
      player.purchaseTower(tower);
      myTowers.add(tower);
      return true;
    }
    return false;
  }

  /** Creates a default path
   * @param path that will be modified
   */
  public void createDefaultPath(Path path) {
    path.getElements().add(new MoveTo(-400, 150)); //150
    path.getElements().add(new LineTo(750, 150));
    path.getElements().add(new LineTo(750, 300));
    path.getElements().add(new LineTo(100, 300));
    path.getElements().add(new LineTo(100, 450));
    path.getElements().add(new LineTo(750, 450));
    path.getElements().add(new LineTo(750, 750));
    path.getElements().add(new LineTo(300, 750));
    path.getElements().add(new LineTo(300, 550));
    path.getElements().add(new LineTo(100, 550));
    path.getElements().add(new LineTo(END_COORDINATE_X, END_COORDINATE_Y));
  }

  /** Creates a default path
   * @param path that will be modified
   */
  public void createDefaultPath2(Path path) {
    path.getElements().add(new MoveTo(-400, 750));
    path.getElements().add(new LineTo(50, 750));
    path.getElements().add(new LineTo(50, 150));
    path.getElements().add(new LineTo(750, 150));
    path.getElements().add(new LineTo(750, 300));
    path.getElements().add(new LineTo(200, 300));
    path.getElements().add(new LineTo(200, 600));
    path.getElements().add(new LineTo(750, 600));
    path.getElements().add(new LineTo(750, END_COORDINATE_Y));
  }

  /** Creates a default path
   * @param path that will be modified
   */
  public void createDefaultPath3(Path path) {
    path.getElements().add(new MoveTo(-400, 100));
    path.getElements().add(new LineTo(-10, 120));
    path.getElements().add(new LineTo(900, 900));
  }


  private List<String> findResistances(Properties bubbleProperties) {
    String fullString = bubbleProperties.getProperty("Resistances");
    String[] allResistances = fullString.split(",");

    List<String> myResistances = new ArrayList<>();

    for (String str : allResistances) {
      myResistances.add(str);
    }
    return myResistances;
  }

  private Properties getProperties(String path) {
    Properties levelProperties = new Properties();
    try {
      levelProperties
          .load(Thread.currentThread().getContextClassLoader().getResourceAsStream(path));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return levelProperties;
  }

  /**
   * Called when a bubble gets hit, not neccessarily popped. Increases player score by default value.
   *
   */
  public void hitBubble() {
    player.increaseBalance(BURST_BUBBLE_POINTS);
  }

  /**
   * updates all portions of the model
   */
  public void updateModel() {
    gameTime++;
    if (gameTime % 100 == 0) {
      gameTime = 0;
      updateBubbles();
      updateTowers(); //fires projectiles if necessary
    }
    updateProjectiles();
  }

  private void updateBubbles() {
    // remove any bubbles that are out of bounds
    List<Enemy> updatedEnemies = new ArrayList<>();

    for (Enemy enemy : myEnemies) {
      if (enemy.getYPos() <= 850 && !enemy.shouldBeDestroyed()) {
        updatedEnemies.add(enemy);
      } else if (enemy.getYPos() > 850){
        player.loseOneLife();
      }
    }
    myEnemies = updatedEnemies;
  }

  private void updateTowers() {
    //System.out.println(myTowers.size());
    for (Tower tower : myTowers) {
      if (tower.shouldActivate(myEnemies)) {
        tower.activate(this); //activate can update bubbles inside range for MutateBubbleTower
      }
    }
  }

  // Move projectiles along their path & remove any that have collided with a bubble
  private void updateProjectiles() {
    for (Projectile p : myProjectiles) {
      p.update(this);
    }

    List<Projectile> updatedProjectiles = new ArrayList<>();
    for (Projectile p : myProjectiles) {
      if (!p.shouldBeDestroyed()) {
        updatedProjectiles.add(p);
      }
    }
    myProjectiles = updatedProjectiles;
  }

  /** Adds a tower to the model
   * @param x x location tower is being created
   * @param y y location tower is being created
   * @param towerType type of tower you are adding
   */
  public void addTower(double x, double y, String towerType) {
    try {
      Class<?> towerClass = Class.forName("ooga.model.tower." + towerType);
      Constructor<?> constructor = towerClass.getConstructors()[0];
      myTowers.add((Tower) constructor
          .newInstance(x, y));
    } catch (Exception e) {
      //error stuff here
    }
  }

}
