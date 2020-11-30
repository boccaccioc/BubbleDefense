package ViewTest.ui.buttons;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import javafx.scene.control.Button;
import javafx.stage.Stage;
import ooga.controller.Controller;
import ooga.view.GameView;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class StartButtonTest extends ApplicationTest {

  Controller controller;
  GameView gameview;

  @Override
  public void start (Stage stage) {
    controller = new Controller();
    controller.start(stage);
    gameview = controller.getGameView();
  }

  @Test
  void checkAbledStartButton() {
    Button startButton = lookup("#Start").query();
    assertFalse(startButton.isDisabled());
  }

  @Test
  void checkClickStartButton() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    assertNotNull(optionButtonOne);

    Button optionButtonTwo = lookup("#OptionButtonTwo").query();
    assertNotNull(optionButtonTwo);

    Button optionButtonThree = lookup("#OptionButtonThree").query();
    assertNotNull(optionButtonThree);
  }

}
