package oppsConcept;

import java.lang.reflect.Constructor;

class HelloWorld implements Cloneable{
	public HelloWorld(int a){
		System.out.println("hello");
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class ObjectCreationTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, CloneNotSupportedException {
		//HelloWorld h1 = new HelloWorld();	// using new Keyword;
		//Constructor h2 = Class.forName("oppsConcept.HelloWorld").getConstructor(String.class);
		//HelloWorld h3 = new HelloWorld(1233);
		//HelloWorld h4 = (HelloWorld)h3.clone();
		HelloWorld h5 = (HelloWorld) HelloWorld.class.getClassLoader().loadClass("oppsConcept.HelloWorld").newInstance();
		
	}
}
