/**
Sort log file:

Input : {
			"booo here"
			"zsfdsf dsafasd sdafasdf fadgadf"
			"zsfdsf dsafasd sdafasdf asdassadf"
			"allo there haha",
			"Allo there big tusk"
		}
Output: {
			"allo there big tusk",
			"Allo there big tusk",
			"booo here"
			"zsfdsf dsafasd sdafasdf asdassadf"
			"zsfdsf dsafasd sdafasdf fadgadf"
}
	Sort the lines....
*/

package practice.aPractice;
import java.util.*;

public class SortLogFile {

	public static void main (String[] args) {
		String[] input = {
		"booo here", 
		"zsfdsf dsafasd sdafasdf fadgadf", 
		"zsfdsf dsafasd sdafasdf asdassadf", 
		"allo there big tusk",
		"Allo there big tusk"
		};
		String[] output = sortLogs(input);

		for(int i=0; i< input.length; i++){
			System.out.println("-	"+input[i]);
		}
		System.out.println("SORTED: ");
		for(int i=0; i< input.length; i++){
			System.out.println("-	"+output[i]);
		}
	}


	public static String[] sortLogs(String[] log) {
		PriorityQueue<String> queue = new PriorityQueue<String>(new LogComparator());
		for(String s : log) {
			queue.add(s);
		}
		String[] result = new String[log.length];

		for(int i=0; i< log.length; i++){
			result[i] = queue.poll();
		}
		return result;
	}

	static class LogComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			a = a.toLowerCase();
			b = b.toLowerCase();
			char[] aArray = a.toCharArray();
			char[] bArray = b.toCharArray();
			int len = Math.min(aArray.length, bArray.length);

			for(int i=0; i < len; i++){
				if(aArray[i] < bArray[i]) {
					return -1;
				}
				else if(aArray[i] > bArray[i]) {
					return 1;
				}
			}
			return 0;
		}
	}
}


