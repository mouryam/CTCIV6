/**
Top K Frequent Words:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
*/
package practice.mPractice;
import java.util.*;

public class TopKFrequentWords{

	public static void main(String[] args) {
		String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		int k = 2;
		System.out.println(Arrays.toString(getTopK(words, k)));
	}


	public static String[] getTopK(String[] words, int k){
		String[] output = new String[k];
		HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
		for(String word : words){
			wordCountMap.put(word, wordCountMap.getOrDefault(word, 0)+1);
		}
		System.out.println(wordCountMap);

		PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(
			(a,b) -> a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : a.getValue() - b.getValue()
			);

		for(Map.Entry<String,Integer> entry : wordCountMap.entrySet()){
			pq.add(entry);
			if(pq.size() > k){
				pq.poll();
			}
		}

		int i = 0;
		while(!pq.isEmpty()){
			output[i] = pq.poll().getKey();
			i++;
		}
		return output;
	}
}