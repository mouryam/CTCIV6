package practice.mPractice;
import java.util.*;


public class MaxSubArray{

	public static void main(String args[]){
		int[] x = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int curr=0, end= 0, start = 0, max_till_here = 0;
		int max_so_far = Integer.MIN_VALUE;

		for(int i=0; i<x.length; i++){

			max_till_here+=x[i];

			if(max_so_far < max_till_here){
				max_so_far = max_till_here;
				start = curr;
				end = i;
			}
			if(max_till_here<0){
				max_till_here = 0;
				curr = i+1;
			}
		}
		System.out.println("Max from the array: "+max_so_far);
		System.out.println("From indices:  "+start+" - "+end);
	}
}