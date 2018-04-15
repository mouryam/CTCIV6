/**
Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.
For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

package practice.aPractice;
import java.util.*;

public class KLargest{

	public static void main(String[] args){
		int[] x = {3,2,1,5,6,4};
		int k = 2;
		System.out.println(Arrays.toString(x));
		System.out.println("K: "+k);

		System.out.print("Kth Largest: ");
		System.out.print(getKthLargest(x, 0, x.length-1, x.length-k)+"\n");

		System.out.print("Kth Smallest: ");
		System.out.print(getKthLargest(x, 0, x.length-1, k-1)+"\n");

	}

	private static int getKthLargest(int[] nums, int start, int end, int k){
		if(start >end){return Integer.MAX_VALUE;}
		int pivot = nums[end];
		int left = start;

		// move everything <= pivot to the left of it
		// the below loop will keep pushing the > pivot nums to the right
		for(int i = start; i<end; i++){
			if(nums[i] <= pivot){
				swap(nums, i, left++);
			}
		}

		// one all the > pivot nums are pushed as far right as possible, swap with the pivot(end)
		// makes the array now : 3,2,1, 4, 6,5
		swap(nums, left, end);

		// pivot (left) is now at the right place in the array
		if(k==left){
			return nums[left];
		}
		// other wise k is one the right part of the array so do stuff there
		else if(k > left){
			return getKthLargest(nums, left+1, end, k);
		}
		// otherwise on the left part (smaller than pivot)
		else{
			return getKthLargest(nums, start, left-1, k);
		}
	}


	private static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}