package ooga.view.ui.button;

import java.io.IOException;
import javafx.scene.control.Button;
import ooga.controller.Controller;
import ooga.view.exceptions.ViewException;

public class QuitButton extends Buttons {

  private final Controller controller;

  /**
   * Quits for current track, so the user can choose a new one. If pressed all progress
   * in that track is lost.
   *
   * @param controller - Controller object
   */
  public QuitButton(Controller controller) {
    super(new Button(), "Quit");
    this.controller = controller;
    initializeThisButton();
  }


  @Override
  public void initializeThisButton() {
    super.initializeThisButton();
    super.getCurrButton().setOnAction(event -> {
      controller.start_stage.hide();
      try {
        controller.startGameOptionStage();
      } catch (IOException e) {
        throw new ViewException("PropertyFileNotFound");
      }

    });
  }
}
