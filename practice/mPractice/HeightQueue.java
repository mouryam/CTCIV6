/**
Suppose you have a random list of people standing in a queue. 
Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number 
of people in front of this person who have a height greater than or equal to h. 
Write an algorithm to reconstruct the queue.

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*/
package practice.mPractice;
import java.util.*;

public class HeightQueue{
	public static void main(String[] args) {
		int[][] x = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

                for(int[] i : x){
                        System.out.print(Arrays.toString(i)+" ");
                }
                System.out.println();
                ArrayList<int[]> result = reconstructQueue(x);
                for(int[] i : result){
                        System.out.print(Arrays.toString(i)+" ");
                }
                System.out.println();

	}

	public static ArrayList<int[]> reconstructQueue(int[][] x){
	       ArrayList<int[]> output = new ArrayList<int[]>();
               
                // Arrays.sort(x,new Comparator<int[]>(){
                //    @Override
                //    public int compare(int[] a, int[] b){
                //        return a[0] == b[0] ? a[1]-b[1] : b[0]-a[0];
                //    }
                // });

                Arrays.sort(x, (a,b) -> a[0] == b[0] ? a[1]-b[1] : b[0]-a[0]);
                for( int[] i : x){

                        if(i[1]>= x.length){
                                output.add(i);
                        }
                        else{
                                output.add(i[1], i);
                        }
                }
                return output;
	}
}