import java.util.Arrays;
import java.util.function.Function;

public class Sorter<T> {

  private Ordering<T> order;

  public Sorter(Ordering<T> order){
    this.order = order;
  }

  public T[] revert(T[] input){
    int length = input.length;
    T[] result = input.clone();
    for(int i = 0; i < length; i++) result[i] = input[length - 1 - i];
    return result;
  }

  public T[] bubbleSort(T[] input){
    T[] result = input.clone();
    for(int k = 0; k < result.length; k++){
      for(int i = result.length -1; i > k; i--){
        if(!order.lessThanOrEqualTo(result[i-1], result[i])){
          T temp = result[i-1];
          result[i-1] = result[i];
          result[i] = temp;
        }
      }
    }
    return result;
  }

  public T[] selectSort(T[] input){
    T[] result = input.clone();
    for(int k = 0; k < result.length; k++){
      int minIndex = k;
      T minimum = result[k];
      for(int i = k + 1; i < result.length; i++){
        if(!order.lessThanOrEqualTo(minimum, result[i])){
          minimum = result[i];
          minIndex = i;
        }
      }
      T temp = result[k];
      result[k] = result[minIndex];
      result[minIndex] = temp;
    }

    return result;
  }

  public T[] insertSort(T[] input){
    T[] result = input.clone();
    for(int k = 1; k < result.length; k++){
      for(int i = k; i > 0; i--){
        if(!order.lessThanOrEqualTo(result[i-1],result[i])){
          T temp = result[i-1];
          result[i-1] = result[i];
          result[i] = temp;
        }
      }
    }
    return result;
  }


  public T[] quickSort(T[] input){
    T[] result = input.clone();
    if(result.length <= 1 || isConstant(result)) return result;
    final T pivot = result[0];
    T[] greaterPart = greaterPart(result,pivot);
    T[] lesserPart = lesserPart(result,pivot);
    T[] equalPart = equalPart(result,pivot);
    greaterPart = quickSort(greaterPart);
    lesserPart = quickSort(lesserPart);
    return concatenateArrays(concatenateArrays(lesserPart,equalPart),greaterPart);
  }

  //quick sort helper methods beginning

  public boolean isConstant(T[] array){
    T firstValue = array[0];
    for(int i = 1; i < array.length; i++){
      if(firstValue != array[i]) return false;
    }
    return true;
  }

  public T[] equalPart(T[] array, T pivot){
    int equalArrayLength = (int) Arrays.stream(array).filter(x -> x.equals(pivot)).count();
    T[] result = blankArray(equalArrayLength);
    int equalArrayIndex = 0;
    for(int i  = 0; i < array.length; i++){
      if(array[i].equals(pivot)){
        result[equalArrayIndex] = array[i];
        equalArrayIndex++;
      }
    }
    return result;
  }

  public T[] lesserPart(T[] array, T pivot){
    int lesserArrayLength = (int) Arrays.stream(array).filter(x -> order.lessThanOrEqualTo(x,pivot) && !x.equals(pivot)).count();
    T[] result = blankArray(lesserArrayLength);
    int lesserArrayIndex = 0;
    for(int i = 0; i < array.length; i++){
      if(order.lessThanOrEqualTo(array[i],pivot) && !array[i].equals(pivot)){
        result[lesserArrayIndex] = array[i];
        lesserArrayIndex++;
      }
    }
    return result;
  }

  public T[] greaterPart(T[] array, T pivot){
    int greaterArrayLength = (int) Arrays.stream(array).filter(x -> !order.lessThanOrEqualTo(x,pivot)).count();
    T[] result = blankArray(greaterArrayLength);
    int greaterArrayIndex = 0;
    for(int i = 0; i < array.length; i++){
      if(!order.lessThanOrEqualTo(array[i],pivot)){
        result[greaterArrayIndex] = array[i];
        greaterArrayIndex++;
      }
    }
    return result;
  }

  public T[] concatenateArrays(T[] firstArray, T[] secondArray){
    T[] temp = blankArray(firstArray.length + secondArray.length);
    for(int i = 0; i < firstArray.length; i++) temp[i] = firstArray[i];
    for(int j = firstArray.length; j < firstArray.length + secondArray.length; j++) temp[j] = secondArray[j - firstArray.length];
    return temp;
  }
  //quick sort helper methods end


  public T[] sortDescending(T[] input, Function<T[],T[]> implementation){
    return revert(implementation.apply(input));
  }

  public T[] blankArray(int length){
    Object[] result = new Object[length];
    for(int i = 0; i < length; i++) result[i] = null;
    return (T[])result;
  }


}


interface Ordering<T>{
  boolean lessThanOrEqualTo(T object1, T object2);
}


