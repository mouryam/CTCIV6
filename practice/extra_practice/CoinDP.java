
package practice.extra_practice;
import java.util.*;

public class CoinDP{
  public static void main(String[] args){
    long change;
    try{
    change = Long.parseLong(args[0]);
    }catch(NumberFormatException e){
      throw new NumberFormatException("Please input a type long!");
    }catch(ArrayIndexOutOfBoundsException ae){
      throw new ArrayIndexOutOfBoundsException("Please input a total number!");
    }
    long[] denominations = {25, 10, 5, 1};
    System.out.println("Number of ways: "+makeChange(change, 0, denominations, new HashMap<String,Integer>()));

    HashMap<Long, List<Long>> minMap = getMinCoinNumber(change, denominations);
    System.out.println("Minimum number of coins needed: "+ minMap);
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

  public static HashMap<Long, List<Long>> getMinCoinNumber(long total, long[] denominations){
    /*
        0  1  2  3  4  5  6  7  8  9  10  
    1   ~  1  2  3  4  5  6  7  8  9  10 
    5   ~  1  2  3  4  1  2  3  4  5  2
    25  ..... 
    */
    HashMap<Long, List<Long>> outputMap = new HashMap<Long,List<Long>>();

    long[] T = new long[(int)total+1];
    long[] R = new long[(int)total+1];

    Arrays.fill(T,Integer.MAX_VALUE-1);
    T[0]= 0;
    Arrays.fill(R, -1);

    for (int i=0; i< denominations.length; i++){
      for(int j=1; j<=total; j++){
        if( j>= denominations[i]){
          if(T[j] > (T[j-(int)denominations[i]]+1)){
            T[j] = T[j-(int)denominations[i]]+1;
            R[j] = i;
          }
        }
      }
    }
    List<Long> coinList = new ArrayList<Long>();
    long amount = total;
    while(amount>0){
      coinList.add(denominations[(int)R[(int)amount]]);
      amount -= denominations[(int)R[(int)amount]];
    }
    outputMap.put(T[(int)total], coinList);
    return outputMap;

  }










}