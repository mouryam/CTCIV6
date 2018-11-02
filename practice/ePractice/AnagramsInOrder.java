/**
Given a sequence of words, print all anagrams together
Given an array of words, print all anagrams together.
For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”},
then output may be “cat tac act dog god”.
*/

package practice.ePractice;
import java.util.*;
import java.lang.*;
import java.io.*;

public class AnagramsInOrder{

  static class Word{
    public String word;
    public int index;
    public Word(String word, int index){
      this.word = word;
      this.index = index;
    }
  }
  
  static class customComparator implements Comparator<Word>{
    public int compare(Word a, Word b){
      return (a.word.compareTo(b.word));
    }
  }

  public static void main(String args[]){
    String[] test = {"cat", "dog", "tac", "god", "act"};
    printInOrderAnagrams(test);
  }

  public static void printInOrderAnagrams(String[] x){
    // for each word -> sort word -> add in Word array
    // sort Word array -> now print from x array using the order of index from Word array
    Word[] words = new Word[x.length];

    // N = x array length
    // M = longest word length

    // O( N*MlogM)
    for(int i=0; i<x.length; i++){
      char[] cArray = x[i].toCharArray();
      Arrays.sort(cArray);
      words[i] = new Word(String.valueOf(cArray), i);
    }

    // O(NlogN * M)
    // M for the comparator
    Arrays.sort(words, new customComparator());

    for (Word sortedWord : words) {
      System.out.print(x[sortedWord.index]+" ");
    }
    System.out.println();

  }


}
