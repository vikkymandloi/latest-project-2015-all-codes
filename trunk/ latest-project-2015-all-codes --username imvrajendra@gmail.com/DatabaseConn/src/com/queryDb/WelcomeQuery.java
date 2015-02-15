package com.queryDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.EntryValue;
import com.pojo.UserPojo;

public class WelcomeQuery {

	public static String welcomeLoad(Connection conn, UserPojo user){
		String result = "";
		PreparedStatement pstatement = null;
		try {
			pstatement = conn.prepareStatement("select * from UsrEntryVal where username=?");
			pstatement.setString(1, user.getUsername());

			ResultSet resulSet = pstatement.executeQuery();

			while(resulSet.next()) {
				result =resulSet.getString("entryval");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				pstatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static boolean welcomeUpdate(Connection conn, EntryValue entry){
		String result = "";
		PreparedStatement pstatement = null;
		try {
			UserPojo user = new UserPojo();
			user.setUsername(entry.getUsername());
			result = welcomeLoad(conn, user);			
			if(result != null && result.length() != 0) {
				// perform Insert Operation with the user
				pstatement = conn.prepareStatement("update UsrEntryVal set entryval=? where username=?");
				pstatement.setString(1, entry.getEntryvalue());
				pstatement.setString(2, entry.getUsername());

				int count = pstatement.executeUpdate();
				return true;
			}
			
			// perform Update Operation with the user 
			pstatement = conn.prepareStatement("insert into UsrEntryVal values (?, ?)");
			pstatement.setString(1, entry.getUsername());
			pstatement.setString(2, entry.getEntryvalue());

			int count = pstatement.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				pstatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static void main(String[] args) {

	}
}
