import static org.junit.Assert.*;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SorterTest {
  Sorter<Integer> sorter = new Sorter<>((a,b) -> a<=b);
  Printer<Integer> printer = new Printer<>();
  Integer[] inputArray = {7, 4 ,2, 6, 1, 3, 0, 8, 5, 9};
  Integer[] expectedRevertedArray = {9, 5, 8, 0, 3, 1, 6, 2, 4, 7};
  Integer[] expectedSortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};




  @Test
  public void revertTest(){
    assertArraysEqual(expectedRevertedArray, sorter.revert(inputArray));
  }

  private <T> void assertArraysEqual(T[] expected, T[] actual){
    int length = expected.length;
    for(int i = 0; i < length; i++){
      Assert.assertEquals(expected[i], actual[i]);
    }
  }


}