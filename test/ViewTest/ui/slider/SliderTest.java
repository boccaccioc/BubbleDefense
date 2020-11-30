package ViewTest.ui.slider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import ooga.controller.Controller;
import ooga.view.GameView;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class SliderTest extends ApplicationTest {

  Controller controller;
  GameView gameview;

  @Override
  public void start (Stage stage){
    controller = new Controller();
    controller.start(stage);
    gameview = controller.getGameView();
  }
  @Test
  void checkSliderInitiallyAbled() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Slider slider = lookup("#SpeedSlider").query();
    assertFalse(slider.isDisabled());
  }

  @Test
  void checkSliderInitialState() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Slider slider = lookup("#SpeedSlider").query();
    Button beginButton = lookup("#Begin").query();
    clickOn(beginButton);
    assertEquals(0.17,slider.getValue());
  }

  @Test
  void checkSliderChangesValue() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Slider slider = lookup("#SpeedSlider").query();
    Button beginButton = lookup("#Begin").query();
    clickOn(beginButton);
    slider.setValue(0.3);
    assertEquals(0.3,slider.getValue());
  }

  @Test
  void checkSliderSpeedsUpGame() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Slider slider = lookup("#SpeedSlider").query();
    Button beginButton = lookup("#Begin").query();
    clickOn(beginButton);
    slider.setValue(0.3);
    assertEquals(controller.getGameView().getBubbles().get(controller.getGameView().getBubble())
        .getCurrentRate(),0.3);
  }

  @Test
  void checkSliderSlowsDownGame() {
    Button startButton = lookup("#Start").query();
    clickOn(startButton);

    Button optionButtonOne = lookup("#OptionButtonOne").query();
    clickOn(optionButtonOne);

    Slider slider = lookup("#SpeedSlider").query();
    Button beginButton = lookup("#Begin").query();
    clickOn(beginButton);
    slider.setValue(0.1);
    assertEquals(controller.getGameView().getBubbles().get(controller.getGameView().getBubble())
        .getCurrentRate(),0.1);
  }


}
