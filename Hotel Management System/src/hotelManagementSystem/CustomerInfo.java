package hotelManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;
public class CustomerInfo extends JFrame implements ActionListener {
	JTable t1;
	JButton b1,b2;
	 
	CustomerInfo(){
		
		t1=new JTable();
		t1.setBounds(0, 50, 1300, 300);
		t1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		add(t1);
		
	//	this.add(new JScrollPane(t1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		JLabel j1=new JLabel("ID");
		j1.setBounds(35, 20, 50, 20);
		add(j1);
	
		JLabel j2=new JLabel("ID NUMBER");
		j2.setBounds(200, 20, 100, 20);
		add(j2);
		
		JLabel j3=new JLabel("NAME");
		j3.setBounds(385, 20, 100, 20);
		add(j3);
		
		JLabel j4=new JLabel("GENDER");
		j4.setBounds(555, 20, 100, 20);
		add(j4);
		
		JLabel j5=new JLabel("COUNTRY");
		j5.setBounds(705, 20, 100, 20);
		add(j5);
		
		JLabel j6=new JLabel("ROOM NO");
		j6.setBounds(845, 20, 100, 20);
		add(j6);
		
		JLabel j7=new JLabel("CHECKED IN");
		j7.setBounds(1000, 20, 100, 20);
		add(j7);
		
		JLabel j8=new JLabel("DEPOSIT");
		j8.setBounds(1200, 20, 100, 20);
		add(j8);
		
		b1=new JButton("LOAD DATA");
		b1.setBounds(300, 520, 150, 50);
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("CANCEL");
		b2.setBounds(600, 520, 100, 50);
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		add(b2);
		b2.addActionListener(this);
		
		getContentPane().setBackground(Color.white);
		
		
		
		setTitle("CUSTOMER DETAILS");
		setBounds(-10,10,1300,650);
		setLayout(null);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new CustomerInfo();
		
	}

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {

				MyConnection c=new MyConnection();
				String str="select * from customer ;";
				ResultSet rs=c.s.executeQuery(str);
				
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(SQLException e) {
				System.out.println(e);
			}
			
			
			
		}else if(ae.getSource()==b2) {
			this.setVisible(false);
			new Reception().setVisible(true);
		}
		
	}

}

