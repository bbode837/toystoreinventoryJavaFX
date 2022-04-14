package mru.tsc.model;
/**
 * class that creates the toy boardgame
 *
 * @author Brandon and Scott
 */
public class BoardGames extends Toy {

  private String numPlayersMin;
  private String numPlayersMax;
  private String designers;
  /**
   * paramaterized constructed used to create a new boardgame toy
   *
   * @param sn , serial number
   * @param name , name
   * @param brand , brand
   * @param price , price
   * @param availCount , available count
   * @param ageAppropriate , appropriate age
   * @param numPlayers , number of players
   * @param designers , designers
   */
  public BoardGames(
      SerialNumber sn,
      String name,
      String brand,
      double price,
      int availCount,
      int ageAppropriate,
      String numPlayers,
      String designers) {
    super(sn, name, brand, price, availCount, ageAppropriate);

    String[] splitLine = numPlayers.split("-");
    this.numPlayersMin = splitLine[0];
    this.numPlayersMax = splitLine[1];

    this.designers = designers;

    setType("BoardGame");
  }
  /**
   * getter method for minimum number of players
   *
   * @return numPlayersMin , min number of players
   */
  public String getNumPlayersMin() {
    return numPlayersMin;
  }
  /**
   * setter method for minimum number of player
   *
   * @param numPlayersMin , min number of players
   */
  public void setNumPlayersMin(String numPlayersMin) {
    this.numPlayersMin = numPlayersMin;
  }
  /**
   * getter method for maximum number of players
   *
   * @return numPlayersMax , max number of players
   */
  public String getNumPlayersMax() {
    return numPlayersMax;
  }
  /**
   * setter method for maximum number of player
   *
   * @param numPlayersMax , max number of players
   */
  public void setNumPlayersMax(String numPlayersMax) {
    this.numPlayersMax = numPlayersMax;
  }
  /**
   * getter method for designers
   *
   * @return designers , designers
   */
  public String getDesigners() {
    return designers;
  }
  /**
   * setter method for designers
   *
   * @param designers , designers
   */
  public void setDesigners(String designers) {
    this.designers = designers;
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
        + ", # of Players: "
        + numPlayersMin
        + " - "
        + numPlayersMax
        + ", Designers: "
        + designers;
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
        + numPlayersMin
        + "-"
        + numPlayersMax
        + ";"
        + designers;
  }
}
