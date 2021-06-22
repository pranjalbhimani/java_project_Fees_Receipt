package feesReceipt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class FeesDataUpdate {

	JFrame jf;
	JLabel p,name,date,course,mno,sem,amt;
	JTextField namet,datet,courset,mnot,semt,amtt;
	JButton gn1;
	JTable table;
	public FeesDataUpdate(int id) {
		// TODO Auto-generated constructor stub
		jf =new JFrame();
		p=new JLabel("Fees Receipt System");
		table=new JTable();
		p.setBounds(150, 40, 300, 80);
		
		name=new JLabel("Name");
		name.setBounds(50, 100, 150, 30);
		
		date=new JLabel("Date");
		date.setBounds(50, 150, 150, 30);
		
		course=new JLabel("Course");
		course.setBounds(50, 200, 150, 30);
		
		mno=new JLabel("Mobile No");
		mno.setBounds(50, 250, 200, 30);
		
		sem=new JLabel("Semester");
		sem.setBounds(50, 300, 200, 30);
		
		amt=new JLabel("Fees Amt");
		amt.setBounds(50, 350, 200, 30);
		
		namet=new JTextField(20);
		namet.setBounds(150, 100, 150,30);
		
		datet=new JTextField(20);
		datet.setBounds(150, 150, 150, 30);
		
		courset=new JTextField(20);
		courset.setBounds(150, 200, 150, 30);
		
		mnot=new JTextField(20);
		mnot.setBounds(150, 250, 150, 30);
		
		semt=new JTextField(20);
		semt.setBounds(150, 300, 150, 30);
		
		amtt=new JTextField(20);
		amtt.setBounds(150, 350, 150, 30);
		
		gn1=new JButton("Update Receipt");
		gn1.setBounds(50, 400, 150, 30);
		gn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String nm = null;
					Class.forName("com.mysql.jdbc.Driver");
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/feesreceipt","root","");
						System.out.print("Connected");
						Statement st=con.createStatement();
						/*String query="select * from students where id="+id;
						ResultSet rs=st.executeQuery(query);
						if(rs.next()) {
						 nm=rs.getString(1);
						}*/
						String query1="update students set Date='"+datet.getText()+"',Name='"+namet.getText()+"',Course='"+courset.getText()+"',semester='"+semt.getText()+"',amount='"+amtt.getText()+"',Mobile='"+mnot.getText()+"' where id="+id;
						System.out.println(query1);
						int i=st.executeUpdate(query1);
						System.out.println(i+"Row Updated");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
						
			}
		});
		
		jf.add(p);
		jf.add(table);
		jf.add(name);
		jf.add(namet);
		jf.add(date);
		jf.add(datet);
		jf.add(course);
		jf.add(courset);
		jf.add(mno);
		jf.add(mnot);
		jf.add(sem);
		jf.add(semt);
		jf.add(amt);
		jf.add(amtt);
		jf.add(gn1);
		jf.setSize(400,400);
		jf.setLayout(null);
		jf.setVisible(true);
		
		
	}
	
}
