package com.normalThread;

class StaticSyncTest{

	public static synchronized void method1(){
		System.out.println(Thread.currentThread().getName()+" called Method 1..");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized void method2(){
		System.out.println(Thread.currentThread().getName()+" called Method 2..");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class SynchTestClass {

	public static void main(String[] args) {
		
		final StaticSyncTest sync1 = new StaticSyncTest();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				StaticSyncTest.method1();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				StaticSyncTest.method2();
			}
		});
		
		t1.start();
		t2.start();
	}

}
