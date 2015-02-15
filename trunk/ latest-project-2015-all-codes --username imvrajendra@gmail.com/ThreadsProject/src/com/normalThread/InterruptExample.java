package com.normalThread;

import java.util.Scanner;

class Test4{
	public void producer() throws InterruptedException{
		synchronized (this) {
			System.out.println("Inside Producer Class ...!");
			wait();
			System.out.println("Thread Resumed... after Interrupt");
		}
	}
	
	public void consumer() throws InterruptedException{
		Thread.sleep(1000);
		Scanner scan = new Scanner(System.in);
		synchronized (this) {
			System.out.println("Inside Consumer Class ...!");
			scan.nextLine();
			System.out.println("Thread Interrupted");
		}
	}
}

public class InterruptExample {

	public static void main(String[] args) {
		final Test4 test = new Test4();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					test.producer();
				} catch (InterruptedException e) {
					System.out.println("Thread1 Interrupted after finish of Thread 2");
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					test.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(!t2.isAlive())
			t1.interrupt();
	}
	
}
