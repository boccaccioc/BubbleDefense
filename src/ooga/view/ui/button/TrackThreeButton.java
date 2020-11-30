package ooga.view.ui.button;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ooga.controller.Controller;
import ooga.model.Model;
import ooga.view.exceptions.ViewException;

public class TrackThreeButton extends Buttons {

  private static final String PNG_EXTENSION = ".png";
  private static final String TRACK_PATH = "data/Tracks/track3";
  private static final Dimension DEFAULT_SIZE = new Dimension(300, 200);
  private static Controller controller;
  private static Model model;
  private final int level = 3;
  private final int css_file_number = 1;

  /**
   * Contained in the option stage and leads the user to the desired track.
   *
   * @param controller - Controller object
   * @param model - Model object
   */
  public TrackThreeButton(Controller controller, Model model) {
    super(new Button(), "OptionButtonThree");
    ImageView img = null;
    try {
      img = new ImageView(new Image(new FileInputStream(TRACK_PATH + PNG_EXTENSION)));
    } catch (FileNotFoundException e) {
      throw new ViewException("ButtonImageNotFound");
    }
    img.setFitHeight(DEFAULT_SIZE.height);
    img.setFitWidth(DEFAULT_SIZE.width);
    this.getCurrButton().setGraphic(img);
    this.controller = controller;
    this.model = model;
    initializeThisButton();
  }

  @Override
  public void initializeThisButton() {
    super.initializeThisButton();
    super.getCurrButton().setOnAction(event -> {
      controller.option_stage.hide();
      controller.startMainGame(css_file_number);
      //model.createDefaultPath3(model.getPath());
      model.createPath(model.getPath(), level);
    });
  }

  @Override
  public void setTextAndID() {
    getCurrButton().setId("OptionButtonThree");
  }
}

