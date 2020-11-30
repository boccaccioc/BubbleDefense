package ViewTest.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ooga.controller.Controller;
import ooga.view.Alert.AlertView;
import ooga.view.GameView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;

public class ViewExceptionTest extends DukeApplicationTest {

  Controller controller;
  GameView gameview;

  @Override
  public void start (Stage stage) {
    controller = new Controller();
    controller.start(stage);
  }

  @Test
  public void testGetInexistentImageForSpriteList() {
    gameview = controller.getGameView();
    Assertions.assertThrows(NullPointerException.class,
        () -> gameview.getTowerDisplay().createSpriteList(9));
  }

  @Test
  public void testSetTowerImageOnButtonException() {
    gameview = controller.getGameView();
    Assertions.assertThrows(NullPointerException.class,
        () -> gameview.getTowerDisplay().setTowerImageOnButton(new Button(),9));
  }

  @Test
  public void testCreateAlert() {
    gameview = controller.getGameView();
    AlertView alert = new AlertView();
    javafxRun(()-> alert.createAlert("Hi"));
    assertNotNull(alert);
  }

}
