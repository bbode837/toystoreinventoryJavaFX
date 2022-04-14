package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Animals;
import mru.tsc.model.Figures;
import mru.tsc.model.Inventory;
import mru.tsc.model.SerialNumber;

class InventroyTest {

  Inventory inventory = new Inventory();

  @Test
  void test() {
    SerialNumber sn = new SerialNumber("1345432123");
    Figures figure = new Figures(sn, "Moon", "Space Toys", 10000000, 1, 20, 'H');

    SerialNumber sn2 = new SerialNumber("2345432123");
    Animals newAnimal = new Animals(sn2, "Fox", "Mega Foxes", 19.99, 200, 50, "Fox Fur", 'L');

    inventory.addToy(figure);
    inventory.addToy(newAnimal);

    int temp = inventory.getIndexNumber(sn2);

    assertEquals(1, temp);
  }

  @Test
  void removeTest() {

    SerialNumber sn = new SerialNumber("1345432124");
    Figures figure = new Figures(sn, "Moon", "Space Toys", 10000000, 1, 20, 'H');

    SerialNumber sn2 = new SerialNumber("2345432124");
    Animals newAnimal = new Animals(sn2, "Fox", "Mega Foxes", 19.99, 200, 50, "Fox Fur", 'L');

    inventory.addToy(figure);
    inventory.addToy(newAnimal);

    assertEquals(2, inventory.getInventory().size());

    inventory.removeToy(figure.getSn());

    assertEquals(1, inventory.getInventory().size());
  }

  @Test
  void testSearchforExistingSN() {

    SerialNumber sn = new SerialNumber("1345432125");
    Figures figure = new Figures(sn, "Moon", "Space Toys", 10000000, 1, 20, 'H');

    SerialNumber sn2 = new SerialNumber("2345432125");
    Animals newAnimal = new Animals(sn2, "Fox", "Mega Foxes", 19.99, 200, 50, "Fox Fur", 'L');

    inventory.addToy(figure);
    inventory.addToy(newAnimal);

    boolean exists = inventory.searchforExistingSN("1345432125");

    assertEquals(true, exists);
  }
}
