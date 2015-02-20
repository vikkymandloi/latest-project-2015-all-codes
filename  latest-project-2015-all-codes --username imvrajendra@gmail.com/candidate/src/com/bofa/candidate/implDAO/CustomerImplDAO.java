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
import java.util.List;

import com.bofa.candidate.ErrorLog;
import com.bofa.candidate.DAO.CustomerDAO;
import com.bofa.candidate.entity.Customer;
import com.bofa.candidate.util.SalesConstants;
import com.bofa.candidate.util.SalesUtility;

/**
 * @author vmandloi
 * Implementation to obtain all the data from customer.txt file.
 */
public class CustomerImplDAO implements CustomerDAO{

	ErrorLog error = null;
	public CustomerImplDAO(){
		error = ErrorLog.getInstance();
	}

	/** @author vmandloi
	 * Populate the List according to the file which is loaded.
	 */
	public List<Customer> getAllCustomers() {
		BufferedReader bufferReader = null;
		List<Customer> result = null;
		try {
			result = new ArrayList<Customer>();
			bufferReader = new BufferedReader(new FileReader(SalesConstants.INPUT_FILE_PATH+SalesConstants.CUSTOMER_FILE));
			String line = bufferReader.readLine(); 
			while(line != null) {
				String[] str = SalesUtility.splitString(line);
				Customer customer = new Customer(str[0], str[1], str[2]);
				result.add(customer);
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
	 * @param beforeSalesDate
	 * Populate the Customer List according to the sale end date from file which is loaded.
	 */
	public List<Customer> getAllCustomers(String beforeSalesDate) {
		BufferedReader bufferReader = null;
		List<Customer> result = null;
		try {
			result = new ArrayList<Customer>();
			bufferReader = new BufferedReader(new FileReader(SalesConstants.INPUT_FILE_PATH+SalesConstants.CUSTOMER_FILE));
			String line = bufferReader.readLine(); 
			while(line != null) {
				String[] str = SalesUtility.splitString(line);
				Date saleEndDate = SalesUtility.getDate(beforeSalesDate);
				Date customerDate = SalesUtility.getDate(str[2]);
				// Sales Date should be greater than the customer reg date.
				if(customerDate!= null && saleEndDate.compareTo(customerDate) >= 0) {
					Customer customer = new Customer(str[0], str[1], str[2]);
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



}
