package lab2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class DynamicArrayTests {
  private DynamicArray array;

  @BeforeEach
  void init() {
    array = new DynamicArray();
  }

  void populate() {
    array.add(4);
    array.add(5);
    array.add(6);
  }

  @Test
  @DisplayName("Add elements in DynamicArray")
  void testAdd() {
    assertEquals(array.size(), 0);
    assertTrue(array.isEmpty());
    array.clear();
    assertEquals(array.size(), 0);
    assertTrue(array.isEmpty());
    populate();
    assertEquals(array.toString(),"4, 5, 6");
  }

  void testArrayContent(int size, String content) {
    assertEquals(array.toString(), content);
    assertEquals(array.size(), size);
    assertEquals(array.isEmpty(), size == 0);
  }

  @Test
  @DisplayName("Add and remove elements in DynamicArray")
  void testRemove() {
    populate();
    array.remove(1);
    testArrayContent(2, "4, 6");
    array.remove(1);
    testArrayContent(1, "4");
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.remove(1));
    array.remove(0);
    testArrayContent(0, "");
  }
}