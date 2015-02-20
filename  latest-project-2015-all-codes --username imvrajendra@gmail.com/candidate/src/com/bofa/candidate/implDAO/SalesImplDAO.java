/**
 * 
 */
package com.bofa.candidate.implDAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bofa.candidate.ErrorLog;
import com.bofa.candidate.DAO.SalesDAO;
import com.bofa.candidate.entity.Sales;
import com.bofa.candidate.util.SalesConstants;
import com.bofa.candidate.util.SalesUtility;

/**
 * @author vmandloi
 *
 */
public class SalesImplDAO implements SalesDAO {
	ErrorLog error = null;
	public SalesImplDAO(){
		error = ErrorLog.getInstance();
	}

	/** @author vmandloi
	 * Populate the List according to the file Sales.txt.
	 */
	public List<Sales> getAllSales() {
		BufferedReader bufferReader = null;
		List<Sales> result = null;
		try {
			result = new ArrayList<Sales>();
			bufferReader = new BufferedReader(new FileReader(SalesConstants.INPUT_FILE_PATH+SalesConstants.SALES_FILE));
			String line = bufferReader.readLine(); 
			while(line != null) {
				String[] str = SalesUtility.splitString(line);
				Sales sale = new Sales(str[0], str[1], str[2]);
				result.add(sale);
				line = bufferReader.readLine();
			}
		} catch (FileNotFoundException e) {
			error.logError("FileNotFoundException :" +e.getMessage());
		} catch (IOException e) {
			error.logError("IOException :" +e.getMessage());
		} finally {
			try {
				bufferReader.close();
			} catch (IOException e) {
				error.logError("IOException "+e.getMessage());
			}
		}
		return result;
	}

	/** @author vmandloi
	 * @param startDate, endDate
	 * Populate the List according to the file Sales.txt, where sale date should be 
	 * in between the startDate and endDate.
	 */
	public List<Sales> getAllSalesBetween(String startDate, String endDate) {
		BufferedReader bufferReader = null;
		List<Sales> result = null;
		try {
			result = new LinkedList<Sales>();
			bufferReader = new BufferedReader(new FileReader(SalesConstants.INPUT_FILE_PATH+SalesConstants.SALES_FILE));
			String line = bufferReader.readLine(); 
			while(line != null) {
				String[] str = SalesUtility.splitString(line);
				Date saleEndDate = SalesUtility.getDate(endDate);
				Date saleStartDate = SalesUtility.getDate(startDate);
				Date saleDate = SalesUtility.getDate(str[1]);
				// Sales Date should be greater than the customer reg date.
				if(saleDate!= null && saleEndDate.compareTo(saleDate) >= 0 && saleStartDate.compareTo(saleDate) <= 0) {
					Sales customer = new Sales(str[0], str[1], str[2]);
					result.add(customer);
				}
				line = bufferReader.readLine();
			}
		} catch (FileNotFoundException e) {
			error.logError("FileNotFoundException :" +e.getMessage());
		} catch (IOException e) {
			error.logError("IOException :" +e.getMessage());
		} finally {
			try {
				bufferReader.close();
			} catch (IOException e) {
				error.logError("IOException "+e.getMessage());
			}
		}
		return result;
	}

	/** @author vmandloi
	 * Populate the List according to the file Sales.txt, where sale date 
	 * is between start date and end date, and also the customer id is Prior 
	 * to sale End Date.
	 */
	public Map<String, List<Sales>> getAllSalesForCustomer(List<String> customer, String startDate, String endDate) {
		Map<String, List<Sales>> result = null;
		List<Sales> resultSales = null;
		try {
			resultSales = getAllSalesBetween(startDate, endDate);
			result = new LinkedHashMap<String, List<Sales>>();
			// Traverse through all the records which are b/w the sales 
			// start date and end date.
			for(Sales saleRecord : resultSales) {
				String customerID = saleRecord.getCustomer_id();
				if(customer.contains(customerID)) {
					if(result.containsKey(customerID)){
						// if for a Customer already present in map then add a new record 
						// to the list of sales for that customer.
						result.get(customerID).add(saleRecord);
					} else {
						result.put(customerID, new LinkedList<Sales>());
					}
				}
			}
		} catch (Exception e) {
			error.logError("IOException :" +e.getMessage());
		}
		return result;
	}

}
