package oppsConcept;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class someone implements Cloneable {  
	
}  

public class SingletonFinal extends someone implements Runnable{  
	static private SingletonFinal objectTest;  
	private SingletonFinal(){  
	}  

	public static synchronized SingletonFinal getObjectReference()  
	{  
		if(objectTest == null) {             
			objectTest = new SingletonFinal();  
			//System.out.println("Object created");  
		}
		/*else{  
			System.out.println("Object already created");  
		}*/  
		return objectTest;  
	}  

	@Override
	public void run() {
		System.out.println(getObjectReference());
	}

	public Object clone() throws CloneNotSupportedException  
	{  
		throw new CloneNotSupportedException("cloning of this class is not supported by me…");   
	}  

	public static void main(String args[]){  

		/*single obj =single.getObjectReference();  
		System.out.println("Main Object" +obj);
		 */
		ExecutorService executor = Executors.newFixedThreadPool(100);

		for(int i=0;i<100;i++){
			executor.submit(new SingletonFinal());
		}

		/*try {  
			single clone =(single)obj.clone();  

			System.out.println("Clone Object" +clone);  
		} catch (CloneNotSupportedException e) {  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
		}*/  
	}  
}  