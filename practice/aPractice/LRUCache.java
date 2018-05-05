/**
Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.

Both operations in O(1) time complexity?
Example:
MyCache cache = new MyCache( 2);
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/


package practice.aPractice;
import java.util.*;

//2 ways:
// - Doubly linked list <- have head and end pointer, use HashMap<Integer,Node> to keep track of whats added
// - LinkedHashMap <- maintains order LinkedHashMap<Integer, Integer>

public class LRUCache{

	public static void main(String[] args) {
		LRULinkedHashMap cache = new LRULinkedHashMap(2);

		System.out.println("put (1,1)");
		cache.put(1, 1);
		System.out.println(cache);

		System.out.println("put (2,2)");
		cache.put(2, 2);
		System.out.println(cache);

		System.out.println("get (1) : "+cache.get(1));       // returns 1
		System.out.println(cache);

		System.out.println("put (3,3)");
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache);

		System.out.println("get (2) : "+cache.get(2));       // returns -1 (not found))
		System.out.println(cache);

		System.out.println("put (4,4)");
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache);

		System.out.println("get (1) : "+cache.get(1));       // returns -1 (not found)
		System.out.println(cache);

		System.out.println("get (3) : "+cache.get(3));       // returns 3
		System.out.println(cache);

		System.out.println("get (4) : "+cache.get(4));       // returns 4
		System.out.println(cache);

	}

	static class LRULinkedHashMap {
		int capacity;
		Map<Integer,Integer> record;

		LRULinkedHashMap(int capacity){
			this.capacity = capacity;
			record = new LinkedHashMap<>();
		}

		int get(int key){
			if(!record.containsKey(key)){
				return -1;
			}
			Integer val = record.get(key);
			record.remove(key);
			record.put(key, val);
			return val;
		}

		void put(int key, int value){
			if(record.containsKey(key)){
				record.remove(key);
			}
			if(record.size() == capacity){
				Iterator iter = record.keySet().iterator();
				if(iter.hasNext()){
					Integer tooOld = (Integer) iter.next();
					record.remove(tooOld);
				}

			}
			record.put(key, value);
		}

		public String toString(){ 
			StringBuilder sb = new StringBuilder();
			for(Map.Entry<Integer,Integer> entry : record.entrySet()){
				sb.append(entry.getValue()+" <- ");
			}
  			return sb.toString();
 		} 

	}

}