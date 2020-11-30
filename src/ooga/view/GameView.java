package ooga.view;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.animation.PathTransition;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import ooga.controller.Controller;
import ooga.controller.PropertiesReader;
import ooga.model.Model;
import ooga.model.enemy.Enemy;
import ooga.model.tower.Tower;
import ooga.model.projectile.Projectile;
import ooga.view.gameDisplay.ScoreDisplay;
import ooga.view.gameDisplay.TowerDisplay;
import ooga.view.ui.ButtonPanel;
import ooga.view.ui.slider.SpeedSlider;

/**
 * GameView brings all classes in the view together to make them work as one to update
 * the game with every step.
 *
 * @author - Luisa Silva, Emily Mittleman and Colin Boccaccio
 */
public class GameView {

  private static final String GAME_BORDER_ID = "border";
  private static final String RESUME = "Resume";
  private static final String PAUSE = "Pause";
  private static final String PATH_ID = "path";
  private static final String RESOURCES = "resources/";
  private static final String RESOURCE_FOLDER = "/" + RESOURCES;
  private static final String LEVEL_EXTENSION = "Level";
  private static final String CSS_EXTENSION = ".css";

  private Scene myScene;
  private BorderPane borderPane;
  private ButtonPanel buttonPanel;

  private Controller myController;
  private Model myModel;
  private Path path;
  private List<Enemy> myEnemies;
  private Map<Circle, PathTransition> bubble_map;
  private List<Shape> myProjectileShapes;
  private int current_level;

  private boolean pause;
  private final SpeedSlider speedSlider;
  private final TowerDisplay towerDisplay;
  private final ScoreDisplay scoreDisplay;

  private List<Tower> towersInPane;

  /**
   * @param model - Model object
   * @param controller -  Controller object
   * @param propReader - Property Reader object
   * @param towersInPane - list of all towers added to the borderpane
   */
  public GameView(Model model, Controller controller, PropertiesReader propReader, List<Tower> towersInPane) {
    myController = controller;
    this.myModel = model;
    this.pause = false;
    this.borderPane = new BorderPane();
    this.speedSlider = new SpeedSlider();
    this.towerDisplay = new TowerDisplay(borderPane, this, myModel, towersInPane, model.getPlayer());
    this.buttonPanel = new ButtonPanel(this, myController, model, speedSlider);
    this.scoreDisplay = new ScoreDisplay(model.getPlayer());
    this.towersInPane = towersInPane;
    path = model.getPath();
    myEnemies = model.getEnemies();
    myProjectileShapes = new ArrayList<>();
    //CURRENT_LEVEL = propReader.getLevelProperties().getTheme();
    //Circle c = new Circle(400,400,100);
    //borderPane.getChildren().add(c);
  }

  /**
   * Method called by NextRoundButton that starts the next wave of bubbles in the current level.
   */
  public void startNextWaveView() {
    bubble_map.clear();
    myModel.startNextWave();
    myEnemies = myModel.getEnemies();

    for (Enemy b : myEnemies) {
      bubble_map.put(b.getMyCircle(), b.getTransition());
      b.getTransition().rateProperty().bind(speedSlider.getSpeedSlider().valueProperty());
      borderPane.getChildren().add(b.getMyCircle());
      /*Circle c = new Circle(100, 250, 5);
      borderPane.getChildren().add(c);
      */
      bubble_map.get(b.getMyCircle()).play();
    }
  }

  /**
   * Method called by controller step method to make sure view is updated at every step by:
   * updating the bank money, updating current lives left, removing bubbles from the border
   * pane when they get to the end of the track or are hit by a projectile, drawing projectiles
   * to pop the bubbles and updating the enable/disable of the NextRound button.
   */
  public void updateView() {
    scoreDisplay.updateScoreDisplay();
    // update bubble map from model
    if(bubble_map.isEmpty() && !pause){
      buttonPanel.getNextRoundButton().setDisable(false);
    }
    if(!bubble_map.isEmpty() && !pause){
      buttonPanel.getNextRoundButton().setDisable(true);
    }
    removeBubble();
    buttonPanel.updateLivesPanel();
    // update active projectiles
    drawProjectiles();
  }

