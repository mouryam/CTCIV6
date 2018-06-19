/**
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

package practice.aPractice;
import java.util.*;

public class MinStack{
	public static void main(String[] args) {

		MyMinStack minStack = new MyMinStack();
		System.out.println("Pushing : 1, 2, 3, 4, 0");
		minStack.push(1);
		minStack.push(2);
		minStack.push(3);
		minStack.push(4);
		minStack.push(0);
		System.out.println("Top: "+minStack.top());
		System.out.println("Min: "+minStack.getMin());

		System.out.println("Popping...");
		minStack.pop();
		System.out.println("Top: "+minStack.top());
		System.out.println("Min: "+minStack.getMin());
	}

	static class MyMinStack{
		private class Node{
			int val;
			int min;
			Node next;

			private Node(int val, int min, Node next){
				this.val = val;
				this.min = min;
				this.next=next;
			}
		}
    	private Node head;
    	public void push(int x){
    		if(head == null){
    			head = new Node(x, x, null);
    		}
    		else{
    			head = new Node(x, Math.min(x,head.min), head);
    		}
    	}
    	public void pop(){
    		head = head.next;
    	}
    	public int top(){
    		return head.val;
    	}
    	public int getMin(){
    		return head.min;
    	}
	}


}