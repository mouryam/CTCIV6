/**
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.


LETS GO ONE STEP FURTHER BY SUGGESTING POSSIBLE WORDS FOR STARTSWITH - (AUTOFILL FUNCTIONALITY)
*/

package practice.aPractice;
import java.util.*;


public class PrefixTree{
	public static void main(String[] args) {
		Trie trie = new Trie();

		System.out.println("Insert 'apple' ...");
		trie.insert("apple");
		System.out.println("Search 'apple' -  "+trie.search("apple"));

		System.out.println("Search 'app' -  "+trie.search("app"));
		System.out.println("Starts with 'app' -  "+trie.startsWith("app"));

		System.out.println("Insert 'app' ...");
		trie.insert("app");
		System.out.println("Search 'app' -  "+trie.search("app"));

        trie.insert("appror");
        trie.insert("appcooo");
        trie.insert("appblooo");
        trie.insert("appxooo");
        trie.insert("appto");
        trie.insert("apptor");
        trie.insert("appsda");
        trie.insert("appsdx");
        trie.insert("appsdc");
        trie.insert("appsdt");
        trie.insert("appsdg");
        trie.insert("appsdc");
        trie.insert("appsdc");
        trie.insert("appsdct");
        trie.insert("appsdcz");
        trie.insert("aptrw");
        System.out.println("Auto-fill with 'app' -  "+trie.autoFill("app"));
	}

}

class TrieNode{
	Map<Character, TrieNode> charToNode;
	boolean isWord = false;
    String word;
	public TrieNode() {
		charToNode = new HashMap<Character, TrieNode>();
	}

}
 class Trie{
	public static TrieNode root;
	public Trie() {
		root = new TrieNode();
	}

    /** Inserts a word into the trie. */
    public void insert(String word) {
    	if(word == null){return;}
    	TrieNode node = root;

    	for(char c : word.toCharArray()){
    		if(!node.charToNode.containsKey(c)){
    			node.charToNode.put(c, new TrieNode());
    		}
    		node = node.charToNode.get(c);
    	}
    	node.isWord = true;
        node.word = word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	if(word == null) { return false;}
    	TrieNode node = root;
    	for(char c : word.toCharArray()){
    		if(!node.charToNode.containsKey(c)){
    			return false;
    		}
    		node = node.charToNode.get(c);
    	}
    	return node.isWord; 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return findStartsWith(prefix) == null;
    }

    private TrieNode findStartsWith(String prefix){
        if(prefix == null) { return null;}

        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            if(!node.charToNode.containsKey(c)){
                return null;
            }
            node = node.charToNode.get(c);
        }
        return node;
    }

    /** Uses BFS to find the first 10 words closest to prefix. */
    public ArrayList<String> autoFill(String prefix){

        ArrayList<String> myList = new ArrayList<String>();
        TrieNode node = findStartsWith(prefix);
        if(node == null){return myList;}
        if(node.isWord) {
            myList.add(node.word);
        }

        Queue<TrieNode> queue = new LinkedList<TrieNode>();
        for(char c : node.charToNode.keySet()) {
            queue.offer(node.charToNode.get(c));
        }

        while(!queue.isEmpty()) {
            if(myList.size() >= 10){break;}
            TrieNode queueNode = queue.poll();
            if(queueNode.isWord) {
                myList.add(queueNode.word);
            } else {
                for(char c : queueNode.charToNode.keySet()){
                    queue.offer(queueNode.charToNode.get(c));
                }
            }
        }
        return myList;
    }

}









