package ooga.view.ui.button;


import java.io.IOException;
import javafx.scene.control.Button;
import ooga.controller.Controller;
import ooga.view.exceptions.ViewException;

public class StartButton extends Buttons {

  Controller controller;
  private static final int WIDTH = 200;
  private static final int HEIGHT = 40;

  /**
   * Starts the new stage called option stage where the user can choose the desired track
   * for the game.
   *
   * @param controller - Controller object
   */
  public StartButton(Controller controller) {
    super(new Button(), "Start");
    this.controller = controller;
    initializeThisButton();
  }


  @Override
  public void initializeThisButton() {
    super.initializeThisButton();
    super.getCurrButton().setOnAction(event -> {
      Controller.stage.hide();
      try {
        controller.startGameOptionStage();
      } catch (IOException e) {
        throw new ViewException("PropertyFileNotFound");
      }
    });
  }

  @Override
  public void setSize() {
    getCurrButton().setPrefSize(WIDTH, HEIGHT);
  }
}


