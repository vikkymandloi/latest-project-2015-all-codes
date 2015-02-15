package immutableClass;

class FullName {
	private String fname;
	private String lname;

	public FullName(String fname, String lname){
		this.fname = fname;
		this.lname = lname;
	}
	
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	@Override
	public String toString() {
		return "FullName [fname=" + fname + ", lname=" + lname + "]";
	}	
}

class EmployeeDetails {
	private int empId;
	private FullName name;
	
	public EmployeeDetails(int empId, FullName name) {
		this.empId = empId;
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}
	public FullName getName() {
		return name;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [empId=" + empId + ", name=" + name + "]";
	}
}


public class ImmutabilityTest {
	public void testFullName(){
		FullName name1 = new FullName("Vrajendra","Mandloi");
		System.out.println("Hash Code = "+name1.hashCode());
		System.out.println(name1);
		
		name1 = new FullName("Ruchi", "Mandloi");
		System.out.println("Hash Code = "+name1.hashCode());
		System.out.println(name1);
	}
	
	public void testEmployeeDetails(){
		FullName name = new FullName("Vrajendra","Mandloi");
		EmployeeDetails detail = new EmployeeDetails(123, name);
		
		System.out.println("Hash Code = "+detail.hashCode());
		System.out.println(detail);
		
		name = new FullName("Ruchi", "Mandloi");
		System.out.println("Hash Code = "+detail.hashCode());
		System.out.println(detail);
	}
	public static void main(String[] args) {
		new ImmutabilityTest().testEmployeeDetails();
	}
}
