package ViewTest.ui.buttons;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import ooga.controller.Controller;
import ooga.view.GameView;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class NextRoundButtonTest extends ApplicationTest {

  Controller controller;
  GameView gameview;

  @Override
  public void start (Stage stage){
    controller = new Controller();
    controller.start(stage);
    gameview = controller.getGameView();
  }

  @Test
  void checkAbledNextRoundButton() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button nextRoundButton = lookup("#NextRound").query();
    assertFalse(nextRoundButton.isDisabled());
  }

  @Test
  void checkFunctionalityNextRoundButton() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button nextRoundButton = lookup("#NextRound").query();
    clickOn(nextRoundButton);

    Button beginButton = lookup("#Begin").query();
    assertFalse(beginButton.isDisabled());
  }

}
