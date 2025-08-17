package in.careerit.jdbc;

import java.sql.*;

public class PreparedStatementDemo {

	public static void main(String[] args) {
		java.util.Scanner  sc = new java.util.Scanner(System.in);
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			if(con != null) {
				  System.out.println("connected successfully");
				//insert operation
//				  System.out.println("dept no : ");
//				  int deptNo =sc.nextInt();
//				  System.out.println("dept name : ");
//				  String dName = sc.next();
//				  System.out.println("location : ");
//				  String loc = sc.next();
				  
//				  String insertQuery ="INSERT INTO DEPT VALUES(?,?,?)";
				  

//				  System.out.println("given query : "+insertQuery);
//				  
//				  PreparedStatement pstmt = con.prepareStatement(insertQuery);
//				  pstmt.setInt(1, deptNo);
//				  pstmt.setString(2, dName);
//				  pstmt.setString(3, loc);
//				  int rowAffected =pstmt.executeUpdate();
//				  if(rowAffected > 0){
//					  System.out.println(rowAffected+ " record(s) inserted successfully");
//				  }else
//					  System.out.println("failed to insert the record");
				  
//				  UPDATE
			  
//				  String update ="UPDATE Dept SET Loc = ? WHERE DeptNo = ?";
//
//				  System.out.println("given query : "+update);
//				  
//				  PreparedStatement pstmt = con.prepareStatement(update);
//				  
//				  pstmt.setString(1, "NEW YORK");
//				  pstmt.setInt(2, 10);
//
//				  int rowAffected =pstmt.executeUpdate();
//				  if(rowAffected > 0){
//					  System.out.println(rowAffected+ " record(s) updated successfully");
//				  }else
//					  System.out.println("failed to insert the record");
				  
				  //update operation
				  //update <tableName> set <col1=val1> , <col2=val2> ...... where<condition>;
				  //String updateQuery = "update dept set loc = 'new delhi' where dept =10";
				  
				  
				  
				  			//delete operation
				  //delete from <tablename> where <condition>;
				  //String deleteQuery ="delete from dept where deptno = 80"
				  
				  System.out.println("enter the dpetNo : ");
				  
				  int deptno = sc.nextInt();
				  
				  String DELETE ="DELETE FROM DEPT WHERE DeptNo = ?";

				  System.out.println("given query : "+DELETE);
				  
				  PreparedStatement pstmt = con.prepareStatement(DELETE);
				  
				  pstmt.setInt(1, deptno);

				  int rowAffected =pstmt.executeUpdate();
				  if(rowAffected > 0){
					  System.out.println(rowAffected+ " record(s) delete successfully");
				  }else{
					  System.out.println("failed to insert the record");
				  }
				  con.close();
			}else{
				System.out.println("failed to connect db");
			}
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println("exception occured : "+e);
		}
	}

}
