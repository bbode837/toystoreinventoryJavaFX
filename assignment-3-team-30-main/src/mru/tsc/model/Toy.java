package mru.tsc.model;
/**
 * class that creates the toy
 *
 * @author Brandon and Scott
 */
public abstract class Toy {

  private String type;
  private SerialNumber sn;
  private String name;
  private String brand;
  private double price;
  private int availCount;
  private int ageAppropriate;
  /**
   * paramaterized constructor used to create a new toy
   *
   * @param sn , serial number
   * @param name , name
   * @param brand , brand
   * @param price , price
   * @param availCount , available count
   * @param ageAppropriate , appropriate age
   */
  public Toy(
      SerialNumber sn,
      String name,
      String brand,
      double price,
      int availCount,
      int ageAppropriate) {
    this.sn = sn;
    this.name = name;
    this.brand = brand;
    this.price = price;
    this.availCount = availCount;
    this.ageAppropriate = ageAppropriate;
  }
  /**
   * getter method for type of toy
   *
   * @return type , type of toy
   */
  public String getType() {
    return type;
  }
  /**
   * setter method for type of toy
   *
   * @param type , type of toy
   */
  public void setType(String type) {
    this.type = type;
  }
  /**
   * getter method for serial number of toy
   *
   * @return sn , serial number
   */
  public SerialNumber getSn() {
    return sn;
  }

  /**
   * setter method for serial number of toy
   *
   * @param sn , serial number
   */
  public void setSn(SerialNumber sn) {
    this.sn = sn;
  }

  /**
   * getter method for toys name
   *
   * @return name , toy name
   */
  public String getName() {
    return name;
  }

  /**
   * setter method for toys name
   *
   * @param name , toy name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * getter method for the toys brand
   *
   * @return brand , brand of toy
   */
  public String getBrand() {
    return brand;
  }
  /**
   * setter method for the toys brand
   *
   * @param brand , brand of toy
   */
  public void setBrand(String brand) {
    this.brand = brand;
  }
  /**
   * getter method for the toys price
   *
   * @return price , price of toy
   */
  public double getPrice() {
    return price;
  }

  /**
   * setter method for the toys price
   *
   * @param price , price of toy
   */
  public void setPrice(double price) {
    this.price = price;
  }
  /**
   * getter method for the toys available count
   *
   * @return availCount , available count of the toy
   */
  public int getAvailCount() {
    return availCount;
  }
  /**
   * setter method for the toys available count
   *
   * @param availCount , available count of the toy
   */
  public void setAvailCount(int availCount) {
    this.availCount = availCount;
  }
  /**
   * getter method for appropriate age for the toy
   *
   * @return ageAppropriate , appropriate age for the toy
   */
  public int getAgeAppropriate() {
    return ageAppropriate;
  }
  /**
   * setter method for appropriate age for the toy
   *
   * @param ageAppropriate , appropriate age for the toy
   */
  public void setAgeAppropriate(int ageAppropriate) {
    this.ageAppropriate = ageAppropriate;
  }
  /**
   * method that organizes the display of the toy on the console
   *
   * @return String
   */
  public abstract String toString();
  /**
   * method that organizes the format of the toys in the datebase
   *
   * @return String
   */
  public abstract String format();
}
