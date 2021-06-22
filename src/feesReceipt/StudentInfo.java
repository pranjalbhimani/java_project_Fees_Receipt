package feesReceipt;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.proteanit.sql.DbUtils;

import java.sql.*;

import javax.swing.*;

public class StudentInfo {
	Connection connection;
	JFrame jf;
	JLabel label;
	JTable table;
	ResultSet rs;
	/*JLabel p,name,date,course,mno,sem,amt;
	JTextField namet,datet,courset,mnot,semt,amtt;*/
	JButton studentload,delete,update;
	//JPanel contentpane;
	public StudentInfo()
	{
		connection=DBconnection.getconnection();
		jf=new JFrame("Student-info");
		
		table=new JTable();
		
		studentload=new JButton("Student-Info");
		studentload.setBounds(341, 466, 103, 25);
		studentload.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String query="select * from students";
					PreparedStatement ps=connection.prepareStatement(query);
					rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					} 
					catch(Exception e3) {
						// TODO: handle exception
						e3.printStackTrace();
					}
				
			}
		});
			
		update=new JButton("Update");
		update.setBounds(172, 466, 94, 25);
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i=table.getSelectedRow();
				int c=0,id=0;
				try {
				rs.first();
				while(rs.next())
				{
					c++;
					if(c==i)
					{
						id=rs.getInt(1);
						break;
					}
				}
				
				new FeesDataUpdate(id);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		delete=new JButton("Delete");
		delete.setBounds(586, 466, 94, 25);
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
						int i=table.getSelectedRow();
						int c=0,id=0;
						rs.first();
						while(rs.next())
						{
							c++;
							if(c==i)
							{
								id=rs.getInt(1);
								break;
							}
						}
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/feesreceipt","root","");
						System.out.print("Connected");
						Statement st=con.createStatement();
						String qry="delete from students where id="+id;
						System.out.println(qry);
						int j=st.executeUpdate(qry);
						System.out.println(j+"Row Deleted");
				} catch (Exception e3) {
					// TODO: handle exception
					e3.printStackTrace();
				}
			}
		});
		jf.getContentPane().setLayout(null);
		
		
		JScrollPane pane=new JScrollPane(table);
		pane.setBounds(30, 126, 718, 307);
		//jf.add(label);
		jf.getContentPane().add(pane);
		jf.getContentPane().add(studentload);
		jf.getContentPane().add(update);
		jf.getContentPane().add(delete);
		jf.setSize(800,800);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(1);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentInfo si=new StudentInfo();
	}

}
