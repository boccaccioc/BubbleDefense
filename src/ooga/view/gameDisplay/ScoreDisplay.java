package ooga.view.gameDisplay;

import java.awt.Dimension;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import ooga.model.Player;

/**
 * ScoreDisplay class deals with displaying the current money on the bank for the user,
 * as well as updating that value when a bubble is popped.
 *
 * @author - Luisa Silva
 */
public class ScoreDisplay {

  private static final int MARGIN_TOP = 0;
  private static final int MARGIN_BOTTOM = 0;
  private static final int MARGIN_RIGHT= 10;
  private static final int MARGIN_LEFT = 0;

  private static final Dimension SCORE_BOX_SIZE = new Dimension(150, 50);
  private static final String SCORE_BOX_ID = "ScoreBox";
  private static final double ARC_HEIGHT = 3.5;
  private static final double ARC_WIDTH = 3.5;

  private static final String BANK_LABEL ="Bank: ";
  private static final String SCORE_TEXT_ID = "ScoreText";

  private Text myScoreText;
  private final Player myPlayer;


  /**
   * @param player - Player object from Model part of the project
   */
  public ScoreDisplay(Player player){
     myPlayer = player;
  }

  /**
   * @param hb - An Hbox object to which our StackPane will be added to, which contains
   *           the live updated money the user currently has.
   */
  public void addStackPane(HBox hb) {
    StackPane stack = new StackPane();
    Rectangle scoreBox = createScoreBox();
    myScoreText = createScoreText();

    stack.getChildren().addAll(scoreBox, myScoreText);
    stack.setAlignment(Pos.CENTER_RIGHT);
    StackPane.setMargin(myScoreText, new Insets(MARGIN_TOP, MARGIN_RIGHT, MARGIN_BOTTOM, MARGIN_LEFT));

    hb.getChildren().add(stack);            // Add stack pane to HBox object
    HBox.setHgrow(stack, Priority.ALWAYS);    // Give stack any extra space
  }


  private Rectangle createScoreBox() {
    Rectangle scoreBox = new Rectangle(SCORE_BOX_SIZE.width, SCORE_BOX_SIZE.height);
    scoreBox.setId(SCORE_BOX_ID);
    scoreBox.setArcHeight(ARC_HEIGHT);
    scoreBox.setArcWidth(ARC_WIDTH);
    return scoreBox;
  }


  private Text createScoreText() {
    Text scoreText = new Text(BANK_LABEL+myPlayer.getBalance());
    scoreText.setId(SCORE_TEXT_ID);
    return scoreText;
  }

  /**
   * Updates text on the score box every time the step function in controller is called.
   */
  public void updateScoreDisplay(){
    myScoreText.setText(BANK_LABEL+ myPlayer.getBalance());
  }

}
