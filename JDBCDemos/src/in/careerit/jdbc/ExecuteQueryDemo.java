package in.careerit.jdbc;

import java.sql.*;

public class ExecuteQueryDemo {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			if(con != null) {
				  System.out.println("connected successfully");
				  
				  String Selectquery ="select * from dept";
				  
				  Statement stmt = con.createStatement();
				  ResultSet rs = stmt.executeQuery(Selectquery);

//				  ResultSet rs = con.createStatement().executeQuery(Selectquery);
				  
				  //move the resultSet to next row
				  //before first row
				  while(rs.next()) {
				  System.out.println(rs.getInt("deptNo")+"\t"+rs.getString("dName")+"\t"+rs.getString("loc"));
				  }
				  //after last row
				  con.close();
			}else {
				System.out.println("failed to connect db");
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println("exception occured : "+e);
		}
		
		
		
	}

}
