package volatileKeyword;

import java.util.Scanner;

class Temp6 extends Thread {
	public static boolean running = true;
	@Override
	public void run() {
		while(running) {
			System.out.println("Hello from "+Thread.currentThread().getName());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class VolatileTestStop {

	public static void main(String[] args) {
		Temp6 t1 = new Temp6();
		Temp6 t2 = new Temp6();
		Temp6 t3 = new Temp6();
		
		t1.start();
		t2.start();
		t3.start();
		
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
		t1.running = false;
	}

}
