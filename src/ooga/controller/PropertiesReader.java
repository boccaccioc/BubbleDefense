package ooga.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import ooga.controller.Properties.BankProperties;
import ooga.controller.Properties.EnemyProperties;
import ooga.controller.Properties.LevelProperties;
import ooga.controller.Properties.TowerProperties;

public class PropertiesReader {

  private Properties prop = new Properties();
  private Properties prop_errors = new Properties();

  private InputStream PROPERTIES_INPUT_STREAM;
  private InputStream PROPERTIES_ERROR_INPUT_STREAM;

  private static String title;
  private static final String TITLE_KEY = "title";
  private static final String DEFAULT_TITLE = "Bubble Defense (Default)";

  private static final String BANK_KEY = "bank_properties";
  private BankProperties bankProp;
  private static final String ENEMY_KEY = "bubble_properties";
  private EnemyProperties enemyPropertiesProp;
  private static final String LEVEL1_KEY = "level1_properties";
  private LevelProperties level1Prop;
  private static final String LEVEL2_KEY = "level2_properties";
  private LevelProperties level2Prop;
  private static final String LEVEL3_KEY = "level3_properties";
  private LevelProperties level3Prop;
  private static final String TOWER_KEY = "tower_properties";
  private TowerProperties towerProp;

  /**
   * @param propDirectory location of folder containing the property file
   * @param propFile name of property file
   * @param errorFile name of property file for error information
   * @throws IOException
   */
  public PropertiesReader(String propDirectory, String propFile, String errorFile) throws IOException {
    PROPERTIES_INPUT_STREAM  = getClass().getClassLoader().getResourceAsStream(propDirectory+propFile);
    PROPERTIES_ERROR_INPUT_STREAM = getClass().getClassLoader().getResourceAsStream(propDirectory+errorFile);
    prop.load(PROPERTIES_INPUT_STREAM);
    prop_errors.load(PROPERTIES_ERROR_INPUT_STREAM);

    setTitle();
    bankProp = new BankProperties(Optional.of(prop.getProperty(BANK_KEY)));
    enemyPropertiesProp = new EnemyProperties(Optional.of(prop.getProperty(ENEMY_KEY)));
    level1Prop = new LevelProperties(Optional.of(prop.getProperty(LEVEL1_KEY)));
    level2Prop = new LevelProperties(Optional.of(prop.getProperty(LEVEL2_KEY)));
    level3Prop = new LevelProperties(Optional.of(prop.getProperty(LEVEL3_KEY)));
    towerProp = new TowerProperties(Optional.of(prop.getProperty(TOWER_KEY)));
  }

  private void setTitle(){
    if(prop.keySet().contains(TITLE_KEY)){
      title = prop.getProperty(TITLE_KEY);
    } else{
      title = DEFAULT_TITLE;
    }
  }
  public String getTitle(){
    return title;
  }

  /**
   * @return returns the bank properties object
   */
  public BankProperties getBankProperties(){
    return bankProp;
  }

  /**
   * @return returns the bubble properties object
   */
  public EnemyProperties getBubbleProperties(){
    return enemyPropertiesProp;
  }

  /**
   * @return returns the first level properties object
   */
  public LevelProperties getLevel1Properties(){
    return level1Prop;
  }

  /**
   * @return returns the second level properties object
   */
  public LevelProperties getLevel2Properties(){
    return level2Prop;
  }

  /**
   * @return returns the third level properties object
   */
  public LevelProperties getLevel3Properties(){
    return level3Prop;
  }

  /**
   * @return returns the tower properties object
   */
  public TowerProperties getTowerProperties(){
    return towerProp;
  }
}
