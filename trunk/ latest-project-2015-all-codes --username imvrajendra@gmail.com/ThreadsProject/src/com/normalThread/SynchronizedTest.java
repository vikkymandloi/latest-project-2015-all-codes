package com.normalThread;

class SyncTestLocal {
	
	Object ob1 = new Object();
	Object ob2 = new Object();
	
	public void method1(){
		synchronized (ob1) {
			System.out.println(Thread.currentThread().getName()+" called Method 1..");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void method2(){
		synchronized (ob2) {
			System.out.println(Thread.currentThread().getName()+" called Method 2..");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class SynchronizedTest {
	
	public static void main(String[] args) {
		final SyncTestLocal sync1 = new SyncTestLocal();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				new SyncTestLocal().method1();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				new SyncTestLocal().method2();
			}
		});
		
		t1.start();
		t2.start();
	}

}
