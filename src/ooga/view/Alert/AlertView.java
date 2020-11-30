package ooga.view.Alert;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 * AlertView class is used to create alerts such as when towers are placed on track,
 * when exceptions for invalid files are thrown and when there is not enough money
 * to purchase a tower or update.
 *
 * @author - Luisa Silva
 */
public class AlertView {


  private static final String WARNING= "Warning!";

  /**
   * @param content_text - text that will be displayed by the alert box to warn user
   *                     about an error.
   */
  public void createAlert(String content_text) {
      Alert errorAlert = new Alert(AlertType.ERROR);
      errorAlert.setHeaderText(WARNING);
      errorAlert.setContentText(content_text);
      errorAlert.showAndWait();
  }


}
