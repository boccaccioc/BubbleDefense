package ooga;


import javafx.stage.Stage;
import ooga.controller.Controller;

public class Main {
    /**
     * Start of the program.
     */
    public static void main (String[] args) {
        Controller oogaController = new Controller();
        oogaController.start(new Stage());
    }
}
