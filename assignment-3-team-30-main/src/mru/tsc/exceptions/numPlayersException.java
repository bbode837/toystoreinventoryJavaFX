package mru.tsc.exceptions;
/**
 * Class that creates an exception when the min number of players is greater then the max number of
 * players
 *
 * @author Brandon and Scott
 */
public class numPlayersException extends Exception {
  /**
   * method that is thrown when when the min number of players is greater then the max number of
   * players
   */
  public numPlayersException() {
    super("Error: Maximum Players is less that Minimum Players");
  }
}
