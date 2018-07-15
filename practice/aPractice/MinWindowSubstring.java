/**
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

*/


package practice.aPractice;
import java.util.*;

public class MinWindowSubstring {
	public static void main (String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println("S: 		"+s);
		System.out.println("T: 		"+s);
		System.out.println("Output: "+minWindow(s,t));
	}

    public static String minWindow(String s, String t) {
    	if(s == null || 
    		t == null || 
    		s.length() < t.length() || 
    		s.length() == 0 || 
    		t.length() ==0 ){ 
    		return "";
    	}
    	HashMap<Character, Integer> map = new HashMap<Character,Integer>();

    	for(char temp : s.toCharArray()) {
    		map.put(temp, 0);
    	}
    	for (char temp : t.toCharArray()) {
    		if(map.containsKey(temp)) {
    			map.put(temp, map.get(temp)+1);
    		}
    		else {
    			return "";
    		}
    	}

    	int start = 0;
    	int end = 0;
    	int minStart=0;
    	int minLen = Integer.MAX_VALUE;
    	int numTargets = t.length();

    	while(end < s.length()) {
    		char cur = s.charAt(end);
    		if(map.get(cur) > 0) {
    			numTargets--;
    		}
    		map.put(cur, map.get(cur)-1);

    		// Now if all targets have been found..lets minimize the window
    		while(numTargets == 0) {
    			if(minLen > end-start+1) {
    				minStart = start;
    				minLen = end-minStart+1;
    			}
    			char curHead = s.charAt(start);
    			if(map.get(curHead) >= 0) {
    				numTargets++;
    			}
				start++;
				map.put(curHead, map.get(curHead)+1);	
			}
    		end++;
		}
    	

    	if(minLen > s.length()){
    		return "";
    	}
    	return s.substring(minStart, minStart+minLen);
        
    }
}