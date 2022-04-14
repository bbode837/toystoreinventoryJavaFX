package mru.tsc.model;
/**
 * class that creates the toy puzzle
 *
 * @author Brandon and Scott
 */
public class Puzzles extends Toy {

  private String puzzleType;
  /**
   * paramaterized constructor used to create a new figure toy
   *
   * @param sn , serial number
   * @param name , name
   * @param brand , brand
   * @param price , price
   * @param availCount , available count
   * @param ageAppropriate , appropriate age
   * @param puzzleType , puzzle type
   */
  public Puzzles(
      SerialNumber sn,
      String name,
      String brand,
      double price,
      int availCount,
      int ageAppropriate,
      String puzzleType) {
    super(sn, name, brand, price, availCount, ageAppropriate);
    this.puzzleType = puzzleType;
    setType("Puzzle");
  }
  /**
   * getter method for puzzle type
   *
   * @return puzzleType , the type of puzzle
   */
  public String getPuzzleType() {
    return puzzleType;
  }
  /**
   * setter method for puzzle type
   *
   * @param puzzleType , the type of puzzle
   */
  public void setPuzzleType(String puzzleType) {
    this.puzzleType = puzzleType;
  }
  /** method that organizes the display of the toy on the console */
  @Override
  public String toString() {
    return "Category: "
        + super.getType()
        + ", Serial Number: "
        + super.getSn().getSN()
        + ", Name: "
        + super.getName()
        + ", Brand: "
        + super.getBrand()
        + ", Price: "
        + super.getPrice()
        + ", Available Count: "
        + super.getAvailCount()
        + ", Age Appropriate:  "
        + super.getAgeAppropriate()
        + ", Puzzle Type: "
        + puzzleType;
  }
  /** method that organizes the format of the toys in the datebase */
  @Override
  public String format() {
    return getSn().getSN()
        + ";"
        + getName()
        + ";"
        + getBrand()
        + ";"
        + getPrice()
        + ";"
        + getAvailCount()
        + ";"
        + getAgeAppropriate()
        + ";"
        + puzzleType;
  }
}
