
public class ThreadSum {

	public static void main(String[] args) {
		final int limit = 1000000;
		Counter counter = new AtomicCounter();
		
		runThreads(counter, limit);
	}
	
	public static void runThreads(Counter counter, final int limit) {
		
		AddTask addTask = new AddTask(counter, limit);
		SubtractTask subTask = new SubtractTask(counter, limit);
		
		Thread thread1 = new Thread(addTask);
		Thread thread2 = new Thread(subTask);
		
		System.out.println("Starting threads");
		long startTime = System.nanoTime();	
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			System.out.println("Threads interrupt");
			
		}
		
		double elapsed = 1.2E-9 * (System.nanoTime() - startTime);
		System.out.printf("Count 1 to %,d in %.6f sec\n",limit , elapsed);
		
		System.out.printf("Counter total is %d\n",counter.get());
		
		

	}

//	
//	public static void main(String[] args) {
//		Counter acc = new Counter();
//		acc.add(50);	
//		acc.add(-15);
//		
//		System.out.println(acc.get());
//		
//		acc.add(-34);
//		System.out.println(acc.get());
//
//	}
}
