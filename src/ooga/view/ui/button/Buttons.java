package ooga.view.ui.button;


import javafx.scene.control.ButtonBase;

/**
 * Buttons superclass extended by all buttons in the game, including start and track buttons
 * on the initial and option scenes
 *
 * @author - Luisa Silva
 */
public abstract class Buttons{

  private final ButtonBase currButton;
  private final String id;
  private static final int WIDTH = 100;
  private static final int HEIGHT = 20;


  /**
   * @param b - ButtonBase object that will be our button
   * @param id - string id of button
   */
  public Buttons(ButtonBase b, String id) {
    currButton = b;
    this.id = id;
    initializeThisButton();
  }

  /**
   * sets the id and text on the button as well as set the size to a general size
   */
  public void initializeThisButton() {

    setTextAndID();
    setSize();
  }


  /**
   * sets the id and text on the button
   */
 public void setTextAndID() {
    currButton.setText(id);
    currButton.setId(id);
  }

  /**
   * sets general size to the button
   */
  public void setSize(){
    currButton.setPrefSize(WIDTH, HEIGHT);
  }


  /**
   * @return the button base of the buttons object created, which will be added to the buttonsPanel
   */
  public ButtonBase getCurrButton() {
    return currButton;
  }

}
