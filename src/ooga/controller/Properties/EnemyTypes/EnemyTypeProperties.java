package ooga.controller.Properties.EnemyTypes;

import static ooga.controller.Controller.PROPERTY_DIRECTORY;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class EnemyTypeProperties {

  private static final String ENEMY_TYPE_DIRECTORY = "Bubble/BubbleTypes/";
  private static final String DEFAULT_ENEMY_PROPS = "basicBubble.properties";
  private static final String DEFAULT_IMAGE_DIRECTORY = "data/images/";
  private String myEnemyProperties;

  private static final String LIVES_KEY = "Lives";
  private static final int DEFAULT_LIVES = 1;
  private int enemyLives;
  private static final String COLLISION_RADIUS_KEY = "CollisionRadius";
  private static final double DEFAULT_RADIUS = 5;
  private double collisionRadius;
  private static final String RESISTANCE_KEY = "Resistances";
  private static final List<String> DEFAULT_RESISTANCES = new ArrayList<>(Arrays.asList("None"));
  private List<String> enemyResistances;
  private static final String IMAGE_KEY = "Lives";
  private static final Path DEFAULT_IMAGE = Path.of("data/images/bubble.png");
  private Path enemyImage;

  private Properties prop = new Properties();
  private InputStream PROPERTIES_INPUT_STREAM;

  /**
   * Reads in properties for a given enemy type
   * @param enemyProps location of the properties file
   * @throws IOException
   */
  public EnemyTypeProperties(Optional<String> enemyProps) throws IOException {
    if(enemyProps.isEmpty()){
      myEnemyProperties = DEFAULT_ENEMY_PROPS;
    } else {
      myEnemyProperties = enemyProps.get();
    }
    PROPERTIES_INPUT_STREAM = getClass().getClassLoader().getResourceAsStream(PROPERTY_DIRECTORY+ ENEMY_TYPE_DIRECTORY + myEnemyProperties);
    prop.load(PROPERTIES_INPUT_STREAM);

    setEnemyLives();
    setEnemyResistances();
    setEnemyCollisionRadius();
    setEnemyImage();
  }

  private void setEnemyImage() {
    enemyImage = Path.of(DEFAULT_IMAGE_DIRECTORY + prop.getProperty(IMAGE_KEY));
  }

  private void setEnemyCollisionRadius() {
    collisionRadius = Double.parseDouble(prop.getProperty(COLLISION_RADIUS_KEY));
  }

  private void setEnemyResistances() {
    String[] resistances = prop.getProperty(RESISTANCE_KEY).split(",");
    enemyResistances = Arrays.asList(resistances.clone());
  }

  private void setEnemyLives() {
    enemyLives = Integer.parseInt(prop.getProperty(LIVES_KEY));
  }

  /**
   * @return image for this enemy type
   */
  public Path getEnemyImage(){
    return enemyImage;
  }

  /**
   * @return collision radius for this enemy type
   */
  public double getCollisionRadius(){
    return collisionRadius;
  }

  /**
   * @return resistances for this enemy type
   */
  public List<String> getEnemyResistances(){
    return enemyResistances;
  }

  /**
   * @return lives for this enemy type
   */
  public int getEnemyLives(){
    return enemyLives;
  }
}
