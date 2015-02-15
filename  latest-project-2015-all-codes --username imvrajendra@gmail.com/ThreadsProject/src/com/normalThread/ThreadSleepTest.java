package com.normalThread;

class Test5 {
	public void sleepMethod() throws InterruptedException{
		System.out.println("INSIDE Method");
		Thread.sleep(3000);
		System.out.println("EXITING Method");
	}
}

public class ThreadSleepTest {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					new Test5().sleepMethod();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t1.join();
		Thread.sleep(3000);
		
		System.out.println("Method Finished");
		
	}
}
