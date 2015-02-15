package com.queryDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.connection.OracleConnection;
import com.pojo.UserPojo;

public class LoginQuery {

	public static boolean loginValidate(Connection conn, UserPojo user){
		boolean result = false;
		try {
			PreparedStatement pstatement = conn.prepareStatement("select * from LoginUser where username=? and pass=?");
			pstatement.setString(1, user.getUsername());
			pstatement.setString(2, user.getPassword());
			
			ResultSet resulSet = pstatement.executeQuery();
			
			while(resulSet.next()) {
				UserPojo actualUser = new UserPojo();
				actualUser.setUsername(resulSet.getString(1));
				actualUser.setPassword(resulSet.getString(2));
				if(actualUser.equals(user)) {
					result = true;
					break;
				}
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static void main(String[] args) {
		Connection conn = OracleConnection.getConnection();
		UserPojo user = new UserPojo();
		user.setUsername("Vrajendra");
		user.setPassword("jan123$%");
		LoginQuery.loginValidate(conn,user);
	}

}
