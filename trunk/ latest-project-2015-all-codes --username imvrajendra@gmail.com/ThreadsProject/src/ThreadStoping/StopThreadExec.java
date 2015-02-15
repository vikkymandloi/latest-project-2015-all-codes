package ThreadStoping;

import java.util.Scanner;

class Temp2 implements Runnable{
	
	public static boolean running = true;
	@Override
	public void run() {
		while (running) {
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Current Thread "+Thread.currentThread().getName());
		}
	}
}

public class StopThreadExec {
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Temp2());
		Thread t2 = new Thread(new Temp2());
		
		t1.start();
		t2.start();
		
		System.out.println("Press Enter to ShutDown..!");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
		Temp2.running = false;	
		
		System.out.println("Thread Closed Execution..!");
		
	}
}
