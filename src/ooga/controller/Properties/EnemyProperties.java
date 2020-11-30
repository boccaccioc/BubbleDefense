package ooga.controller.Properties;

import static ooga.controller.Controller.PROPERTY_DIRECTORY;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import ooga.controller.Properties.EnemyTypes.EnemyTypeProperties;

public class EnemyProperties {
  private static final String ENEMY_DIRECTORY = "Bubble/";
  private static final String DEFAULT_ENEMY_PROPS = "defaultBubble.properties";
  private static final String DEFAULT_IMAGE_DIRECTORY = "data/images/";
  private String myEnemyProperties;

  private static final String BASIC_BUBBLE_KEY = "basic_bubble_location";
  private static final String SOAPY_BUBBLE_KEY = "soapy_bubble_location";
  private static final String BARNACLE_BUBBLE_KEY = "barnacle_bubble_location";
  private EnemyTypeProperties basicBubbleProps;
  private EnemyTypeProperties soapyBubbleProps;
  private EnemyTypeProperties barnacleBubbleProps;

  private Properties prop = new Properties();
  private InputStream PROPERTIES_INPUT_STREAM;

  /**
   * Reads in properties for the enemies
   * @param EnemyProps location of the properties file
   * @throws IOException
   */
  public EnemyProperties(Optional<String> EnemyProps) throws IOException {
    if(EnemyProps.isEmpty()){
      myEnemyProperties = DEFAULT_ENEMY_PROPS;
    } else {
      myEnemyProperties = EnemyProps.get();
    }
    PROPERTIES_INPUT_STREAM  = getClass().getClassLoader().getResourceAsStream(PROPERTY_DIRECTORY+ ENEMY_DIRECTORY + myEnemyProperties);
    prop.load(PROPERTIES_INPUT_STREAM);

    basicBubbleProps = new EnemyTypeProperties(Optional.of(prop.getProperty(BASIC_BUBBLE_KEY)));
    barnacleBubbleProps = new EnemyTypeProperties(Optional.of(prop.getProperty(BARNACLE_BUBBLE_KEY)));
    soapyBubbleProps = new EnemyTypeProperties(Optional.of(prop.getProperty(SOAPY_BUBBLE_KEY)));
  }

  /**
   * @return properties for basic bubbles
   */
  public EnemyTypeProperties getBasicBubbleProps(){
    return basicBubbleProps;
  }

  /**
   * @return properties for barnacle bubbles
   */
  public EnemyTypeProperties getBarnacleBubbleProps(){
    return barnacleBubbleProps;
  }

  /**
   * @return properties for soapy bubbles
   */
  public EnemyTypeProperties getSoapyBubbleProps(){
    return soapyBubbleProps;
  }


}
