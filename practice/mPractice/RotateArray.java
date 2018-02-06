/**
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] 
is rotated to [5,6,7,1,2,3,4].
*/
package practice.mPractice;
import java.util.*;


public class RotateArray{
	public static void main(String[] args) {
		int[] x = {1,2,3,4,5,6,7};
		int k = 3;
		System.out.println(Arrays.toString(x)+":	k = "+k);
		System.out.println(Arrays.toString(rotate(x,k)));
	}


	public static int[] rotate(int[] x, int k){
		k %= x.length;
		int count =0;
		for(int start =0; count < x.length; start++){
			int current = start;
			int prev = x[start];
			do{
				int next = (current+k)%x.length;
				int temp = x[next];
				x[next] = prev;
				prev = temp;
				current = next;
				count++;
			}while(start != current);
		}
		return x;
	}
}