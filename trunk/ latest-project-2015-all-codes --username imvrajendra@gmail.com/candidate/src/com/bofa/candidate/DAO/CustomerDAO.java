/**
 *  Customer DAO
 */
package com.bofa.candidate.DAO;

import java.util.List;

import com.bofa.candidate.entity.Customer;

/**
 * @author vmandloi
 */
public interface CustomerDAO{
	
	/**
	 * Obtain List of all Customers.
	 * @author vmandloi
	 * @return
	 */
	public List<Customer> getAllCustomers();
	
	/**
	 * Obtain all Customers before sales Date
	 * @author vmandloi
	 * @param beforeSalesDate
	 * @return
	 */
	public List<Customer> getAllCustomers(String beforeSalesDate);
}
