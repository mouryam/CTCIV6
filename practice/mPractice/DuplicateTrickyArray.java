/**
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?
Example:
Input:
[4,3,2,7,8,2,3,1]
Output:
[2,3]
*/


package practice.mPractice;
import java.util.*;

public class DuplicateTrickyArray{
	public static void main(String[] args) {
		int[] x = {4,3,2,7,8,2,3,1};

		System.out.println(Arrays.toString(x));
		System.out.println(getDupe(x));
	}

	public static ArrayList<Integer> getDupe(int[] x){
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(int i =0; i<x.length; i++){
			int index = Math.abs(x[i])-1;
			if(x[index]<0){
				output.add(Math.abs(x[index]));
			}
			x[index] = -x[index];
		}
		return output;
	}
}