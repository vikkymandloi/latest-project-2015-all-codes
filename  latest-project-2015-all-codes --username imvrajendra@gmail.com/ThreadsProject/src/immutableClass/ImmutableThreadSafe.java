package immutableClass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ImmutableValue{

	private int value = 0;

	public ImmutableValue(int value){
		this.value = value;
	}

	public int getValue(){
		return this.value;
	}

	public ImmutableValue add(int valueToAdd){
		return new ImmutableValue(this.value + valueToAdd);
	}
}


public class ImmutableThreadSafe implements Runnable {
	
	ImmutableValue value1 = new ImmutableValue(0);
	
	public void valueTest(){
		for(int i=0;i<100;i++) 
			value1 = value1.add(i);
		System.out.println("Final Value : "+value1.getValue());
	}
	
	@Override
	public void run() {
		valueTest();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(50);
		
		ImmutableThreadSafe it1 = new ImmutableThreadSafe();
		for(int i=0;i<50;i++){
			service.submit(new ImmutableThreadSafe());
		};
		service.shutdown();
		
		service.awaitTermination(1, TimeUnit.DAYS);
	}
}
