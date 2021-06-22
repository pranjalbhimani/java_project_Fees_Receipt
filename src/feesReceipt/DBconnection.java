package feesReceipt;

import java.sql.*;

import javax.swing.*;

public class DBconnection {
	
	
	public static Connection getconnection()
	{
		Connection con=null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/feesreceipt","root","");
			JOptionPane.showMessageDialog(null, "Connected Successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
			
	}

}
