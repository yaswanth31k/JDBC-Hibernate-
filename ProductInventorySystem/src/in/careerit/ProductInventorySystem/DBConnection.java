package in.careerit.ProductInventorySystem;

import java.sql.*;

public class DBConnection {
	static Connection getConnection(){
	Connection con =null;
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		
		
		}catch(SQLException | ClassNotFoundException e) {
		System.out.println("exception occured : "+e);
		}
		
		return con;
	}
}
