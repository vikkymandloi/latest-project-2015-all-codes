package oppsConcept;

class A{
	public A(){
		System.out.println("A is called");
	}
	
	static{
		System.out.println("Static A is called");
	}
	
	{
		System.out.println("UnNamed A is called");
	}
	
	public A(int a){
		System.out.println("A parameterized is Called");
	}
	
	static int hello(int a){
		return 12;
	}
}

class B extends A{
	public B(){
		System.out.println("B is Called");
	}
	
	{
		System.out.println("UnNamed B is called");
	}
	
	static{
		System.out.println("Static B is called");
	}
	
	int hello(String l) {
		return 12;
	}
}

class C extends A{
	
}

public class OopsConceptTest {
	public static void main(String[] args) {
		B a1 = (B) new A();
		
	}
}
