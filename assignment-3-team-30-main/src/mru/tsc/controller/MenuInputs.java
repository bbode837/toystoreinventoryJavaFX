package mru.tsc.controller;

import javax.swing.JOptionPane;

import mru.tsc.exceptions.negativePriceException;
import mru.tsc.exceptions.snDigitException;

/**
 * Class that deals with all of the user input
 *
 * @author Brandon and Scott
 */
public class MenuInputs {

  /**
   * method that takes in the input to validate that its a proper serial number
   *
   * @param inp , input form the user
   * @return flag , returns true if the input was 10 integers long
   * @throws snDigitException , throws when input is not equal to 10
   */
  public boolean validateSN(String inp) throws snDigitException {

    long num;
    boolean flag = true;

    if (inp.equals("")) {
      flag = false;
      JOptionPane.showMessageDialog(null, "Serial Number cannot be blank.");
    } else {
      num = Long.parseLong(inp);
    }

    if (inp.length() != 10) {
      flag = false;
      throw new snDigitException();
    }
    return flag;
  }

  /**
   * validates the price
   *
   * @param price String pric
   * @return flag
   */
  public boolean validatePrice(String price) {
    boolean flag = false;
    try {
      flag = validateToyPrice(price);
    } catch (negativePriceException e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }

    return flag;
  }

  /**
   * Validates the brand
   *
   * @param brand text being validated
   */
  public void validateBrand(String brand) {
    if (brand.equals("")) {

      JOptionPane.showMessageDialog(null, "Your toy must have a brand name. Try again.");
    }
  }

  /**
   * validates the name
   *
   * @param name text being validated
   */
  public void validateName(String name) {
    if (name.equals("")) {
      JOptionPane.showMessageDialog(null, "Your toy must have a name. Try again.");
    }
  }

  /**
   * method that validates the toy price, to make sure its a positive integer
   *
   * @param price , input form user
   * @return flag , returns true if the number recieved is positive and an integer
   * @throws negativePriceException , thrown if the input is a negative number
   */
  public boolean validateToyPrice(String price) throws negativePriceException {

    boolean flag = false;

    if (price.equals("")) {
      JOptionPane.showMessageDialog(null, "Price cannot be blank.");
    } else {
      try {
        double newPrice = Double.parseDouble(price);
        flag = true;
        if (newPrice < 0) {
          throw new negativePriceException();
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
      }
    }

    return flag;
  }

  /**
   * method that validates the available count to be positive
   *
   * @param inp , input from the user
   * @return boo , returns true if the input is positive and an integer
   */
  public int validateAvailCount(String inp) {
    int nmb = 0;

    if (inp.equals("")) {
      JOptionPane.showMessageDialog(null, "Available-count cannot be blank.");
    }

    try {
      nmb = Integer.parseInt(inp);
      if (nmb < 0) {
        JOptionPane.showMessageDialog(null, "The available count cannot be negative! Try again.");
      }
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "Available count needs to be an Integer! Try again.");
    }

    return nmb;
  }
  /**
   * method that validates the age to be positive
   *
   * @param inp , input from the user
   * @return boo , returns true if the input is positive and an integer
   */
  public int validateAge(String inp) {
    int nmb = 0;

    if (inp.equals("")) {
      JOptionPane.showMessageDialog(null, "Age cannot be blank.");
    }

    try {
      nmb = Integer.parseInt(inp);
      if (nmb < 0) {
        JOptionPane.showMessageDialog(null, "The age cannot be negative");
      }
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "Age needs to be an Integer! Try again.");
    }

    return nmb;
  }
  /**
   * method that validates if the figure class is an option
   *
   * @param inp , user input
   * @return boo , returns true if the input matches one of the classifications
   */
  public boolean validateFigureClass(String inp) {
    String cls;

    boolean boo = false;

    cls = inp.toUpperCase();

    if (cls.equals("ACTION") || cls.equals("DOLL") || cls.equals("HISTORIC")) {

      boo = true;
    } else if (inp.equals("")) {
      JOptionPane.showMessageDialog(null, "Classification cannot be blank");
    } else {
      JOptionPane.showMessageDialog(
          null, "This is not a classifcation option (Action, Doll, Historic) please try again.");
    }

    return boo;
  }
  /**
   * method that validates if the size is an available option
   *
   * @param size , user input
   * @return boo , returns true if the input matches one of the size options
   */
  public boolean validateSize(String size) {
    char c;
    boolean boo = false;

    if (size.equals("SMALL") || size.equals("MEDIUM") || size.equals("LARGE")) {
      c = size.toUpperCase().charAt(0);
      boo = true;
    } else if (size.equals("")) {
      JOptionPane.showInternalMessageDialog(null, "Size cannot be blank");
    } else {
      JOptionPane.showMessageDialog(
          null, "That is not a size option (Small, Medium, Large) please try again.");
    }

    return boo;
  }

  /**
   * validate the material
   *
   * @param material text being validated
   * @return boolean if validated
   */
  public boolean validateMaterial(String material) {
    boolean flag = true;

    if (material.equals("")) {
      JOptionPane.showMessageDialog(null, "Material cannot be blank");
      flag = false;
    }

    return flag;
  }

  /**
   * method that validates if the type of puzzle game is an availabel option
   *
   * @param inp , input from the user
   * @return boo , returns true if the input matches one of the type options
   */
  public boolean validatePuzzleType(String inp) {
    String type;
    boolean boo = false;

    type = inp.toLowerCase();

    if (type.equals("mechanical")
        || type.equals("cryptic")
        || type.equals("logic")
        || type.equals("trivia")
        || type.equals("riddle")) {
      boo = true;
    } else if (inp.equals("")) {
      JOptionPane.showMessageDialog(null, "Type cannot be blank");
    } else {
      JOptionPane.showMessageDialog(
          null,
          "This is not a valid puzzle type (Mechanical, Cryptic, Logic, Trivia, Riddle) please try again.");
    }

    return boo;
  }
  /**
   * method that validates that the min number of payers is less than the max number of players
   *
   * @param min , minimum number of players inputted
   * @param max , maximum number of players inputted
   * @return boo , returns true if the min number of players is less than the max number of players
   *     that the inputs are an integer
   */
  public boolean validateNumPlayers(String min, String max) {
    boolean boo = false;
    int mn;
    int mx;

    try {
      mn = Integer.parseInt(min);
      mx = Integer.parseInt(max);
      if (mn > mx) {
        JOptionPane.showMessageDialog(
            null,
            "The minimum number of players cannot exceed the maximum number of players. Try again");
      } else {
        boo = true;
      }
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "This is not an Integer Number! Try again.");
    }
    return boo;
  }
}
