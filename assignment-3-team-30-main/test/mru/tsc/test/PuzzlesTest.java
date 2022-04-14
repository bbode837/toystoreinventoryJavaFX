package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Puzzles;
import mru.tsc.model.SerialNumber;

class PuzzlesTest {

  @Test
  void test() {

    SerialNumber sn = new SerialNumber("4345432123");
    Puzzles puzzle = new Puzzles(sn, "Rubix Cube", "Tesla", 29.99, 5, 12, "mechanical");

    assertEquals("4345432123", sn.getSN());
    assertEquals("Rubix Cube", puzzle.getName());
    assertEquals("Tesla", puzzle.getBrand());
    assertEquals(29.99, puzzle.getPrice());
    assertEquals(5, puzzle.getAvailCount());
    assertEquals(12, puzzle.getAgeAppropriate());
    assertEquals("mechanical", puzzle.getPuzzleType());
  }
}
