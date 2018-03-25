/**
Find the point of rotation of an array
For example, and array [5,6,7,1,2,3,4] point of rotation would be 1 at index 3
*/
package practice.mPractice;
import java.util.*;

public class PointOfRotation{

	public static void main(String[] args) {
		int[] x = {5,6,7,1,2,3,4};
		// int[] x = {1,1,1,1,1,1,1,1,1,1,2,1,1};
		int por = getPointofRotation(x);
		System.out.println(Arrays.toString(x));
		System.out.printf("Point of rotation at index: %s [%s]\n", por, x[por]);
	}


	public static int getPointofRotation(int[] input){
		int start = 0;
		int end = input.length-1;
		int mid = start+(end-start)/2;

		while(start<end){
			mid = start + (end-start)/2;
			if(input[mid] > input[end]){
				start = mid+1;
			}
			else if(input[mid] < input[end]){
				end = mid;
			}
			else{
				if(input[end-1] > input[end]){
					start = end;
					break;
				}
				end--;
			}
			
		}

		return start;

	}
}