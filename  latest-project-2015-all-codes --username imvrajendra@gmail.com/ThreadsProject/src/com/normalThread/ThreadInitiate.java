package com.normalThread;

class Temp1 implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Hello From Thread "+Thread.currentThread().getName());
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadInitiate {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Temp1());
		Thread t2 = new Thread(new Temp1());
		t1.setPriority(1);
		t2.setPriority(10);
		
		t1.start();
		t2.start();
		
	}
}
