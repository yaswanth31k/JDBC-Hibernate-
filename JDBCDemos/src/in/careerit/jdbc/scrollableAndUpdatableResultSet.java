package in.careerit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class scrollableAndUpdatableResultSet {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			if(con != null) {
				  System.out.println("connected successfully");
				  
				  String Selectquery ="select deptNo,dname,loc from dept";
				  
				  //forward and readonly resultset
				  //Statement stmt = con.createStatement();
				  
				  //forward and readonly resultset
				  //Statement stmt =con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);

				  //scrollable and readonly resultSet
//				  Statement stmt =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

				  //scrollable and updatable
				  Statement stmt =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

				  
				  ResultSet rs = stmt.executeQuery(Selectquery);

//				  ResultSet rs = con.createStatement().executeQuery(Selectquery);
				  
				  //move the resultSet to next row
				  //before first row
				  System.out.println("forward record");
				  System.out.println("------------------");
				  while(rs.next()) {
				  System.out.println(rs.getInt("deptNo")+"\t"+rs.getString("dName")+"\t"+rs.getString("loc"));
				  }
				  
				  
				  System.out.println("backword record");
				  System.out.println("------------------");
				  while(rs.previous()) {
				  System.out.println(rs.getInt("deptNo")+"\t"+rs.getString("dName")+"\t"+rs.getString("loc"));
				  }
				  //after last row
				  
				  
				  System.out.println("record #4");
				  System.out.println("============");
				  rs.absolute(4);
				  System.out.println(rs.getInt("deptNo")+"\t"+rs.getString("dName")+"\t"+rs.getString("loc"));
				  
				  System.out.println("record last");
				  System.out.println("============");
				  rs.last();
				  System.out.println(rs.getInt("deptNo")+"\t"+rs.getString("dName")+"\t"+rs.getString("loc"));
				  
				  System.out.println("first record");
				  System.out.println("============");
				  rs.first();
				  System.out.println(rs.getInt("deptNo")+"\t"+rs.getString("dName")+"\t"+rs.getString("loc"));
				  
				  
				  rs.afterLast();
				  rs.previous();
				  System.out.println("last record");
				  System.out.println("============");
				  rs.last();
				  System.out.println(rs.getInt("deptNo")+"\t"+rs.getString("dName")+"\t"+rs.getString("loc"));
				  
				  
				  rs.beforeFirst();
				  rs.next();
				  System.out.println("first record");
				  System.out.println("============");
				  rs.first();
				  System.out.println(rs.getInt("deptNo")+"\t"+rs.getString("dName")+"\t"+rs.getString("loc"));

				  rs.absolute(4);
				  rs.updateString(3, "new");
				  rs.updateRow();
				  System.out.println("roe updates succesfully");
				  
				  rs.absolute(3);
				  rs.deleteRow();
				  System.out.println("3rd record deleted");
				  
				  rs.moveToInsertRow();
				  rs.updateInt(1, 333);
				  rs.updateString(2, "kjdfgkjhdfg");
				  rs.updateString(3, "new");
				  rs.updateRow();
				  System.out.println("record inserted");
				  
				  
				  
				  con.close();
			}else {
				System.out.println("failed to connect db");
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println("exception occured : "+e);
		}

	}

}
