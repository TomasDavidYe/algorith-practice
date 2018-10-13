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
    //To be implemented
    return result;
  }

  public T[] sortDescending(T[] input, Function<T[],T[]> implementation){
    return revert(implementation.apply(input));
  }


}


interface Ordering<T>{
  boolean isLessOrEqualThen(T object1, T object2);
}


