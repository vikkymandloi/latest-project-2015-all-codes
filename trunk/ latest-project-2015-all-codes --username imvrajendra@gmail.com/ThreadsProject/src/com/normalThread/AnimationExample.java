package com.normalThread;

class HelloWorld {
	public HelloWorld() {
		try {
			//wait();
			Thread.sleep(4000);
			notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public class AnimationExample{  
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				new HelloWorld();
			}
		});
		t1.start();
	}
}  