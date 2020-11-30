package ViewTest.ui.buttons;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import ooga.controller.Controller;
import ooga.view.GameView;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class QuitButtonTest extends ApplicationTest {

  Controller controller;
  GameView gameview;

  @Override
  public void start (Stage stage){
    controller = new Controller();
    controller.start(stage);
    gameview = controller.getGameView();
  }

  @Test
  void checkAbledQuitButton() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);


    Button quitButton = lookup("#Quit").query();
    assertFalse(quitButton.isDisabled());
  }

  @Test
  void checkFunctionalityQuitButton() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button quitButton = lookup("#Quit").query();
    clickOn(quitButton);

    Button optionButtonTwo = lookup("#OptionButtonTwo").query();

    Button optionButtonThree = lookup("#OptionButtonThree").query();

    assertNotNull(optionButtonOne);
    assertNotNull(optionButtonTwo);
    assertNotNull(optionButtonThree);
  }

}
