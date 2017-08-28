/**
Given an image represented by an NxN matrix,
where each pixel is 4 bytes, write a method to rotate by 90 degrees.
Can you do this in place?
*/
package practice.ch01;
public class rotateMatrix{

  public static void main(String[] args) {
    int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16} };
    printMatrix(matrix);
    int[][] matrixRotated = {{13,9,5,1}, {14,10,6,2}, {15,11,7,3}, {16,12,8,4} };
    rotate(matrix);
    printMatrix(matrix);
  }

  public static void rotate(int[][] matrix){
    int n = matrix.length;
    for (int layer =0; layer<n/2; layer++) {
      int first = layer;
      int last = n-1-layer;
      for (int i=first; i<last; i++ ) {
        int offset = i-first;
        int top = matrix[first][i];
        matrix[first][i] = matrix[last-offset][first];
        matrix[last-offset][first] = matrix[last][last-offset];
        matrix[last][last-offset] = matrix[i][last];
        matrix[i][last] = top;
      }
    }
  }

  public static void printMatrix(int[][] matrix){
    for (int row = 0; row < matrix.length; row++) {
        for (int col = 0; col < matrix[row].length; col++) {
            System.out.printf("%4d", matrix[row][col]);
        }
        System.out.println();
    }
    System.out.println();
  }
}
