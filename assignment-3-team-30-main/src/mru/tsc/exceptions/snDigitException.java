package mru.tsc.exceptions;

/**
 * Class that creates an exception for serial number inputs that do not contain 10 integers
 *
 * @author Brandon and Scott
 */
public class snDigitException extends Exception {
  /** method that is thrown when a serial number input does not contain 10 integers */
  public snDigitException() {
    super("Error: The Serial Number's length MUST be 10 digits! Try again.");
  }
}
