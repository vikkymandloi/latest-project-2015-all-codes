/**
 * 
 */
package com.bofa.candidate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import com.bofa.candidate.util.SalesConstants;

/**
 * @author vmandloi
 *
 */
public class ErrorLog {
	private static ErrorLog errorLog = null;
	
	FileWriter filewriter = null;
	private BufferedWriter buffer = null;
	File file = null;
	
	private ErrorLog(){
		// if file doesnt exists, then create it
		try {
			file = new File(SalesConstants.ERROR_FILE_PATH);
			if (!file.exists()) {
				file.createNewFile();
			}
			filewriter = new FileWriter(file.getAbsoluteFile(), true);	// to Append the data in file.
			buffer = new BufferedWriter(filewriter);
			buffer.newLine();
			buffer.write("###### Error File Instantiated ######");
		} catch (IOException e) {
			System.out.println("EXCEPTION: Unable to Log the message in Error Log.!");
		} 
	}
	
	public static ErrorLog getInstance(){
		if(errorLog == null) {
			errorLog = new ErrorLog();
		}
		return errorLog;
	}
	
	public void logError(String message){
		try {
			buffer.newLine();
			String log = "# Exception ("+new Date()+") : "+message+".";
			buffer.write(log);
			System.out.println(log);
			buffer.flush();
		} catch (Exception e) {
			System.out.println("EXCEPTION: Unable to Log the message in Error Log.!");
		}
	}
	
	public void logClose(){
		try {
			buffer.newLine();
			buffer.write("##### END of LOG #####");
			buffer.close();
		} catch (Exception e) {
			System.out.println("EXCEPTION: Unable to Log the message in Error Log Close.!");
		}
	}
	
	// temporary to test the application
	public static void main(String[] args) {
		new ErrorLog();
	}
}
