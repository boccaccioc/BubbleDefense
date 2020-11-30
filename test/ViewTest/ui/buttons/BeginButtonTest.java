package ViewTest.ui.buttons;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import javafx.scene.control.Button;
import javafx.stage.Stage;
import ooga.controller.Controller;
import ooga.view.GameView;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class BeginButtonTest extends ApplicationTest {

  Controller controller;
  GameView gameview;
  @Override
  public void start (Stage stage) {
    controller = new Controller();
    controller.start(stage);
    gameview = controller.getGameView();
  }

  //makes sure initial play button is abled
  @Test
  void checkAbledBeginButton() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button beginButton = lookup("#Begin").query();
    assertFalse(beginButton.isDisabled());
  }

  //makes sure play button can only be clicked once per level
  @Test
  void checkDisabledBeginButton() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button beginButton = lookup("#Begin").query();
    clickOn(beginButton);

    assertTrue(beginButton.isDisabled());
  }

  @Test
  void checkFunctionalityBeginButton() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button beginButton = lookup("#Begin").query();
    clickOn(beginButton);

    try {
      Thread.sleep(2500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    assertFalse(controller.getGameView().getBubblesArray().isEmpty());
  }


}
