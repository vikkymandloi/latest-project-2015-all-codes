package com.normalThread;

class Temp5{
	static int count = 0;
	
	public static void incrementCount(){
		synchronized (Temp5.class) {
			for(int i=0;i<1E4;i++) {
				count++;
			}
			System.out.println(count);
		}
	}
}

public class ClassLevelSync {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Temp5.incrementCount();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Temp5.incrementCount();
			}
		});
		
		t1.start();
		t2.start();
		
	}

}
