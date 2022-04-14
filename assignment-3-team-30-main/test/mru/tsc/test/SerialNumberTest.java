package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mru.tsc.model.SerialNumber;

class SerialNumberTest {

  @Test
  void test() {
    SerialNumber sn = new SerialNumber("1345432123");
    boolean flag = sn.isForFigures(sn.getSN());

    assertEquals(true, flag);

    flag = sn.isForAnimals(sn.getSN());

    assertEquals(false, flag);

    flag = sn.isForBoardGames(sn.getSN());

    assertEquals(false, flag);

    flag = sn.isForPuzzles(sn.getSN());

    assertEquals(false, flag);
  }
}