  private void drawProjectiles() {
    clearCurrentProjectiles();
    List<Projectile> projectiles = myModel.getProjectiles();
    /*
    for(Projectile p: projectiles) {
      if(!myProjectileShapes.contains(p.getSceneImg())) {
        if(p.getCollisionImg() != null) {
          //img.setFitHeight(TOWER_SIZE.height);
          //img.setFitWidth(TOWER_SIZE.width);
          borderPane.getChildren().add(p.getCollisionImg());
        }
      }
    }*/

    myProjectileShapes.clear();
    for(Projectile projectile: projectiles) {
      Shape image = projectile.getSceneImg();
      myProjectileShapes.add(image);
    }
    borderPane.getChildren().addAll(myProjectileShapes);
  }

  private void clearCurrentProjectiles() {
    borderPane.getChildren().removeAll(myProjectileShapes);
  }


  /**
   * @param width - width size of the game scene
   * @param height - height size of the game scene
   * @param cssFileNameNumber - level number of css file for the scene
   * @return - game scene containing, track, background, buttonpanel and tower panel.
   */
  public Scene makeGameScene(int width, int height, int cssFileNameNumber) {
    HBox hbox = buttonPanel.addHBox();

    scoreDisplay.addStackPane(hbox);
    borderPane.setId(GAME_BORDER_ID);

    borderPane.setTop(hbox);
    borderPane.setRight(towerDisplay.addFlowPane());
    startPaths(borderPane);

    myScene = new Scene(borderPane, width, height);
    myScene.getStylesheets().add(getClass().getResource(
        RESOURCE_FOLDER + LEVEL_EXTENSION+
            cssFileNameNumber +
            CSS_EXTENSION).toExternalForm());

    return myScene;
  }


  /**
   * Method called by Begin button that starts the game on chosen track.
   */
  public void playGame() {
    pause = false;
    bubble_map.clear();
    buttonPanel.getBeginButton().setDisable(true);

    for(Enemy b : myEnemies){
        bubble_map.put(b.getMyCircle(), b.getTransition());
        b.getTransition().rateProperty().bind(speedSlider.getSpeedSlider().valueProperty());
        borderPane.getChildren().add(b.getMyCircle());
        bubble_map.get(b.getMyCircle()).play();
    }

    myController.togglePause();
  }

  /**
   * Method called by Pause/Resume button that pauses and resumes the game when clicked.
   */
  public void pauseGame() {
    if (!pause) {
      for (Circle bubble : bubble_map.keySet()) {
        bubble_map.get(bubble).pause();
      }
      buttonPanel.getPauseButton().setText(RESUME);
      pause = true;
    } else {
      for (Circle bubble : bubble_map.keySet()) {
        bubble_map.get(bubble).play();
      }
      buttonPanel.getPauseButton().setText(PAUSE);
      pause = false;
    }
  }

  private void startPaths(BorderPane border) {
    path.setId(PATH_ID);
    border.getChildren().addAll(path);
    bubble_map = new HashMap<>();
  }

  private void removeBubble() {
    List<Enemy> currentEnemies = myModel.getEnemies();
    for(Enemy enemy : myEnemies) {
      if(!currentEnemies.contains(enemy)) {
        borderPane.getChildren().remove(enemy.getMyCircle());
        bubble_map.remove(enemy.getMyCircle());
      }
    }
  }

  /*FOR TESTS ONLY*/

  /**
   * @return - pause boolean.
   */
  public boolean getPause() {
    return pause;
  }

  /**
   * @return - bubble_map hashmap with bubble Circle object and key and its
   * transition as value.
   */
  public Map<Circle, PathTransition> getBubbles() {
    return bubble_map;
  }

  /**
   * @return - Bubbles's array created in model and used in view.
   */
  public List<Enemy> getBubblesArray() {
    return myEnemies;
  }

  /**
   * @return - fist bubble key (Circle object) of the bubble_map hashmap.
   */
  public Circle getBubble() {
    for (Circle bubble : bubble_map.keySet()) {
      return bubble;
    }
    return new Circle();
  }

  /**
   * @return - current path object.
   */
  public Path getPath() {
    return path;
  }

  /**
   * @return - button panel object.
   */
  public ButtonPanel getButtonPanel() {
    return buttonPanel;
  }

  /**
   * @return - tower display object
   */
  public TowerDisplay getTowerDisplay(){return towerDisplay;}



}
