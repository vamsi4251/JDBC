package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertImage {

	public static void main(String[] args) {
		String Driver = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/jdbc";
		String USERNAME = "root";
		String PASSWORD = "root";
		FileInputStream fin;
		
		try {
			Scanner src = new Scanner(System.in);
			
			//1.Register the Driver class
			Class.forName(Driver);
			
			//2.Create connection
			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			//3.Create statement
			String qry = "insert into imagetable values(?,?)";
			PreparedStatement pmst = conn.prepareStatement(qry);
			fin = new FileInputStream("C://Users//Lenovo//Desktop//Images//Angular.png");
			System.out.println("enter id");
			pmst.setInt(1, src.nextInt());
			pmst.setBinaryStream(2, fin,fin.available());
			
			//4.Execute queries
			int i = pmst.executeUpdate();
			if (i > 0) {
				System.out.println("Data entered succesfully");
			} 
			else {
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
