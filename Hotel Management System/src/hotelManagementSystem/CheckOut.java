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
public class CheckOut extends JFrame implements ActionListener {
	JTextField t1,t2,t3,t4,t5;
	Choice c1;
	JButton b1,b2,b3;
	CheckOut(){
//		ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("hotelManagementSystem/Icons/img11.jpg"));
//		JLabel l=new JLabel(i);
//		l.setBounds(450, 0, 400, 250);
//		add(l);
	
//		
//		t1=new JTable();
//		t1.setBounds(0, 40, 500, 400);
//		add(t1);
		
		b1=new JButton("CHECK");
		b1.setBounds(100, 200, 150, 50);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("BACK");
		b2.setBounds(300, 200, 150, 50);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
//		ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("hotelManagementSystem/Icons/img12.jpg"));
//		Image i1=i.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
//		ImageIcon i2=new ImageIcon(i1);
		b3=new JButton("@");
		b3.setBounds(460, 50, 20, 20);
		b3.addActionListener(this);
		add(b3);
		
		
		JLabel l1=new JLabel("GUEST ID");
		l1.setBounds(50, 50, 150, 50);
		l1.setForeground(Color.black);
		l1.setFont(new Font("serif", Font.BOLD, 20));
		add(l1);
		
		JLabel l2=new JLabel("ROOM NO");
		l2.setBounds(50, 100, 150, 50);
		l2.setFont(new Font("serif", Font.BOLD, 20));
		l2.setForeground(Color.black);
		add(l2);
		

		c1=new Choice();
		try {
			MyConnection c=new MyConnection();
			String str="Select * from customer;";
			ResultSet rs=c.s.executeQuery(str);
			while(rs.next()) {
				c1.add(rs.getString("number"));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		c1.setBounds(300,50, 150, 120);
		add(c1);
		
		t1=new JTextField();
		t1.setBounds(310, 100, 50, 40);
		add(t1);
		


		getContentPane().setBackground(Color.white);
	
		setTitle("CHECK OUT STATUS");
		setLayout(null);
		setBounds(400, 20, 550, 350);
		setVisible(true);
	}
	
	
	public static void main(String [] args) {
		new CheckOut();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b3) {
			try {
			MyConnection c=new MyConnection();
		
			String id=c1.getSelectedItem();
			String str="select * from customer where number='"+id+"';";
		
			
				ResultSet rs=c.s.executeQuery(str);
				while(rs.next()) {
					t1.setText(rs.getString("room"));
			//		room=rs.getString("room");
				}
				
			}catch(Exception e) {
				e.getMessage();
			}
			
			
		}
		else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}else if(ae.getSource()==b1) {
			String id=c1.getSelectedItem();
			String room=t1.getText();
			MyConnection c=new MyConnection();
			String str1="delete from customer where number='"+id+"';";
			String str2="update room set available='AVAILABLE' where room_number='"+room+"'";
			try {;
				c.s.executeUpdate(str1);
				c.s.executeUpdate(str2);
				JOptionPane.showMessageDialog(null, "CHECK-OUT DONE");
				new Reception().setVisible(true);
				this.setVisible(false);
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
	}

}