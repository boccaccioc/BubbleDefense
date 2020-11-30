package ooga.view.ui.button;

import javafx.scene.control.Button;
import ooga.view.GameView;

public class PauseResumeButton extends Buttons {


  private final GameView view;

  /**
   * Pause and resumes the game when pressed, so bubbles stop coming.
   *
   * @param view - GameView object
   */
  public PauseResumeButton(GameView view) {
    super(new Button(), "Pause");
    this.view = view;
    initializeThisButton();
  }

  @Override
  public void initializeThisButton() {
    super.initializeThisButton();
    super.getCurrButton().setOnAction(event -> view.pauseGame());
  }



}
