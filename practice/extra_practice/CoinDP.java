
package practice.extra_practice;
import java.util.*;

public class CoinDP{
  public static void main(String[] args){
    long change = Long.parseLong(args[0]);
    long[] denominations = {25, 10, 5, 1};
    System.out.println(makeChange(change, 0, denominations, new HashMap<String,Integer>()));
  }

  public static int makeChange(long change, int index, long[] denominations, HashMap<String,Integer> memo){
  	if (change==0) {return 1;}
  	if (index >= denominations.length){return 0;}
  	String key = change+"-"+index;
  	if(memo.containsKey(key)){
  		return memo.get(key);
  	}
  	long amountWithCoin = 0;
  	int ways = 0;
  	while(amountWithCoin<=change){
  		long remaining = change-amountWithCoin;
  		ways+=makeChange(remaining, index+1, denominations, memo);
  		amountWithCoin+=denominations[index];
  	}
  	memo.put(key, ways);
  	return ways;
  }

  public static int getMinCoinNumber(int total, long[] denominations){

  }

}