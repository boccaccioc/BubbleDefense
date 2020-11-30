package ooga.controller.Properties;

import static ooga.controller.Controller.PROPERTY_DIRECTORY;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Properties;

public class LevelProperties {

  private static final String LEVEL_DIRECTORY = "Level/";
  private static final String DEFAULT_LEVEL_PROPS = "level1.properties";//"level1.properties";
  private String myLevelProperties;

  private static final String WAVE_DIRECTORY = "Level/WaveConfigurations/";
  private static final String BUBBLE_WAVES_KEY = "bubble_waves";
  private static final String DEFAULT_BUBBLE_WAVES = "testWaves.txt"; //TODO: abstract this so it doesnt need to be txt
  private String bubbleWavesLocation;
  private ArrayList<String[]> bubbleWaves;

  private static final String PATH_DIRECTORY = "Level/PathConfiguration/";
  private static final String PATH_KEY = "Path";
  private static final String DEFAULT_PATH = "testPath.txt";
  private String pathFileLocation;
  private ArrayList<String[]> pathPoints;


  private static final String THEME_KEY = "theme";
  private static final int DEFAULT_THEME = 1;
  private int theme;

  private Properties prop = new Properties();
  private InputStream PROPERTIES_INPUT_STREAM;


  /**
   * Reads in properties for the levels
   * @param levelProps location of the properties file
   * @throws IOException
   */
  public LevelProperties(Optional<String> levelProps) throws IOException {
    if(levelProps.isEmpty()){
      myLevelProperties = DEFAULT_LEVEL_PROPS;
    } else {
      myLevelProperties = levelProps.get();
    }
    PROPERTIES_INPUT_STREAM  = getClass().getClassLoader().getResourceAsStream(PROPERTY_DIRECTORY+LEVEL_DIRECTORY+myLevelProperties);
    prop.load(PROPERTIES_INPUT_STREAM);
    bubbleWaves = new ArrayList<>();
    pathPoints = new ArrayList<>();
    setLevelBubbles();
    setPath();
    setTheme();
  }

  private void setPath() throws FileNotFoundException {
    if (prop.keySet().contains(PATH_KEY)) {
      pathFileLocation = prop.getProperty(PATH_KEY);
    }
    else {
      pathFileLocation = DEFAULT_PATH;
    }
    createPath();
  }

  private void setLevelBubbles() throws FileNotFoundException {
    if(prop.keySet().contains(BUBBLE_WAVES_KEY)) {
      bubbleWavesLocation = prop.getProperty(BUBBLE_WAVES_KEY);
    } else {
      bubbleWavesLocation = DEFAULT_BUBBLE_WAVES;
    }
    createBubbleWaves();
  }

/*  private void createBubbleWaves(){
      *//*Path path = Paths.get(this.getClass().getClassLoader().getResource(WAVE_DIRECTORY+bubbleWavesLocation).toURI());
      for (String line : Files.readAllLines(path)) {
        bubbleWaves.add(line.split(","));
      }*//*
    String[] array = new String[2];
    array[0] = ("Basic");
    array[1] = ("Basic");
    bubbleWaves.add(array);
  }*/

  private void createPath() throws FileNotFoundException {
    try {
      Path path = Paths.get(LevelProperties.class.getClassLoader().getResource(PROPERTY_DIRECTORY+PATH_DIRECTORY+pathFileLocation).toURI());
      for(String coordinate : Files.readAllLines(path)) {
        pathPoints.add(coordinate.split(","));
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new FileNotFoundException("Wrong Path file Location");
    }
  }

  private void createBubbleWaves() throws FileNotFoundException {
    try {
      Path path = Paths.get(LevelProperties.class.getClassLoader().getResource(PROPERTY_DIRECTORY+WAVE_DIRECTORY+bubbleWavesLocation).toURI());
      for (String line : Files.readAllLines(path)) {
        bubbleWaves.add(line.split(","));
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new FileNotFoundException("Please fix your Bubble Wave File Location");
    }
  }

  /**
   * @return the points that make up the path
   */
  public ArrayList<String[]> getPathPoints() {
    return pathPoints;
  }

  /**
   * @return the waves for the bubbles
   */
  public ArrayList<String[]> getBubbleWaves(){
    return bubbleWaves;
  }

  private void setTheme() {
    if(prop.keySet().contains(THEME_KEY)) {
      theme = Integer.parseInt(prop.getProperty(THEME_KEY));
    } else {
      theme = DEFAULT_THEME;
    }
  }

  /**
   * @return gets the theme for the level
   */
  public int getTheme(){
    return theme;
  }


}
