package immutableClass;

/**
 * Immutability points.. 
 * 1. Class values should not be changed if they change there hashcode should change.
 * 2. Class Should be final so that it cannot be extended.
 * 3. if any class is already extended 
*/

class HelloWorld {
	public final String FullName;
	
	public String getFullName() {
		return FullName;
	}

	public HelloWorld(String FullName){
		this.FullName = FullName;
	}

	@Override
	public String toString() {
		return "HelloWorld [FullName=" + FullName + "]";
	}	
}

final class TestImu extends HelloWorld{
	private final int employeeId;
	private final String employeeCompany;
	
	public TestImu(int employeeId, String employeeCompany, String FullName) {
		super(FullName);
		this.employeeId = employeeId;
		this.employeeCompany = employeeCompany;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public String getEmployeeCompany() {
		return employeeCompany;
	}
	@Override
	public String toString() {
		return "TestImu [employeeId=" + employeeId + ", employeeCompany="
				+ employeeCompany + ", Full Name=" + getFullName() + "]";
	}
}

public class TestImmutable {
	public void testImmutability1 (){
		TestImu t1 = new TestImu(12345, "Deloitte Corp.","Vrajendra Singh Mandloi");
		System.out.println(t1.hashCode()+" - "+t1);
		t1 = new TestImu(12345, "Google Tech.", "Vrajendra");
		System.out.println(t1.hashCode()+" - "+t1);
	}
	
	public void testImmutability2(){
		
	}
	
	public static void main(String[] args) {
		new TestImmutable().testImmutability1();
	}
}
