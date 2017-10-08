package practice.moderate;
import ctciutil.CTCIMethods;
import ctciutil.HashMapList;
import java.util.ArrayList;
import java.util.HashMap;

public class T9 {
	public static int numLetters = 26;
	public static char[][] t9Letters = {
			null, 					// 0
			null, 					// 1
			{'a', 'b', 'c'}, 		// 2
			{'d', 'e', 'f'}, 		// 3
			{'g', 'h', 'i'}, 		// 4
			{'j', 'k', 'l'},		// 5
			{'m', 'n', 'o'},		// 6
			{'p', 'q', 'r', 's'}, 	// 7
			{'t', 'u', 'v'},		// 8
			{'w', 'x', 'y', 'z'} 	// 9
	};


  public static HashMapList<String, String> initializeDictionary(String[] words){

    HashMap<Character,Character> letterToNumberMap = createLetterToNumberMap();

    HashMapList<String, String> numWordPair = new HashMapList<String, String>();
    for (String word: words){
      String convertToNum = getT9Number(word, letterToNumberMap);
      numWordPair.put(convertToNum, word);
    }
    return numWordPair;
  }

  public static HashMap<Character,Character> createLetterToNumberMap(){
    HashMap<Character,Character> numMap = new HashMap<Character,Character>();

    for(int i=0; i<t9Letters.length; i++){
      char[] letters = t9Letters[i];
      if(letters !=null){
        for (Character c : letters ) {
          char num = Character.forDigit(i, 10);
          numMap.put(c, num);
        }
      }
    }
    return numMap;
  }


  public static String getT9Number(String word, HashMap<Character,Character> letterToNumberMap){
    StringBuilder total = new StringBuilder();

    for (Character c  : word.toCharArray()) {
      if(letterToNumberMap.containsKey(c)){
        total.append(letterToNumberMap.get(c));
      }
    }
    return total.toString();
  }


	public static ArrayList<String> getValidT9Words(String numbers, HashMapList<String, String> dictionary) {
		return dictionary.get(numbers);
	}

	public static void main(String[] args) {
		HashMapList<String, String> dictionary = initializeDictionary(CTCIMethods.getListOfWords());
		ArrayList<String> words = getValidT9Words("8733", dictionary);
		for (String w: words) {
			System.out.println(w);
		}
	}

}
