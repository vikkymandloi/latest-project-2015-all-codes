/**
 * 
 */
package com.bofa.candidate.util;


/**
 * @author vmandloi
 *
 */
public interface SalesConstants {
	final static String[] DATE_FORMAT = {"yyyy-MM-dd","MM/dd/yyyy"};
	final static String INPUT_FILE_PATH = "src/input/";
	final static String CUSTOMER_FILE = "customers.txt";
	final static String CUSTOMER = "customer";
	final static String SALES_FILE = "sales.txt";
	final static String SALES = "sales";
	final static String ERROR_FILE_PATH = "src/error/globalErrors.txt";	
	final static String OUTPUT_FILE_PATH = "src/output/output.txt";	
	final static String SALE_PROPERTIES = "src/input/runtime.properties";
	// refund eligibility level
	final static String LEVEL1_REF_MIN = "refund.level1.amount.min";
	final static String LEVEL1_REF_MAX = "refund.level1.amount.max";
	final static String LEVEL2_REF_MIN = "refund.level2.amount.min";
	final static String LEVEL2_REF_MAX = "refund.level2.amount.max";
	final static String LEVEL3_REF_MIN = "refund.level3.amount.min";
	final static String LEVEL3_REF_MAX = "refund.level3.amount.max";
	final static String LEVEL4_REF_MIN = "refund.level4.amount.min";
	final static String LEVEL4_REF_MAX = "refund.level4.amount.max";
	final static String LEVEL5_REF_MIN = "refund.level5.amount.min";
	// Discount Percet levels
	final static String LEVEL1_DISCOUNT = "refund.level1.percent";
	final static String LEVEL2_DISCOUNT = "refund.level2.percent";
	final static String LEVEL3_DISCOUNT = "refund.level3.percent";
	final static String LEVEL4_DISCOUNT = "refund.level4.percent";
	final static String LEVEL5_DISCOUNT = "refund.level5.percent";
	final static double COUNT_DOWN = 0.01;

	final static String DECIMAL_PATTERN = "###,###,###.##";
}
