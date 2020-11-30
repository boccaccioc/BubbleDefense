package ooga.controller;

import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;
import ooga.model.Model;
import ooga.model.tower.Goldfish;
import ooga.model.tower.Octopus;
import ooga.model.tower.Pufferfish;
import ooga.model.tower.Seahorse;
import ooga.model.tower.Submarine;
import ooga.model.tower.Tower;
import ooga.view.GameView;
import ooga.view.OptionView;
import ooga.view.StartView;

/**
 * Connects the view and model part of the project and contains the step function that makes
 * sure the game is animated with time.
 *
 * @author - Colin Boccaccio and Luisa Silva
 */
public class Controller extends Application {

  private GameView myView;
  private Model myModel;
  private PropertiesReader propReader;
  private Scene myScene;
  private Timeline animation;
  private boolean pause;

  private static final int SECOND_DELAY = 5;
  public static final Dimension DEFAULT_SIZE = new Dimension(1000, 800);

  public static final List<Tower> DEFAULT_TOWERS_IN_PANE = new ArrayList<Tower>() {
    {
      add(new Goldfish(0, 0));
      add(new Pufferfish(0,0));
      add(new Octopus(0,0));
      add(new Seahorse(0,0));
      add(new Submarine(0,0));
    }
  };

  public static final String PROPERTY_DIRECTORY = "GameConfigurations/"; //used by all the property reading classes
  private static final String PROPERTIES_FILE = "testProperties.properties";
  private static final String ERROR_FILE = "errors.properties";

  public static Stage stage;
  public static Stage start_stage;
  public static Stage option_stage;

  public Controller() {
  pause = true;
  }

  /**
   * @param stage - new stage for the staring  scene with the start button
   */
  @Override
  public void start(Stage stage) {
    Controller.stage = stage;
    StartView startView = new StartView(this);
    myScene = startView.makeInitialScene();
    stage.setScene(myScene);
    stage.show();
  }


  /**
   * Starts new option stage with the optional track buttons
   */
  public void startGameOptionStage() throws IOException {
    option_stage = new Stage();
    propReader = new PropertiesReader(PROPERTY_DIRECTORY, PROPERTIES_FILE, ERROR_FILE);
    myModel = new Model(propReader);

    OptionView optionView = new OptionView(this, myModel);
    myScene = optionView.makeGameOptionScene();
    option_stage.setScene(myScene);
    option_stage.show();
  }

  /**
   * Starts main game stage.
   *
   * @param current_choice - int that denotes the css file chosen by clicking on different
   *                       track buttons at the option scene.
   */
  public void startMainGame(int current_choice) {
    start_stage = new Stage();

    //PropertiesReader propReader = new PropertiesReader(PROPERTY_DIRECTORY, PROPERTIES_FILE, ERROR_FILE);
    start_stage.setTitle(propReader.getTitle());

    //myModel = new Model(propReader);
    myView = new GameView(myModel, this, propReader, DEFAULT_TOWERS_IN_PANE);

    // add our user interface components to Frame and show it
    myScene = myView.makeGameScene(DEFAULT_SIZE.width, DEFAULT_SIZE.height, current_choice);
    myScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
    myScene.setOnMouseClicked(e -> handleMouseInput(e.getX(), e.getY()));

    start_stage.setScene(myScene);
    setUpAnimation();
    start_stage.show();
  }

  private void setUpAnimation() {
    KeyFrame frame = new KeyFrame(Duration.millis(SECOND_DELAY), e -> step());
    animation = new Timeline();
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.getKeyFrames().add(frame);
    animation.play();
  }

  /**
   * Makes sure to update the model and view part of the code every time it is called.
   */
  public void step() {
    pause = myView.getPause();
    if (!pause) {
      //gameController.updateBoardForStep();
      myModel.updateModel();
      myView.updateView();
    }
  }

  private void handleKeyInput(KeyCode code) {
    switch (code) {
      case LEFT -> System.out.println("left");
    }
  }

  private void handleMouseInput(double x, double y) {
    //for each tower if x and y are on tower sprite then open up tower's upgrade menu
    //

  }

  /**
   * makes sure pause boolean is changed every time pause button is clicked on
   * and the pause method is called in view.
   */
  public void togglePause(){
    pause = !pause;
  }

  /**
   * @return - Gameview object from view part of the project
   */
  public  GameView getGameView(){
    return myView;
  }

  /**
   * @return - Model object from model part of the project
   */
  public  Model getModel(){
    return myModel;
  }

}
