package practice.basics;
import java.util.*;

public class QuickSort{

  public static void main(String[] args) {
    int[] array = {1, 12, 5, 26, 7, 14, 3, 7, 2};
    System.out.println(Arrays.toString(array));
    System.out.println("QUICK SORTED: ");
    doQuickSort(array, 0, array.length-1);
    System.out.println(Arrays.toString(array));

  }

  private static void doQuickSort(int[] array, int left, int right){
    int index = partition(array, left, right);
    if(left < index -1) {
      doQuickSort(array, left, index-1);
    } 
    if (index < right){
      doQuickSort(array, index, right);
    }
  }

  private static int partition(int[] array, int left, int right) {
    int i = left;
    int j = right;
    int temp;
    int pivot = array[left+(right-left)/2];
    while (i <= j) {
      while (array[i] < pivot) {
        i++;
      }
      while (array[j] > pivot) {
        j--;
      }
      if (i <= j) {
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
        j--;
      }
    }
    return i;
  }

}
