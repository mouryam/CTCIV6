/**
1.Substring Addition
Write a program to add the substring
eg :say you have a list {1 7 6 3 5 8 9 } and user is entering a sum 16.
Output should display (2-4) that is {7 6 3} cause 7+6+3=16.

*/
package practice.extra_practice;
import java.util.*;

public class SubstringAddition{
  public static void main(String[] args){

    int[] list = {1,7,6,3,5,8,9};
    int[] test = {16, 22, 7, 45, 9};

    for (int sum : test) {
      ArrayList<Integer> range = getRange(sum, list);
      if(range.isEmpty()){
        System.out.println("Could not find");
      }
      else{
        System.out.println("("+range.get(0)+"-"+range.get(1)+")");
      }
    }
  }

  public static ArrayList<Integer> getRange(int sum, int[] list){
    HashMap<Integer, Integer> range = new HashMap<Integer,Integer>();
    int total=0;
    for(int i=0; i<list.length; i++){
      total += list[i];
      range.put(total, i);
    }
    ArrayList<Integer> found = new ArrayList<Integer>();

    for (int key : range.keySet()) {
      if(range.containsKey(key-sum)){
        found.add(range.get(key-sum)+1);
        found.add(range.get(key));
        return found;
      }
    }
    return found;
  }
}
