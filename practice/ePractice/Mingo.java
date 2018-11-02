/**
The Mingo game:
The game of Mingo involves a 100 X 100 board with unique positive whole numbers
in the range from 1 to 1,000,000 randomly distributed in the cells.
Unique numbers are "called" one at a time and the goal is to have a "Mingo",
which is an entire row or column of cells with numbers that have been called;
one might also form a diagonal from corner to corner with numbers that have been called.
Write a function that takes as parameters a square array of 100 X 100 positive whole numbers
and list of "called" numbers. Your function will report whether a "Mingo" occurs,
 and after how many called numbers the first Mingo occurs. You may assume valid input.

*/
package practice.ePractice;
import java.util.*;

public class Mingo{

  static class Position {
    public int row, col;
    public Position(int row, int column) {
      this.row = row;
      this.col = column;
    }
  }

  public static void main(String[] args) {
    int matrix[][] = {
            {1,  2,   3,  4,  5,  6,  7,  8,  9, 10},
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
            {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
            {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
            {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
            {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
            {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
            {91, 92, 93, 94, 95, 96, 97, 98, 99, 100}
    };
    int called[] = {1, 2, 3, 4, 12, 23, 34, 45, 56, 67, 78, 89, 5, 6, 7, 8, 9, 10};
    findMingo(matrix, called);
    int called2[] = {10, 19, 28, 37, 46, 55, 64, 73, 82, 1, 2, 3, 4, 5, 91};
    findMingo(matrix, called2);

  }

  public static void findMingo(int[][] matrix, int[] called){
    HashMap<Integer, Position> numPosMap = createNumToPositionMap(matrix);
    int[] rowCount = new int[matrix.length];
    int[] colCount = new int[matrix[0].length];
    int countDiag = 0;
    int countDiagInverse = 0;
    for (int i=0; i<called.length; i++) {
      int x = called[i];
      rowCount[numPosMap.get(x).row]++;
      colCount[numPosMap.get(x).col]++;

      if(numPosMap.get(x).row == numPosMap.get(x).col){
        countDiag++;
      }
      if(numPosMap.get(x).row + numPosMap.get(x).col == matrix.length-1){
        countDiagInverse++;
      }
      if(countDiag == matrix.length || countDiagInverse == matrix.length){
        System.out.println("MINGO on diagonal");
        System.out.println("On number: "+ x+ " After "+(i+1)+" calls");
        return;
      }

      if(rowCount[numPosMap.get(x).row] == matrix.length){
        System.out.println("MINGO on row: "+numPosMap.get(x).row);
        System.out.println("On number: "+ x+ " After "+i+" calls");
        return;
      }
      if(colCount[numPosMap.get(x).col] == matrix[0].length){
        System.out.println("MINGO on col: "+numPosMap.get(x).col);
        System.out.println("On number: "+ x+ " After "+i+" calls");
        return;
      }
    }
    System.out.println("NO MINGOOOOOOO!");
  }


  public static HashMap<Integer,Position> createNumToPositionMap(int[][] matrix){
    HashMap<Integer, Position> numToPositionMap = new HashMap<Integer, Position>();
    for (int row =0; row<matrix.length; row++) {
      for (int col=0; col<matrix[row].length; col++ ) {
          numToPositionMap.put(matrix[row][col], new Position(row,col));
      }
    }
    return numToPositionMap;
  }


}
