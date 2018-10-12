public class Sorter<T> {

  private Ordering<T> order;

  public Sorter(Ordering<T> order){
    this.order = order;
  }
}


interface Ordering<T>{
  boolean isLessOrEqualThen(T object1, T object2);
}


