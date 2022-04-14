package mru.tsc.model;

/**
 * class that organizes the serial number
 *
 * @author Brandon and Scott
 */
public class SerialNumber {

  private String sn;

  public SerialNumber() {}

  public SerialNumber(String sn) {

    this.sn = sn;
  }
  /**
   * getter method for serial number
   *
   * @return sn , serial number
   */
  public String getSN() {
    return sn;
  }
  /**
   * method that tests if the serial number is for a figure
   *
   * @param sn , serial number
   * @return condition , returns true if first number is 0 or 1
   */
  public boolean isForFigures(String sn) {

    long snCode;
    boolean condition = false;

    long newSN = Long.parseLong(sn);

    snCode = newSN / 1000000000;

    if (snCode == 0 || snCode == 1) {
      condition = true;
    }

    return condition;
  }
  /**
   * method that tests if the serial number is for a animal
   *
   * @param sn , serial number
   * @return condition , returns true if first number is 2 or 3
   */
  public boolean isForAnimals(String sn) {

    long snCode;
    boolean condition = false;

    long newSN = Long.parseLong(sn);

    snCode = newSN / 1000000000;

    if (snCode == 2 || snCode == 3) {
      condition = true;
    }

    return condition;
  }

  /**
   * method that tests if the serial number is for a animal
   *
   * @param sn , serial number
   * @return condition , returns true if first number is 4, 5 or 6
   */
  public boolean isForPuzzles(String sn) {

    long snCode;
    boolean condition = false;

    long newSN = Long.parseLong(sn);

    snCode = newSN / 1000000000;

    if (snCode == 4 || snCode == 5 || snCode == 6) {
      condition = true;
    }

    return condition;
  }
  /**
   * method that tests if the serial number is for a board game
   *
   * @param sn , serial number
   * @return condition , returns true if first number is 7, 8 or 9
   */
  public boolean isForBoardGames(String sn) {

    long snCode;
    boolean condition = false;

    long newSN = Long.parseLong(sn);

    snCode = newSN / 1000000000;

    if (snCode == 7 || snCode == 8 || snCode == 9) {
      condition = true;
    }

    return condition;
  }
}
