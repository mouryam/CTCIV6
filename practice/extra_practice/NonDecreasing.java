/**
Given an integer n > 0, which denotes the number of digits, the task to find total number of n-digit positive integers which are non-decreasing in nature.
A non-decreasing integer is a one in which all the digits from left to right are in non-decreasing form. ex: 1234, 1135, ..etc.
Examples:
Input : n = 1
Output : 10
Numbers are 0, 1, 2, ...9.

Input : n = 2
Output : 55

Input : n = 4
Output : 715
*/

package practice.extra_practice;
import java.util.*;
public class NonDecreasing{

  public static void main(String[] args){
    int[] test = { 1, 2, 3, 4};
    for (int x : test) {
      System.out.println(x+": "+getNonDecreasing(x) );
    }
  }

  public static int getNonDecreasing(int x){
    int[][]dp = new int[x+1][10];

    for(int i=0; i<10; i++){
      dp[0][i] = 1;
    }

    for (int i=1; i<= x;i++){
      dp[i][9] = 1;
    }

    for (int i=1; i<=x; i++){
      for(int len=8; len>=0; len--){
        dp[i][len] = dp[i-1][len] + dp[i][len+1];
      }
    }
    return dp[x][0];
  }

}
