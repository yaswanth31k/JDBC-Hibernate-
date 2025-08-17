package in.careerit.jdbc;

import java.sql.*;

public class TestConnection {

	public static void main(String[] args) {
		
		try {
			// load and register the driver
			Driver driver = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(driver);
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			
			//Establish the connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			if(con != null) {
				System.out.println("connected successfully");
				//perform Dml operation
				
				//close the connection
				
				con.close();
			}else {
				System.out.println("failed to connect db");
			}
		}catch(SQLException e) {
			System.out.println("exception occured : "+e);
		}
	}

}
