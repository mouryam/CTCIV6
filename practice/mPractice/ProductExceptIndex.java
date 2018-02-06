/**
You have an array of integers, and for each index you want to find the product of every integer except the integer at that index.
Write a method getProductsOfAllIntsExceptAtIndex() that takes an array of integers and returns an array of the products.
Input:   [1, 7, 3, 4]
Output:   [84, 12, 28, 21]

Why? :   [7 * 3 * 4,  1 * 3 * 4,  1 * 7 * 4,  1 * 7 * 3]
*/
package practice.mPractice;
import java.util.*;

public class ProductExceptIndex{

	public static void main(String[] args) {
		int[] input = {1, 7, 3, 4};
		System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(input)));
	}

	public static int[] getProductsOfAllIntsExceptAtIndex(int[] x){
		int[] y = new int[x.length];
		int product =1;

		//get before products first
		for(int i=0; i<x.length; i++){
			y[i] = product;
			product*=x[i];
		}
		//get after products then mutiply it with the existing products before
		product = 1;
		for(int j=x.length-1; j>=0; j--){
			y[j] *= product;
			product*=x[j];
		}

		return y;
	}

}