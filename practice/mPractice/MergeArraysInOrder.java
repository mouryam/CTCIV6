/**
Girl Scout cookie consipiracy

Merge two srrays in sorted order
int[] myArray     = new int[]{3, 4, 6, 10, 11, 15};
int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

System.out.println(mergeArrays(myArray, alicesArray));
// prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
*/
package practice.mPractice;
import java.util.*;

public class MergeArraysInOrder{

	public static void main(String[] args) {
		int[] myArray     = {3, 4, 6, 10, 11, 15};
		int[] alicesArray = {1, 5, 8, 12, 14, 19};

		System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));
	}

	public static int[] mergeArrays(int[] x, int[] y){
		int xIndex =0;
		int yIndex =0;
		int [] output = new int[x.length+y.length];
		int outputIndex =0;

		if(x.length == 0){
			return y;
		}
		if(y.length ==0){
			return x;
		}
		while(outputIndex != output.length){
			if(yIndex >= y.length){
				output[outputIndex] = x[xIndex];
				xIndex++;
				outputIndex++;
				continue;
			}else if (xIndex >= x.length){
				output[outputIndex] = y[yIndex];
				yIndex++;
				outputIndex++;
				continue;			
			}
			if(xIndex != x.length && x[xIndex] <= y[yIndex]){
				output[outputIndex] = x[xIndex];
				xIndex++;
			}else if(yIndex != y.length && y[yIndex] <=x[xIndex]){
				output[outputIndex] = y[yIndex];
				yIndex++;
			}
			outputIndex++;

		}
		return output;


	}










}