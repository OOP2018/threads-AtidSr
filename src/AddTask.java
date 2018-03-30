
public class AddTask implements Runnable {
	
	private Counter counter;
	private int limit;
	
	public AddTask(Counter counter , int limit) {
		this.counter = counter;
		this.limit = limit;
	}
	
	public void run() {
		for (int k = 0 ; k <= limit ; k++) {
			counter.add(k);
		}
		System.out.println("Done " + Thread.currentThread().getName());

	}


}
