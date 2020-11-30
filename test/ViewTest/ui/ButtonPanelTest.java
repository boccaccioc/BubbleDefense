package ViewTest.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import ooga.controller.Controller;
import ooga.view.GameView;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;

public class ButtonPanelTest extends DukeApplicationTest {

  Controller controller;
  GameView gameview;

  @Override
  public void start (Stage stage) {
    controller = new Controller();
    controller.start(stage);
    gameview = controller.getGameView();
  }

  @Test
  void testGetBeginButton() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button beginButton = lookup("#Begin").query();

    assertEquals(beginButton,controller.getGameView().getButtonPanel().getBeginButton());
  }

  @Test
  void testGetPauseButton() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button pauseButton = lookup("#Pause").query();

    assertEquals(pauseButton,controller.getGameView().getButtonPanel().getPauseButton());
  }

  @Test
  void testGetNextRoundButton() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Button nextRoundButton = lookup("#NextRound").query();

    assertEquals(nextRoundButton,controller.getGameView().getButtonPanel().getNextRoundButton());
  }

  @Test
  void testAddHBox() {

    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    HBox hBox = lookup("#hbox").query();

    assertNotNull(hBox);
  }

  @Test
  void testUpdateLivesPanel() {

    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    controller.getModel().getPlayer().loseOneLife();
    javafxRun(()->controller.step());

    assertEquals("Lives: 49\nLevel: 1",controller.getGameView().getButtonPanel().getLivesText().getText() );
  }
}
