package hotelManagementSystem;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;
public class PickUp extends JFrame implements ActionListener {
	Choice c1;
	JCheckBox c2;
	JButton b1,b2;
	JTable t1;
	PickUp(){
		//		ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("hotelManagementSystem/Icons/img11.jpg"));
		//		JLabel l=new JLabel(i);
		//		l.setBounds(450, 0, 400, 250);
		//		add(l);

				
				t1=new JTable();
				t1.setBounds(0, 100, 1000, 200);
				add(t1);
				
	

		b1=new JButton("LOAD");
		b1.setBounds(130, 320, 150, 50);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);

		b2=new JButton("BACK");
		b2.setBounds(430, 320, 150, 50);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);

		JLabel l2=new JLabel("TYPE OF CAR");
		l2.setBounds(50, 10, 150, 50);
		add(l2);
		
		JLabel l3=new JLabel("NAME");
		l3.setBounds(30, 50, 200, 50);
		add(l3);
		
		JLabel l4=new JLabel("AGE");
		l4.setBounds(150, 50, 200, 50);
		add(l4);
		
		JLabel l5=new JLabel("GENDER");
		l5.setBounds(300, 50, 200, 50);
		add(l5);
		
		JLabel l6=new JLabel("COMPANY");
		l6.setBounds(440, 50, 200, 50);
		add(l6);
		
		JLabel l7=new JLabel("MODEL");
		l7.setBounds(580, 50, 200, 50);
		add(l7);
		
		JLabel l8=new JLabel("AVAILABLE");
		l8.setBounds(740, 50, 200, 50);
		add(l8);
		
		JLabel l9=new JLabel("LOCATION");
		l9.setBounds(880, 50, 200, 50);
		add(l9);

		c1=new Choice();
		try {
			MyConnection c=new MyConnection();
			String str="Select * from driver ;";
			ResultSet rs=c.s.executeQuery(str);
			while(rs.next()) {
				c1.add(rs.getString("model"));
			}
		}catch(Exception e) {
			
		}
		c1.setBounds(250, 20, 100, 20);
//		c1.setBackground(Color.black);
//		c1.setForeground(Color.white);
		add(c1);
		

		
		getContentPane().setBackground(Color.white);

		setTitle("PICK UP");
		setLayout(null);
		setBounds(200, 20, 1000, 500);
		setVisible(true);
	}


	public static void main(String [] args) {
		new PickUp();

	}


	@Override
	public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==b1) {
				try {
					
					String str="Select * from driver where model='"+c1.getSelectedItem()+ "';";
					//String str2="select * from room where available='AVAILABLE' AND bed_type='"+c1.getSelectedItem()+ "';";
					
					MyConnection c=new MyConnection();
					ResultSet rs=c.s.executeQuery(str);
					t1.setModel(DbUtils.resultSetToTableModel(rs));
				
					
				}catch(Exception e) {
					System.out.println(e);
				}
			}else if(ae.getSource()==b2) {
				new Reception().setVisible(true);
				this.setVisible(false);
			}

	}
}
