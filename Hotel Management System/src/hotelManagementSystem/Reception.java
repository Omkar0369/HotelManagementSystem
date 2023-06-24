package hotelManagementSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Reception extends JFrame implements ActionListener {
	
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
	
	
	Reception(){
		ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("hotelManagementSystem/Icons/img7.jpg"));
		JLabel l1=new JLabel(i);
		l1.setBounds(0,0,598,750);
		add(l1);
		
		b1=new JButton("NEW CUSTOMER FORM");
		b1.setBounds(230, 10, 200, 40);
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		b1.setFont(new Font("serif", Font.BOLD, 10));
		l1.add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("ROOM");
		b2.setBounds(230, 60, 200, 40);
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		b2.setFont(new Font("serif", Font.BOLD, 10));
		b2.addActionListener(this);
		l1.add(b2);
		
		b3=new JButton("DEPARTMENT");
		b3.setBounds(230, 110, 200, 40);
		b3.setForeground(Color.white);
		b3.setBackground(Color.black);
		b3.setFont(new Font("serif", Font.BOLD, 10));
		b3.addActionListener(this);
		l1.add(b3);
		
		b4=new JButton("ALL EMPLOYEE INFO");
		b4.setBounds(230, 160, 200, 40);
		b4.setForeground(Color.white);
		b4.setBackground(Color.black);
		b4.setFont(new Font("serif", Font.BOLD, 10));
		b4.addActionListener(this);
		l1.add(b4);
		
		b5=new JButton("CUSTOMER INFO");
		b5.setBounds(230, 210, 200, 40);
		b5.setForeground(Color.white);
		b5.setBackground(Color.black);
		b5.setFont(new Font("serif", Font.BOLD, 10));
		b5.addActionListener(this);
		l1.add(b5);
		
		b6=new JButton("MANAGER INFO");
		b6.setBounds(230, 260, 200, 40);
		b6.setForeground(Color.white);
		b6.setBackground(Color.black);
		b6.setFont(new Font("serif", Font.BOLD, 10));
		b6.addActionListener(this);
		l1.add(b6);
		
		b7=new JButton("CHECKOUT");
		b7.setBounds(230, 310, 200, 40);
		b7.setForeground(Color.white);
		b7.setBackground(Color.black);
		b7.setFont(new Font("serif", Font.BOLD, 10));
		b7.addActionListener(this);
		l1.add(b7);
		
		b8=new JButton("UPDATE CHECK STATUS");
		b8.setBounds(230, 360, 200, 40);
		b8.setForeground(Color.white);
		b8.setBackground(Color.black);
		b8.setFont(new Font("serif", Font.BOLD, 10));
		b8.addActionListener(this);
		l1.add(b8);
		
		b9=new JButton("UPDATE ROOM STATUS");
		b9.setBounds(230, 410, 200, 40);
		b9.setForeground(Color.white);
		b9.setBackground(Color.black);
		b9.setFont(new Font("serif", Font.BOLD, 10));
		b9.addActionListener(this);
		l1.add(b9);
		
		b10=new JButton("PICK UP SERVICE");
		b10.setBounds(230, 460, 200, 40);
		b10.setForeground(Color.white);
		b10.setBackground(Color.black);
		b10.setFont(new Font("serif", Font.BOLD, 10));
		b10.addActionListener(this);
		l1.add(b10);
		
		b11=new JButton("SEARCH ROOM");
		b11.setBounds(230, 510, 200, 40);
		b11.setForeground(Color.white);
		b11.setBackground(Color.black);
		b11.setFont(new Font("serif", Font.BOLD, 10));
		b11.addActionListener(this);
		l1.add(b11);

		b12=new JButton("LOGOUT");
		b12.setBounds(230, 560, 200, 40);
		b12.setForeground(Color.white);
		b12.setBackground(Color.black);
		b12.setFont(new Font("serif", Font.BOLD, 10));
		b12.addActionListener(this);
		l1.add(b12);
		
		
		setTitle("RECEPTION DETAILS");
		setBounds(300,10,598,700);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Reception();
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			new AddCustomer().setVisible(true);
			this.setVisible(false);
		}else if(ae.getSource()==b2) {
			new Room();
			this.setVisible(false);
			
		}else if(ae.getSource()==b3) {
			new Department().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource()==b4) {
			new EmployeeInfo().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource()==b5) {
			new CustomerInfo().setVisible(true);
			this.setVisible(false);
		}else if(ae.getSource()==b6) {
			new ManagerInfo().setVisible(true);
			this.setVisible(false);
		}else if(ae.getSource()==b7) {
			new CheckOut().setVisible(true);
			this.setVisible(false);
		}else if(ae.getSource()==b8) {
			new UpdateCheck().setVisible(true);
			this.setVisible(false);
		}else if(ae.getSource()==b9) {
			new UpdateRoomStatus().setVisible(true);
			this.setVisible(false);
		}else if(ae.getSource()==b10) {
			new PickUp().setVisible(true);
			this.setVisible(false);
		}else if(ae.getSource()==b11) {
			new SearchRoom().setVisible(true);
			this.setVisible(false);
		}else if(ae.getSource()==b12) {
			this.setVisible(false);	
		}
		
		
		
		
	}
	
}
