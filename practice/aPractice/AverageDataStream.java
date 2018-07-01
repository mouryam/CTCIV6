/**
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/

package practice.aPractice;
import java.util.*;


public class AverageDataStream{

	public static void main(String[] args){
		MovingAverage m = new MovingAverage(3);
		m.next(1);
		m.next(10);
		m.next(3);
		m.next(5);
	}
}

class MovingAverage{
	Queue<Integer> queue;
	double sum;
	int size;
	public MovingAverage(int size){
		queue = new LinkedList<>();
		sum=0;
		this.size =size;
	}


	public double next(int val){
		if(queue.size()>=size){
			sum-=queue.poll();
		}
		queue.offer(val);
		sum+=val;

		double result = sum/queue.size();
		System.out.println("Average: "+result);
		return result;
		
	}
}
