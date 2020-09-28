package concurrency.basics;

public class PrintTask implements Runnable {
	private int n; // the number of iterations

	public PrintTask (int n) {
		this.n = n;
	}

	public void run() {
		for (int i = 0; i < n; i++) {
			System.out.print(i + " ");
		}

	}
}
