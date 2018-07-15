/**
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. 
Each time the sliding window moves right by one position. 
Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?


------
 - So, could do it with pointers: max, index  - and just update them each tiem we go into new window
 	- check if index is still within the window range
 	
 - Use ArrayDeque. -> smarter..O(n)
 	- Have at most 1 element (index of max) in the queue and just update/remove it as the window changes
 	- We know it is O(n) because we are pushing each element on the deque ONCE and removing it from the deque at MOST once. 
 	So a remove which is pollLast() or poll() at most ONCE and push (offer) at MOST once.
*/



package practice.aPractice;
import java.util.*;

public class SlidingWindowMaximum {

	public static void main (String[] args) {
		int slidingWindowSize = 3;
		int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
		int[] res = maxSlidingWindow(input, slidingWindowSize);
		System.out.println("[1  3  -1] -3  5  3  6  7	:"+res[0]);
		System.out.println(" 1 [3  -1  -3] 5  3  6  7	:"+res[1]);
		System.out.println(" 1  3 [-1  -3  5] 3  6  7	:"+res[2]);
		System.out.println(" 1  3  -1 [-3  5  3] 6  7	:"+res[3]);
		System.out.println(" 1  3  -1  -3 [5  3  6] 7	:"+res[4]);
		System.out.println(" 1  3  -1  -3  5 [3  6  7]	:"+res[5]);
	}


    public static int[] maxSlidingWindow(int[] nums, int k) {
    	if(nums == null || 
    		nums.length == 0 || 
    		k==0 || 
    		nums.length-k+1 <=0) {
    		return new int[0];
    	}
    	int[] res = new int[nums.length-k+1];
    	int resIndex = 0;
    	Deque<Integer> queue = new ArrayDeque<Integer>();

    	for(int i=0; i<nums.length; i++) {
    		//remove elements outside of window
    		while(!queue.isEmpty() && queue.peek() < i-k+1) {
    			queue.poll();
    		}
    		// remove elements less than the current and is no longer relevant of the current window
    		while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
    			queue.pollLast();
    		}
    		queue.offer(i);
    		if(i >= k-1) {
    			res[resIndex] = nums[queue.peek()];
    			resIndex++;
    		}
    	}
        return res;
    }



}