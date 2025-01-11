package com.acc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	public static Connection getDBconnection(){
		Connection con =null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store?useSSL=false","root","Anish@1424");
			} catch (ClassNotFoundException e ) {
				e.printStackTrace();
			} catch( SQLException e) {
				e.printStackTrace();
			}
		return con;


	}

}
