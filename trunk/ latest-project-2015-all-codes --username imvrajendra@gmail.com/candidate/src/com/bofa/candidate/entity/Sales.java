/**
 * 
 */
package com.bofa.candidate.entity;

import com.bofa.candidate.superentity.SuperAbstract;

/**
 * @author vmandloi
 * Sales Entity 
 */
public class Sales implements SuperAbstract {
	private static final long serialVersionUID = -8068518184431752018L;
	String customer_id;
	String sale_date;
	String sale_amount;
	public Sales(String customer_id, String sale_date, String sale_amount) {
		super();
		this.customer_id = customer_id;
		this.sale_date = sale_date;
		this.sale_amount = sale_amount;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getSale_date() {
		return sale_date;
	}
	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}
	public String getSale_amount() {
		return sale_amount;
	}
	public void setSale_amount(String sale_amount) {
		this.sale_amount = sale_amount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result
				+ ((sale_amount == null) ? 0 : sale_amount.hashCode());
		result = prime * result
				+ ((sale_date == null) ? 0 : sale_date.hashCode());
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
		Sales other = (Sales) obj;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (sale_amount == null) {
			if (other.sale_amount != null)
				return false;
		} else if (!sale_amount.equals(other.sale_amount))
			return false;
		if (sale_date == null) {
			if (other.sale_date != null)
				return false;
		} else if (!sale_date.equals(other.sale_date))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sales [customer_id=" + customer_id + ", sale_date=" + sale_date
				+ ", sale_amount=" + sale_amount + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
