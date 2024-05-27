package jdbc;
import java.sql.*;
public class jdbc1 {
	
	public static void main(String[] x) {
		
		try {
			
			//1.Register the Driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.Create connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root", "root");
			
			//3.Create statement
			Statement stmt = conn.createStatement();
			
			//4.Execute queries
			stmt.executeUpdate("create table student(id int(10),name varchar(40))");
			
			System.out.println("Table created");
			
			//5.Close connection
			conn.close();
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
