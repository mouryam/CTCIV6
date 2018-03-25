package practice.mPractice;
import java.util.*;
import ctciutil.CTCIMethods;

public class SpiralMatrix{
	public static void main(String[] args) {
		int[][] matrix = {{2,3}};
		List<Integer> answer = getSpiral(matrix);
		CTCIMethods.printMatrix(matrix);
        System.out.println(Arrays.toString(answer.toArray()));

       	System.out.println("-----------------------------------");

		int[][] matrix2 = {{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> answer2 = getSpiral(matrix2);
		CTCIMethods.printMatrix(matrix2);
        System.out.println(Arrays.toString(answer2.toArray()));
    }
    public static List<Integer> getSpiral(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
        	System.out.println("You get nothing!");
        	return result;
        }
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while (left<=right && top<=bottom ){
            // go right
            // System.out.println("going right...");
            for(int i = left; i<=right; i++){
                result.add(matrix[top][i]);
                // System.out.println(Arrays.toString(result.toArray()));
            }
            top++;

            // System.out.println("going down...");
            // go down
            for(int i = top; i<=bottom; i++){
        	    result.add(matrix[i][right]);
            	// System.out.println(Arrays.toString(result.toArray()));
            }
            right--;

            // go left
            // System.out.println("going left...");
            if(top>bottom){break;} // break if it no where else to go other than to repeat
            for(int i = right; i>=left; i--){
                result.add(matrix[bottom][i]);
         		// System.out.println(Arrays.toString(result.toArray()));
            }
            bottom--;

            // go up
            // System.out.println("going left...");
            if(left>right){break;} // break if no where else to go other than to repeat
            for(int i = bottom; i>= top; i--){
                result.add(matrix[i][left]);
         		// System.out.println(Arrays.toString(result.toArray()));
            }
            left++;
        }
        return result;
	}
}