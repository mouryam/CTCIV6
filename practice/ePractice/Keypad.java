/**
There is a security keypad at the entrance of a building. It has 9 numbers 1 - 9 in a 3x3 matrix format.
1 2 3
4 5 6
7 8 9
The security has decided to allow one digit error for a person but that digit should be horizontal or vertical.
Example: for 5 the user is allowed to enter 2, 4, 6, 8 or for 4 the user is allowed to enter 1, 5, 7.
IF the security code to enter is 1478 and if the user enters 1178 he should be allowed.
 Write a function to take security code from the user and print out if he should be allowed or not
*/
package practice.ePractice;
import ctciutil.CTCIMethods;
import java.util.*;

public class Keypad{

  public static void main(String[] args){
    char[][] keypad = {   {'1','2','3'},
                          {'4','5','6'},
                          {'7','8','9'}
                        };
    char[] code = {'1', '4', '7', '8'};
    char[][] test = {"1178".toCharArray(), "2178".toCharArray(), "1175".toCharArray(), "1478".toCharArray()};
    CTCIMethods.printMatrix(keypad);
    for (char[] x : test) {
      System.out.println(String.valueOf(x)+": " +accessKeypad(x, code, keypad));
    }
  }

  public static boolean accessKeypad(char[] x, char[] code, char[][] keypad){
    if(x.length != code.length){
      return false;
    }
    boolean oneTryUsed = false;

    for(int i=0; i<x.length; i++){
      if(x[i] == code[i]){
        continue;
      }
      else if(x[i] != code[i]){
        if(oneTryUsed){
          return false;
        }
        for(int row=0; row<3; row++){
          for(int col=0; col<3; col++){
            if(x[i] == keypad[row][col]){
              oneTryUsed = true;
              boolean incorrect = true;
              if(row-1>=0 && x[i]==keypad[row-1][col]){
                incorrect = false;
              }
              else if(row+1<3 && code[i] == keypad[row+1][col]){
                incorrect = false;
              }
              else if(col-1>0 && code[i] == keypad[row][col-1]){
                incorrect = false;
              }
              else if(col+1<3 && code[i] == keypad[row][col+1]){
                incorrect = false;
              }
              if(incorrect){
                return false;
              }
            }
          }
        }

      }
    }
    return true;


  }



}
