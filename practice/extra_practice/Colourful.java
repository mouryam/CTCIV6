package practice.extra_practice;
import java.util.*;



public class Colourful {

  public static void main(String[] args) {
    int[] test = {3245, 23, 2244, 1234, 236};
    System.out.println("Colourful?");
    for (int x : test) {
      System.out.println(x+ ": "+ isColourful(x));
    }
  }

  public static boolean isColourful(int num){
    HashSet<Integer> hashSet = new HashSet<>();
    ArrayList<Integer> numbers = new ArrayList<>();
    while (num!=0){
      numbers.add(num%10);
      num = num/10;
    }
    Collections.reverse(numbers);

    for (int i=0; i<numbers.size() ; i++ ) {
      for (int j=i; j<numbers.size() ; j++ ) {
          int prod = 1;
          for (int k =i;  k<=j ;k++ ) {
            prod *= numbers.get(k);
          }
          if (hashSet.contains(prod)){
            return false;
          }
          hashSet.add(prod);
      }
    }
    return true;
  }

}
