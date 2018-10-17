import java.util.function.Function;
import org.junit.Assert;
import org.junit.Test;

public class SorterTest {

  Sorter<Integer> sorter = new Sorter<>((a, b) -> a <= b);
  Printer<Integer> printer = new Printer<>();
  Integer[] inputArray = {7, 4, 2, 6, 1, 3, -2, 0, 8, 5, 9, 7, -3, 3, 11, 11, 4, 1, -4, 1, 13, 2, 3, 5, -1, 6, 12, 10, -5};
  Integer[] expectedRevertedArray = {-5, 10, 12, 6, -1, 5, 3, 2, 13, 1, -4, 1, 4, 11, 11, 3, -3, 7, 9, 5, 8, 0, -2, 3, 1, 6, 2, 4, 7};
  Integer[] expectedSortedArray = {-5, -4, -3, -2, -1, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 9, 10, 11, 11, 12, 13};


  @Test
  public void revertTest() throws Exception {
    assertWithImplementation("Revert array Test: ", sorter::revert, expectedRevertedArray);
  }

  @Test
  public void bubbleSortTest() throws Exception {
    assertWithImplementation("Bubble-Sort", sorter::bubbleSort, expectedSortedArray);
  }

  @Test
  public void selectSortTest() throws Exception {
    assertWithImplementation("Select-Sort Test: ", sorter::selectSort, expectedSortedArray);
  }

  @Test
  public void insertSortTest() throws Exception {
    assertWithImplementation("Insert-Sort Test: ", sorter::insertSort, expectedSortedArray);
  }

 // @Test
  public void quickSortTest() throws Exception {
    assertWithImplementation("Quick-Sort Test: ", sorter::quickSort, expectedSortedArray);
  }

  @Test
  public void concatenateTest() throws Exception {
    Integer[] array1 = {1,2,3};
    Integer[] array2 = {4,5,6};
    Integer[] result = {1,2,3,4,5,6};
    assertArraysEqual(result, sorter.concatenateArrays(array1,array2));
  }

  @Test
  public void lesserArrayTest() throws Exception {
    Integer[] array = {1,3,5,2,1,1,4,5,6,7,8,2,3};
    int pivot = 3;
    Integer[] expectedLowerArray = {1,2,1,1,2};
    assertArraysEqual(expectedLowerArray, sorter.lesserPart(array,pivot));
  }

  @Test
  public void greaterArrayTest() throws Exception {
    Integer[] array = {1,3,5,2,1,1,4,5,6,7,8,2,3};
    int pivot = 3;
    Integer[] expectedUpperArray = {5,4,5,6,7,8};
    assertArraysEqual(expectedUpperArray,sorter.greaterPart(array,pivot));
  }

  @Test
  public void equalArrayTest() throws Exception{
    Integer[] array = {1,3,5,2,1,1,4,5,6,7,8,2,3};
    int pivot = 3;
    Integer[] expectedEqualArray = {3,3};
    assertArraysEqual(expectedEqualArray,sorter.equalPart(array,pivot));
  }


  private void assertWithImplementation(String description, Function<Integer[], Integer[]> implementation, Integer[] expected) throws Exception {
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

  private <T> void assertArraysEqual(T[] expected, T[] actual) throws Exception {
    if(expected.length != actual.length) throw new Exception("Compared arrays do not have the same size");
    int length = expected.length;
    for (int i = 0; i < length; i++) {
      Assert.assertEquals(expected[i], actual[i]);
    }
  }


}