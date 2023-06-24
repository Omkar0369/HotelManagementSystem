package hotelManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class AddDriver extends JFrame implements ActionListener {
		
	JTextField t1,t2,t3,t4,t5;
	JRadioButton r1,r2;
	JComboBox c1;
	JButton b1,b2;
	
	
		AddDriver(){
			
			ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("hotelManagementSystem/Icons/img6.jpg"));
			JLabel l1=new JLabel(i);	
			l1.setBounds(0, 0, 560, 650);
			add(l1);
			
			JLabel name=new JLabel("NAME");
			name.setForeground(Color.white);
			name.setBackground(Color.black);
			name.setBounds(100, 20, 200, 50);
			name.setFont(new Font("serif",Font.BOLD,20));
			l1.add(name);
			
			t1=new JTextField();
			t1.setBounds(300, 20, 200, 40);
			t1.setFont(new Font("serif",Font.BOLD,20));
			l1.add(t1);
			
			
			JLabel age=new JLabel("AGE");
			age.setForeground(Color.white);
			age.setBackground(Color.black);
			age.setBounds(100, 80, 200, 50);
			age.setFont(new Font("serif",Font.BOLD,20));
			l1.add(age);
			
			t2=new JTextField();
			t2.setBounds(300, 80, 50, 40);
			t2.setFont(new Font("serif",Font.BOLD,20));
			l1.add(t2);
			
			JLabel gender=new JLabel("GENDER");
			gender.setForeground(Color.white);
			gender.setBackground(Color.black);
			gender.setBounds(100, 140, 200, 50);
			gender.setFont(new Font("serif",Font.BOLD,20));
			l1.add(gender);
			
			r1=new JRadioButton("MALE");
			r1.setBounds(300, 145, 70, 30);
			l1.add(r1);
			
			r2=new JRadioButton("FEMALE");
			r2.setBounds(400, 145, 80, 30);
			l1.add(r2);
			
			JLabel car=new JLabel("CAR COMPANY");
			car.setForeground(Color.white);
			car.setBackground(Color.black);
			car.setBounds(100, 200, 200, 50);
			car.setFont(new Font("serif",Font.BOLD,20));
			l1.add(car);
			
			t3=new JTextField();
			t3.setBounds(300, 205, 200, 40);
			t3.setFont(new Font("serif",Font.BOLD,20));
			l1.add(t3);
			
			JLabel model=new JLabel("MODEL");
			model.setForeground(Color.white);
			model.setBackground(Color.black);
			model.setBounds(100, 260, 200, 50);
			model.setFont(new Font("serif",Font.BOLD,20));
			l1.add(model);
			
			t4=new JTextField();
			t4.setBounds(300, 265, 200, 40);
			t4.setFont(new Font("serif",Font.BOLD,20));
			l1.add(t4);
			
			JLabel available=new JLabel("AVAILABLE");
			available.setForeground(Color.white);
			available.setBackground(Color.black);
			available.setBounds(100, 320, 200, 50);
			available.setFont(new Font("serif",Font.BOLD,20));
			l1.add(available);
			
			c1=new JComboBox(new String[] {"AVAILABLE","OCCUPIED"});
			c1.setBounds(300, 320, 100, 40);
			l1.add(c1);
			
			
			JLabel location=new JLabel("LOCATION");
			location.setForeground(Color.white);
			location.setBackground(Color.black);
			location.setBounds(100, 380, 200, 50);
			location.setFont(new Font("serif",Font.BOLD,20));
			l1.add(location);
			
			t5=new JTextField();
			t5.setBounds(300, 385, 200, 40);
			t5.setFont(new Font("serif",Font.BOLD,20));
			l1.add(t5);
			
			b1=new JButton("SUBMIT");
			b1.setBounds(100, 460, 100, 50);
			b1.setForeground(Color.white);
			b1.setBackground(Color.black);
			l1.add(b1);
			b1.addActionListener(this);
			
			b2=new JButton("CANCEL");
			b2.setBounds(300, 460, 100, 50);
			b2.setForeground(Color.white);
			b2.setBackground(Color.black);
			l1.add(b2);
			b2.addActionListener(this);
			
			
			setTitle("ADD DRIVER DETAILS");
			setBounds(300,20,560,650);
			setLayout(null);
			setVisible(true);
			
		}
		
		public static void main(String[] args) {
			new AddDriver();
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==b1) {
				String name=t1.getText();
				String age=t2.getText();
				String car=t3.getText();
				String model=t4.getText();
				String location=t5.getText();
				String gender =null;
				if(r1.isSelected()) {
					gender="MALE";
				}
				else if(r2.isSelected()) {
					gender="FEMALE";
				}
				String available=(String)c1.getSelectedItem();
				MyConnection c=new MyConnection();
				String str="insert into driver values('"+name+"','"+age+"',"+"'"+gender+"',"+"'"+car+"',"+"'"+model+"',"+"'"+available+"',"+"'"+location+"');";
				try {
					c.s.executeUpdate(str);
					JOptionPane.showMessageDialog(null,"New driver added successfully");
					this.setVisible(false);
				}
				catch(SQLException e) {
					System.out.println(e);
				}
				
			}else if(ae.getSource()==b2) {
				this.setVisible(false);
			}
			
		}
}
