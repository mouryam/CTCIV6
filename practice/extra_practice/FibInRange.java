/**
Given a certain range, produce all numbers in that range that fit the criteria.
The criteria is as follows:
a number that starts with 2 of the same number,
and then the sum of the previous 2 is that of the next number, and etc.
For example:
112358 : classic fib
121224 :  12+12=24
448:  4+4=8
*/

package practice.extra_practice;
import java.util.*;


public class FibInRange {

  public static void main(String[] args) {
      List<Long> fibNumbers = getAllFib(10000, 200000);
      for (Long x : fibNumbers) {
        System.out.println(x);
      }
  }

	public static List<Long> getAllFib(long min, long max){
		List<Long> list = new ArrayList<Long>();
    long i = 0;
    long[] dp = new long[String.valueOf(max).length()];
    while(String.valueOf(i).length()*2 < String.valueOf(max).length()){
      if(notWorthIt(i, max)){
        break;
      }
      dp[0] = i;
      dp[1] = i;
      String temp = String.valueOf(dp[0])+String.valueOf(dp[1]);

      for(int j=2; j<dp.length;j++){
        dp[j] = dp[j-1]+dp[j-2];
        temp += String.valueOf(dp[j]);
        System.out.println("EXTRA: "+temp);
        if(Long.valueOf(temp) > max){
          break;
        }
        if(Long.valueOf(temp) < max && Long.valueOf(temp) > min ){
          list.add(Long.valueOf(temp));
        }
      }
      i++;
    }
    return list;
	}

  public static boolean notWorthIt(long i, long max){
    String maxString  = String.valueOf(max);
    int maxStringlength = maxString.length();
    if(maxStringlength % 2 !=0){
      maxStringlength++;
    }
    String getCutOffString = maxString.substring(0, maxStringlength/3);
    if(i >= Long.valueOf(getCutOffString)){
      return true;
    }
    return false;
  }

}
