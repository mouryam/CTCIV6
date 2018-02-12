/**
Given a sorted array consisting of only integers where every element appears twice except for 
one element which appears once. Find this single element that appears only once.
Example 1:
	Input: [1,1,2,3,3,4,4,8,8]
	Output: 2
Example 2:
	Input: [3,3,7,7,10,11,11]
	Output: 10
Note: Your solution should run in O(log n) time and O(1) space.   (So use binary search.....)
*/

package practice.mPractice;
import java.util.*;

public class SingleInArray{
	public static void main(String[] args){
		int[] x = {1,1,2,3,3,4,4,8,8};
		System.out.println(Arrays.toString(x));
		System.out.println(searchSingle(x));
	}

	public static int searchSingle(int[] x){
		int start = 0;
		int end = x.length-1;
		int mid=0;

		// elements always change at odd index. 
		// so if it doesnt change on odd index then that is the single
		while(start<end){
			mid = (start+end)/2;
			// mid should be the first one of the pair which is at an (even) index if its everything is double
			if(mid%2 == 1){mid--;}

			// if mid+1 is not the same as in mid then it must mean the left side has the defect
			// because from start to mid if no single then mid+1 would have been the same
			if(x[mid] != x[mid+1]){
				end = mid;
			}
			// otherwise its on the right side
			else{
				start = mid+2;
			}

		}
		return x[start];

	}
}