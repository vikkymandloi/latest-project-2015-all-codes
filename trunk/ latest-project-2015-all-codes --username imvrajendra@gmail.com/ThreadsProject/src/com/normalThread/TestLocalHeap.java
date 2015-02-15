package com.normalThread;

import java.util.Arrays;

class HeapStackTest{
	public void count(){
		int count = 5;
		int[] arr = new int[count];
		for(int i=0;i<1E5;i++) {
			if(--count==-1) {
				count=4;
			} 
			arr[count] = i;
		}
		System.out.println(Thread.currentThread().getName()+" = "+Arrays.toString(arr));
	}
}

public class TestLocalHeap {

	/*public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(50);
		final HeapStackTest test1 = new HeapStackTest();
		for(int i=0;i<50;i++) {
			service.submit(new Runnable() {
				@Override
				public void run() {
					test1.count();
				}
			});
		}
		service.shutdown();
		try {
			service.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}*/
	
	public static void main(String[] args) {
		final HeapStackTest test1 = new HeapStackTest();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				test1.count();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				test1.count();
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				test1.count();
			}
		});
		
		t1.start();t2.start();t3.start();
	}
}
