import static org.junit.Assert.*;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SorterTest {
  Sorter<Integer> sorter = new Sorter<>((a,b) -> a<=b);
  Printer<Integer> printer = new Printer<>();
  Integer[] inputArray = {7, 4 ,2, 6, 1, 3, 0, 8, 5, 9,7,3,11,11,4,1,1,13,2,3,5,6, 12, 10};
  Integer[] expectedRevertedArray = {10, 12, 6,5,3,2,13,1,1,4,11,11,3,7,9, 5, 8, 0, 3, 1, 6, 2, 4, 7};
  Integer[] expectedSortedArray = {0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 9, 10, 11,11, 12, 13};




  @Test
  public void revertTest(){
    System.out.println("Array revert test: ");
    Integer[] actualRevertedArrray = sorter.revert(inputArray);
    System.out.println("Input Array: ");
    printer.printArray(inputArray);
    System.out.println("Output Array: ");
    printer.printArray(actualRevertedArrray);
    assertArraysEqual(expectedRevertedArray, actualRevertedArrray);
    System.out.println();
    System.out.println();
  }

  @Test
  public void bubbleSortTest(){
    System.out.println("Bubble sort test: ");
    Integer[] actualSortedArrray = sorter.bubbleSort(inputArray);
    System.out.println("Input Array: ");
    printer.printArray(inputArray);
    System.out.println("Output Array: ");
    printer.printArray(actualSortedArrray);
    assertArraysEqual(expectedSortedArray, actualSortedArrray);
    System.out.println();
    System.out.println();
  }

  @Test
  public void selectSortTest(){
    System.out.println("Select sort test: ");
    Integer[] actualSortedArrray = sorter.selectSort(inputArray);
    System.out.println("Input Array: ");
    printer.printArray(inputArray);
    System.out.println("Output Array: ");
    printer.printArray(actualSortedArrray);
    assertArraysEqual(expectedSortedArray, actualSortedArrray);
    System.out.println();
    System.out.println();
  }

  private <T> void assertArraysEqual(T[] expected, T[] actual){
    int length = expected.length;
    for(int i = 0; i < length; i++){
      Assert.assertEquals(expected[i], actual[i]);
    }
  }


}