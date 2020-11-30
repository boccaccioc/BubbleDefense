package ViewTest.ui.buttons;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import ooga.controller.Controller;
import ooga.view.GameView;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class PauseResumeButtonTest extends ApplicationTest {

  Controller controller;
  GameView gameview;

  @Override
  public void start (Stage stage){
    controller = new Controller();
    controller.start(stage);
    gameview = controller.getGameView();
  }


  @Test
  void checkAbledPauseButton() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button pauseButton = lookup("#Pause").query();
    assertFalse(pauseButton.isDisabled());
  }

  @Test
  void checkFunctionalityPauseButton() throws InterruptedException {

    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button pauseButton = lookup("#Pause").query();
    Button beginButton = lookup("#Begin").query();
    clickOn(beginButton);
    Thread.sleep(1500);
    clickOn(pauseButton);

    assertTrue(controller.getGameView().getPause());
  }

  @Test
  void checkNameChangePauseButton() throws InterruptedException {

    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button pauseButton = lookup("#Pause").query();
    Button beginButton = lookup("#Begin").query();
    clickOn(beginButton);
    clickOn(pauseButton);

    assertEquals("Resume",pauseButton.getText());
  }

}
