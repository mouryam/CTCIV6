/**
Median is the middle value in an ordered integer list. If the size of the list is even, 
there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3
[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:
	void addNum(int num) - Add a integer number from the data stream to the data structure.
	double findMedian() - Return the median of all elements so far.

Example:
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2

*/

package practice.aPractice;
import ctciutil.TreeNode;
import ctciutil.CTCIMethods;
import java.util.*;


// So we got a BST and Queue approach...
// most likely BST for interviews. Smarter way is Queue..Do both for practice
public class MedianDataStream{

	public static void main(String[] args) {
		// MedianFinderBST medianFinder = new MedianFinderBST();
		MedianFinderHEAPS medianFinder = new MedianFinderHEAPS();

		medianFinder.addNum(2);
			System.out.println(medianFinder.findMedian());
		medianFinder.addNum(3);
				System.out.println(medianFinder.findMedian());
		medianFinder.addNum(0);
				System.out.println(medianFinder.findMedian());
		medianFinder.addNum(1);
				System.out.println(medianFinder.findMedian());
		medianFinder.addNum(4);
				System.out.println(medianFinder.findMedian());

		medianFinder.print();
	}

	static class MedianFinderHEAPS{
		private PriorityQueue<Integer> small = new PriorityQueue<Integer>(Comparator.reverseOrder());
		private PriorityQueue<Integer> large = new PriorityQueue<Integer>();
		public MedianFinderHEAPS(){ 
		}

		public void addNum(int num){
			small.offer(num);
			large.offer(small.poll());
			if(large.size()> small.size()){
				small.offer(large.poll());
			}
		}
    	public double findMedian() {
        	if(large.size() == small.size()){
        		return ( (large.peek() + small.peek()) / 2.0);
        	}
        	return small.peek();
    	}
    	public void print(){
    		System.out.println("PQ ARE NOT IN ORDER!");
    		System.out.println(small);
    		System.out.println(large);
    	}

	}

	static class MedianFinderBST{
	    public TreeNode root;
	    private TreeNode medianLeft;
	    private TreeNode medianRight;
        private int size;

    	
    	public MedianFinderBST(){
    	}
    	public void print(){
    		root.print();
    	}

	    public void addNum(int num) {
	        if (root == null) {
	            root = new TreeNode(num);
	            medianLeft = root;
	            medianRight = root;
	        }
	        else{
	        	root.insertInOrder(num);

	        	if(size %2 == 0){
	        		if(num <= medianLeft.data){
	        			medianRight = medianLeft;
	        		}
	        		else if(num > medianLeft.data && num <= medianRight.data){
	        			medianLeft = getSuccessor(medianLeft);
	        			medianRight = getPredecessor(medianRight);
	        		}
	        		else if (num > medianRight.data){
	        			medianLeft = medianRight;
	        		}
	        	}
	        	else {
	        		if(num <= medianLeft.data){
	        			medianLeft = getPredecessor(medianLeft);
	        		}
	        		else{
	        			medianRight = getSuccessor(medianRight);
	        		}
	        	}
	        }
	        size++;
    	}

    	public double findMedian() {
        	return (medianLeft.data + medianRight.data) / 2.0;
    	}

    	public TreeNode getSuccessor(TreeNode x){
    		if(x.right !=null){
    			return leftMost(x.right);
    		}
    		TreeNode successor = x.parent;
    		TreeNode child = x;

    		while(successor!=null && child != successor.left){
    			child = successor;
    			successor = successor.parent;
    		}
    		return successor;
    	}

    	public TreeNode getPredecessor(TreeNode x){
    		if(x.left !=null){
    			return rightMost(x.left);
    		}
    		TreeNode predecessor = x.parent;
    		TreeNode child = x;

    		while(predecessor!=null && child != predecessor.right){
    			child = predecessor;
    			predecessor = predecessor.parent;
    		}
    		return predecessor;
    	}

        private TreeNode rightMost(TreeNode x) {
            if (x.right == null){
            	return x;	
            }
            return rightMost(x.right);
        }

        private TreeNode leftMost(TreeNode x){
        	if (x.left == null){
        		return x;
        	}
        	return leftMost(x.left);
        }

	}
}



