package mru.tsc.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import mru.tsc.controller.Logging;
import mru.tsc.controller.MenuInputs;
/**
 * class that creates the inventory for the store
 *
 * @author Brandon and Scott
 */
public class Inventory {

  ArrayList<Toy> inventory = new ArrayList<>();
  ArrayList<Toy> foundT;
  private int escapeInt;
  MenuInputs inputs = new MenuInputs();
  Logging logger = new Logging();
  /** constructor used to create a new inventory */
  public Inventory() {}

  /**
   * getter method for toys arraylist
   *
   * @return inventory , the inventory of the store
   */
  public ArrayList<Toy> getInventory() {
    return inventory;
  }
  /**
   * method that adds a toy to the inventory
   *
   * @param t , toy being added
   */
  public void addToy(Toy t) {
    inventory.add(t);
  }

  /**
   * method that searches the inventory for a serial number match
   *
   * @param sn , serial number inputted
   * @return condition , returns true if toys match the inputted serial number
   */
  public ArrayList<Toy> searchInventory(SerialNumber sn) {

    foundT = new ArrayList<Toy>();

    logger.setInfoMessage("Searching by Serial Number");
    for (Toy t : inventory) {
      if (t.getSn().getSN().equals(sn.getSN())) {
        foundT.add(t);
      }
    }
    logger.setInfoMessage("Serial number search complete");
    return foundT;
  }

  /**
   * This method checks if the Serial Number already exists in the DataBase
   *
   * @param sn SerialNumber entered by the user
   * @return flag returns false if already in the system
   */
  public boolean searchforExistingSN(String sn) {
    boolean exists = false;

    for (Toy t : inventory) {
      if (t.getSn().getSN().equals(sn)) {
        exists = true;
      }
    }
    return exists;
  }

  /**
   * getter method to return index number for removal
   *
   * @param sn , serial number
   * @return ndx , index number
   */
  public int getIndexNumber(SerialNumber sn) {

    foundT = new ArrayList<Toy>();
    int ndx = -1;
    for (Toy t : inventory) {
      ndx++;
      if (t.getSn().getSN().equals(sn.getSN())) {
        foundT.add(t);
        break;
      }
    }

    return ndx;
  }
  /**
   * method that searches inventory by type
   *
   * @param input , type of toy
   * @return condition , returns true if toys match the inputted type
   */
  public ArrayList<Toy> searchInventoryByName(String input) {

    String searchInput = modifySearchInput(input);
    System.out.println(inventory.toString());
    foundT = new ArrayList<Toy>();
    logger.setInfoMessage("Searching by name");
    for (Toy t : inventory) {
      if (t.getName().contains(searchInput)) {
        foundT.add(t);
      }
    }
    logger.setInfoMessage("Search by name complete");
    return foundT;
  }

  /**
   * Searches the inventory by Type
   *
   * @param input type provided by the user
   * @return condition returns true if found
   */
  public ArrayList<Toy> searchInventoryByType(String input) {

    String searchInput = modifySearchInput(input);

    foundT = new ArrayList<Toy>();
    logger.setInfoMessage("Searching by type");
    for (Toy t : inventory) {
      if (t.getType().equals(searchInput)) {
        foundT.add(t);
      }
    }
    logger.setInfoMessage("Search by type complete");
    return foundT;
  }

  /**
   * Modifies the search input provided by the user
   *
   * @param input search input provided by the user
   * @return searchInput the modified version of the user input
   */
  public String modifySearchInput(String input) {
    String searchInput;
    if (input.equalsIgnoreCase("boardgame")) {
      searchInput = "BoardGame";
    } else {
      char firstLetter = input.toUpperCase().charAt(0);
      String subString = input.substring(1);

      searchInput = firstLetter + subString;
    }
    return searchInput;
  }
  /**
   * method that purchases the toy and removes one from the availble count
   *
   * @param boughtToy the choice of toy that wants to be purchased
   */
  public void purchaseToy(Toy boughtToy) {

    if (boughtToy.getAvailCount() > 0) {
      boughtToy.setAvailCount(boughtToy.getAvailCount() - 1);
      JOptionPane.showMessageDialog(null, "Successfully Purchased");
    } else {
      JOptionPane.showMessageDialog(null, "That toy is out of stock.");
      logger.setWarningMessage("Toy is out of stock");
    }
  }

  /**
   * method that removes a toy from the database
   *
   * @param sn , serial number that is inputted by user
   */
  public void removeToy(SerialNumber sn) {
    int ndx = getIndexNumber(sn);
    inventory.remove(ndx);
    JOptionPane.showMessageDialog(null, "Toy Removed");
    logger.setInfoMessage("Toy Removed");
  }
}
