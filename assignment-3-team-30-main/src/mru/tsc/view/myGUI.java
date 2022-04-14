package mru.tsc.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mru.tsc.controller.Logging;
import mru.tsc.controller.MenuInputs;
import mru.tsc.controller.ShopController;
import mru.tsc.exceptions.snDigitException;
import mru.tsc.model.Animals;
import mru.tsc.model.BoardGames;
import mru.tsc.model.Figures;
import mru.tsc.model.Puzzles;
import mru.tsc.model.SerialNumber;
import mru.tsc.model.Toy;

/** @author Scott and Brandon */
public class myGUI extends ShopController {

  @FXML private RadioButton snRDButton;
  @FXML private RadioButton nameRDButton;
  @FXML private RadioButton typeRDButton;
  @FXML private TextField snTextField;
  @FXML private TextField nameTextField;
  @FXML private TextField typeTextField;
  @FXML private Button searchButton;
  @FXML private Button closeButton;
  @FXML private Button saveButton;
  @FXML private Button buyButton;
  @FXML private ListView<Toy> searchListView;
  @FXML private ListView<Toy> removeToyListView;
  @FXML private TextField snTextFieldAddToy;
  @FXML private TextField nameTextFieldAddToy;
  @FXML private TextField brandTextFieldAddToy;
  @FXML private TextField priceTextFieldAddToy;
  @FXML private TextField countTextFieldAddToy;
  @FXML private TextField ageTextFieldAddToy;
  @FXML private TextField typeTextFieldAddToy;
  @FXML private TextField minPlayersTextFieldAddToy;
  @FXML private TextField maxPlayersTextFieldAddToy;
  @FXML private TextField designersTextFieldAddToy;
  @FXML private TextField classificationTextFieldAddToy;
  @FXML private TextField materialTextFieldAddToy;
  @FXML private TextField sizeTextFieldAddToy;
  @FXML private TextField snTextFieldRemoveToy;
  @FXML private Button removeButton;
  @FXML private ComboBox<String> categoryBox;
  @FXML private Label snLabel;
  @FXML private Label nameLabel;
  @FXML private Label typeLabel;

  MenuInputs m = new MenuInputs();
  SerialNumber sn = new SerialNumber();
  Logging logger = new Logging();

  @FXML
  ObservableList<String> categoryList =
      FXCollections.observableArrayList("Puzzle", "Board Game", "Animal", "Figure");

  /** myGUI no arg constructor */
  public myGUI() {}

  /**
   * myGUI constructor
   *
   * @param primaryStage primary stage
   */
  public myGUI(Stage primaryStage) {
    try {

      logger.setInfoMessage("Setting GUI");
      Parent root = FXMLLoader.load(getClass().getResource("myGUI.fxml"));
      Scene scene = new Scene(root, 1100, 700);

      primaryStage.setScene(scene);
      primaryStage.show();

      logger.setInfoMessage("GUI Set");

    } catch (Exception e) {
      e.printStackTrace();
      logger.setWarningMessage(e.getMessage());
    }
  }

  /** initialize method sets values to the comboBox and adds radio buttons to ToggleGroup */
  @FXML
  private void initialize() {
    categoryBox.setValue("");
    categoryBox.setItems(categoryList);

    ToggleGroup rdGroup = new ToggleGroup();
    snRDButton.setToggleGroup(rdGroup);
    nameRDButton.setToggleGroup(rdGroup);
    typeRDButton.setToggleGroup(rdGroup);
  }

  /**
   * radio button event handler changes the text color of labels to the radio button selected
   *
   * @param event radio button clicked
   */
  @FXML
  void radioBTNHandler(ActionEvent event) {

    if (snRDButton.isSelected()) {
      snLabel.setTextFill(Color.RED);
      nameLabel.setTextFill(Color.GRAY);
      typeLabel.setTextFill(Color.GRAY);
    } else if (nameRDButton.isSelected()) {
      nameLabel.setTextFill(Color.RED);
      snLabel.setTextFill(Color.GRAY);
      typeLabel.setTextFill(Color.GRAY);
    } else if (typeRDButton.isSelected()) {
      typeLabel.setTextFill(Color.RED);
      snLabel.setTextFill(Color.GRAY);
      nameLabel.setTextFill(Color.GRAY);
    }
  }

  /**
   * serach button handler searches for a toy based on SerialNumber, Name or Type
   *
   * @param event serach button clicked
   */
  @FXML
  void searchBTNHandler(ActionEvent event) {
    ArrayList<Toy> foundToys = null;
    searchListView.getItems().clear();

    if (snRDButton.isSelected()) {
      String snNumber = snTextField.getText().toString();
      foundToys = new ArrayList<>();

      boolean snFlag = false;
      try {
        snFlag = m.validateSN(snNumber);
      } catch (snDigitException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please enter a number");
      }

      if (snFlag) {
        foundToys = searchBySN(snNumber);
      }

      printIfFound(foundToys);
    } else if (nameRDButton.isSelected()) {
      String name = nameTextField.getText().toString();
      foundToys = new ArrayList<>();

      foundToys = searchByName(name);

      printIfFound(foundToys);
    } else if (typeRDButton.isSelected()) {
      String type = typeTextField.getText().toString();
      foundToys = new ArrayList<>();

      foundToys = searchByType(type);

      printIfFound(foundToys);
    }
  }

