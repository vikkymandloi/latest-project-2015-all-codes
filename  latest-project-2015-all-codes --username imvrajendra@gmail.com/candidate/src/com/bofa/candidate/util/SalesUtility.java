/**
 * 
 */
package com.bofa.candidate.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.bofa.candidate.ErrorLog;
import com.bofa.candidate.entity.Customer;
import com.bofa.candidate.entity.Sales;

/**
 * @author vmandloi
 * Utility class provided all the addons to work throwout the application.
 */
public class SalesUtility {

	/** @author vmandloi
	 * Date validation utility to provide if the date is valid or not.
	 */
	public static boolean isDateValid(String dateToValidate){
		ErrorLog error = ErrorLog.getInstance();
		boolean result = false;
		if(dateToValidate == null || dateToValidate.length() == 0){
			error.logError("Date "+dateToValidate+" is NULL");
			return result;
		}
		//sdf.setLenient(false);
		for(int i=0;i<SalesConstants.DATE_FORMAT.length; i++) {
			try {
				SimpleDateFormat sdf1 = new SimpleDateFormat(SalesConstants.DATE_FORMAT[i]);
				//if not valid, it will throw ParseException
				Date date = sdf1.parse(dateToValidate);
				error.logError("This is Correct Format "+date);
				result = true;
			} catch (ParseException e) {
				error.logError("Date "+dateToValidate+" is NOT in Correct Format");
				error.logError(e.getMessage());
			}
		}
		return result;
	}

	/** @author vmandloi
	 * Date value from String.
	 */
	public static Date getDate(String dateToValidate){
		ErrorLog error = ErrorLog.getInstance();
		Date result = null;
		if(dateToValidate == null || dateToValidate.length() == 0){
			error.logError("Date "+dateToValidate+" is NULL");
			return null;
		}
		//
		for(int i=0;i<SalesConstants.DATE_FORMAT.length; i++) {
			try {
				SimpleDateFormat sdf1 = new SimpleDateFormat(SalesConstants.DATE_FORMAT[i]);
				sdf1.setLenient(false);
				//if not valid, it will throw ParseException
				Date date = sdf1.parse(dateToValidate);
				return result = date;
			} catch (ParseException e) {
				error.logError("Date "+dateToValidate+" is NOT in Correct Format");
				error.logError(e.getMessage());
			}
		}
		return result;
	}

	/** @author vmandloi
	 * @param str
	 * Split the string using split method of String.
	 */
	public static String[] splitString(String str) {
		// to handle the null pointer condition
		if(str == null || str.length() == 0)
			return new String[]{"","",""};
		String[] arrayStr = str.split(",");
		for(int i=0;i<arrayStr.length; i++) {
			arrayStr[i] = arrayStr[i].trim();	
			// to remove the white spaces from individual elements in array.
		}
		return arrayStr;
	}

	/** @author vmandloi
	 * @param str
	 * Split the string using split method of String.
	 */
	public static Map<String, String> processDiscount(Map<String, List<Sales>> customerSales, Properties discountProperties) {
		Map<String, String> result = new LinkedHashMap<String, String>();
		ErrorLog error = ErrorLog.getInstance();
		double totalDiscount = 0;
		double totalSales = 0;
		try {
			for (Entry<String, List<Sales>> entry : customerSales.entrySet())
			{
				List<Sales> salesForCustomer = entry.getValue();
				if(salesForCustomer!=null && salesForCustomer.size()!=0){
					for(Sales sale: salesForCustomer){
						totalSales += Double.valueOf(sale.getSale_amount());
					}
					//System.out.println("Total Sales: "+totalSales);
					if(totalSales != 0) {
						totalDiscount = applyDiscount(totalSales, discountProperties);
					}
					result.put(entry.getKey(), String.valueOf(totalSales+","+totalDiscount));
					totalSales = 0;
					totalDiscount = 0;
				}
			}
		} catch (NumberFormatException e) {
			error.logError("NumberFormatException: "+e.getMessage());
		} catch (Exception e) {
			error.logError("Exception: "+e.getMessage());
		}
		return result;
	}

