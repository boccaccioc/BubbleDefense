package ViewTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ooga.controller.Controller;
import ooga.view.GameView;
import ooga.view.StartView;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;

public class StartViewTest extends DukeApplicationTest {

  Controller controller;
  GameView gameview;

  @Override
  public void start (Stage stage) {
    controller = new Controller();
    controller.start(stage);
    gameview = controller.getGameView();
  }


  @Test
  void testStartScene() {
    StartView startView = new StartView(controller);

    startView.makeInitialScene();

    BorderPane borderPane = lookup("#StartBorder").query();

    assertNotNull(borderPane);
  }

  @Test
  void testStartTextStyle() {
    StartView startView = new StartView(controller);

    startView.makeInitialScene();

    Text borderPaneText = lookup("#StartText").query();

    assertEquals("BUBBLE DEFENSE",borderPaneText.getText());
    assertEquals(Font.font("Verdana", FontWeight.BOLD, 100),borderPaneText.getFont());
  }



}
