package mru.tsc.application;

import javafx.application.Application;
import javafx.stage.Stage;
import mru.tsc.controller.Logging;
import mru.tsc.view.myGUI;

/**
 * Main method that runs application
 *
 * @author brandon and scott
 */
public class Main extends Application {
  /**
   * Method that runs application
   *
   * @param args , args
   */
  public static void main(String[] args) {
    Logging logger = new Logging();
    logger.setWarningMessage("Application Started.");
    launch(args);
  }
  /** method that starts the user interface */
  @Override
  public void start(Stage primaryStage) {
    myGUI gui = new myGUI(primaryStage);
  }
}
