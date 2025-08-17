package in.careerit.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatement_Procedure {

	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			if(con != null){
				System.out.println("connected succesfully");
				CallableStatement cstmt = con.prepareCall("{call getEmpDetails(?,?,?,?,?)}");
				cstmt.setInt(1, 7369);
				cstmt.registerOutParameter(2, Types.VARCHAR);
				cstmt.registerOutParameter(3, Types.INTEGER);
				cstmt.registerOutParameter(4, Types.VARCHAR);
				cstmt.registerOutParameter(5, Types.INTEGER);
				
				cstmt.execute();
				
				System.out.println("employee no: 7369");
				System.out.println("employee name : "+cstmt.getString(2));
				System.out.println("employee sal "+cstmt.getDouble(3));
				System.out.println("designation "+cstmt.getString(4));
				System.out.println("dept no : "+cstmt.getString(5));
						
				//function using callablesatement;
				cstmt = con.prepareCall("{?=call getTotalSalaryByDept(?)}");
				
				cstmt.setInt(2,20);
				cstmt.registerOutParameter(1, Types.DOUBLE);
				cstmt.execute();
				System.out.println("---------------");
				System.out.println("department no: 20");
				System.out.println("total salary : "+cstmt.getDouble(1));
			}else{
				System.out.println("failed to connect the db");
			}
		}catch(SQLException | ClassNotFoundException e){
			System.out.println("ecception occured "+e);
		}
	}

}
