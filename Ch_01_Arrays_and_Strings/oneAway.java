/**
There are three types of edits that can be performed on strings:
insert, remove, replace char.
Given two strings, write a function to check if they are <=1 edit away.
Ex:
  pale,   ple   = true
  pales,  pale  = true
  pale,   bale  = true
  pale,   bake  = false
*/

public class oneAway{

  public static void main(String[] args){
    String[][] oneAways = {{"pale", "ple"}, {"pales", "pale"}, {"pale", "bale"},
                            {"pale", "bake"}};
    for (String[] x : oneAways) {
      System.out.println(x[0]+", "+x[1]+": "+isOneAway(x[0], x[1]));
    }
  }


  public static boolean isOneAway(String x, String y){
    if (x.length() == y.length()) return replaceCheck(x, y);
    else{
      if (Math.abs(x.length() - y.length()) > 1) return false;
      return (x.length()> y.length()) ? editCheck(y,x) : editCheck(x,y);
    }
  }


  public static boolean editCheck(String shortX, String longY){
    int shortIndex =0 , longIndex = 0;
    while(shortIndex < shortX.length() && longIndex < longY.length()){
      if (shortX.charAt(shortIndex) != longY.charAt(longIndex)) {
        if (shortIndex != longIndex) return false;
        longIndex++;
      }
      else{
        shortIndex++;
        longIndex++;
      }
    }
    return true;
  }

  public static boolean replaceCheck(String x, String y){
    boolean oneReplace = false;
    for (int i=0; i<x.length(); i++) {
        if (x.charAt(i) != y.charAt(i)) {
          if (oneReplace) return false;
          oneReplace = true;
        }
    }
    return true;
  }

}
