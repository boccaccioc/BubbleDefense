package ViewTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ooga.controller.Controller;
import ooga.view.GameView;
import ooga.view.OptionView;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;

public class OptionViewTest extends DukeApplicationTest {

  Controller controller;
  GameView gameview;

  @Override
  public void start (Stage stage) {
    controller = new Controller();
    controller.start(stage);
    gameview = controller.getGameView();
  }

  @Test
  void testOptionViewScene() {
    OptionView optionView = new OptionView(controller, controller.getModel());

    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    optionView.makeGameOptionScene();

    BorderPane borderPane = lookup("#OptionBorder").query();

    assertNotNull(borderPane);
  }

  @Test
  void testOptionTextStyle() {
    OptionView optionView = new OptionView(controller, controller.getModel());

    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    optionView.makeGameOptionScene();

    Text borderPaneText = lookup("#OptionText").query();

    assertEquals("Choose Your Track",borderPaneText.getText());
    assertEquals(Font.font("Verdana", FontWeight.BOLD, 60),borderPaneText.getFont());
  }

  @Test
  void testCreateTrackPane() {
    OptionView optionView = new OptionView(controller, controller.getModel());

    Button startButton = lookup("#Start").query();
    clickOn(startButton);


    assertNotNull(lookup("#OptionButtonOne").query());
    assertNotNull(lookup("#OptionButtonTwo").query());
    assertNotNull(lookup("#OptionButtonThree").query());
  }



}
