package com.normalThread;

import java.util.Scanner;

class Test1 {

	public void producer1(){
		synchronized (this) {
			System.out.println("Inside Producer Class 1 ....");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Producer class 1 Resumed.. ");
		}
	}

	public void producer2(){
		synchronized (this) {
			System.out.println("Inside Producer Class 2 ....");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Producer class 2 Resumed.. ");
		}
	}

	public void producer3(){
		synchronized (this) {
			System.out.println("Inside Producer Class 3 ....");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Producer class 3 Resumed.. ");
		}
	}

	public synchronized void consumer(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inside Consumer Class ...");
		scanner.nextLine();
		System.out.println("Return Key Pressed..");
		notifyAll();
	}
}

public class WaitExample {

	public static void main(String[] args) {
		final Test1 test = new Test1();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					test.producer1();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					test.producer2();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					test.producer3();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					test.consumer();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
