import static org.junit.Assert.*;

import java.util.List;
import java.util.function.Function;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SorterTest {

  Sorter<Integer> sorter = new Sorter<>((a, b) -> a <= b);
  Printer<Integer> printer = new Printer<>();
  Integer[] inputArray = {7, 4, 2, 6, 1, 3, -2, 0, 8, 5, 9, 7, -3, 3, 11, 11, 4, 1, -4, 1, 13, 2, 3, 5, -1, 6, 12, 10, -5};
  Integer[] expectedRevertedArray = {-5, 10, 12, 6, -1, 5, 3, 2, 13, 1, -4, 1, 4, 11, 11, 3, -3, 7, 9, 5, 8, 0, -2, 3, 1, 6, 2, 4, 7};
  Integer[] expectedSortedArray = {-5, -4, -3, -2, -1, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 9, 10, 11, 11, 12, 13};


  @Test
  public void revertTest() {
    assertWithImplementation("Revert array Test: ", sorter::revert, expectedRevertedArray);
  }

  @Test
  public void bubbleSortTest() {
    assertWithImplementation("Bubble-Sort", sorter::bubbleSort, expectedSortedArray);
  }

  @Test
  public void selectSortTest() {
    assertWithImplementation("Select-Sort Test: ", sorter::selectSort, expectedSortedArray);
  }

  @Test
  public void insertSortTest() {
    assertWithImplementation("Insert-Sort Test: ", sorter::insertSort, expectedSortedArray);
  }


  private void assertWithImplementation(String description, Function<Integer[], Integer[]> implementation, Integer[] expected) {
    System.out.println(description);
    Integer[] actualSortedArrray = implementation.apply(inputArray);
    System.out.println("Input Array: ");
    printer.printArray(inputArray);
    System.out.println("Expected Array: ");
    printer.printArray(expected);
    System.out.println("Actual Array: ");
    printer.printArray(actualSortedArrray);
    assertArraysEqual(expected, actualSortedArrray);
    System.out.println();
    System.out.println();
  }

  private <T> void assertArraysEqual(T[] expected, T[] actual) {
    int length = expected.length;
    for (int i = 0; i < length; i++) {
      Assert.assertEquals(expected[i], actual[i]);
    }
  }


}