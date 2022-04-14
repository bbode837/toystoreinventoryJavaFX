package mru.tsc.controller;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/**
 * Logging class for application
 *
 * @author brandon and scott
 */
public class Logging {
  /** creating the logger */
  public Logger MJLOGR = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

  /** Logging constructor */
  public Logging() {
    LogManager.getLogManager().reset();

    FileHandler fh;
    try {
      fh = new FileHandler("doc/toyStoreLog.log", true);
      fh.setLevel(Level.ALL);
      MJLOGR.addHandler(fh);
      SimpleFormatter simple = new SimpleFormatter();
      fh.setFormatter(simple);

    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * setter for Warning Text
   *
   * @param text warning message text
   */
  public void setWarningMessage(String text) {
    MJLOGR.warning(text);
  }

  /**
   * setter for info Text
   *
   * @param text info message text
   */
  public void setInfoMessage(String text) {
    MJLOGR.info(text);
  }
}
