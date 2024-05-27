package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataInseration {

	public static void main(String[] args) {
		try {
			
			//1.Register the Driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.Create connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root", "root");
			
			//3.Create statement
			Statement stmt = conn.createStatement();
			
			//4.Execute queries
			stmt.executeUpdate("insert into student values(1,'vamsi')");
			stmt.executeUpdate("insert into student values(2,'krishna')");
			
			System.out.println("Rows inserted");
			
			//5.Close connection
			conn.close();
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
