/**
Assume you have a method isSubstring which checks if one word is a substring of another.
Given two strings, s1 and s2, write a code to check is s2 is a rotation of s1
using only one call to isSubstring
Ex:
"waterbottle" is rotation of "erbottlewat"
*/
package practice.ch01;
public class StringRotation{

  public static void main(String[] args) {
    String s1 = "waterbottle";
    String s2 = "erbottlewat";
    System.out.println(s1+", "+s2+": "+checkRotation(s1,s2));
  }

  public static boolean checkRotation(String s1, String s2){
    String s2s2 ="";
    if(s1.length() == s2.length() && s1.length()>0){
      s2s2 = s2+s2;
      return isSubstring(s2s2, s1);
    }
    return false;
  }

  public static boolean isSubstring(String big, String small) {
  if (big.indexOf(small) >= 0) {
    return true;
  } else {
    return false;
  }
}
}
