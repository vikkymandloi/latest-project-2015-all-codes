package volatileKeyword;

public class VolatileTest {

	private static int count = 0;

	public static void main(String[] args) {
		VolatileTest v1 = new VolatileTest();
		v1.doWork();		
	}

	public void doWork() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				readVar();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				writeVar();
			}
		});

		t1.start();
		t2.start();
	}

	public void readVar(){
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(count);
		}
	}

	public void writeVar(){
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
		}
	}
}
