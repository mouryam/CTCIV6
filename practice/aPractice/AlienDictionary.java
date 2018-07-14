/**
There is a new alien language which uses the latin alphabet. 
However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, 
where words are sorted lexicographically by the rules of this new language. 
Derive the order of letters in this language.

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
Output: "wertf"

Input:
[
  "z",
  "x"
]
Output: "zx"

Input:
[
  "z",
  "x",
  "z"
] 
Output: "" 
Explanation: The order is invalid, so return "".

Note:
-	You may assume all letters are in lowercase.
-	You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
-	If the order is invalid, return an empty string.
-	There may be multiple valid order of letters, return any one of them is fine.

-----
- Pretty much Topological sort
- Compare adjacent words to get the first character difference (also keep track of # of characters before, degrees)
- Keep track of degrees in ordering of each character (0 -> no letters before it)
- Do topological sort variation ro find the order. BFS way..
*/

package practice.aPractice;
import java.util.*;

public class AlienDictionary { 
	public static void main (String[] args) {
		String[] input = {  "wrt",
							"wrf",
  							"er",
  							"ett",
  							"rftt"
  						};
		System.out.println(Arrays.toString(input));
		System.out.println(alienOrder(input));
	}

	public static String alienOrder(String[] words) {
		Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
		Map<Character, Integer> degree = new HashMap<Character,Integer>();
		String result = "";
		if(words == null || words.length == 1) { return result;}

		// setup degree map to (character, 0) for all unique characters
		for(String word : words){
			for(Character c : word.toCharArray()){
				if(!degree.containsKey(c)){
					degree.put(c, 0);
				}
			}
		}

		// build the dependency map
		for(int i=0; i< words.length-1; i++) {
			char[] w1 = words[i].toCharArray();
			char[] w2 = words[i+1].toCharArray();
			int len = Math.min(w1.length, w2.length);
			for(int j=0; j<len; j++) {
				char c1 = w1[j];
				char c2 = w2[j];

				if(c1 == c2) { continue; }
				Set<Character> c2Set = map.containsKey(c1) ? map.get(c1) : new HashSet<Character>();
				if(!c2Set.contains(c2)){
					c2Set.add(c2);
					degree.put(c2, degree.get(c2)+1);
					map.put(c1, c2Set);
				}
				break;
			}
		}

		// topological sort and build out the order to result
		// pretty much BFS search to get the characters with the least degrees
		// each time you visit a character, it will be the lowest degree
		// so add it to the result then get its neighbors,
		// for each neighbor, decrease its degree and if it has no parents anymore ( degree = 0) then add it to the queue

		Queue<Character> queue = new LinkedList<Character>();

		for(char c : degree.keySet()) {
			if(degree.get(c) == 0) {
				queue.add(c);
			}
		}

		while(!queue.isEmpty()) {
			char c = queue.poll();
			result+=c;
			if (map.containsKey(c)) {
				for(char neighbor : map.get(c)) {
					degree.put(neighbor, degree.get(neighbor)-1);
					if (degree.get(neighbor) == 0) {
						queue.add(neighbor);
					}
				}
			}
		}

		if(result.length() != degree.size()) {
			return "";
		}
		return result;
	}

}