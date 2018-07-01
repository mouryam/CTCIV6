/**
Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and 
you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). 
You may assume that the earliest timestamp starts at 1.

It is possible that several hits arrive roughly at the same time.

Example:
HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3.
counter.getHits(301); 
Follow up:
What if the number of hits per second could be very large? Does your design scale?
-
Concurrency update becomes an issue. Add write lock for protection (synchronized block). But this may slowdown the machine badly.
Move hit counters onto a distributed system. Have several machines counting together. Assign userIDs to diff hosts.
Add LB on top to make sure requests get distributed evenly.
Upon reading, sum up counts across all machines. For a read-heavy system, add cache.
*/

package practice.aPractice;
import java.util.*;
import java.util.concurrent.*;

public class HitCount {

	public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
		HitCounter counter = new HitCounter(5);

        Runnable task = () -> {
            System.out.println("Executing inside : " + Thread.currentThread().getName());
        	for(int i=0; i<100; i++){
				counter.hit(1);
				counter.hit(2);
				counter.hit(3);
				counter.hit(4);
				counter.hit(5);
        	}
			counter.getHits(5);
        };

        executorService.submit(task);
        executorService.submit(task);
        executorService.shutdown();
        try {
    		executorService.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
    		e.printStackTrace();
		}
		counter.getHits(6);
				counter.getHits(7);

	}
}

class HitCounter {
	int interval;
	int[] times;
	int[] hits;

	public HitCounter(int interval){
		this.interval = interval;
		times = new int[interval];
		hits = new int[interval];
	}

	public synchronized void hit(int time){
		// System.out.println(Thread.currentThread().getName()+" - Adding at time: "+time);
		int index = time % interval;
		if(times[index] !=time){
			times[index] = time;
			hits[index] = 1;
		} else {
			hits[index]++;
		}
	}
	public synchronized int getHits(int time){
		int total = 0;
		for(int i=0; i<interval; i++){
			if(time - times[i] < 300){
				total += hits[i];
			}
		}
		System.out.println(Thread.currentThread().getName()+ " - Total at time '"+time+"': "+total);
		return total;
	}

}


