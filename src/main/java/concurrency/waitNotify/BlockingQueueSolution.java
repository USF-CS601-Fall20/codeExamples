package concurrency.waitNotify;

import java.util.LinkedList;
import java.util.List;

/** BlockingQueue example - demonstrates the use of wait() and notify().
 * From http://tutorials.jenkov.com/java-concurrency/blocking-queues.html
 */
public class BlockingQueueSolution {
	private List<Integer> queue = new LinkedList<>();
	private int capacity;

	public BlockingQueueSolution(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Waits until there is space in the queue, then adds an element to the queue
	 * @param element the element to be added to the queue
	 * @throws InterruptedException
	 */
	public synchronized void enqueue(Integer element) throws InterruptedException {
		while (queue.size() == capacity) {
			System.out.println(Thread.currentThread().getName() + " is waiting...");
			this.wait();
		}
		queue.add(element);
		System.out.println("Inserting " + element); //should be using Logger instead

		//System.out.println(Thread.currentThread().getName() + " is notifying all...");
		this.notifyAll();
	}

	/**
	 * Waits until the queue has something to dequeue, then dequeues it and returns the element.
	 * @return the first element from the queue
	 * @throws InterruptedException
	 */
	public synchronized Integer dequeue() throws InterruptedException {
		while (queue.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " is waiting...");
            this.wait();

		}

		Integer item = queue.remove(0);
		System.out.println("Removing " + item); // should be using Logger instead

		//System.out.println(Thread.currentThread().getName() + " is notifying all...");

		this.notifyAll();
		return item;
	}
}
