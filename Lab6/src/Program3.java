public class Program3 {
  public static void main(String[] args){
    Integer[] intArry = {1,2,3,4,5};
    Double[] doubArry = {1.1, 2.2, 3.3, 4.4};
    Character[] charArry = {'H', 'E', 'L', 'L', 'O'};
    String[] strArry = {"once", "upon", "a", "time"};
    printArray(intArry);
    printArray(doubArry);
    printArray(charArry);
    printArray(strArry);
  }

  public static <T> void printArray(T[] arr) {
    for (T element : arr){
      System.out.println(element);
    }
  }
}
