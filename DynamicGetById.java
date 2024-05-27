package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DynamicGetById {

	public static void main(String[] args) {
		String Driver = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/jdbc";
		String USERNAME = "root";
		String PASSWORD = "root";
		
		try {
			Scanner src = new Scanner(System.in);
			
			//1.Register the Driver class
			Class.forName(Driver);
			
			//2.Create connection
			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			//3.Create statement
			String qry = "select * from student where id = ?";
			PreparedStatement pmst = conn.prepareStatement(qry);
			System.out.println("enter is");
			pmst.setInt(1, src.nextInt());
			
			//4.Execute queries
			ResultSet res = pmst.executeQuery();
			while(res.next()) {
				System.out.println(res.getInt("id")+" "+res.getString("name"));
			}
			
			//5.Close connection
			conn.close();
			src.close();
			
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
