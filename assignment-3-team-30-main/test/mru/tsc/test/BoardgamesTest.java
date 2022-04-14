package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mru.tsc.model.BoardGames;
import mru.tsc.model.SerialNumber;

class BoardgamesTest {

  @Test
  void test() {
    SerialNumber sn = new SerialNumber("8765434567");
    BoardGames bg = new BoardGames(sn, "Clue", "Matel", 100.50, 2, 10, "2-4", "Scott Charles");

    assertEquals("8765434567", sn.getSN());
    assertEquals("Clue", bg.getName());
    assertEquals("Matel", bg.getBrand());
    assertEquals(100.50, bg.getPrice());
    assertEquals(2, bg.getAvailCount());
    assertEquals(10, bg.getAgeAppropriate());

    String minPlayers = bg.getNumPlayersMin();
    assertEquals("2", minPlayers);
    String maxPlayers = bg.getNumPlayersMax();
    assertEquals("4", maxPlayers);
    assertEquals("2-4", bg.getNumPlayersMin() + "-" + bg.getNumPlayersMax());
  }
}
