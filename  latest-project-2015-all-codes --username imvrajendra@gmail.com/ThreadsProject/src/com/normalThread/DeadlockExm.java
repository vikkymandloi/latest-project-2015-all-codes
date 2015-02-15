package com.normalThread;

class Test3 {
	public static synchronized void method1(){
		System.out.println("Inside Method 1");
		Test2.method2(); 
		System.out.println("Outside Method 1");
	}

	public static synchronized void method2(){
		System.out.println("Inside Method 2");
		System.out.println("Outside Method 2");
	}
}

class Test2 {
	public static synchronized void method1(){
		System.out.println("Inside Method 1");
		Test3.method2();
		System.out.println("Outside Method 1");
	}

	public static synchronized void method2(){
		System.out.println("Inside Method 2");
		System.out.println("Outside Method 2");
	}
}

public class DeadlockExm {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Test2.method1();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Test3.method1();
			}
		});

		t1.start();
		t2.start();
	}
}
