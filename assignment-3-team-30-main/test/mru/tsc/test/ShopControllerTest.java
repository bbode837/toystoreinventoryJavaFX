package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mru.tsc.controller.ShopController;

class ShopControllerTest {

  ShopController sc = new ShopController();

  @Test
  void test() {

    boolean exists = sc.existsInInventory("6855604945");
    assertEquals(true, exists);

    boolean exists2 = sc.existsInInventory("1111111111");

    assertEquals(false, exists2);
  }
}
