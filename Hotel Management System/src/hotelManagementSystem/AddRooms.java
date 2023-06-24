package hotelManagementSystem;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class AddRooms extends JFrame implements ActionListener{
	
	JTextField t1,t2;
	JComboBox c1,c2,c3;
	JButton b1,b2;
	
	
		AddRooms(){
			ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotelManagementSystem/Icons/img5.jpg"));
			JLabel l1=new JLabel(i1);
			l1.setBounds(0, 0, 800, 533);
			add(l1);
			
			JLabel room=new JLabel("ROOM NUMBER");
			room.setBounds(100, 30, 300, 30);
			room.setFont(new Font("serif", Font.BOLD, 20));
			room.setForeground(Color.white);
			l1.add(room);
			
			t1=new JTextField();
			t1.setBounds(330, 30, 100, 30);
			t1.setFont(new Font("serif", Font.BOLD, 20));
			t1.setForeground(Color.BLACK);
			l1.add(t1);
			
			JLabel available=new JLabel("AVAILABLE");
			available.setBounds(100, 90, 300, 30);
			available.setFont(new Font("serif", Font.BOLD, 20));
			available.setForeground(Color.white);
			l1.add(available);
			
			c2=new JComboBox(new String [] {"AVAILABLE","OCCUPIED"});//Anonymous array
			c2.setBounds(330, 90, 100, 30);
			l1.add(c2);
			
//			c1=new JComboBox(new String [] {"CLEANED","DIRTY"});//Anonymous array
//			c1.setBounds(330, 90, 100, 30);
//			l1.add(c1);
			
			JLabel status=new JLabel("CLEANING STATUS");
			status.setBounds(100, 150, 300, 30);
			status.setFont(new Font("serif", Font.BOLD, 20));
			status.setForeground(Color.white);
			l1.add(status);
			
			c1=new JComboBox(new String [] {"CLEANED","DIRTY"});//Anonymous array
			c1.setBounds(330, 150, 100, 30);
			l1.add(c1);
			
			
			JLabel price=new JLabel("PRICE");
			price.setBounds(100, 210, 300, 30);
			price.setFont(new Font("serif", Font.BOLD, 20));
			price.setForeground(Color.white);
			l1.add(price);
			
			t2=new JTextField();
			t2.setBounds(330, 210, 100, 30);
			t2.setFont(new Font("serif", Font.BOLD, 20));
			t2.setForeground(Color.BLACK);
			l1.add(t2);
			
			
			JLabel type=new JLabel("BED TYPE");
			type.setBounds(100, 270, 300, 30);
			type.setFont(new Font("serif", Font.BOLD, 20));
			type.setForeground(Color.white);
			l1.add(type);
			
			c3=new JComboBox(new String [] {"SINGLE BED","DOUBLE BED"});//Anonymous array
			c3.setBounds(330, 270, 100, 30);
			l1.add(c3);
			
			b1=new JButton("ADD ROOM");
			b1.setBounds(100, 330, 200, 50);
			b1.setBackground(Color.black);
			b1.setForeground(Color.white);
			b1.addActionListener(this);
			l1.add(b1);
			
			b2=new JButton("CANCEL");
			b2.setBounds(430, 330, 200, 50);
			b2.setBackground(Color.black);
			b2.setForeground(Color.white);
			b2.addActionListener(this);
			l1.add(b2);
			
			
			setTitle("ADD ROOM DETAILS");
			setBounds(300,20,800,550);
			setLayout(null);
			setVisible(true);
			
		}
		public static void main(String[] args) {
			new AddRooms();
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==b1) {
				String room=t1.getText();
				String available=(String)c2.getSelectedItem();//object to string
				String status=(String)c1.getSelectedItem();
				String price=t2.getText();
				String type=(String)c3.getSelectedItem();
				
				MyConnection c=new MyConnection();
				try {
					String str="insert into room values('"+room+"',"+"'"+available+"',"+"'"+status+"',"+"'"+price+"',"+"'"+type+"');";         
					c.s.executeUpdate(str);
					JOptionPane.showMessageDialog(null,"New room added successfully");
					this.setVisible(false);
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}else if(ae.getSource()==b2) {
				this.setVisible(false);
			}
			
		}
}
