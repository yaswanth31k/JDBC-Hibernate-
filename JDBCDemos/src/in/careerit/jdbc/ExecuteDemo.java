package in.careerit.jdbc;

import java.sql.*;

public class ExecuteDemo {

	public static void main(String[] args) {
		java.util.Scanner sc =new java.util.Scanner(System.in);
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			if(con!= null){
				System.out.println("connected successfully");
				System.out.println("read the query to be executed : ");
				String query = sc.nextLine(); // select * from dept
				
				System.out.println("given query : "+query);
				Statement stmt =con.createStatement();
				boolean result = stmt.execute(query);
				
				if(result){
					System.out.println(" it is a select query");
					ResultSet rs = stmt.getResultSet();
					while(rs.next()){
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
					}
				}else{
					System.out.println("it is a dml query");
					int rowsAffected = stmt.getUpdateCount();
					System.out.println(rowsAffected+" record affected by the query");
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
