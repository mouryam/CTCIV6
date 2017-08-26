
public class isUnique {

  public static boolean isUniqueChars(String str) {
    if(str.length()>128){
      return false;
    }
    boolean[] uniqueList = new boolean[128];
    for (int i=0; i<str.length(); i++) {
      int val = str.charAt(i);
      if (uniqueList[val]) {
        return false;
      }
      uniqueList[val] = true;
    }
    return true;
	}

	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}
}
