package ViewTest.ui.buttons;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javafx.scene.control.Button;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import ooga.controller.Controller;
import ooga.view.GameView;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class TrackButtonTest extends ApplicationTest {

  Controller controller;
  GameView gameview;

  @Override
  public void start (Stage stage) {
    controller = new Controller();
    controller.start(stage);
    gameview = controller.getGameView();
  }

  @Test
  void checkAbledTrackButtons() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    assertFalse(optionButtonOne.isDisabled());

    Button optionButtonTwo = lookup("#OptionButtonTwo").query();
    assertFalse(optionButtonTwo.isDisabled());

    Button optionButtonThree = lookup("#OptionButtonThree").query();
    assertFalse(optionButtonThree.isDisabled());
  }

  @Test
  void checkFunctionalityTrackButtonOne() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button beginButton = lookup("#Begin").query();
    assertNotNull(beginButton);
  }

  @Test
  void checkFunctionalityTrackButtonTwo() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonTwo = lookup("#OptionButtonTwo").query();
    clickOn(optionButtonTwo);

    Button beginButton = lookup("#Begin").query();
    assertNotNull(beginButton);
  }

  @Test
  void checkFunctionalityTrackButtonThree() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonThree = lookup("#OptionButtonThree").query();
    clickOn(optionButtonThree);

    Button beginButton = lookup("#Begin").query();
    assertNotNull(beginButton);
  }

}
