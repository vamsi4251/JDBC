package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class deletionById {

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
			String qry = "delete from student where id = ?";
			PreparedStatement pmst = conn.prepareStatement(qry);
			System.out.println("enter is");
			pmst.setInt(1, src.nextInt());
			
			//4.Execute queries
			int i = pmst.executeUpdate();
			if (i > 0) {
				System.out.println("Data deleted succesfully");
			} else {
				System.out.println("data invalid");
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