	/** @author vmandloi
	 * @param str
	 * Split the string using split method of String.
	 */
	private static double applyDiscount(double totalSales, Properties discountProperties) {
		double totalDiscountAmt = 0;
		double deductibleAmount = 0;
		double level1_min = Double.parseDouble(discountProperties.get(SalesConstants.LEVEL1_REF_MIN).toString());
		double level1_max = Double.parseDouble(discountProperties.get(SalesConstants.LEVEL1_REF_MAX).toString());
		double level2_min = Double.parseDouble(discountProperties.get(SalesConstants.LEVEL2_REF_MIN).toString());
		double level2_max = Double.parseDouble(discountProperties.get(SalesConstants.LEVEL2_REF_MAX).toString());
		double level3_min = Double.parseDouble(discountProperties.get(SalesConstants.LEVEL3_REF_MIN).toString());
		double level3_max = Double.parseDouble(discountProperties.get(SalesConstants.LEVEL3_REF_MAX).toString());
		double level4_min = Double.parseDouble(discountProperties.get(SalesConstants.LEVEL4_REF_MIN).toString());
		double level4_max = Double.parseDouble(discountProperties.get(SalesConstants.LEVEL4_REF_MAX).toString());
		double level5_min = Double.parseDouble(discountProperties.get(SalesConstants.LEVEL5_REF_MIN).toString());
		
		if(totalSales>level5_min) {
			deductibleAmount = totalSales-level5_min;
			totalDiscountAmt += getDiscount(deductibleAmount, discountProperties.getProperty(SalesConstants.LEVEL5_DISCOUNT));
			totalSales = level5_min-SalesConstants.COUNT_DOWN;
		}
		if(totalSales>=level4_min && totalSales<=level4_max) {
			deductibleAmount = totalSales-level4_min;
			totalDiscountAmt += getDiscount(deductibleAmount, discountProperties.getProperty(SalesConstants.LEVEL4_DISCOUNT));
			totalSales = level4_min-SalesConstants.COUNT_DOWN;
		}
		if(totalSales>=level3_min && totalSales<=level3_max) {
			deductibleAmount = totalSales-level3_min;
			totalDiscountAmt += getDiscount(deductibleAmount, discountProperties.getProperty(SalesConstants.LEVEL3_DISCOUNT));
			totalSales = level3_min-SalesConstants.COUNT_DOWN;
		}
		if(totalSales>=level2_min && totalSales<=level2_max) {
			deductibleAmount = totalSales-level2_min;
			totalDiscountAmt += getDiscount(deductibleAmount, discountProperties.getProperty(SalesConstants.LEVEL2_DISCOUNT));
			totalSales = level2_min-SalesConstants.COUNT_DOWN;
		}
		if(totalSales>=level1_min && totalSales<=level1_max) {
			deductibleAmount = totalSales-level1_min;
			totalDiscountAmt += getDiscount(deductibleAmount, discountProperties.getProperty(SalesConstants.LEVEL1_DISCOUNT));
			totalSales = level1_min-SalesConstants.COUNT_DOWN;
		}
		
		return totalDiscountAmt;
	}

	/** @author vmandloi
	 * @param str
	 * Process the Discount.
	 */
	private static double getDiscount(double deductibleAmount, String percentRefund) {
		return (deductibleAmount * Double.valueOf(percentRefund)) / 100;
	}

	/** @author vmandloi
	 * @param str
	 * Process the result to the O/p File.
	 */
	public static void publishSales(Map<String, Customer> customerMap, Map<String, String> processedDiscount) {
		BufferedWriter bufferWriter = null;
		ErrorLog error = ErrorLog.getInstance();
		DecimalFormat DECIMAL_FORMAT = new DecimalFormat(SalesConstants.DECIMAL_PATTERN);
		double totalSalesAcross = 0;
		double totalRefundAcross = 0;
		try {
			File file = new File(SalesConstants.OUTPUT_FILE_PATH);
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
			bufferWriter = new BufferedWriter(fileWriter);
			String line = "=================================================================================================================";
			
			bufferWriter.write(line);
			System.out.println(line);
			bufferWriter.newLine();
			String title = "Customer Name"+String.format("%" + (60-13) + "s", " ")+"Sale Amount \t \t \t Refund Amount";
			bufferWriter.write(title);
			System.out.println(title);
			bufferWriter.newLine();
			for (Entry<String, String> entry : processedDiscount.entrySet()) {
				bufferWriter.newLine();
				// First obtain the value of Customer 
				Customer cust = customerMap.get(entry.getKey());
				String[] saleValue = splitString(entry.getValue());
				// First Write the Customer Name from Customer Map.
				totalSalesAcross += Double.valueOf(saleValue[0]);
				totalRefundAcross += Double.valueOf(saleValue[1]);
				int len = cust.getCustomer_name().length();
				String writeString = cust.getCustomer_name()+String.format("%" + (60-len) + "s", " ")+
									DECIMAL_FORMAT.format(Double.valueOf(saleValue[0])).toString()+"\t \t \t ("+
									DECIMAL_FORMAT.format(Double.valueOf(saleValue[1])).toString()+")";
				bufferWriter.write(writeString);
				System.out.println(writeString);
				bufferWriter.flush();
			}
			bufferWriter.newLine();
			bufferWriter.write(line);
			System.out.println(line);
			bufferWriter.newLine();
			String total = "Total "+String.format("%" + (60-5) + "s", " ")+
					DECIMAL_FORMAT.format(totalSalesAcross).toString()+"\t \t \t "+
					DECIMAL_FORMAT.format(totalRefundAcross).toString();
			System.out.println(total);
			bufferWriter.write(total);
		} catch (IOException e) {
			error.logError(e.getMessage());
		} finally {
			try {
				bufferWriter.close();
			} catch (IOException e) {
				error.logError(e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		/*System.out.println(getDate("2005-05-05"));
		System.out.println(getDate("06/06/2005"));
		ErrorLog error = null;
		Properties discountProperties = null;
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
		}
		System.out.println(applyDiscount(10000000, discountProperties));*/
		DecimalFormat DECIMAL_FORMAT = new DecimalFormat(SalesConstants.DECIMAL_PATTERN);
		double val = 391039.05000000005;
		System.out.println(DECIMAL_FORMAT.format(val));
	}
}
