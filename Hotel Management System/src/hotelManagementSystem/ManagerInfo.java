package hotelManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;
public class ManagerInfo extends JFrame implements ActionListener {
	JTable t1;
	JButton b1,b2;
	 
	ManagerInfo(){
		
		t1=new JTable();
		t1.setBounds(0, 50, 1300, 300);
		t1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		add(t1);
		
	//	this.add(new JScrollPane(t1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		JLabel j1=new JLabel("NAME");
		j1.setBounds(75, 20, 50, 20);
		add(j1);
	
		JLabel j2=new JLabel("AGE");
		j2.setBounds(240, 20, 50, 20);
		add(j2);
		
		JLabel j3=new JLabel("GENDER");
		j3.setBounds(405, 20, 100, 20);
		add(j3);
		
		JLabel j4=new JLabel("JOB");
		j4.setBounds(625, 20, 100, 20);
		add(j4);
		
		JLabel j5=new JLabel("SALARY");
		j5.setBounds(785, 20, 100, 20);
		add(j5);
		
		JLabel j6=new JLabel("PHONE");
		j6.setBounds(945, 20, 100, 20);
		add(j6);
		
		JLabel j7=new JLabel("MAIL");
		j7.setBounds(1195, 20, 100, 20);
		add(j7);
		
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
		
	
		
		
		
		setTitle("MANAGER DETAILS");
		setBounds(-10,10,1300,650);
		setLayout(null);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new ManagerInfo();
		
	}

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {

				MyConnection c=new MyConnection();
				String str="select * from employee where job='Manager';";
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

