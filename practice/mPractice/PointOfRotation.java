/**
Find the point of rotation of an array
For example, and array [5,6,7,1,2,3,4] point of rotation would be 1 at index 3
*/
package practice.mPractice;
import java.util.*;

public class PointOfRotation{

	public static void main(String[] args) {
		int[] x = {5,6,7,1,2,3,4};
		int por = getPointofRotation(x);
		System.out.println(Arrays.toString(x));
		System.out.printf("Point of rotation at index: %s [%s]\n", por, x[por]);
	}


	public static int getPointofRotation(int[] input){
		int start = 0;
		int end = input.length-1;
		int mid = start+(end-start)/2;

		int last = input[end];

		while(start<=end){
			if(input[mid] > last){
				start = mid+1;
			}
			else if(input[mid] < last){
				end = mid-1;
			}
			else{break;}
			mid = start + (end-start)/2;
		}

		return mid;

	}
}