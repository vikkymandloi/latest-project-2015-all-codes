package synchronizeBlock;

// In this Class there is no Need of Synchronization 
class Temp4 implements Runnable{
	private volatile static int count = 0;
	
	public void incrementCount(){
		for(int i=0;i<1E5;i++)
			count++;
		
		System.out.println("Count is from "+Thread.currentThread().getName()+" is : "+count);
	}
	
	@Override
	public void run() {
		incrementCount();
	}
}

public class CounterAnother {

	public static void main(String[] args) {
		Temp4 t4 = new Temp4();
		// with Same instance
		Thread t1 = new Thread(t4);
		Thread t2 = new Thread(t4);
		
		// With different instance
		/*Thread t1 = new Thread(new Temp4());
		Thread t2 = new Thread(new Temp4());*/
		
		t1.start();
		t2.start();
	}
}
