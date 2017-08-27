/**
Palindrome Permutation:
Given a string, write a function to check if it is a permutation of a plaindrome.
Input: Tact Coa
Output: true
*/
public class paliPerm{

  public static void main(String[] args) {
    String[] list = {"Tact Coa"};
    for (String x : list ) {
      System.out.println(x+ ": "+ isPaliPerm(x.toLowerCase()));
    }
  }

  public static boolean isPaliPerm(String str){
    int[] table = new int[128];
    int onlyOneOdd = 0;

    for (int i=0; i<str.length(); i++) {
      if(str.charAt(i) == ' ') continue;

      int val = str.charAt(i);
      table[val]++;
      if(table[val] % 2 != 0){
        onlyOneOdd++;
      }
      else onlyOneOdd--;
    }
    return onlyOneOdd<=1;
  }

}
