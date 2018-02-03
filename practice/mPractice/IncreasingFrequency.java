/**
Order an array with increasing frequency
Input -> [ 2 2 2 2 4 4 8 9 9 12 5]
Output -> [ 2 2 2 2 4 4 9 9 5 8 12]
*/
package practice.mPractice;
import java.util.*;



public class IncreasingFrequency{
	public static void main(String[] args) {
		boolean usedDefault = false;
		int[] x = {2, 2, 2, 2, 4, 4, 8, 9, 9, 12, 5, 1 , 3};
		if (args.length == 0){
			System.out.println("Passed in nothing!: going to use the default: "+Arrays.toString(x));
			usedDefault = true;
		}else{
			int[] y = new int[args.length];
			for(int i = 0;i < args.length;i++){
				try {
					y[i] = Integer.parseInt(args[i]);
    			}
    			catch (NumberFormatException nfe){
					System.out.println("Passed in incorrectly!: going to use the default: "+Arrays.toString(x));
					usedDefault = true;
					break;
        		}
			}
			if(!usedDefault){
				System.out.println(Arrays.toString(getIncreasingFreqArray(y)));
			}
		}
		if(usedDefault){
			System.out.println(Arrays.toString(getIncreasingFreqArray(x)));
		}

	}


	public static int[] getIncreasingFreqArray(int[] input){
		int[] output = new int[input.length];

		HashMap<Integer,Integer> freqMap = new HashMap<Integer,Integer>();

		for(int i=0; i<input.length; i++){
			if(freqMap.containsKey(input[i])){
				int total = freqMap.get(input[i]);
				total++;
				freqMap.put(input[i], total);
			}
			else{
				freqMap.put(input[i], 1);
			}
		}
		System.out.println(freqMap);

		int max = 0;
		int maxKey = 0;

		int outPutIndex = 0;
		while(!freqMap.isEmpty()){
			for(Integer i : freqMap.keySet()){
				int current = freqMap.get(i);
				if(max<current){
					max = current;
					maxKey = i;
				}
			}
			if(max == 1){
				break;
			}
			for(int j = 0; j<max; j++){
				output[outPutIndex] = maxKey;
				outPutIndex++;
			}
			freqMap.remove(maxKey);
			max = 0;
		}

		if(!freqMap.isEmpty()){
			ArrayList<Integer> leftover = new ArrayList<Integer>(freqMap.keySet());
			Collections.sort(leftover);
			for(int i = 0; i<leftover.size(); i++){
				output[outPutIndex] = leftover.get(i);
				outPutIndex++;
			}
		}
		return output;
	}


	// Or you could have just used a treeMap.............




}