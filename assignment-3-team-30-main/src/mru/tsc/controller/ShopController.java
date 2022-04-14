package mru.tsc.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import mru.tsc.exceptions.snDigitException;
import mru.tsc.model.Animals;
import mru.tsc.model.BoardGames;
import mru.tsc.model.Figures;
import mru.tsc.model.Inventory;
import mru.tsc.model.Puzzles;
import mru.tsc.model.SerialNumber;
import mru.tsc.model.Toy;

/**
 * Shop Controller Class Accepts user input and interacts between Model and View
 *
 * @author Scott and Brandon
 */
public class ShopController extends Inventory {
  MenuInputs m = new MenuInputs();
  Scanner kb = new Scanner(System.in);
  Logging logger = new Logging();
  private SerialNumber sn;

  public ShopController() {
    readFile();
  }

  /**
   * searches for an existing serial number
   *
   * @param sn serial number
   * @return exists boolean if found
   */
  public boolean existsInInventory(String sn) {
    boolean exists;

    exists = searchforExistingSN(sn);

    return exists;
  }

  /**
   * saveAndExit executes the save() method and exits the program
   *
   * @throws IOException exceptions for File I/O
   */
  public void saveAndExit() throws IOException {
    save();
    System.exit(0);
  }

  /**
   * Searches the inventory array list by Type provided by the user
   *
   * @param input type provided by user
   * @return fountT list of found Toys
   */
  public ArrayList<Toy> searchByType(String input) {

    ArrayList<Toy> foundT = null;

    if (input.equals("")) {
      JOptionPane.showMessageDialog(null, "Not a valid type");
    } else {
      foundT = searchInventoryByType(input);
    }

    return foundT;
  }
  /**
   * Searches the inventory array list by Name provided by the user
   *
   * @param input name provided by user
   * @return foundT list of found Toys
   */
  public ArrayList<Toy> searchByName(String input) {
    ArrayList<Toy> foundT = null;

    if (input.equals("")) {
      JOptionPane.showMessageDialog(null, "Not a valid name.");
    } else {
      foundT = searchInventoryByName(input);
    }

    return foundT;
  }

  /**
   * searches the inventory arraylist by Serial Number provided by the user
   *
   * @param input serial number provided by user
   * @return foundT list of found Toys
   */
  public ArrayList<Toy> searchBySN(String input) {

    ArrayList<Toy> foundToys = null;

    try {
      m.validateSN(input);
      sn = new SerialNumber(input);
      foundToys = searchInventory(sn);
    } catch (snDigitException e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }

    return foundToys;
  }

  /** Reads the toys.txt into the inventory array list */
  public void readFile() {

    String sn;
    String currentLine;
    String[] splittedLine;
    Scanner fileReader;

    try {

      File myObj = new File("res/toys.txt");
      fileReader = new Scanner(myObj);
      while (fileReader.hasNextLine()) {
        currentLine = fileReader.nextLine();
        splittedLine = currentLine.split(";");
        sn = splittedLine[0];
        SerialNumber s = new SerialNumber(sn);

        if (s.isForFigures(sn)) {
          addFigure(splittedLine, s);
        } else if (s.isForAnimals(sn)) {
          addAnimal(splittedLine, s);
        } else if (s.isForBoardGames(sn)) {
          addBoardGame(splittedLine, s);
        } else if (s.isForPuzzles(sn)) {
          addPuzzle(splittedLine, s);
        }
      }
    } catch (FileNotFoundException e) {
      logger.setWarningMessage("File not found!");
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
  }

  /**
   * if the toy from readFile is a puzzle, this method constructs a puzzle
   *
   * @param splittedLine toy information for Puzzles constructor
   * @param s serial number
   */
  public void addPuzzle(String[] splittedLine, SerialNumber s) {
    Puzzles p =
        new Puzzles(
            s,
            splittedLine[1],
            splittedLine[2],
            Double.parseDouble(splittedLine[3]),
            Integer.parseInt(splittedLine[4]),
            Integer.parseInt(splittedLine[5]),
            splittedLine[6]);
    addToy(p);
  }

  /**
   * if the toy from readFile is a BoardGame, this method constructs a BoardGame
   *
   * @param splittedLine toy information for BoardGames constructor
   * @param s Serial Number
   */
  public void addBoardGame(String[] splittedLine, SerialNumber s) {
    BoardGames b =
        new BoardGames(
            s,
            splittedLine[1],
            splittedLine[2],
            Double.parseDouble(splittedLine[3]),
            Integer.parseInt(splittedLine[4]),
            Integer.parseInt(splittedLine[5]),
            splittedLine[6],
            splittedLine[7]);
    addToy(b);
  }

  /**
   * if the toy from readFile is an animal, this method constructs an animal
   *
   * @param splittedLine toy information for Animals constructor
   * @param s Serial Number
   */
  public void addAnimal(String[] splittedLine, SerialNumber s) {
    Animals a =
        new Animals(
            s,
            splittedLine[1],
            splittedLine[2],
            Double.parseDouble(splittedLine[3]),
            Integer.parseInt(splittedLine[4]),
            Integer.parseInt(splittedLine[5]),
            splittedLine[6],
            splittedLine[7].charAt(0));
    addToy(a);
  }

  /**
   * if the toy from readFile is a Figure, this method constructs a Figure
   *
   * @param splittedLine toy information for Figure constructor
   * @param s Serial Number
   */
  public void addFigure(String[] splittedLine, SerialNumber s) {
    Figures f =
        new Figures(
            s,
            splittedLine[1],
            splittedLine[2],
            Double.parseDouble(splittedLine[3]),
            Integer.parseInt(splittedLine[4]),
            Integer.parseInt(splittedLine[5]),
            splittedLine[6].charAt(0));
    addToy(f);
  }

  /**
   * Formats and Saves the Inventory array list to toys.txt file
   *
   * @throws IOException exceptions for File I/O
   */
  private void save() throws IOException {

    logger.setInfoMessage("Saving");
    File db = new File("res/toys.txt");
    PrintWriter pw = new PrintWriter(db);
    for (Toy t : getInventory()) {
      pw.println(t.format());
    }
    logger.setInfoMessage("Save Successful!");
    pw.close();
  }
}
