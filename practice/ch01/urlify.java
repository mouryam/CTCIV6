/**
Write a method to replace all spaces in a string with '%20'.
You may assume that the string has sufficient space at the end to hold the additional
characters and that you are given the true length of the string.

Example:
Input:  "Mr John Smith    ", 13
Output: "Mr%20John%20Smith"
*/
package practice.ch01;
public class urlify{

  public static void main(String[] args) {
    char[] input = "Mr John Smith    ".toCharArray();
    urlIfy(input, 13);
    System.out.println(input);
 }

 public static void urlIfy(char[] str, int trueLength){
   int spaceNum = 0;
   for (int i =0; i<trueLength; i++) {
     if(str[i] == ' ') spaceNum++;
   }

   int finalStringLength = trueLength + spaceNum*2;
   for (int i=trueLength-1; i>=0; i--) {
     if(str[i] == ' '){
       str[finalStringLength-1] = '0';
       str[finalStringLength-2] = '2';
       str[finalStringLength-3] = '%';
       finalStringLength-=3;
     }
     else {
       str[finalStringLength-1] = str[i];
       finalStringLength--;
     }
   }
 }
}
