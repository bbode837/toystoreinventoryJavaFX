package mru.tsc.model;
/**
 * class that creates the toy figure
 *
 * @author Brandon and Scott
 */
public class Figures extends Toy {

  private char classification;
  /**
   * paramaterized constructor used to create a new figure toy
   *
   * @param sn ,serial number
   * @param name ,name
   * @param brand ,brand
   * @param price ,price
   * @param availCount ,available count
   * @param ageAppropriate , appropriate age
   * @param classification , classification
   */
  public Figures(
      SerialNumber sn,
      String name,
      String brand,
      double price,
      int availCount,
      int ageAppropriate,
      char classification) {
    super(sn, name, brand, price, availCount, ageAppropriate);
    this.classification = classification;
    setType("Figure");
  }
  /**
   * setter method for classification
   *
   * @param c , classification
   */
  public void setClassification(char c) {
    classification = c;
  }
  /**
   * getter method for classification
   *
   * @return classification , classification
   */
  public char getClassifiction() {
    return classification;
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
        + ", Classification: "
        + classification;
  }
  /** method that organizes the format of the toys in the datebase */
  @Override
  public String format() { // TODO Auto-generated method stub
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
        + classification;
  }
}
