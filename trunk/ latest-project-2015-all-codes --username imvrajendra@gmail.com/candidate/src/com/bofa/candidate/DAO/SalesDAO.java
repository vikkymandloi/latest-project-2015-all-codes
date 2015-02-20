/**
 *  Sales DAO
 */
package com.bofa.candidate.DAO;

import java.util.List;
import java.util.Map;

import com.bofa.candidate.entity.Customer;
import com.bofa.candidate.entity.Sales;

/**
 * @author vmandloi
 */
public interface SalesDAO {
	/**
	 * Obtain all Sales records
	 * @author vmandloi
	 * @return
	 */
	public List<Sales> getAllSales();
	
	/**
	 * Obtain all Sales records between Sales start / End Date
	 * @author vmandloi
	 * @param startDate, endDate
	 * @return
	 */
	public List<Sales> getAllSalesBetween(String startDate,String endDate);
	
	/**
	 * Obtain all Sales records between Sales start / End Date with Customer ID
	 * @author vmandloi
	 * @param customerId, startDate, endDate
	 * @return
	 */
	public Map<String, List<Sales>> getAllSalesForCustomer(List<String> customer, String startDate,String endDate);
	
	/**
	 * Obtain all Sales records with Customer ID
	 * @author vmandloi
	 * @param customerId, startDate, endDate
	 * @return
	 */
	public Map<String, List<Sales>> getAllSalesForCustomer(List<String> customer);
}
