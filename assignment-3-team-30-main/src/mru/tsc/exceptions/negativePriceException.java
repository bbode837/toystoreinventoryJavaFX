package mru.tsc.exceptions;
/**
 * Class that creates an exception for negative inputted price
 *
 * @author Brandon and Scott
 */
public class negativePriceException extends Exception {
  /** method that is thrown when a negative inputted price is declared */
  public negativePriceException() {
    super("Error: Price must be positive");
  }
}
