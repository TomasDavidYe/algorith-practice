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
        if(!order.isLessOrEqualThen(result[i-1], result[i])){
          T temp = result[i-1];
          result[i-1] = result[i];
          result[i] = temp;
        }
      }
    }
    return result;
  }

  public T[] sortDescending(T[] input, Function<T[],T[]> implementation){
    return revert(implementation.apply(input));
  }


}


interface Ordering<T>{
  boolean isLessOrEqualThen(T object1, T object2);
}


