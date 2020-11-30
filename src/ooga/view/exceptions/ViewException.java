package ooga.view.exceptions;

import java.util.ResourceBundle;
import ooga.view.Alert.AlertView;

/**
 * ViewException is the exception thrown for errors including missing images used by the
 * view classes. It throws an alert box when exceptions are thrown.
 *
 * @author - Luisa Silva
 */
public class ViewException extends RuntimeException {

  AlertView alert = new AlertView();
  private static final String EXCEPTION_PROPERTY_FILE_PATH = "resources.exceptions/exceptions";

  public ViewException(String message){
    ResourceBundle exceptions = ResourceBundle.getBundle(EXCEPTION_PROPERTY_FILE_PATH);
    System.out.println(exceptions.getString(message));
    alert.createAlert(exceptions.getString(message));
  }

  public ViewException(String message, Throwable cause){
    super(message, cause);

  }

}
