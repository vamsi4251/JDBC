package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataFetch {

	public static void main(String[] args) {
		try {
			
			//1.Register the Driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.Create connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root", "root");
			
			//3.Create statement
			Statement stmt = conn.createStatement();
			
			//4.Execute queries
			ResultSet res = stmt.executeQuery("select * from student");
			
			while(res.next()) {
				System.out.println(res.getInt("id") +" "+res.getString("name"));
			}
			
			//5.Close connection
			conn.close();
			
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
