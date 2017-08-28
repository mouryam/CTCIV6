/**
Implement a method to perform basic string compression using counts of repeated
characters.
Ex:
  aabcccccaaa  --> a2b1c5a3
  If compression is NOT smaller then return the orginal.
*/
package practice.ch01;
public class stringCompression{

  public static void main(String[] args) {
    String[] test = {"aabcccccaaa", "abcdefg"};
    for (String x : test) {
      System.out.println(x+": "+compress(x));
    }
  }

  public static String compress(String x){
    int count = 1;
    int i=0;
    StringBuilder finalx = new StringBuilder();
    while (i<x.length()){
      if(i == x.length()-1 || x.charAt(i+1) != x.charAt(i) ){
        finalx.append(x.charAt(i));
        finalx.append(count);
        count = 1;
      }
      else count++;
      i++;
    }
    return finalx.length() < x.length() ? finalx.toString() : x;
  }
}
