package immutableClass;

import java.util.ArrayList;
import java.util.List;

class TestImmuneName{
	private String companyName;
	private List<FullName> empName;
	
	public TestImmuneName(String companyName, List<FullName> empName){
		this.companyName = companyName;
		this.empName = empName;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public List<FullName> getEmpName() {
		//return Collections.unmodifiableList(empName);
		return new ArrayList<FullName>(this.empName);
	}
	@Override
	public String toString() {
		return "TestImmuneName [companyName=" + companyName + ", empName="
				+ empName + "]";
	}
}

public class ImmutableListTest {
	public void testListDetails(){
		FullName name = new FullName("Vrajendra","Mandloi");
		List<FullName> listName = new ArrayList<FullName>();
		listName.add(name);
		TestImmuneName detail = new TestImmuneName("Deloitte", listName);
		
		System.out.println("Hash Code = "+detail.hashCode());
		System.out.println(detail);
		
		name = new FullName("Ekta", "Mandloi");
		detail.getEmpName().add(name);
		System.out.println("Hash Code = "+detail.hashCode());
		System.out.println(detail);
	}
	
	public static void main(String[] args) {
		new ImmutableListTest().testListDetails();
	}
}
