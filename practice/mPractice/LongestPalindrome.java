/**
Get the longest palindrome from a string

aaabaaa
aaabbaaa
*/
package practice.mPractice;
import java.util.*;

public class LongestPalindrome{

	public static void main(String[] args) {
		String x;
		if (args.length == 0 || args.length>1){
			System.out.println("Passed in incorrectly!: going to use the default: 'aaabaaa'");
			x = "aaabaaa";
		}else{
			x = args[0];
		}
		int maxLength = 0;
		int start = 0;
		int end = 0;
 
		for(int i=0; i<x.length(); i++){
			int lenOdd = getPalindromeLength(x, i, i);
			int lenEven = getPalindromeLength(x, i, i+1);
			int currMax = Math.max(lenOdd, lenEven);
			if(maxLength <= currMax){
				maxLength = Math.max(lenOdd, lenEven);
				start = (i-((maxLength-1)/2));
				end = (i+((maxLength)/2));
			}
		}
		System.out.println("maxLength of '"+x+"':"+maxLength+"	("+start+" - "+end+")		O(N^2)"); // crappy print statement....
	}

	public static int getPalindromeLength(String input, int j, int k){

		while(j>=0 && k<input.length() && 
			input.charAt(j) == input.charAt(k)){
			j--;
			k++;
		}
		return k-j-1; // count itself "a" will return 1, "aaa" -> 3
	}
}