package feesReceipt;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.*;


public class FeesReceiptSystem {
	JFrame jf;
	JLabel p,name,date,course,mno,sem,amt;
	JTextField namet,datet,courset,mnot,semt,amtt;
	JTextArea txtadd;
	JButton gn,reset,pr,stdinfo;
	
	public FeesReceiptSystem() {
		// TODO Auto-generated constructor stub
		jf =new JFrame();
		p=new JLabel("Fees Receipt System");
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
		
		txtadd=new JTextArea(300,200);
		txtadd.setBounds(400, 100, 350, 280);
		
		gn=new JButton("Generate Receipt");
		gn.setBounds(50, 400, 150, 30);
		gn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String a,b,c,d,e1,f1;
				a=namet.getText();
				b=datet.getText();
				c=courset.getText();
				d=mnot.getText();
				e1=semt.getText();
				f1=amtt.getText();
				
				txtadd.setText(txtadd.getText()+"                             Fees Receipt System        \n\n");
				txtadd.setText(txtadd.getText()+"Name       :"+"  "+a+" "+"\n\n");
				txtadd.setText(txtadd.getText()+"Date       :"+"  "+b+" "+"\n\n");
				txtadd.setText(txtadd.getText()+"Course     :"+"  "+c+" "+"\n\n");
				txtadd.setText(txtadd.getText()+"Mobile No  : "+"  "+d+" "+"\n\n");
				txtadd.setText(txtadd.getText()+"Semester   : "+"  "+e1+" "+"\n\n");
				txtadd.setText(txtadd.getText()+"Fees Amt   : "+"  "+f1+" "+"\n\n");
				txtadd.setText(txtadd.getText()+"                                                                                        Signature    \n\n");
				
				try {
					Connection connection=null;
					connection=DBconnection.getconnection();
					//String query="insert into students('Date','Name','Course','Semester','amount','Mobile No')values(?,?,?,?,?,?)";
	//String query="insert into students('Date','Name','Course','semester','amount','Mobile No') values('" + b + "','" + a + "','" + c + "', '" + e1 + "','" + f1 + "','" + d + "')";
	/*String query="insert into students(Date,Name,Course,semester,amount,Mobile No) values('"+ b +"','"+a+"','"+c+"','"+e1+"','"+f1+"','"+d+"')";				
	PreparedStatement st = connection.prepareStatement("insert into students ('Date','Name','Course','semester','amount','Mobile No') values ('"+b+"','"+a+"','"+c+"','"+e1+"','"+f1+"','"+d+"')");					
					
					PreparedStatement ps=connection.prepareStatement(query);
	*/				/*ps.setString(1,b);
					ps.setString(2,a);
					ps.setString(3,c);
					ps.setString(4,e1);
					ps.setString(5, f1);
					ps.setString(6,d);*/
					//ps.executeUpdate(query);
					//JOptionPane.showMessageDialog(null, "Data Saved Successfully");
					String qry="insert into students (Date,Name,Course,semester,amount,Mobile) values('"+b+"','"+a+"','"+c+"' ,'"+e1+"','"+f1+"','"+d+"')";
					Statement st=connection.createStatement();
					int i=st.executeUpdate(qry);
					System.out.println(i+"row Inserted");
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}	
				//txtadd.setText(txtadd.getText()+"\n"+name.getText()+"\n\n");
				//txtadd.setText(txtadd.getText()+"\n"+date.getText()+"\n\n");
				/*txtadd.setText("Date       :"+b+"\n\n");
				txtadd.setText("Course     :"+c+"\n\n");
				txtadd.setText("Mobile No  :"+d+"\n\n");
				txtadd.setText("Semester   :"+e1+"\n\n");
				txtadd.setText("Fees Amt   :"+f+"\n\n");*/
			}
		});
		
		
		reset=new JButton("Reset");
		reset.setBounds(250, 400, 150, 30);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				namet.setText("");
				datet.setText("");
				courset.setText("");
				mnot.setText("");
				semt.setText("");
				amtt.setText("");
				txtadd.setText("");
			}
		});
		
		
		pr=new JButton("Print Receipt");
		pr.setBounds(450, 400, 150,30);
		pr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					txtadd.print();
				}
				catch(Exception e2) {
					
				}
				
			}
		});
		
		stdinfo=new JButton("Student-Info");
		stdinfo.setBounds(650, 400, 150,30);
		stdinfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentInfo si=new StudentInfo();
				/*try {
					String query="select * from students";
					PreparedStatement ps=connection.prepareStatement(query);
					ResultSet rs=ps.executeQuery();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}*/
			}
		});
		
		jf.add(p);
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
		jf.add(txtadd);
		jf.add(gn);
		jf.add(reset);
		jf.add(pr);
		jf.add(stdinfo);
		jf.setSize(400,400);
		jf.setLayout(null);
		jf.setVisible(true);
		
	}
	
	

}