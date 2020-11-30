package ooga.view.ui.button;

import javafx.scene.control.Button;
import ooga.view.GameView;

public class BeginButton extends Buttons {


  private final GameView view;

  /**
   * Starts the game on whichever level the player chooses
   *
   * @param view - GameView Object
   */
  public BeginButton(GameView view) {
    super(new Button(), "Begin");
    this.view = view;
    initializeThisButton();
  }


  @Override
  public void initializeThisButton() {
    super.initializeThisButton();
    super.getCurrButton().setOnAction(event -> view.playGame());
  }





}
