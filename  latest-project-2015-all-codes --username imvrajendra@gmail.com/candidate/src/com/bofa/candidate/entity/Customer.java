/**
 * 
 */
package com.bofa.candidate.entity;

import com.bofa.candidate.superentity.SuperAbstract;

/**
 * @author vmandloi
 * Customer Entity.
 */
public class Customer implements SuperAbstract {
	private static final long serialVersionUID = 7695075032221645444L;
	String customer_id;
	String customer_name;
	String date_created;
	
	public Customer(String customer_id, String customer_name,
			String date_created) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.date_created = date_created;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getDate_created() {
		return date_created;
	}
	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result
				+ ((customer_name == null) ? 0 : customer_name.hashCode());
		result = prime * result
				+ ((date_created == null) ? 0 : date_created.hashCode());
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
		Customer other = (Customer) obj;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (customer_name == null) {
			if (other.customer_name != null)
				return false;
		} else if (!customer_name.equals(other.customer_name))
			return false;
		if (date_created == null) {
			if (other.date_created != null)
				return false;
		} else if (!date_created.equals(other.date_created))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name="
				+ customer_name + ", date_created=" + date_created + "]";
	}

	/* (non-Javadoc)
	 * @see com.bofa.candidate.superentity.SuperAbstract#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o) {
		Customer obj = (Customer) o;
		return this.customer_name.compareTo(obj.customer_name);
	}

}
