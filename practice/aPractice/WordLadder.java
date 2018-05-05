/**
Given two words (beginWord and endWord), and a dictionary's word list, 
find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
	beginWord = "hit"
	endWord = "cog"
	wordList = ["hot","dot","dog","lot","log","cog"]
Return:
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
	Return an empty list if there is no such transformation sequence.
	All words have the same length.
	All words contain only lowercase alphabetic characters.
	You may assume no duplicates in the word list.
	You may assume beginWord and endWord are non-empty and are not the same.
*/

package practice.aPractice;
import java.util.*;

public class WordLadder{
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
		System.out.println(wordList);
		System.out.println(beginWord+" --> "+endWord);
		System.out.println("-------------------------");

		// Create a distance graph using BFS. The paths will always be the shortest
		// Utilize DFS to get all paths (must backtrack to find >1 paths if it exist and same length)
    	HashSet<String> dictionary = new HashSet<String>(wordList);
	    List<List<String>> results = new ArrayList<List<String>>();         
	    HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
	    HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
	    ArrayList<String> solution = new ArrayList<String>();

	    dictionary.add(beginWord);          
	    bfs(beginWord, endWord, dictionary, nodeNeighbors, distance);                 
	    dfs(beginWord, endWord, nodeNeighbors, distance, solution, results);

	    for(List x : results){
	    	System.out.println(x);
	    }  
	}


	private static void bfs(String start, String end, HashSet<String> dictionary, 
			HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance){

		// for each word, create a list of its neighbors:
		for(String s : dictionary){
			nodeNeighbors.put(s, new ArrayList<String>());
		}
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		distance.put(start, 0);

		while(!queue.isEmpty()){
			int count = queue.size();
			// repeat for each of the word in the queue level
			for(int i=0; i< count; i++){
				String curr = queue.poll();
				int currDistance = distance.get(curr);
				ArrayList<String> currNeighbors = getNeighbors(curr, dictionary);
				for(String neighbor : currNeighbors){
					nodeNeighbors.get(curr).add(neighbor);
					if(!distance.containsKey(neighbor)){
						distance.put(neighbor, currDistance+1);
						if(end.equals(neighbor)){
							break;
						}else{
							queue.offer(neighbor);
						}
					}
				}
			}
		}
		// System.out.println(nodeNeighbors);
		// System.out.println(distance);
	}
	private static void dfs(String beginWord, String endWord, HashMap<String, ArrayList<String>> nodeNeighbors, 
		HashMap<String, Integer> distance, ArrayList<String> individualSequence, List<List<String>> results) {

		individualSequence.add(beginWord);
		if(endWord.equals(beginWord)){
			results.add(new ArrayList<String>(individualSequence));
		}
		else{
			for(String next : nodeNeighbors.get(beginWord)){
				// ensure it is the next one down the path (not parent, or sibling, or > 1 distance)
				if(distance.get(next) == distance.get(beginWord)+1){
					dfs(next, endWord, nodeNeighbors, distance, individualSequence, results);
				}
			}
		}
		// reset sequence for another path
	 	individualSequence.remove(individualSequence.size() - 1); 
	}


	// get words with only one difference in letter and exist in the dictionary
	private static ArrayList<String> getNeighbors(String curr, HashSet<String> dictionary){
		ArrayList<String> neighbors = new ArrayList<String>();
		char[] currArray = curr.toCharArray();
		for(char ch = 'a'; ch<='z'; ch++){
			for(int i = 0; i<currArray.length; i++){
				if(currArray[i] != ch){
					char temp = currArray[i];
					currArray[i] = ch;
					if(dictionary.contains(String.valueOf(currArray))){
						neighbors.add(String.valueOf(currArray));
					}
					currArray[i] = temp;
				}
			}
		}
		return neighbors;
	}
	
}