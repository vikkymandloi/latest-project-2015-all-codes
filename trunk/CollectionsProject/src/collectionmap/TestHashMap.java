package collectionmap;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

class KeyComp implements Comparable<KeyComp>{
	private String name;
	private int id;
	
	public KeyComp(String name, int id){
		this.name = name;
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyComp other = (KeyComp) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "name=" + name + ", id=" + id;
	}
	
	@Override
	public int compareTo(KeyComp o) {
		return this.name.compareTo(o.name);
	}
}

class ValueComp implements Comparable<ValueComp>{
	String name;
	int id;
	
	public ValueComp(String name, int id){
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "name=" + name + ", id=" + id ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValueComp other = (ValueComp) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(ValueComp o) {
		return this.name.compareTo(o.name);
	}
	
}

public class TestHashMap {

	public static <T> void main(String[] args) {
		KeyComp comp1 = new KeyComp("Vrajendra Mandloi",123);
		KeyComp comp2 = new KeyComp("Ekta Mandloi",234);
		KeyComp comp3 = new KeyComp("Jaya Mandloi",345);
		KeyComp comp4 = new KeyComp("Ritika Mandloi",456);
		KeyComp comp5 = new KeyComp("Rajendra Mandloi",567);
		KeyComp comp6 = new KeyComp("Lokendra Mandloi",678);
		KeyComp comp7 = new KeyComp("Gajendra Mandloi",789);
		KeyComp comp8 = new KeyComp("Vicky Mandloi",890);
		
		ValueComp vcomp1 = new ValueComp("Vrajendra Mandloi",123);
		ValueComp vcomp2 = new ValueComp("Ekta Mandloi",234);
		ValueComp vcomp3 = new ValueComp("Jaya Mandloi",345);
		ValueComp vcomp4 = new ValueComp("Ritika Mandloi",456);
		ValueComp vcomp5 = new ValueComp("Rajendra Mandloi",567);
		ValueComp vcomp6 = new ValueComp("Lokendra Mandloi",678);
		ValueComp vcomp7 = new ValueComp("Gajendra Mandloi",789);
		ValueComp vcomp8 = new ValueComp("Vicky Mandloi",890);
		
		//Map<KeyComp, ValueComp> map1 = new HashMap<KeyComp, ValueComp>();
		Map<KeyComp, ValueComp> map1 = new TreeMap<KeyComp, ValueComp>();
		//Map<KeyComp, ValueComp> map1 = new LinkedHashMap<KeyComp, ValueComp>();
		
		map1.put(comp1, vcomp8);
		map1.put(comp2, vcomp7);
		map1.put(comp3, vcomp6);
		map1.put(comp4, vcomp5);
		map1.put(comp5, vcomp4);
		map1.put(comp6, vcomp3);
		map1.put(comp7, vcomp2);
		map1.put(comp8, vcomp1);
		
		int arr[] = new int[]{1,2,3,4,5,6,7,8,9,10};
		System.arraycopy(arr, 0, arr, 2, arr.length-2);
		arr = Arrays.copyOf(arr, 15);
		System.out.println(arr.length);
		System.out.println(map1.toString());
	}
}
