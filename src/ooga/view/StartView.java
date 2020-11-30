package ooga.view;

import java.awt.Dimension;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import ooga.controller.Controller;
import ooga.view.ui.button.StartButton;

/**
 * StartView class creates the very first scene of the game that contains the start button.
 *
 * @author - Luisa Silva
 */
public class StartView {

  private static final String START_BORDERPANE_ID = "StartBorder";
  private static final String START_BORDERPANE_TEXT = "BUBBLE DEFENSE";
  private static final String TEXT_ID = "StartText";

  private static final String RESOURCES = "resources/";
  private static final String RESOURCE_FOLDER = "/" + RESOURCES;
  private static final String START_EXTENSION = "Start";
  private static final String CSS_EXTENSION = ".css";
  private static final Dimension DEFAULT_SIZE = new Dimension(1000, 800);
  private static Controller myController;

  /**
   * @param controller - Controller object
   */
  public StartView(Controller controller){
    myController = controller;
  }

  /**
   * @return - starting scene of the game by setting a initial text, adding a background and
   * the start button.
   */
  public Scene makeInitialScene() {
    BorderPane starting_border = new BorderPane();
    starting_border.setId(START_BORDERPANE_ID);
    setStartText(starting_border);
    Scene myScene = setStartSceneStyle(starting_border);
    StartButton startButton = new StartButton(myController);
    starting_border.setCenter(startButton.getCurrButton());

    return myScene;
  }

  private Scene setStartSceneStyle(BorderPane starting_border) {
    Scene myScene = new Scene(starting_border, DEFAULT_SIZE.width, DEFAULT_SIZE.height);
    myScene.getStylesheets().add(getClass().getResource(
        RESOURCE_FOLDER +
            START_EXTENSION +
            CSS_EXTENSION).toExternalForm());
    return myScene;
  }

  private void setStartText(BorderPane starting_border) {
    Text topText = new Text(START_BORDERPANE_TEXT);
    topText.setId(TEXT_ID);
    starting_border.setTop(topText);
  }

  /**
   * @return - The text on the starting scene.
   */
  public static String getStartBorderpaneText() {
    return START_BORDERPANE_TEXT;
  }
}
