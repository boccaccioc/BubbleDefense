package ooga.view.ui.slider;
import javafx.scene.control.Slider;

/**
 * SpeedSlider class creates the speedSlider object that is added to the buttons panel
 * and that controls the speed of the bubbles.
 *
 * @author - Luisa Silva
 */
public class SpeedSlider {

  public static final double SPEED_MIN = 0.07;
  public static final double SPEED_MAX = 0.36;
  public static final double SPEED_START = 0.17;
  public static final double SLIDER_INCREMENT = 0.1;
  public static final int NO_TICK = 0;
  public static final String ID = "SpeedSlider";

  private final Slider speedSlider;

  /**
   * Creates speedslider object with chosen specifications
   */
  public SpeedSlider() {
    speedSlider = new Slider(SPEED_MIN, SPEED_MAX, SPEED_START);
    speedSlider.setShowTickMarks(true);
    speedSlider.setShowTickLabels(true);
    speedSlider.setSnapToTicks(true);
    speedSlider.setMajorTickUnit(SLIDER_INCREMENT);
    speedSlider.setMinorTickCount(NO_TICK);
    speedSlider.setBlockIncrement(SLIDER_INCREMENT);
    speedSlider.setId(ID);
  }

  /**
   * @return - speedSlider object that will be added to buttons panel
   */
  public Slider getSpeedSlider() {
    return speedSlider;
  }

}
