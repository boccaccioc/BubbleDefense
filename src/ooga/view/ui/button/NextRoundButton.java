package ooga.view.ui.button;

import javafx.scene.control.Button;
import ooga.model.Model;
import ooga.view.GameView;

public class NextRoundButton extends Buttons {

  private final Model myModel;
  private final GameView view;
  private static final int WIDTH = 150;
  private static final int HEIGHT = 20;

  /**
   * Starts the next wave of buttons on the selected level, after the previous one is over.
   *
   * @param view - Gameview object
   * @param model - Model object
   */
  public NextRoundButton(GameView view, Model model) {
    super(new Button(), "NextRound");
    this.view = view;
    myModel = model;
    initializeThisButton();
    getCurrButton().setDisable(true);
  }

  @Override
  public void initializeThisButton() {
    super.initializeThisButton();
    super.getCurrButton().setOnAction(event -> view.startNextWaveView());
  }

  @Override
  public void setTextAndID() {
    getCurrButton().setText("Next Round");
    getCurrButton().setId("NextRound");
  }

  @Override
  public void setSize(){
    getCurrButton().setPrefSize(WIDTH, HEIGHT);
  }



}
