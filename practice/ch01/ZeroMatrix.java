/**
Write an algorithm such that if an element in an MxN matrix is 0,
its rntire row and column are set to 0
*/
package practice.ch01;
import ctciutil.CTCIMethods;
public class ZeroMatrix{

  public static void main(String[] args) {
    int nrows = 10;
    int ncols = 15;
    int[][] matrix = CTCIMethods.randomMatrix(nrows, ncols, -10, 10);
    CTCIMethods.printMatrix(matrix);
    zeroMatrix(matrix);
    System.out.println("Zeroed:");
    CTCIMethods.printMatrix(matrix);
  }

  public static void zeroMatrix(int[][] matrix){
    boolean[] rows = getListZeroRows(matrix);
    boolean[] cols = getListZeroCols(matrix);
    zeroRows(matrix, rows);
    zeroCols(matrix, cols);
  }


  public static void zeroRows(int[][] matrix, boolean[] zeroRows){
    for (int i=0; i<matrix.length; i++) {
      for (int j=0; j<matrix[0].length; j++) {
        if (zeroRows[i]) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  public static void zeroCols(int[][] matrix, boolean[] zeroCols){
    for (int i=0; i<matrix[0].length; i++) {
      for (int j=0; j<matrix.length; j++) {
        if (zeroCols[i]) {
          matrix[j][i] = 0;
        }
      }
    }
  }


  public static boolean[] getListZeroRows(int[][] matrix){
    boolean[] rows = new boolean[matrix.length];
    for (int i=0; i<matrix.length; i++) {
      for (int j=0; j<matrix[0].length; j++) {
        if(matrix[i][j] == 0){
          rows[i] = true;
          break;
        }
      }
    }
    return rows;
  }

  public static boolean[] getListZeroCols(int[][] matrix){
    boolean[] cols = new boolean[matrix[0].length];
    for (int i=0; i<matrix[0].length; i++) {
      for (int j=0; j<matrix.length; j++) {
        if(matrix[j][i] == 0){
          cols[i] = true;
          break;
        }
      }
    }
    return cols;
  }

}
