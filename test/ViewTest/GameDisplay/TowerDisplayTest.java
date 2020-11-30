package ViewTest.GameDisplay;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import ooga.controller.Controller;
import ooga.model.tower.Goldfish;
import ooga.model.tower.Tower;
import ooga.view.GameView;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;

public class TowerDisplayTest extends DukeApplicationTest {

  Controller controller;
  GameView gameview;

  @Override
  public void start (Stage stage){
    controller = new Controller();
    controller.start(stage);
    gameview = controller.getGameView();
  }


  @Test
  void testAddFlowPane() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    FlowPane flowPane = lookup("#flow").query();

    assertNotNull(flowPane);
  }


  @Test
  void testCreateTowerButtons() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button tower = lookup("#TowerButtons").query();

    assertNotNull(tower);
  }

  @Test
  void testCreateAnimatedTower() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button tower = lookup("#TowerButtons").query();
    clickOn(tower);

    BorderPane border = lookup("#border").query();
    clickOn(border);

    assertEquals(0,tower.getLayoutX());
  }

  @Test
  void testCreateRangeOnTower() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    FlowPane tower = lookup("#flow").query();
    clickOn(tower);

    Circle towerRange = lookup("#TowerRange").query();

    BorderPane border = lookup("#border").query();
    clickOn(border, 500,500);


    assertEquals(500,towerRange.getCenterX());
  }

  @Test
  void testSetTower() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button tower = lookup("#TowerButtons").query();
    clickOn(tower);

    BorderPane border = lookup("#border").query();
    clickOn(border);

    assertEquals(98,tower.getHeight());
    assertEquals(165,tower.getWidth());
  }

  @Test
  void testHandleUpdateClick() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button tower = lookup("#TowerButtons").query();
    clickOn(tower,800,300);

    BorderPane border = lookup("#border").query();
    clickOn(border,500,500);

    clickOn(tower,500,500);

    Circle towerRange = lookup("#TowerRange").query();

    assertNotNull(towerRange);
  }

  @Test
  void testUpgradeFiringSpeed() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button tower = lookup("#TowerButtons").query();
    clickOn(tower);

    gameview = controller.getGameView();
    Tower my_tower= new Goldfish(tower.getLayoutX(),tower.getLayoutY());
    int prev_speed = (int)my_tower.getProjectileSpeed();
    javafxRun(()-> gameview.getTowerDisplay().upgradeFiringSpeed(my_tower));

    assertEquals((prev_speed*1.2), my_tower.getProjectileSpeed());
  }

  @Test
  void testUpgradeRangeRadius() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button tower = lookup("#TowerButtons").query();
    clickOn(tower);

    gameview = controller.getGameView();
    Tower my_tower= new Goldfish(tower.getLayoutX(),tower.getLayoutY());
    Circle my_tower_radius= new Circle(my_tower.getRangeRadius());
    int prev_radius = my_tower.getRangeRadius();
    javafxRun(()-> gameview.getTowerDisplay().upgradeRangeRadius(my_tower,my_tower_radius ));

    assertEquals((int)(prev_radius*1.2), my_tower.getRangeRadius());
  }

}
