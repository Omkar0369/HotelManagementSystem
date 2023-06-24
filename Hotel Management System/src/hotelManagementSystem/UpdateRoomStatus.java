package hotelManagementSystem;
import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class UpdateRoomStatus extends JFrame implements ActionListener {
	JTextField t1,t2,t3;
	Choice c1;
	JButton b1,b2,b3;
	UpdateRoomStatus(){
		ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("hotelManagementSystem/Icons/img9.jpg"));
		JLabel l=new JLabel(i);
		l.setBounds(0, 0, 1000, 700);
		add(l);
	
//		
//		t1=new JTable();
//		t1.setBounds(0, 40, 500, 400);
//		add(t1);
		
		b1=new JButton("CHECK");
		b1.setBounds(100, 450, 150, 50);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		l.add(b1);
		
		b2=new JButton("UPDATE");
		b2.setBounds(300, 450, 150, 50);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		l.add(b2);
		
		b3=new JButton("BACK");
		b3.setBounds(500, 450, 150, 50);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		l.add(b3);
		
		JLabel l1=new JLabel("GUEST NAME");
		l1.setBounds(50, 50, 150, 50);
		l1.setFont(new Font("serif", Font.BOLD, 20));
		l.add(l1);
		
		JLabel l2=new JLabel("ROOM NO");
		l2.setBounds(50, 150, 150, 50);
		l2.setFont(new Font("serif", Font.BOLD, 20));
		l.add(l2);
		
		JLabel l3=new JLabel("AVAILIBILE");
		l3.setBounds(50, 250, 200, 50);
		l3.setFont(new Font("serif", Font.BOLD, 20));
		l.add(l3);
		
		JLabel l4=new JLabel("CLEAN STATUS");
		l4.setBounds(50, 350, 200, 50);
		l4.setFont(new Font("serif", Font.BOLD, 20));
		l.add(l4);
		
		c1=new Choice();
		try {
			MyConnection c=new MyConnection();
			String str="Select * from customer;";
			ResultSet rs=c.s.executeQuery(str);
			while(rs.next()) {
				c1.add(rs.getString("name"));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		c1.setBounds(300, 70, 150, 120);
		l.add(c1);
		
		t1=new JTextField();
		t1.setBounds(300, 150, 50, 40);
		l.add(t1);
		
		t2=new JTextField();
		t2.setBounds(300, 250, 150, 40);
		l.add(t2);
		
		t3=new JTextField();
		t3.setBounds(300, 350, 150, 40);
		l.add(t3);
		
//		t4=new JTextField();
//		t4.setBounds(300, 450, 150, 40);
//		l.add(t4);
	
		setTitle("ROOMS STATUS");
		setLayout(null);
		setBounds(100, 0, 1000, 700);
		setVisible(true);
	}
	
	
	public static void main(String [] args) {
		new UpdateRoomStatus();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
			
			MyConnection c=new MyConnection();
			String str1=c1.getSelectedItem();
			String room=null;
			try {
				ResultSet rs=c.s.executeQuery("select * from customer where name='"+str1+"';");
				while(rs.next()) {
					t1.setText(rs.getString("room"));
					room=rs.getString("room");
				}
				//t1.setModel(DbUtils.resultSetToTableModel(rs));
				ResultSet rs2=c.s.executeQuery("select * from room where room_number='"+room+"';");
				while(rs2.next()) {
					t2.setText(rs2.getString("available"));
					t3.setText(rs2.getString("status"));
				}
				
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
		}else if(ae.getSource()==b2) {
				try {
					MyConnection c=new MyConnection();
					String room=t1.getText();
					String available=t2.getText();
					String status=t3.getText();
					
					String str="Update room set available='"+available+"',status= '"+status+"' where room_number='"+room+"';";
					c.s.executeUpdate(str);
					JOptionPane.showMessageDialog(null,"Room updated successfully");
					new Reception().setVisible(true);
					this.setVisible(false);
					
				}catch(Exception e) {
					System.out.println(e);
				}
			
		}else if(ae.getSource()==b3) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}

}