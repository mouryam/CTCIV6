/**
There is an alarm keypad that has faulty buttons, so the keypad has to accept some incorrect codes,
so long as the code contains digits which are in the correct code, in the correct order.
For example, if the correct code is "13654", the keypad should accept "13", "165", and "354".
Write a program that accepts an input code and determines if it should be accepted or rejected.
*/

package practice.extra_practice;
import java.util.*;

public class FaultyAlarm{

  public static void main(String args[]){

    String alarm = "13654";
    String[] test = {"13", "165", "354", "23", "0", "136543"};
    System.out.println("Code: "+ alarm);
    for (String x : test) {
      System.out.println(x+": "+alarm(alarm, x));
    }
  }


  public static boolean alarm(String alarm, String x){

    int j = 0;

    if(alarm.length() <= x.length()){
      if(x.contains(alarm)){
        return true;
      }
    }

    for(int i=0; i< alarm.length(); i++){
      if(alarm.charAt(i)== x.charAt(j)){
        j++;
      }
      if(j==x.length()){
        return true;
      }
    }
    return false;
  }

}
