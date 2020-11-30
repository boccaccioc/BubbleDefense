package ViewTest.GameDisplay;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ooga.controller.Controller;
import ooga.view.GameView;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;

public class ScoreDisplayTest extends DukeApplicationTest {

  Controller controller;
  GameView gameview;

  @Override
  public void start (Stage stage) {
    controller = new Controller();
    controller.start(stage);
    gameview = controller.getGameView();
  }


  @Test
  void testAddStackPane() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Rectangle scoreBox = lookup("#ScoreBox").query();

    assertNotNull(scoreBox);
  }

  @Test
  void testScoreBoxSize() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Rectangle scoreBox = lookup("#ScoreBox").query();

    assertEquals(50,scoreBox.getHeight());
    assertEquals(150,scoreBox.getWidth());
  }

  @Test
  void testScoreBoxText() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Text scoreBoxText = lookup("#ScoreText").query();

    assertEquals(Font.font("Verdana", FontWeight.BOLD, 22),scoreBoxText.getFont());
  }

  @Test
  void testUpdateScoreDisplay() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Text scoreBoxText = lookup("#ScoreText").query();

    assertEquals("Bank: 900",scoreBoxText.getText());

    javafxRun(()->controller.step());

    assertEquals("Bank: 900",scoreBoxText.getText());
  }




}
