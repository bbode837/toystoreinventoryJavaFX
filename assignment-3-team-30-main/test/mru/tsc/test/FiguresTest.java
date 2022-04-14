package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Figures;
import mru.tsc.model.SerialNumber;

class FiguresTest {

  @Test
  void test() {
    SerialNumber sn = new SerialNumber("1345432123");
    Figures figure = new Figures(sn, "Moon", "Space Toys", 10000000, 1, 20, 'H');

    assertEquals("1345432123", sn.getSN());
    assertEquals("Moon", figure.getName());
    assertEquals("Space Toys", figure.getBrand());
    assertEquals(10000000, figure.getPrice());
    assertEquals(1, figure.getAvailCount());
    assertEquals(20, figure.getAgeAppropriate());
    assertEquals('H', figure.getClassifiction());
  }
}
