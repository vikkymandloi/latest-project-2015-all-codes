package oppsConcept;

class hello {
	public void helloWorld() throws Exception{
		for(int i=0;i<10;i++) {
			System.out.println(i);

			if(i==3)
				throw new Exception();
		}
	}
}

public class ExceptionTest {

	public static void main(String[] args) throws Exception {
		new hello().helloWorld();
	}

}
