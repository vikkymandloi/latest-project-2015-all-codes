package synchronizeBlock;

public class CountNumberSynchronize {

	public static void main(String[] args) {
		CountNumberSynchronize v1 = new CountNumberSynchronize();
		v1.doWork();
	}
	
	private int count = 0;
	
	private synchronized void incrementCount(){
		count++;
	}
	
	public void doWork() {
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<1E4; i++) {
					incrementCount();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<1E4; i++) {
					incrementCount();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Total Count Value "+count);
	}
}
