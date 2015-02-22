/**
 * main Controller class to execute the program.
 */
package com.bofa.candidate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.bofa.candidate.DAO.CustomerDAO;
import com.bofa.candidate.DAO.SalesDAO;
import com.bofa.candidate.entity.Customer;
import com.bofa.candidate.entity.Sales;
import com.bofa.candidate.implDAO.CustomerImplDAO;
import com.bofa.candidate.implDAO.SalesImplDAO;
import com.bofa.candidate.util.SalesConstants;
import com.bofa.candidate.util.SalesUtility;

/**
 * @author vmandloi
 * 
 */
public class ControllerSales {
	static ErrorLog error = null;
	static Properties discountProperties = null;
	public ControllerSales(){
		// Instantiate the Logger 
		FileInputStream fileInput = null;
		try {
			error = ErrorLog.getInstance();
			File file = new File(SalesConstants.SALE_PROPERTIES);
			fileInput = new FileInputStream(file);
			discountProperties = new Properties();
			discountProperties.load(fileInput);
		} catch (FileNotFoundException e) {
			error.logError(e.getMessage());
		} catch (IOException e) {
			error.logError(e.getMessage());
		} catch(Exception e){
			error.logError(e.getMessage());
		} finally {
			try {
				fileInput.close();
			} catch (IOException e) {
				error.logError("IOException: "+e.getMessage());
			}
		}
	}
	
	/**
	 * @author vmandloi
	 * This method is used to validate the date according to it's format.
	 */
	public boolean checkDates(String[] args){
		boolean result = false;
		if(args.length < 2) {
			error.logError("Sorry you Need to provide 2 dates. (Start Date /  End Date)");
		} else {
			// Validate First argument as Start Date
			if(SalesUtility.isDateValid(args[0]) == true) {
				result = true;
			} else {
				result = false;
			}
			// Validate First argument as End Date
			if(SalesUtility.isDateValid(args[1]) == true) {
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ControllerSales sales = new ControllerSales();
			CustomerDAO customer = new CustomerImplDAO();
			SalesDAO salesimpl = new SalesImplDAO();
			Map<String, Customer> customerMap = new LinkedHashMap<String, Customer>();
			Map<String, List<Sales>> customerSalesSorted = new LinkedHashMap<String, List<Sales>>();
			Map<String, List<Sales>> customerSales = null;
			List<String> customerIDList = null;
			List<Customer> customerList = null;
			Date startDate = null;
			Date endDate = null;
			// Check Dates for Start and End Date
			if(sales.checkDates(args)) {
				startDate = SalesUtility.getDate(args[0]);
				endDate = SalesUtility.getDate(args[1]);
				
				if(startDate.compareTo(endDate)>0 || startDate==null || endDate == null) {
					error.logError("Start Date cannot be After End Date");
					terminator();
				}
				// populate the list according to End dates.
				customerList = customer.getAllCustomers(args[1]);
			} else if(args == null || args.length == 0) {
				customerList = customer.getAllCustomers();
			} else {
				terminator();
			}
			// Obtain the list of Customers which are registered before sale end Date.
			
			// Sort the Customer List According to It's Name
			Collections.sort(customerList);
			
			if(customerList != null && customerList.size() != 0){
				for(Customer cust : customerList){
					customerMap.put(cust.getCustomer_id(), cust);
				}
				// Convert the Customer key set to List
				customerIDList = new LinkedList<String>(customerMap.keySet());
				if(args == null || args.length == 0) {
					customerSales = salesimpl.getAllSalesForCustomer(customerIDList);
				} else {
					customerSales = salesimpl.getAllSalesForCustomer(customerIDList, args[0], args[1]);
				}
				//Sort the order of Map coming from Sales for Customer.
				for(String custID : customerIDList){
					if(custID != null && custID.length() != 0) {
						customerSalesSorted.put(custID, customerSales.get(custID));
					}
				}
				customerSales = null;
				// Process Sales
				Map<String, String> processedDiscount = SalesUtility.processDiscount(customerSalesSorted, discountProperties);
				if(processedDiscount != null && processedDiscount.size() != 0) {
					SalesUtility.publishSales(customerMap, processedDiscount);
				} else {
					error.logError("No Discounts to be processed for Customers.");
				}
			} else {
				error.logError("No Customers found for the period..!");
			}
		} catch (Exception e) {
			error.logError(e.getMessage());
		} finally {
			error.logClose();
		}
	}

	public static void terminator(){
		error.logError("Abnormal Termination due to Invalid Dates...");
		error.logClose();
		System.exit(0);
	}
}
