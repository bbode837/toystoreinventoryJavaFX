package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Animals;
import mru.tsc.model.SerialNumber;

class AnimalsTest {

  @Test
  void test() {
    SerialNumber sn = new SerialNumber("2345432123");
    Animals newAnimal = new Animals(sn, "Fox", "Mega Foxes", 19.99, 200, 50, "Fox Fur", 'L');

    assertEquals("2345432123", sn.getSN());
    assertEquals("Fox", newAnimal.getName());
    assertEquals("Mega Foxes", newAnimal.getBrand());
    assertEquals(19.99, newAnimal.getPrice());
    assertEquals(200, newAnimal.getAvailCount());
    assertEquals(50, newAnimal.getAgeAppropriate());
    assertEquals("Fox Fur", newAnimal.getMaterial());
    assertEquals('L', newAnimal.getSize());
  }
}
