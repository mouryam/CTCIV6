/*
 * For Given Number N find if its COLORFUL number or not
 *
 Return True/False

 COLORFUL number:

 A number can be broken into different sub-sequence parts.
 Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 And this number is a COLORFUL number, since product of every digit of a sub-sequence are different
 Example:

 N = 23
 2 3 23
 2 -> 2
 3 -> 3
 23 -> 6
 this number is a COLORFUL number since product of every digit of a sub-sequence are different.

 Output : True
 */


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
