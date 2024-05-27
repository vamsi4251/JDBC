package jdbc;
import java.sql.*;
import java.util.Scanner;

public class DynamicInseration {

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
			String qry = "insert into student values(?,?)";
			PreparedStatement pmst = conn.prepareStatement(qry);
			System.out.println("enter id");
			pmst.setInt(1, src.nextInt());
			System.out.println("enter username");
			pmst.setString(2, src.next());
			
			//4.Execute queries
			pmst.executeUpdate();
			
			System.out.println("Rows inserted");
			
			//5.Close connection
			conn.close();
			src.close();
			
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
