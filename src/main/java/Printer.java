public class Printer<T> {

  public  void printArray(T[] input){
    System.out.print("[");
    for(int i = 0; i < input.length; i++){
      System.out.print(input[i]);
      if(i < input.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }

}
