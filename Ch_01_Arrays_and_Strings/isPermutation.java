public class isPermutation{

  public static void main(String[] args) {
    String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
    for (String[] pair : pairs) {
      String x = pair[0];
      String y = pair[1];
      boolean permutation = isPermutation(x,y);
      System.out.println(x +", "+y+": "+permutation);
    }
  }

  public static boolean isPermutation(String x, String y){
    if (x.length() != y.length()) return false;

    int[] list = new int[128];
    for (int i=0; i<x.length(); i++) {
      int valx = x.charAt(i);
      list[valx]++;
    }

    for (int j=0; j<y.length(); j++) {
      int valy = y.charAt(j);
      if(list[valy] <=0) return false;
      list[valy]--;
    }
    return true;
  }

}
