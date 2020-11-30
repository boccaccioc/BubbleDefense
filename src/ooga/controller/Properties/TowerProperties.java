package ooga.controller.Properties;

import static ooga.controller.Controller.PROPERTY_DIRECTORY;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.*;

public class TowerProperties {

  private static final String TOWER_DIRECTORY = "Tower/";
  private static final String DEFAULT_TOWER_PROPS = "defaultTower.properties";
  private static final String DEFAULT_IMAGE_DIRECTORY = "data/images/";
  private String myTowerProperties;

  private static final String FIRING_SPEED_KEY = "FiringSpeed";
  private static final double DEFAULT_FIRING_SPEED = 15;
  private double firingSpeed;
  private static final String PRICE_KEY = "Price";
  private static final double DEFAULT_PRICE = 100;
  private double price;
  private static final String IMAGE_KEY = "Lives";
  private static final Path DEFAULT_IMAGE = Path.of("data/images/image1.png");
  private Path towerImage;
  private static final String RANGE_KEY = "Range";
  private static final double DEFAULT_RANGE = 25;
  private double firingRange;
  private static final String PROJECTILES_PER_SHOT = "ProjectilesPerShot";
  private static final int DEFAULT_PER_SHOT = 1;
  private int projectilesPerShot;

  private Properties prop = new Properties();
  private InputStream PROPERTIES_INPUT_STREAM;

  /**
   * Reads in properties for the towers
   * @param towerProps location of the properties file
   * @throws IOException
   */
  public TowerProperties(Optional<String> towerProps) throws IOException {
    if(towerProps.isEmpty()){
      myTowerProperties = DEFAULT_TOWER_PROPS;
    } else {
      myTowerProperties = towerProps.get();
    }
    PROPERTIES_INPUT_STREAM  = getClass().getClassLoader().getResourceAsStream(PROPERTY_DIRECTORY+ TOWER_DIRECTORY
        + myTowerProperties);
    prop.load(PROPERTIES_INPUT_STREAM);
    setFiringSpeed();
    setPrice();
    setImage();
    setRange();
    setProjectilesPerShot();
  }

  private void setProjectilesPerShot() {
    projectilesPerShot = Integer.parseInt(prop.getProperty(PROJECTILES_PER_SHOT));
  }

  private void setImage() {
    towerImage = Path.of(DEFAULT_IMAGE_DIRECTORY + prop.getProperty(IMAGE_KEY));
  }

  private void setRange() {
    firingRange = Double.parseDouble(prop.getProperty(RANGE_KEY));
  }

  private void setPrice() {
    price = Double.parseDouble(prop.getProperty(PRICE_KEY));
  }

  private void setFiringSpeed() {
    firingSpeed = Double.parseDouble(prop.getProperty(FIRING_SPEED_KEY));
  }

}
