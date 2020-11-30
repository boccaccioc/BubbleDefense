package ooga.view.ui;

import javafx.scene.control.ButtonBase;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import ooga.controller.Controller;
import ooga.model.Model;
import ooga.view.GameView;
import ooga.view.ui.button.BeginButton;
import ooga.view.ui.button.NextRoundButton;
import ooga.view.ui.button.PauseResumeButton;
import ooga.view.ui.button.QuitButton;
import ooga.view.ui.slider.SpeedSlider;

/**
 * ButtonPanel class takes care of adding all buttons to the Hbox located to the
 * top of the borderpane and also the speedslider, as well as the lives display text.
 *
 * @author - Luisa Silva
 */
public class ButtonPanel {

  private static GameView myGameView;
  private static Controller myController;
  private static Model myModel;
  private static SpeedSlider speedSlider;
  private static PauseResumeButton buttonPause;
  private static BeginButton buttonBegin;
  private static NextRoundButton buttonNextRound;
  private static final String HBOX_ID = "hbox";

  private static final String LIVES_LABEL ="Lives: ";
  private static final String LIVES_TEXT_ID = "LivesText";
  private static Text livesText;

  /**
   * @param gameView - Gameview object
   * @param controller - Controller object
   * @param model - Model object
   * @param speedSlider - SpeedSlider object
   */
  public ButtonPanel(GameView gameView, Controller controller, Model model, SpeedSlider
      speedSlider){
    myGameView = gameView;
    myController = controller;
    myModel = model;
    this.speedSlider = speedSlider;
  }

  /**
   * @return - Hbox that will be added to the top of the borderPane and that contains
   * all buttons, speedslider and lives text;
   */
  public HBox addHBox() {
    HBox hbox = new HBox();
    hbox.setId(HBOX_ID);
    addButtonPanel(hbox);
    addLivesPanel(hbox);
    return hbox;
  }

  private void addLivesPanel(HBox hbox){
    livesText = new Text(LIVES_LABEL+ myModel.getPlayer().getLivesLeft());
    livesText.setId(LIVES_TEXT_ID);
    hbox.getChildren().addAll(livesText);
  }

  /**
   * Updates lives panel by being called on updateview method in Gameview class
   */
  public void updateLivesPanel(){
    livesText.setText(LIVES_LABEL+ myModel.getPlayer().getLivesLeft() + "\n"+
        "Level: "+ myModel.getLevel());
  }

  private void addButtonPanel(HBox hbox) {
    buttonBegin = new BeginButton(myGameView);

    buttonPause = new PauseResumeButton(myGameView);

    buttonNextRound = new NextRoundButton(myGameView, myModel);

    QuitButton quitButton = new QuitButton(myController);

    hbox.getChildren().addAll(buttonBegin.getCurrButton(),
        buttonPause.getCurrButton(),
        buttonNextRound.getCurrButton(),
        quitButton.getCurrButton(),
        speedSlider.getSpeedSlider());
  }

  /**
   * @return - Begin button
   */
  public ButtonBase getBeginButton(){
    return buttonBegin.getCurrButton();
  }

  /**
   * @return - Pause/Resume button
   */
  public ButtonBase getPauseButton(){
    return buttonPause.getCurrButton();
  }

  /**
   * @return - Next Round button
   */
  public ButtonBase getNextRoundButton(){
    return buttonNextRound.getCurrButton();
  }

  /**
   * @return - lives text (with lives left for the player) on lives panel
   */
  public Text getLivesText(){return livesText;}

}
