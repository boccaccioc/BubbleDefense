package ooga.view;

import java.awt.Dimension;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import ooga.controller.Controller;
import ooga.model.Model;
import ooga.view.ui.button.TrackOneButton;
import ooga.view.ui.button.TrackThreeButton;
import ooga.view.ui.button.TrackTwoButton;

/**
 * OptionView class creates the track Option scene where the user can click on desired track.
 *
 * @author - Luisa Silva
 */
public class OptionView {

  private static final String OPTION_BORDERPANE_ID = "OptionBorder";
  private static final String OPTION_BORDERPANE_TEXT = "Choose Your Track";
  private static final String TEXT_ID = "OptionText";

  private static final String RESOURCES = "resources/";
  private static final String RESOURCE_FOLDER = "/" + RESOURCES;
  private static final String OPTION_EXTENSION = "Option";
  private static final String CSS_EXTENSION = ".css";

  private static final int VERTICAL_GAP =4;
  private static final int HORIZONTAL_GAP =4;
  private static final Dimension DEFAULT_SIZE = new Dimension(1000, 800);

  private static Controller myController;
  private static Model myModel;


  /**
   * @param controller - Controller object
   * @param model - Model Object
   */
  public OptionView(Controller controller, Model model){
    myController = controller;
    myModel = model;
  }

  /**
   * @return - creates the scene where the user can choose game track for bubbles by:
   * adding text, option track buttons and background image.
   */
  public Scene makeGameOptionScene() {
    BorderPane option_border = new BorderPane();
    option_border.setId(OPTION_BORDERPANE_ID);
    createText(option_border);
    Scene myScene = setSceneAndStyle(option_border);
    FlowPane flow = new FlowPane();
    createTrackPane(flow);
    option_border.setCenter(flow);
    flow.setAlignment(Pos.CENTER);

    return myScene;
  }

  private Scene setSceneAndStyle(BorderPane option_border) {
    Scene myScene = new Scene(option_border, DEFAULT_SIZE.width, DEFAULT_SIZE.height);
    myScene.getStylesheets().add(getClass().getResource(
        RESOURCE_FOLDER +
            OPTION_EXTENSION +
            CSS_EXTENSION).toExternalForm());
    return myScene;
  }

  private void createText(BorderPane option_border) {
    Text topText = new Text(OPTION_BORDERPANE_TEXT);
    topText.setId(TEXT_ID);
    option_border.setTop(topText);
  }

  /**
   * @param flow -  creates a FlowPane object where all track buttons will be added to.
   */
  public void createTrackPane(FlowPane flow){
    flow.setVgap(VERTICAL_GAP);
    flow.setHgap(HORIZONTAL_GAP);

    TrackOneButton trackOneButton = new TrackOneButton(myController, myModel);
    TrackTwoButton trackTwoButton = new TrackTwoButton(myController,myModel);
    TrackThreeButton trackThreeButton = new TrackThreeButton(myController,myModel);

    flow.getChildren().addAll(trackOneButton.getCurrButton(),
        trackTwoButton.getCurrButton(),
        trackThreeButton.getCurrButton());
  }


}