  /**
   * works with search button handler prints list of toys that match the search query
   *
   * @param foundToys list of toys that match the search
   */
  public void printIfFound(ArrayList<Toy> foundToys) {

    if (foundToys.isEmpty()) {
      JOptionPane.showMessageDialog(null, "That item was not found.");
    } else {
      ObservableList<Toy> toys = FXCollections.observableArrayList(foundToys);
      searchListView.getItems().addAll(toys);
    }
  }

  /**
   * close button handler saves edits made to inventory to a database and closes the main window
   *
   * @param event close button clicked
   */
  @FXML
  void closeBTNHandler(ActionEvent event) {
    try {
      saveAndExit();
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "The file does not exist");
      logger.setWarningMessage("The file doesn't exits. Could not save");
    }
  }

  /**
   * buy button event handler selected toy's available count is decremented by 1
   *
   * @param event buy button clicked
   */
  @FXML
  void buyBtnHandler(ActionEvent event) {

    Toy boughtToy = searchListView.getSelectionModel().getSelectedItem();

    if (boughtToy != null) {
      purchaseToy(boughtToy);
    }
  }

  /**
   * remove toy event handler Removes a toy based on serial number
   *
   * @param event remove button clicked
   */
  @FXML
  void removeBtnHandler(ActionEvent event) {
    ArrayList<Toy> foundToys = null;
    removeToyListView.getItems().clear();

    String SN = snTextFieldRemoveToy.getText().toString();

    boolean snFlag = false;

    if (!snTextFieldRemoveToy.getText().toString().equals("")) {

      try {
        snFlag = m.validateSN(SN);
      } catch (snDigitException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please enter a serial number");
      }

      boolean snExists = searchforExistingSN(SN);

      if (snFlag && snExists) {
        SerialNumber removeThisToy = new SerialNumber(SN);
        foundToys = searchBySN(removeThisToy.getSN());
        ObservableList toys = FXCollections.observableArrayList(foundToys);
        removeToyListView.getItems().addAll(toys);
        removeToy(removeThisToy);
      } else {
        JOptionPane.showMessageDialog(null, "That serial number does not exist.");
      }
    }
  }

  /**
   * save button event handler Gathers relevant information from appropriate text fields, creates a
   * new toy and adds it into inventory
   *
   * @param event save button clicked
   */
  @FXML
  void saveBtnHandler(ActionEvent event) {

    String newToyType = categoryBox.getValue();

    if (newToyType.equals("")) {
      JOptionPane.showMessageDialog(null, "Please select a category");
    } else {

      String SN = snTextFieldAddToy.getText().toString();

      boolean snFlag = false;
      boolean snExists = searchforExistingSN(SN);
      boolean snConditions = false;

      try {
        snFlag = m.validateSN(SN);
      } catch (snDigitException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
      }

      SerialNumber newSN = null;
      if (snFlag && !snExists) {
        newSN = new SerialNumber(SN);
        snConditions = true;
      } else if (snExists) {
        JOptionPane.showMessageDialog(
            null, "A Toy With That Serial Number Already Exists, Try Again.");
      }

      String newName = nameTextFieldAddToy.getText().toString();
      m.validateName(newName);

      String newBrand = brandTextFieldAddToy.getText().toString();
      m.validateBrand(newBrand);

      String price = priceTextFieldAddToy.getText().toString();
      boolean flag1 = m.validatePrice(price);

      Double newPrice = null;

      if (flag1) {
        newPrice = Double.parseDouble(price);
      }

      String count = countTextFieldAddToy.getText().toString();
      int newCount = m.validateAvailCount(count);

      String age = ageTextFieldAddToy.getText().toString();
      int newAge = m.validateAge(age);

      if (newToyType.equals("Puzzle") && snConditions) {
        addNewPuzzle(SN, newSN, newName, newBrand, newPrice, newCount, newAge);

      } else if (newToyType.equals("Board Game") && snConditions) {
        addNewBoardGame(SN, newSN, newName, newBrand, newPrice, newCount, newAge);

      } else if (newToyType.equals("Animal") && snConditions) {
        addNewAnimal(SN, newSN, newName, newBrand, newPrice, newCount, newAge);

      } else if (newToyType.equals("Figure") && snConditions) {
        addNewFigure(SN, newSN, newName, newBrand, newPrice, newCount, newAge);
      }
    }
  }

  /**
   * works with saveBTNHandler creates a new Figure and adds it to inventory
   *
   * @param SN String serial number
   * @param newSN SerialNumber serial number
   * @param newName String new name
   * @param newBrand String new brand
   * @param newPrice Double new price
   * @param newCount Integer new avialable count
   * @param newAge Integer new age
   */
  public void addNewFigure(
      String SN,
      SerialNumber newSN,
      String newName,
      String newBrand,
      Double newPrice,
      int newCount,
      int newAge) {
    String classification = classificationTextFieldAddToy.getText().toString();

    boolean flagFigure1 = m.validateFigureClass(classification);
    boolean flagFigure2 = sn.isForFigures(SN);

    if (flagFigure1 && flagFigure2) {
      char newClassification = classification.toUpperCase().charAt(0);

      Figures newFigure =
          new Figures(newSN, newName, newBrand, newPrice, newCount, newAge, newClassification);

      addToy(newFigure);

      JOptionPane.showMessageDialog(null, "Toy Added!");
      logger.setInfoMessage("New figure added");
    } else if (!flagFigure2) {
      JOptionPane.showMessageDialog(null, "Figure serial numbers must start with 0 or 1");
    }
  }

  /**
   * works with saveBTNHandler creates a new Animal and adds it to inventory
   *
   * @param SN String serial number
   * @param newSN SerialNumber serial number
   * @param newName String new name
   * @param newBrand String new brand
   * @param newPrice Double new price
   * @param newCount Integer new avialable count
   * @param newAge Integer new age
   */
  public void addNewAnimal(
      String SN,
      SerialNumber newSN,
      String newName,
      String newBrand,
      Double newPrice,
      int newCount,
      int newAge) {
    String material = materialTextFieldAddToy.getText().toString();
    String size = sizeTextFieldAddToy.getText().toString();
    boolean flagAnimal1 = m.validateSize(size);
    boolean flagAnimal2 = sn.isForAnimals(SN);
    boolean flagAnimal3 = m.validateMaterial(material);

    if (flagAnimal1 && flagAnimal2 && flagAnimal3) {
      char newSize = size.toUpperCase().charAt(0);
      Animals newAnimal =
          new Animals(newSN, newName, newBrand, newPrice, newCount, newAge, material, newSize);

      addToy(newAnimal);
      JOptionPane.showMessageDialog(null, "Toy Added!");
      logger.setInfoMessage("New animal added");
    } else if (!flagAnimal2) {
      JOptionPane.showMessageDialog(null, "Animal serial numbers must start with 2 or 3");
    }
  }

  /**
   * works with saveBTNHandler creates a new Board Game and adds it to inventory
   *
   * @param SN String serial number
   * @param newSN SerialNumber serial number
   * @param newName String new name
   * @param newBrand String new brand
   * @param newPrice Double new price
   * @param newCount Integer new avialable count
   * @param newAge Integer new age
   */
  public void addNewBoardGame(
      String SN,
      SerialNumber newSN,
      String newName,
      String newBrand,
      Double newPrice,
      int newCount,
      int newAge) {
    String minNum = minPlayersTextFieldAddToy.getText().toString();
    String maxNum = maxPlayersTextFieldAddToy.getText().toString();
    String numPlayers = minNum + "-" + maxNum;
    String designers = designersTextFieldAddToy.getText().toString();

    boolean flagBoardGame1 = m.validateNumPlayers(minNum, maxNum);
    boolean flagBoardGame2 = sn.isForBoardGames(SN);

    if (flagBoardGame1 && flagBoardGame2) {
      BoardGames newBoardGame =
          new BoardGames(
              newSN, newName, newBrand, newPrice, newCount, newAge, numPlayers, designers);
      addToy(newBoardGame);
      JOptionPane.showMessageDialog(null, "Toy Added!");
      logger.setInfoMessage("New board game added");
    } else if (!flagBoardGame2) {
      JOptionPane.showMessageDialog(null, "Board Game serial numbers must start with 7, 8 or 9");
    }
  }

  /**
   * works with saveBTNHandler creates a new Puzzle and adds it to inventory
   *
   * @param SN String serial number
   * @param newSN SerialNumber serial number
   * @param newName String new name
   * @param newBrand String new brand
   * @param newPrice Double new price
   * @param newCount Integer new avialable count
   * @param newAge Integer new age
   */
  public void addNewPuzzle(
      String SN,
      SerialNumber newSN,
      String newName,
      String newBrand,
      Double newPrice,
      int newCount,
      int newAge) {
    String newType = typeTextFieldAddToy.getText().toString();

    boolean flagPuzzle1 = m.validatePuzzleType(newType);
    boolean flagPuzzle2 = sn.isForPuzzles(SN);

    if (flagPuzzle1 && flagPuzzle2) {
      Puzzles newPuzzle =
          new Puzzles(newSN, newName, newBrand, newPrice, newCount, newAge, newType);
      addToy(newPuzzle);
      JOptionPane.showMessageDialog(null, "Toy Added!");
      logger.setInfoMessage("New puzzle added");
    } else if (!flagPuzzle2) {
      JOptionPane.showMessageDialog(null, "Puzzle serial numbers must start with 4, 5, or 6");
    }
  }
}
