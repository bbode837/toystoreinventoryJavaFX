package mru.tsc.model;
/**
 * class that creates the toy animal
 *
 * @author Brandon and Scott
 */
public class Animals extends Toy {

  private String material;
  private char size;
  /**
   * paramaterized constructor used to create a new animal toy
   *
   * @param sn , serial number
   * @param name , name
   * @param brand , brand
   * @param price , price
   * @param availCount , available count
   * @param ageAppropriate , appropriate age
   * @param material , material
   * @param size , size
   */
  public Animals(
      SerialNumber sn,
      String name,
      String brand,
      double price,
      int availCount,
      int ageAppropriate,
      String material,
      char size) {
    super(sn, name, brand, price, availCount, ageAppropriate);
    this.material = material;
    this.size = size;
    setType("Animal");
  }
  /**
   * getter method for material
   *
   * @return material , the material of the animal
   */
  public String getMaterial() {
    return material;
  }
  /**
   * getter method for size
   *
   * @return size , the size of the animal
   */
  public char getSize() {
    return size;
  }
  /**
   * setter method for material
   *
   * @param material , material of the animal
   */
  public void setMaterial(String material) {
    this.material = material;
  }
  /**
   * setter method for size
   *
   * @param size , size of the animal
   */
  public void setSize(char size) {
    this.size = size;
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
        + ", Material: "
        + material
        + ", Size: "
        + size;
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
        + material
        + ";"
        + size;
  }
}
