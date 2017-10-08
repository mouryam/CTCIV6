/**
A Seed of a number n is a number x such that multiplication of x with its digits is equal to n.
The task is to find all seeds of a given number n. If no seed exists, then print the same.
Examples:
Input  : n = 138
Output : 23
23 is a seed of 138 because
23*2*3 is equal to 138

Input : n = 4977
Output : 79 711
79 is a seed of 4977 because
79 * 7 * 9 = 4977.
711 is also a seed of 4977 because
711 * 1 * 1 * 7 = 4977

Input  : n = 9
Output : No seed exists

Input  : n = 738
Output : 123
*/
package practice.extra_practice;
import java.util.*;

public class seedRoot{
 static int[] cache = new int[10000];
  public static void main(String[] args) {
    int[] tests = {4977, 9, 738, 4040, 1111};
    for (int n : tests) {
      ArrayList<Integer> x = getSeedRoots(n);
      if(x.isEmpty()){
        System.out.println(n+": No seed exists");
      }
      else{
        System.out.println(n+": "+x);
      }
    }
  }

  public static ArrayList<Integer> getSeedRoots(int n){
    ArrayList<Integer> total = new ArrayList<Integer>();

    for(int i=11; i<=n; i++){
      if(i*getProductDigits(i) == n){
        total.add(i);
      }
    }
    return total;
  }

  public static int getProductDigits(int x){
    if (x%10 == 0){
      return 0;
    }
    if(x <10){
      return x;
    }
    if(cache[x] != 0){
      return cache[x];
    }
    int prod = (x%10)*(getProductDigits(x/10));
    cache[x] = prod;
    return cache[x];
  }

}
