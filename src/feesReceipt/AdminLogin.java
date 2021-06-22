package feesReceipt;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//simport java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/*import java.sql.*;

import javax.swing.*;*/


public class AdminLogin {
	//Connection conn=null;
	JFrame jf;
	JLabel username,password;
	JTextField ut,pt;
	JButton login;
	
	public AdminLogin() {
		// TODO Auto-generated constructor stub
		
		jf=new JFrame("AdminLogin");
		//conn=DBconnection.getconnection();
		username=new JLabel("UserName");
		username.setBounds(50, 50, 150, 30);
		
		password=new JLabel("Password");
		password.setBounds(50, 100,150, 30);
		
		ut=new JTextField(20);
		ut.setBounds(155, 50, 150, 30);
		
		pt=new JTextField(20);
		pt.setBounds(155, 100, 150, 30);
		
		login=new JButton("Login"); 
		login.setBounds(80, 180, 150, 30);
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String a,b;
				a=ut.getText();
				b=pt.getText();
				if(a.equals("Pranjal") && b.equals("12345"))
				{
					JOptionPane.showMessageDialog(null, "Successfully Login");
					FeesReceiptSystem fe=new FeesReceiptSystem();
					//frs.getdata();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid UserName and Password");
				}
			}
				
		});
		
		
		jf.add(username);
		jf.add(ut);
		jf.add(password);
		jf.add(pt);
		jf.add(login);
		
		
		jf.setSize(400, 400);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(1);
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminLogin a=new AdminLogin();
	}

}
